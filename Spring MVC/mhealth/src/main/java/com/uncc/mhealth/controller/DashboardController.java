package com.uncc.mhealth.controller;

import java.util.List;

//import javax.servlet.http.HttpServletRequest;





import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.uncc.mhealth.dao.BacLogDAO;
import com.uncc.mhealth.dao.UserDAO;
import com.uncc.mhealth.dao.UserMIMappingDAO;
import com.uncc.mhealth.model.Response;
import com.uncc.mhealth.model.User;
import com.uncc.mhealth.service.BacService;

import javafx.util.Pair;
@Controller
public class DashboardController {
    
   @Autowired
   private UserDAO userDao;
   @Autowired
   private BacLogDAO bacLogDao;
   @Autowired
   private UserMIMappingDAO mIDAO;
   
   //****** this controller is not being used *******
   
   @RequestMapping(value = "/apps/apis/dashboard/getBac", method = RequestMethod.POST)
   public @ResponseBody Response dashboard(HttpServletRequest request) {
	   	System.out.println("Webservice called.");
		String token = request.getParameter("token");
		System.out.println("@@@Token=" + token);
    	User user = userDao.getUserFromToken(token);
    	
    	DashboardResponse dResponse = new DashboardResponse();
    	
    	String result = "";
    	if(true/*user != null*/) { 
    		
    		List<Pair<Integer, Integer>> datedBacData = BacService.getDatedAvgBacForAllUsers(bacLogDao);
			
    		result = "{";
    		for (Pair<Integer, Integer> a: datedBacData)
    		{
    			result = result + "\"" + a.getKey() + "\":\"" + a.getValue() + "\",\n";
    		}
    		if (datedBacData.size() > 0)
    			result = result.substring(0, result.length() -2) + "}";
    		
    	} else {
    		result = "{\"Error\": \"User Object not found\"}";
    	}
    	System.out.println("@@@Bac Done");
    	dResponse.setBacData(result);
    	dResponse.setUserList(userDao.list());
    	System.out.println("@@@User List done");
    	
    	int msgCount = mIDAO.getAllMapping(1).size();
    	msgCount = msgCount + mIDAO.getAllMapping(2).size();
    	dResponse.setMsgCount(msgCount);
    	System.out.println("@@@Messages done");
    	
	   	System.out.println("returning result ." + result);
	   	Response response = new Response();
	   	response.setData(dResponse);
	   	response.setStatus(Response.SUCCESS);
    	return response;   }
   		
   class DashboardResponse{
	   private String bacData;
	   private List<User> userList;
	   private Integer msgCount;
	public String getBacData() {
		return bacData;
	}
	public void setBacData(String bacData) {
		this.bacData = bacData;
	}
	public List<User> getUserList() {
		return userList;
	}
	public void setUserList(List<User> userList) {
		this.userList = userList;
	}
	public Integer getMsgCount() {
		return msgCount;
	}
	public void setMsgCount(Integer msgCount) {
		this.msgCount = msgCount;
	}
   }
   @RequestMapping(value = "/admin_dashboard", method = RequestMethod.GET)
   public ModelAndView adminDashboard(HttpServletRequest request) {
   	
   	if(request.getSession().getAttribute("user") == null){
   		return new ModelAndView("redirect:/login");
   	} else {
   		
   		ModelAndView model = new ModelAndView("admin_dashboard");
   		model.addObject("user", request.getSession().getAttribute("user"));
   		return model; 
   	}
   }

//   @RequestMapping(value = "/admin_dashboard", method = RequestMethod.GET)
//   public ModelAndView adminDashboard(HttpServletRequest request) {
//   	
//   	if(request.getSession().getAttribute("user") == null){
//   		return new ModelAndView("redirect:/login");
//   	} else {
//   		
//   		ModelAndView model = new ModelAndView("dashboard");
////   		model.addObject("user", request.getSession().getSessionAttribute("user"));
//   		return model; 
//   	}
//   }      

}
