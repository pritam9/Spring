package com.uncc.mhealth.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.uncc.mhealth.config.Constants;
import com.uncc.mhealth.dao.StrategiesDAO;
import com.uncc.mhealth.dao.UserDAO;
import com.uncc.mhealth.model.Response;
import com.uncc.mhealth.model.Strategies;
import com.uncc.mhealth.model.User;
 
/**
 * Handles requests for the application home page.
 */
@Controller
public class StrategyController {
     
    @Autowired
    private UserDAO userDao;
    @Autowired
    private StrategiesDAO strategiesDao;
    
    @RequestMapping(value = "apps/apis/strategy/store", method = RequestMethod.POST)
    public @ResponseBody Response strategyStore(HttpServletRequest request) {
    	String token = request.getParameter(Constants.Parameter.SESSION_TOKEN);
    	String strategy = request.getParameter(Constants.Parameter.STRATEGY);
    	Response response = new Response();
    	User user = userDao.getUserFromToken(token); 
    	if(user != null) {
    		Strategies st = new Strategies(user.getId(), strategy);
    		strategiesDao.saveOrUpdate(st);
    		
    		response.setStatus(Response.SUCCESS);
    		response.setData(st);
    	} else {
    		response.setStatus(Response.ERROR);
    		response.setMessage(Constants.User.INVALID_TOKEN);
    	}
    	return response;
    }
    
    @RequestMapping(value = "apps/apis/strategy/get", method = RequestMethod.POST)
    public @ResponseBody Response strategyGet(HttpServletRequest request) {
    	String token = request.getParameter(Constants.Parameter.SESSION_TOKEN);
    	Response response = new Response();
    	User user = userDao.getUserFromToken(token); 
    	if(user != null) {
    		Strategies st = strategiesDao.get(user.getId());
    		response.setStatus(Response.SUCCESS);
    		response.setData(st);
    	} else {
    		response.setStatus(Response.ERROR);
    		response.setMessage(Constants.User.INVALID_TOKEN);
    	}
    	return response;
    }
       
}
