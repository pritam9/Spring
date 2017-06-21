package com.uncc.mhealth.controller;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.uncc.mhealth.config.Constants;
import com.uncc.mhealth.config.Constants.Message;
import com.uncc.mhealth.dao.UserDAO;
import com.uncc.mhealth.dao.UserMIMappingDAO;
import com.uncc.mhealth.dao.UserSurveyDAO;
import com.uncc.mhealth.dao.UserTokenDAO;
import com.uncc.mhealth.model.Response;
import com.uncc.mhealth.model.User;
import com.uncc.mhealth.model.UserMIMapping;
import com.uncc.mhealth.model.UserToken;
import com.uncc.mhealth.service.FeedbackManager;
import com.uncc.mhealth.service.PushService;
 
/**
 * Handles requests for the application home page.
 */
@Controller
public class UserController {
     
    @Autowired
    private UserDAO userDao;
    @Autowired
    private UserTokenDAO userTokenDao;
    @Autowired
	private UserMIMappingDAO userMiMappingDao;
    @Autowired
	private PushService pushService;
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
	private FeedbackManager feedbackManager;
    @Autowired
    private UserSurveyDAO userSurveyDao;
    
    
    @RequestMapping(value = "apps/apis/auth/login_ver2", method = RequestMethod.POST)
    public @ResponseBody Response login_ver2(HttpServletRequest request) {
    	String username = request.getParameter(Constants.Parameter.USERNAME);
    	String password = request.getParameter(Constants.Parameter.PASSWORD);
    	String deviceToken = request.getParameter(Constants.Parameter.DEVICE_TOKEN);
    	
    	Response response = new Response();
    	User currentUser = userDao.get(username);
    	//System.out.println("User Details::"+currentUser);
    	
    	if(currentUser != null && passwordEncoder.matches(password, currentUser.getPassword())) {
    		/**
    		 * create session token & save apple device token
    		 */
    		String auth_token = UUID.randomUUID().toString().toUpperCase() +
        	        "|" + currentUser.getUsername() +
        	        "|" + System.currentTimeMillis();
    		
    		UserToken userToken = userTokenDao.getUserToken(currentUser.getId(), deviceToken);
    		if(userToken == null){
    			userToken = new UserToken();
    			userToken.setUser_id(currentUser.getId());
        		userToken.setToken(deviceToken);
        		userToken.setSession_token(auth_token);
        		userToken.setIsWithNewCert("Y");
    			userTokenDao.saveOrUpdate(userToken);

    		} else {
    			userToken.setSession_token(auth_token);
    			userTokenDao.update(userToken);
    		}
    		
    		
    		/**
    		 * set session
    		 * this token is received by mobile app and will be used for further calls
    		 */
    		currentUser.setToken(auth_token);
    		request.getSession().setAttribute("user",currentUser);
    		
    		if(feedbackManager.isFeedBackGenerated(currentUser.getId())){
    			currentUser.setGender(feedbackManager.getGender(currentUser.getId()));
    		}else{
    			currentUser.setGender("");
    		}
    		//clear the password field for safety
    		currentUser.setPassword("");
    		response.setStatus(Response.SUCCESS);
    		response.setData(currentUser);
    	} else {
    		response.setMessage(Constants.User.INVALID_CREDENTIALS);
    		response.setStatus(Response.ERROR);
    	}
    	return response;
    }
    
    @RequestMapping(value = "apps/apis/auth/logout_ver2", method = RequestMethod.POST)
    public @ResponseBody Response logout_ver2(HttpServletRequest request) {
    	String token = request.getParameter(Constants.Parameter.SESSION_TOKEN);
    	String deviceToken = request.getParameter(Constants.Parameter.DEVICE_TOKEN);
    	
    	Response response = new Response();
    	User user = userDao.getUserFromToken(token);
    	if(user != null) { 
    		response.setData(deviceToken);
    		response.setStatus(Response.SUCCESS);
    		//delete device token
    		userTokenDao.delete(user.getId(), deviceToken);
    	} else {
    		response.setStatus(Response.ERROR);
    		response.setMessage(Constants.User.INVALID_TOKEN);
    	}
    	return response;
    }
     
    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public ModelAndView newUser() {
        ModelAndView model = new ModelAndView("register");
        model.addObject("user", new User());
        return model;      
    }
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView login() {
        ModelAndView model = new ModelAndView("login");
        model.addObject("user", new User());
        return model;      
    }
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public ModelAndView logout(HttpServletRequest request) {
    	request.getSession().setAttribute("user", null);
        ModelAndView model = new ModelAndView("login");
        model.addObject("user", new User());
        return model;      
    }
    @RequestMapping(value = "/dashboard", method = RequestMethod.GET)
    public ModelAndView dashboard(HttpServletRequest request) {
    	
    	if(request.getSession().getAttribute("user") == null){
    		return new ModelAndView("redirect:/login");
    	} else {
    		User user=(User)request.getSession().getAttribute("user");
    		ModelAndView model=null;
    		if(user.getDetailsUpdated().equals("Y")){
    			model = new ModelAndView("dashboard");
        		model.addObject("user", request.getSession().getAttribute("user"));
        		if(feedbackManager.isFeedBackGenerated(user.getId())){
        			model.addObject("isFeedBackGenerated", "Y");
        		}
    		}else{
    			model = new ModelAndView("updateDetails");
        		model.addObject("user", request.getSession().getAttribute("user"));	
        		model.addObject("msg", "Please update your details before proceeding to survey");	
    		}
    		return model; 
    	}
    }
    @RequestMapping(value = "/mentorFeedback", method = RequestMethod.GET)
    public ModelAndView mentorFeedback(HttpServletRequest request) {
    	
    	if(request.getSession().getAttribute("user") == null){
    		return new ModelAndView("redirect:/login");
    	} else {
    		User user=(User)request.getSession().getAttribute("user");
    		ModelAndView model=new ModelAndView("mentorFeedback");
        	model.addObject("mentorFeedback", userSurveyDao.getMentorFeedback(user.getId()));
    		return model; 
    	}
    }
    @RequestMapping(value = "/updateDetails", method = RequestMethod.GET)
    public ModelAndView updateDetails(HttpServletRequest request) {
    	
    	if(request.getSession().getAttribute("user") == null){
    		return new ModelAndView("redirect:/login");
    	} else {
    		
    		ModelAndView model = new ModelAndView("updateDetails");
    		model.addObject("user", request.getSession().getAttribute("user"));
    		return model; 
    	}
    }
    @RequestMapping(value = "apps/registerUser", method = RequestMethod.POST)
    public @ResponseBody Response saveUser(@RequestBody User user) {
    	Response response = new Response();
    	//this token is not being used in new flow
    	String auth_token = UUID.randomUUID().toString().toUpperCase() +
    	        "|" + user.getUsername() +
    	        "|" + System.currentTimeMillis();
    	user.setToken(auth_token);
    	user.setPassword(passwordEncoder.encode(user.getPassword()));
    	user.setDetailsUpdated("Y");
    	user.setIstoApp("Y");
        userDao.saveOrUpdate(user);
        response.setStatus(Response.SUCCESS);
        return response;
    }
    
    @RequestMapping(value = "apps/apis/pushMessage", method = RequestMethod.POST)
	public @ResponseBody Response pushMessage(HttpServletRequest request) {
		String token = request.getParameter(Constants.Parameter.SESSION_TOKEN);
		Response response = new Response();
		User user = userDao.getUserFromToken(token);
		if (user != null) {
			UserMIMapping map = null;
				map = new UserMIMapping(user.getId(), 2, UserMIMapping.SENT, 0, "Hello!! This is Push Notification Test Msg..",
						new Date(System.currentTimeMillis()).toString());
				userMiMappingDao.saveOrUpdate(map);
				if (map != null && map.getMi_id() > 0) {
					List<UserToken> tokenList = userTokenDao.get(user.getId());
					pushService.pushMessage(tokenList, Message.NEW_MESSAGE);
				}
				response.setStatus(Response.SUCCESS);
				response.setData(map);
		} else {
			response.setStatus(Response.ERROR);
			response.setMessage(Constants.User.INVALID_TOKEN);
		}
		return response;
	}
    @RequestMapping(value = "saveUpdatedDetails", method = RequestMethod.POST)
	public @ResponseBody Response saveUpdatedDetails(HttpServletRequest request) {
    	Response response = new Response();
    	if(request.getSession().getAttribute("user") == null){
    		response.setStatus(Response.ERROR);
    		response.setMessage(Constants.User.INVALID_CREDENTIALS);
    	} else {
    		User user=(User) request.getSession().getAttribute("user");
    		User currentUser = userDao.get(user.getUsername());
    		String email=request.getParameter("email");
    		String firstName=request.getParameter("firstName");
    		String lastName=request.getParameter("lastName");
    		String nickName=request.getParameter("nickName");
    		String DOB=request.getParameter("DOB");
    		user.setPassword(currentUser.getPassword());
    		user.setEmail(email);
    		user.setFirstName(firstName);
    		user.setLastName(lastName);
    		user.setNickname(nickName);
    		user.setDob(DOB);
    		user.setDetailsUpdated("Y");
    		userDao.saveOrUpdate(user);
    		user.setPassword("");
    		request.getSession().setAttribute("user",user);
    		response.setStatus(Response.SUCCESS);
    		response.setData(user);
    	}
    	return response;
	}
    @RequestMapping(value = "/resourcesPage", method = RequestMethod.GET)
    public ModelAndView resourcesPage(HttpServletRequest request) {
    	
    	if(request.getSession().getAttribute("user") == null){
    		return new ModelAndView("redirect:/login");
    	} else {
    		
    		ModelAndView model = new ModelAndView("resources");
    		model.addObject("user", request.getSession().getAttribute("user"));
    		return model; 
    	}
    }
    
    
    
    
    
    
    
    
    
    
    
   
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
   //TODO: **************** Following methods are not used, need to be cleared **************** 
    @Deprecated
    @RequestMapping(value = "apps/verifyLogin", method = RequestMethod.POST)
    public @ResponseBody Response verifyLogin(@RequestBody User user, HttpServletRequest request) {
    	Response response = new Response();
    	User currentUser = userDao.get(user.getUsername());
    	System.out.println("@@ Current User : "+currentUser);
    	if(currentUser != null && currentUser.getPassword().equals(user.getPassword())) {
    		//set session
    		request.getSession().setAttribute("user",currentUser);
    		
    		currentUser.setPassword("");
    		response.setStatus(Response.SUCCESS);
    		response.setData(currentUser);
    	} else {
    		response.setMessage(Constants.User.INVALID_CREDENTIALS);
    		response.setStatus(Response.ERROR);
    	}
    	return response;
    }
  //TODO: this will be used for mobile apps
    @Deprecated
    @RequestMapping(value = "apps/apis/auth/login", method = RequestMethod.POST)
    public @ResponseBody Response login(HttpServletRequest request) {
    	String username = request.getParameter("username");
    	String password = request.getParameter("password");
    	
    	
    	System.out.println("@@input param: "+username);
    	Response response = new Response();
    	User currentUser = userDao.get(username);
    	System.out.println("@@ Current User : "+currentUser);
    	
    	
    	if(currentUser != null && currentUser.getPassword().equals(password)) {
    		//set session
    		request.getSession().setAttribute("user",currentUser);
    		
    		currentUser.setGender(feedbackManager.getGender(currentUser.getId()));
    		
    		currentUser.setPassword("");
    		response.setStatus(Response.SUCCESS);
    		response.setData(currentUser);
    	} else {
    		response.setMessage(Constants.User.INVALID_CREDENTIALS);
    		response.setStatus(Response.ERROR);
    	}
    	return response;
    }
    
    @Deprecated
    @RequestMapping(value = "apps/apis/push/registerDevice", method = RequestMethod.POST)
    public @ResponseBody Response registerDevice(HttpServletRequest request) {
    	String token = request.getParameter("token");
    	String deviceToken = request.getParameter("deviceToken");
    	
    	Response response = new Response();
    	User user = userDao.getUserFromToken(token);
    	if(user != null) { 
    		response.setData(deviceToken);
    		response.setStatus(Response.SUCCESS);
    		//store device token
    		UserToken userToken = new UserToken();
    		userToken.setUser_id(user.getId());
    		userToken.setToken(deviceToken);
    		userToken.setIsWithNewCert("Y");
    		userTokenDao.saveOrUpdate(userToken);
    	} else {
    		response.setStatus(Response.ERROR);
    		response.setMessage(Constants.User.INVALID_TOKEN);
    	}
    	return response;
    }
    @Deprecated
    @RequestMapping(value = "apps/apis/push/unregisterDevice", method = RequestMethod.POST)
    public @ResponseBody Response unregisterDevice(HttpServletRequest request) {
    	String token = request.getParameter("token");
    	String deviceToken = request.getParameter("deviceToken");
    	
    	Response response = new Response();
    	User user = userDao.getUserFromToken(token);
    	if(user != null) { 
    		response.setData(deviceToken);
    		response.setStatus(Response.SUCCESS);
    		//delete device token
    		userTokenDao.delete(user.getId(), deviceToken);
    	} else {
    		response.setStatus(Response.ERROR);
    		response.setMessage(Constants.User.INVALID_TOKEN);
    	}
    	return response;
    }

    @Deprecated
    @RequestMapping(value = "/tempPush", method = RequestMethod.GET)
    public ModelAndView tempPush(HttpServletRequest request) {
    	
    	if(request.getSession().getAttribute("user") == null){
    		return new ModelAndView("redirect:/login");
    	} else {
    		pushService.pushMessage(userTokenDao.get(((User)request.getSession().getAttribute("user")).getId()), "New Push");
    		ModelAndView model = new ModelAndView("tempPush");
    		model.addObject("user", request.getSession().getAttribute("user"));
    		return model; 
    	}
    }  
    @Deprecated
    @RequestMapping(value = "/User/get/{userId}", method = RequestMethod.GET)
	public @ResponseBody User getUser(
			@PathVariable("userId") int userId) {
		System.out.println("rcvd userId=" + userId);
		User user = userDao.get(userId);
		return user;
	}
    @Deprecated
    @RequestMapping(value = "/User/edit", method = RequestMethod.GET)
    public ModelAndView editUser(HttpServletRequest request) {
        int userId = Integer.parseInt(request.getParameter("id"));
        User user = userDao.get(userId);
        ModelAndView model = new ModelAndView("UserForm");
        model.addObject("user", user);
        return model;      
    }
    @Deprecated
    @RequestMapping(value = "/User/delete", method = RequestMethod.GET)
    public ModelAndView deleteUser(HttpServletRequest request) {
        int userId = Integer.parseInt(request.getParameter("id"));
        userDao.delete(userId);
        return new ModelAndView("redirect:/User");     
    }
    @Deprecated
    @RequestMapping(value="/User")
    public ModelAndView home() {
        List<User> listUsers = userDao.list();
        ModelAndView model = new ModelAndView("user");
        model.addObject("userList", listUsers);
        return model;
    }    
     
}
