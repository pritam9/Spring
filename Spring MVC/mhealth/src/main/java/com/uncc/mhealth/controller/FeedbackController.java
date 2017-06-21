package com.uncc.mhealth.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.uncc.mhealth.config.Constants;
import com.uncc.mhealth.dao.FeedbackDAO;
import com.uncc.mhealth.dao.QuestionDAO;
import com.uncc.mhealth.dao.UserDAO;
import com.uncc.mhealth.dao.UserSurveyDAO;
import com.uncc.mhealth.model.Feedback;
import com.uncc.mhealth.model.PF;
import com.uncc.mhealth.model.Question;
import com.uncc.mhealth.model.User;
import com.uncc.mhealth.model.UserSurvey;
import com.uncc.mhealth.model.UserSurveyResponse;
import com.uncc.mhealth.service.FeedbackManager;
 
/**
 * Handles requests for the application home page.
 */
@Controller
public class FeedbackController {
     
    @Autowired
    private UserDAO userDao;
    @Autowired
    private UserSurveyDAO userSurveyDao;
    @Autowired
    private FeedbackDAO feedbackDao;
    @Autowired
    private QuestionDAO questionDao;
    
    @RequestMapping(value = "/feedback", method = RequestMethod.POST)
    public ModelAndView feedbackPost(HttpServletRequest request) {
    	return feedback(request);
    }
    
    /**
     * this method validates the user and shows feedback page in two scenarios:
     * 1. Showing feedback page from browser by validating user session
     * 2. Showing feedback page from app by validating session token sent through post request 
     * @param request
     * @return
     */
    public ModelAndView feedback(HttpServletRequest request) {
    	Object session = null;
    	if(request.getParameter(Constants.Parameter.USER) != null){
    		session = request.getParameter(Constants.Parameter.USER);
    	} else if(request.getSession().getAttribute("user") != null){
    		session = request.getSession().getAttribute("user");
    	} 
    	if(session == null) {
    		return new ModelAndView("redirect:/login");
    	} else {
    		
    		User user = null;
    		if(session instanceof User) {
    			user = (User) session;
    		} else {
    			user = userDao.getUserFromToken((String)session);
    		}
    		ModelAndView model = new ModelAndView("feedback");
    		
    		/*UserSurvey userSurvey1 = userSurveyDao.get(user.getId(), "baseline_survey_page1");
    		UserSurvey userSurvey2 = userSurveyDao.get(user.getId(), "baseline_survey_page2");
    		UserSurvey userSurvey3 = userSurveyDao.get(user.getId(), "baseline_survey_page3");
    		UserSurvey userSurvey4 = userSurveyDao.get(user.getId(), "baseline_survey_page4");
    		UserSurvey userSurvey5 = userSurveyDao.get(user.getId(), "baseline_survey_page5");
    		UserSurvey userSurvey6 = userSurveyDao.get(user.getId(), "baseline_survey_page6");
    		UserSurvey userSurvey7 = userSurveyDao.get(user.getId(), "baseline_survey_page7");
    		UserSurvey userSurvey8 = userSurveyDao.get(user.getId(), "baseline_survey_page8");*/
    		
    		/*List<UserSurveyResponse> userSurvey1=userSurveyDao.getUserSurveyResponse(user.getId(),"baseline_survey_page1");
    		List<UserSurveyResponse> userSurvey2=userSurveyDao.getUserSurveyResponse(user.getId(),"baseline_survey_page2");
    		List<UserSurveyResponse> userSurvey3=userSurveyDao.getUserSurveyResponse(user.getId(),"baseline_survey_page3");
    		List<UserSurveyResponse> userSurvey4=userSurveyDao.getUserSurveyResponse(user.getId(),"baseline_survey_page4");
    		List<UserSurveyResponse> userSurvey5=userSurveyDao.getUserSurveyResponse(user.getId(),"baseline_survey_page5");
    		List<UserSurveyResponse> userSurvey6=userSurveyDao.getUserSurveyResponse(user.getId(),"baseline_survey_page6");
    		List<UserSurveyResponse> userSurvey7=userSurveyDao.getUserSurveyResponse(user.getId(),"baseline_survey_page7");
    		List<UserSurveyResponse> userSurvey8=userSurveyDao.getUserSurveyResponse(user.getId(),"baseline_survey_page8");*/
    		
    		ObjectMapper mapper = new ObjectMapper();
    		try {
    			
    			/*ArrayList<Question> myObjects1 = (ArrayList<Question>)FeedbackManager.createUserSurveyObj(userSurvey1,questionDao.getSurvey("baseline",1));
    			model.addObject("survey1", myObjects1);
    			
    			ArrayList<Question> myObjects2 = (ArrayList<Question>)FeedbackManager.createUserSurveyObj(userSurvey2,questionDao.getSurvey("baseline",2));
    			model.addObject("survey2", myObjects2);
    			
    			ArrayList<Question> myObjects3 = (ArrayList<Question>)FeedbackManager.createUserSurveyObj(userSurvey3,questionDao.getSurvey("cea",3));
    			model.addObject("survey3", myObjects3);
    			
    			ArrayList<Question> myObjects4 = (ArrayList<Question>)FeedbackManager.createUserSurveyObj(userSurvey4,questionDao.getSurvey("baseline",4));
    			model.addObject("survey4", myObjects4);
    			
    			ArrayList<Question> myObjects5 = (ArrayList<Question>)FeedbackManager.createUserSurveyObj(userSurvey5,questionDao.getSurvey("baseline",5));
    			model.addObject("survey5", myObjects5);
    			
    			ArrayList<Question> myObjects6 = (ArrayList<Question>)FeedbackManager.createUserSurveyObj(userSurvey6,questionDao.getSurvey("pss",6));
    			model.addObject("survey6", myObjects6);
    			
    			ArrayList<Question> myObjects7 = (ArrayList<Question>)FeedbackManager.createUserSurveyObj(userSurvey7,questionDao.getSurvey("rcq",7));
    			model.addObject("survey7", myObjects7);
    			
    			ArrayList<Question> myObjects8 = (ArrayList<Question>)FeedbackManager.createUserSurveyObj(userSurvey8,questionDao.getSurvey("baseline",8));
    			model.addObject("survey8", myObjects8);*/
    			
				/*ArrayList<Question> myObjects1 = mapper.readValue(userSurvey1.getResponse(), new TypeReference<ArrayList<Question>>(){});
				model.addObject("survey1", myObjects1);
				
				ArrayList<Question> myObjects2 = mapper.readValue(userSurvey2.getResponse(), new TypeReference<ArrayList<Question>>(){});
				model.addObject("survey2", myObjects2);
				
				ArrayList<Question> myObjects3 = mapper.readValue(userSurvey3.getResponse(), new TypeReference<ArrayList<Question>>(){});
				model.addObject("survey3", myObjects3);
				
				ArrayList<Question> myObjects4 = mapper.readValue(userSurvey4.getResponse(), new TypeReference<ArrayList<Question>>(){});
				model.addObject("survey4", myObjects4);
				
				ArrayList<Question> myObjects5 = mapper.readValue(userSurvey5.getResponse(), new TypeReference<ArrayList<Question>>(){});
				model.addObject("survey5", myObjects5);
				
				ArrayList<Question> myObjects6 = mapper.readValue(userSurvey6.getResponse(), new TypeReference<ArrayList<Question>>(){});
				model.addObject("survey6", myObjects6);
				
				ArrayList<Question> myObjects7 = mapper.readValue(userSurvey7.getResponse(), new TypeReference<ArrayList<Question>>(){});
				model.addObject("survey7", myObjects7);
				
				ArrayList<Question> myObjects8 = mapper.readValue(userSurvey8.getResponse(), new TypeReference<ArrayList<Question>>(){});
				model.addObject("survey8", myObjects8);*/
				
				Feedback feedback = feedbackDao.get(user.getId());
				PF pf = mapper.readValue(feedback.getFeedback(), PF.class);
				//System.out.println("PF Obj ::"+pf.toString());
				model.addObject("pf", pf);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    		
    		model.addObject("user", user);
    		return model; 
    	}
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    //**************** Following methods are not in use ******************
    @Deprecated
    @RequestMapping(value = "/feedback", method = RequestMethod.GET)
    public ModelAndView feedbackGet(HttpServletRequest request) {
    	return feedback(request);
    }
       
}
