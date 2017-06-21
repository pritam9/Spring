package com.uncc.mhealth.controller;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.uncc.mhealth.config.Constants;
import com.uncc.mhealth.config.Constants.Message;
import com.uncc.mhealth.dao.FeedbackDAO;
import com.uncc.mhealth.dao.MIDAO;
import com.uncc.mhealth.dao.UserDAO;
import com.uncc.mhealth.dao.UserMIMappingDAO;
import com.uncc.mhealth.dao.UserTokenDAO;
import com.uncc.mhealth.model.Feedback;
import com.uncc.mhealth.model.MI;
import com.uncc.mhealth.model.MIResponse;
import com.uncc.mhealth.model.PF;
import com.uncc.mhealth.model.Response;
import com.uncc.mhealth.model.User;
import com.uncc.mhealth.model.UserMIMapping;
import com.uncc.mhealth.model.UserToken;
import com.uncc.mhealth.service.MiService;
import com.uncc.mhealth.service.PushService;

@Controller
public class MIController {
	@Autowired
    private MIDAO miDao;
	@Autowired
    private UserDAO userDao;
	@Autowired
    private FeedbackDAO feedbackDao;
	@Autowired
    private UserTokenDAO userTokenDao;
	@Autowired
	private MiService miService;
	@Autowired
	private PushService pushService;
	
	    
    /**
     * returns all the sent messages for the user
     * @param request
     * @return
     */
    @RequestMapping(value = "apps/apis/coach/list", method = RequestMethod.POST)
    public @ResponseBody Response miList(HttpServletRequest request) {
    	String token = request.getParameter(Constants.Parameter.SESSION_TOKEN);
    	Response response = new Response();
    	User user = userDao.getUserFromToken(token); 
    	if(user != null) {
    		List<UserMIMapping> userMiList = miService.getUserMIList(user.getId());
    		response.setStatus(Response.SUCCESS);
    		response.setData(userMiList);
    	} else {
    		response.setStatus(Response.ERROR);
    		response.setMessage(Constants.User.INVALID_TOKEN);
    	}
    	return response;
    }
    /**
     * return all the new messages for the user
     * @param request
     * @return
     */
    @RequestMapping(value = "apps/apis/coach/new", method = RequestMethod.POST)
    public @ResponseBody Response miNew(HttpServletRequest request) {
    	String token = request.getParameter(Constants.Parameter.SESSION_TOKEN);
    	Response response = new Response();
    	User user = userDao.getUserFromToken(token); 
    	if(user != null) {
    		List<UserMIMapping> userMiList = miService.getUserMINew(user.getId());
    		response.setStatus(Response.SUCCESS);
    		response.setData(userMiList);
    	} else {
    		response.setStatus(Response.ERROR);
    		response.setMessage(Constants.User.INVALID_TOKEN);
    	}
    	return response;
    }
    /**
     * stores the user response for the messages
     * @param request
     * @return
     */
    @RequestMapping(value = "apps/apis/coach/answer/store", method = RequestMethod.POST)
	public @ResponseBody Response storeAnswer(HttpServletRequest request) {
		String token = request.getParameter(Constants.Parameter.SESSION_TOKEN);
		String messageId = request.getParameter(Constants.Parameter.MESSAGE_ID);
		String answer = request.getParameter(Constants.Parameter.ANSWER);
		Response response = new Response();
		User user = userDao.getUserFromToken(token);
		if (user != null) {
				Feedback feedback = feedbackDao.get(user.getId());
				ObjectMapper mapper = new ObjectMapper();
				PF pf;
				try {
					pf = mapper.readValue(feedback.getFeedback(), PF.class);
					// TODO: check if already responded, if responded then
					// ignore this request
					UserMIMapping userMiMap = miService.updateUserMI(user.getId(), messageId,
							UserMIMapping.NOT_AVAILABLE, UserMIMapping.NOT_AVAILABLE, answer, pf);
					response.setStatus(Response.SUCCESS);
					response.setData(userMiMap);
					// set this response as sent
					if (userMiMap != null && userMiMap.getMi_id() > 0) {
						miService.updateUserMI(user.getId(), "" + userMiMap.getId(), UserMIMapping.RECEIVED,
								UserMIMapping.NOT_AVAILABLE, null, pf);
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					response.setStatus(Response.ERROR);
					response.setMessage(e.getMessage());
				}
		} else {
			response.setStatus(Response.ERROR);
			response.setMessage(Constants.User.INVALID_TOKEN);
		}
		return response;
	}
    /**
     * updates open status for the messages
     * @param request
     * @return
     */
    @RequestMapping(value = "apps/apis/coach/message/open", method = RequestMethod.POST)
	public @ResponseBody Response openMessage(HttpServletRequest request) {
		String token = request.getParameter(Constants.Parameter.SESSION_TOKEN);
		String messageId = request.getParameter(Constants.Parameter.MESSAGE_ID);
		Response response = new Response();
		User user = userDao.getUserFromToken(token);
		if (user != null) {
				Feedback feedback = feedbackDao.get(user.getId());
				ObjectMapper mapper = new ObjectMapper();
				PF pf;
				try {
					pf = mapper.readValue(feedback.getFeedback(), PF.class);

					// TODO: check if already opened, if opened then ignore this
					// request

					UserMIMapping userMiMap = miService.updateUserMI(user.getId(), messageId,
							UserMIMapping.NOT_AVAILABLE, UserMIMapping.OPENED, null, pf);
					if (userMiMap != null && userMiMap.getMi_id() > 0) {
						miService.updateUserMI(user.getId(), "" + userMiMap.getId(), UserMIMapping.SENT,
								UserMIMapping.NOT_AVAILABLE, null, pf);
						List<UserToken> tokenList = userTokenDao.get(user.getId());
						pushService.pushMessage(tokenList, Message.NEW_MESSAGE);
					}
					response.setStatus(Response.SUCCESS);
					response.setData(userMiMap);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					response.setStatus(Response.ERROR);
					response.setMessage(e.getMessage());
				}

		} else {
			response.setStatus(Response.ERROR);
			response.setMessage(Constants.User.INVALID_TOKEN);
		}
		return response;
	}
    
    @RequestMapping(value = "apps/resetUser", method = RequestMethod.GET)
    public @ResponseBody Response resetUser(HttpServletRequest request) {
    	miService.sentWelcomeMessages(26);
    	Response response = new Response();
    	response.setStatus(Response.SUCCESS);
    	response.setData("");
    	return response;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    //TODO: ********* following methods are not being used *************
    @Deprecated
    @RequestMapping(value="/add_mi")
    public ModelAndView home(HttpServletRequest request) {
    	if(request.getSession().getAttribute("user") == null){
    		return new ModelAndView("redirect:/login");
    	} else {
    		ModelAndView model = new ModelAndView("add_mi");
    		model.addObject("user", request.getSession().getAttribute("user"));
    		model.addObject("miList", miDao.list());
    		return model; 
    	} 
    }
    
    @Deprecated
    @RequestMapping(value = "/apps/getMI", method = RequestMethod.GET)
	public @ResponseBody List<MI> getSurvey() {
    	return miDao.list();
	} 
    @Deprecated
    @RequestMapping(value = "/apps/submitMI", method = RequestMethod.POST)
	public @ResponseBody Response submitMI(@RequestBody MIResponse request) {
    	System.out.println("@@ submitMI : "+request);
    	Response response = new Response();
    	
    	User user = userDao.getUserFromToken(request.getToken());
    	if(user != null) {
    		miDao.saveOrUpdate(request.getMi());
    		response.setStatus(Response.SUCCESS);
    	} else {
    		response.setStatus(Response.ERROR);
    		response.setMessage(Constants.User.INVALID_TOKEN);
    	}
    	
    	return response;
	}

    
}
