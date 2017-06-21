package com.uncc.mhealth.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.uncc.mhealth.config.Constants;
import com.uncc.mhealth.dao.ProsConsDAO;
import com.uncc.mhealth.dao.UserDAO;
import com.uncc.mhealth.model.ProsCons;
import com.uncc.mhealth.model.Response;
import com.uncc.mhealth.model.User;
 
/**
 * Handles requests for the application home page.
 */
@Controller
public class ProsConsController {
     
    @Autowired
    private UserDAO userDao;
    @Autowired
    private ProsConsDAO prosConsDao;
    
    @RequestMapping(value = "apps/apis/prosCons/store", method = RequestMethod.POST)
    public @ResponseBody Response strategyStore(HttpServletRequest request) {
    	String token = request.getParameter(Constants.Parameter.SESSION_TOKEN);
    	String pros_cons = request.getParameter(Constants.Parameter.PROS_CONS);
    	Response response = new Response();
    	User user = userDao.getUserFromToken(token); 
    	if(user != null) {
    		ProsCons bacLog = new ProsCons();
    		bacLog.setUser_id(user.getId());
    		bacLog.setPros_cons(pros_cons);
    		bacLog.setUpdated_time(new Date(System.currentTimeMillis()).toString());
    		prosConsDao.saveOrUpdate(bacLog);
    		response.setStatus(Response.SUCCESS);
    		response.setData(bacLog);
    	} else {
    		response.setStatus(Response.ERROR);
    		response.setMessage(Constants.User.INVALID_TOKEN);
    	}
    	return response;
    }
       
}
