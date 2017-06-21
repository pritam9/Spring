package com.uncc.mhealth.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.uncc.mhealth.config.Constants;
import com.uncc.mhealth.dao.BacLogDAO;
import com.uncc.mhealth.dao.UserDAO;
import com.uncc.mhealth.model.BacLog;
import com.uncc.mhealth.model.Response;
import com.uncc.mhealth.model.User;
 
/**
 * Handles requests for the application home page.
 */
@Controller
public class BacLogController {
     
    @Autowired
    private UserDAO userDao;
    @Autowired
    private BacLogDAO bacLogDao;
    
    @RequestMapping(value = "apps/apis/bac/store", method = RequestMethod.POST)
    public @ResponseBody Response strategyStore(HttpServletRequest request) {
    	String token = request.getParameter(Constants.Parameter.SESSION_TOKEN);
    	String date = request.getParameter(Constants.Parameter.DATE);
    	Response response = new Response();
    	User user = userDao.getUserFromToken(token); 
    	if(user != null) {
    		BacLog bacLog = new BacLog();
    		bacLog.setUser_id(user.getId());
    		bacLog.setBac(Double.parseDouble(request.getParameter(Constants.Parameter.BAC)));
    		bacLog.setDrinks(Integer.parseInt(request.getParameter(Constants.Parameter.DRINKS)));
    		bacLog.setBeer(Integer.parseInt(request.getParameter(Constants.Parameter.BEER)));
    		bacLog.setWine(Integer.parseInt(request.getParameter(Constants.Parameter.WINE)));
    		bacLog.setShots(Integer.parseInt(request.getParameter(Constants.Parameter.SHOTS)));
    		bacLog.setLiquor(Integer.parseInt(request.getParameter(Constants.Parameter.LIQUOR)));
    		
    		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
    		try {
				Date logDate = sdf.parse(date);
				bacLog.setLog_date(logDate.toString());
	    		
	    		bacLogDao.saveOrUpdate(bacLog);
	    		
	    		response.setStatus(Response.SUCCESS);
	    		response.setData(bacLog);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				response.setStatus(Response.SUCCESS);
				response.setMessage(e.getMessage());
				e.printStackTrace();
			}
    		
    		
    	} else {
    		response.setStatus(Response.ERROR);
    		response.setMessage(Constants.User.INVALID_TOKEN);
    	}
    	return response;
    }
    
    @RequestMapping(value = "apps/apis/bac/get", method = RequestMethod.POST)
    public @ResponseBody Response strategyGet(HttpServletRequest request) {
    	String token = request.getParameter(Constants.Parameter.SESSION_TOKEN);
    	Response response = new Response();
    	User user = userDao.getUserFromToken(token); 
    	if(user != null) {
    		List<BacLog> st = bacLogDao.get(user.getId());
    		response.setStatus(Response.SUCCESS);
    		
    		Collections.sort(st, BacLog.bacLogComparator);
    		response.setData(st);
    	} else {
    		response.setStatus(Response.ERROR);
    		response.setMessage(Constants.User.INVALID_TOKEN);
    	}
    	return response;
    }
    
    @RequestMapping(value = "/aboutBac", method = RequestMethod.GET)
    public ModelAndView dashboard(HttpServletRequest request) {
    	Object session = null;
    	if(request.getSession().getAttribute("user") != null){
    		session = request.getSession().getAttribute("user");
    	} else if(request.getParameter(Constants.Parameter.USER) != null){
    		session = request.getParameter(Constants.Parameter.USER);
    	}
    	
    	if(session == null) {
    		return new ModelAndView("redirect:/login");
    	} else {
    		
    		User user = null;
    		if(session instanceof User) {
    			user = (User) session;
    		} else if(session instanceof String) {
    			user = userDao.getUserFromToken((String)session);
    		}
    		ModelAndView model = new ModelAndView("about_bac");
    		model.addObject("user", user);
    		return model; 
    	}
    }
    @RequestMapping(value = "/alcoholBody", method = RequestMethod.GET)
    public ModelAndView alcoholBody(HttpServletRequest request) {
    	Object session = null;
    	if(request.getSession().getAttribute("user") != null){
    		session = request.getSession().getAttribute("user");
    	} else if(request.getParameter(Constants.Parameter.USER) != null){
    		session = request.getParameter(Constants.Parameter.USER);
    	}
    	
    	if(session == null) {
    		return new ModelAndView("redirect:/login");
    	} else {
    		
    		User user = null;
    		if(session instanceof User) {
    			user = (User) session;
    		} else if(session instanceof String) {
    			user = userDao.getUserFromToken((String)session);
    		}
    		ModelAndView model = new ModelAndView("alcohol_body");
    		model.addObject("user", user);
    		return model; 
    	}
    }
    @RequestMapping(value = "/alcoholMen", method = RequestMethod.GET)
    public ModelAndView alcoholMen(HttpServletRequest request) {
    	Object session = null;
    	if(request.getSession().getAttribute("user") != null){
    		session = request.getSession().getAttribute("user");
    	} else if(request.getParameter(Constants.Parameter.USER) != null){
    		session = request.getParameter(Constants.Parameter.USER);
    	}
    	
    	if(session == null) {
    		return new ModelAndView("redirect:/login");
    	} else {
    		
    		User user = null;
    		if(session instanceof User) {
    			user = (User) session;
    		} else if(session instanceof String) {
    			user = userDao.getUserFromToken((String)session);
    		}
    		ModelAndView model = new ModelAndView("alcohol_men");
    		model.addObject("user", user);
    		return model; 
    	}
    }
    @RequestMapping(value = "/alcoholWomen", method = RequestMethod.GET)
    public ModelAndView alcoholWomen(HttpServletRequest request) {
    	Object session = null;
    	if(request.getSession().getAttribute("user") != null){
    		session = request.getSession().getAttribute("user");
    	} else if(request.getParameter(Constants.Parameter.USER) != null){
    		session = request.getParameter(Constants.Parameter.USER);
    	}
    	
    	if(session == null) {
    		return new ModelAndView("redirect:/login");
    	} else {
    		
    		User user = null;
    		if(session instanceof User) {
    			user = (User) session;
    		} else if(session instanceof String) {
    			user = userDao.getUserFromToken((String)session);
    		}
    		ModelAndView model = new ModelAndView("alcohol_women");
    		model.addObject("user", user);
    		return model; 
    	}
    }
    @RequestMapping(value = "/genderGenetic", method = RequestMethod.GET)
    public ModelAndView genderGenetic(HttpServletRequest request) {
    	Object session = null;
    	if(request.getSession().getAttribute("user") != null){
    		session = request.getSession().getAttribute("user");
    	} else if(request.getParameter(Constants.Parameter.USER) != null){
    		session = request.getParameter(Constants.Parameter.USER);
    	}
    	
    	if(session == null) {
    		return new ModelAndView("redirect:/login");
    	} else {
    		
    		User user = null;
    		if(session instanceof User) {
    			user = (User) session;
    		} else if(session instanceof String) {
    			user = userDao.getUserFromToken((String)session);
    		}
    		ModelAndView model = new ModelAndView("gender_genetic");
    		model.addObject("user", user);
    		return model; 
    	}
    }
    @RequestMapping(value = "/alcoholLaw", method = RequestMethod.GET)
    public ModelAndView alcoholLaw(HttpServletRequest request) {
    	Object session = null;
    	if(request.getSession().getAttribute("user") != null){
    		session = request.getSession().getAttribute("user");
    	} else if(request.getParameter(Constants.Parameter.USER) != null){
    		session = request.getParameter(Constants.Parameter.USER);
    	}
    	
    	if(session == null) {
    		return new ModelAndView("redirect:/login");
    	} else {
    		
    		User user = null;
    		if(session instanceof User) {
    			user = (User) session;
    		} else if(session instanceof String) {
    			user = userDao.getUserFromToken((String)session);
    		}
    		ModelAndView model = new ModelAndView("alcohol_law");
    		model.addObject("user", user);
    		return model; 
    	}
    }
    @RequestMapping(value = "/alcoholMyth", method = RequestMethod.GET)
    public ModelAndView alcoholMyth(HttpServletRequest request) {
    	Object session = null;
    	if(request.getSession().getAttribute("user") != null){
    		session = request.getSession().getAttribute("user");
    	} else if(request.getParameter(Constants.Parameter.USER) != null){
    		session = request.getParameter(Constants.Parameter.USER);
    	}
    	
    	if(session == null) {
    		return new ModelAndView("redirect:/login");
    	} else {
    		
    		User user = null;
    		if(session instanceof User) {
    			user = (User) session;
    		} else if(session instanceof String) {
    			user = userDao.getUserFromToken((String)session);
    		}
    		ModelAndView model = new ModelAndView("alcohol_myth");
    		model.addObject("user", user);
    		return model; 
    	}
    }
    @RequestMapping(value = "/alcoholTips", method = RequestMethod.GET)
    public ModelAndView alcoholTips(HttpServletRequest request) {
    	Object session = null;
    	if(request.getSession().getAttribute("user") != null){
    		session = request.getSession().getAttribute("user");
    	} else if(request.getParameter(Constants.Parameter.USER) != null){
    		session = request.getParameter(Constants.Parameter.USER);
    	}
    	
    	if(session == null) {
    		return new ModelAndView("redirect:/login");
    	} else {
    		
    		User user = null;
    		if(session instanceof User) {
    			user = (User) session;
    		} else if(session instanceof String) {
    			user = userDao.getUserFromToken((String)session);
    		}
    		ModelAndView model = new ModelAndView("alcohol_tips");
    		model.addObject("user", user);
    		return model; 
    	}
    }
    @RequestMapping(value = "/alcoholDrinks", method = RequestMethod.GET)
    public ModelAndView alcoholDrinks(HttpServletRequest request) {
    	Object session = null;
    	if(request.getSession().getAttribute("user") != null){
    		session = request.getSession().getAttribute("user");
    	} else if(request.getParameter(Constants.Parameter.USER) != null){
    		session = request.getParameter(Constants.Parameter.USER);
    	}
    	
    	if(session == null) {
    		return new ModelAndView("redirect:/login");
    	} else {
    		
    		User user = null;
    		if(session instanceof User) {
    			user = (User) session;
    		} else if(session instanceof String) {
    			user = userDao.getUserFromToken((String)session);
    		}
    		ModelAndView model = new ModelAndView("alcohol_drinks");
    		model.addObject("user", user);
    		return model; 
    	}
    }
       
}
