package com.uncc.mhealth.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.uncc.mhealth.config.Constants;
import com.uncc.mhealth.dao.FeedbackDAO;
import com.uncc.mhealth.dao.QuestionDAO;
import com.uncc.mhealth.dao.UserDAO;
import com.uncc.mhealth.dao.UserSurveyDAO;
import com.uncc.mhealth.model.Feedback;
import com.uncc.mhealth.model.MHealthRequest;
import com.uncc.mhealth.model.Option;
import com.uncc.mhealth.model.PF;
import com.uncc.mhealth.model.Question;
import com.uncc.mhealth.model.Response;
import com.uncc.mhealth.model.SubQuestion;
import com.uncc.mhealth.model.Survey;
import com.uncc.mhealth.model.SurveyResponse;
import com.uncc.mhealth.model.User;
import com.uncc.mhealth.model.UserSurvey;
import com.uncc.mhealth.model.UserSurveyResponse;
import com.uncc.mhealth.service.FeedbackManager;
import com.uncc.mhealth.service.MiService;
import com.uncc.mhealth.service.SurveyService;
import com.uncc.mhealth.utils.EmailUtil;

@Controller
public class SurveyController {
	@Autowired
    private QuestionDAO questionDao;
	@Autowired
    private UserDAO userDao;
	@Autowired
    private UserSurveyDAO userSurveyDao;
	@Autowired
	private MiService miService;
	@Autowired
	private FeedbackManager feedbackManager;
	@Autowired
    private FeedbackDAO feedbackDao;
	
	@RequestMapping(value="/baseline_survey_page1")
    public ModelAndView baselineSurveyPage1(HttpServletRequest request) {
    	if(request.getSession().getAttribute("user") == null){
    		return new ModelAndView("redirect:/login");
    	} else {
    		ModelAndView model = new ModelAndView("baseline_survey_page1");
    		model.addObject("user", request.getSession().getAttribute("user"));
    		model.addObject("survey", "baseline_survey_page1");
    		return model; 
    	} 
    }
    @RequestMapping(value="/baseline_survey_page2")
    public ModelAndView baselineSurveyPage2(HttpServletRequest request) {
    	if(request.getSession().getAttribute("user") == null){
    		return new ModelAndView("redirect:/login");
    	} else {
    		ModelAndView model = new ModelAndView("baseline_survey_page2");
    		UserSurvey userSurvey = userSurveyDao.get(((User)request.getSession().getAttribute("user")).getId(), "baseline_survey_page1");
    		ObjectMapper mapper = new ObjectMapper();
    		try {
				ArrayList<Question> myObjects = mapper.readValue(userSurvey.getResponse(), new TypeReference<ArrayList<Question>>(){});
				model.addObject("questions", myObjects);
			} catch (Exception e) {
				e.printStackTrace();
			}
    		
    		model.addObject("user", request.getSession().getAttribute("user"));
    		model.addObject("survey", "baseline_survey_page2");
    		return model; 
    	} 
    }
    @RequestMapping(value="/baseline_survey_page3")
    public ModelAndView baselineSurveyPage3(HttpServletRequest request) {
    	if(request.getSession().getAttribute("user") == null){
    		return new ModelAndView("redirect:/login");
    	} else {
    		ModelAndView model = new ModelAndView("baseline_survey_page3");
    		UserSurvey userSurvey = userSurveyDao.get(((User)request.getSession().getAttribute("user")).getId(), "baseline_survey_page2");
    		ObjectMapper mapper = new ObjectMapper();
    		try {
				ArrayList<Question> myObjects = mapper.readValue(userSurvey.getResponse(), new TypeReference<ArrayList<Question>>(){});
				model.addObject("questions", myObjects);
			} catch (Exception e) {
				e.printStackTrace();
			}
    		
    		model.addObject("user", request.getSession().getAttribute("user"));
    		model.addObject("survey", "baseline_survey_page3");
    		return model; 
    	} 
    }
    @RequestMapping(value="/baseline_survey_page4")
    public ModelAndView baselineSurveyPage4(HttpServletRequest request) {
    	if(request.getSession().getAttribute("user") == null){
    		return new ModelAndView("redirect:/login");
    	} else {
    		ModelAndView model = new ModelAndView("baseline_survey_page4");
    		UserSurvey userSurvey = userSurveyDao.get(((User)request.getSession().getAttribute("user")).getId(), "baseline_survey_page3");
    		ObjectMapper mapper = new ObjectMapper();
    		try {
				ArrayList<Question> myObjects = mapper.readValue(userSurvey.getResponse(), new TypeReference<ArrayList<Question>>(){});
				model.addObject("questions", myObjects);
			} catch (Exception e) {
				e.printStackTrace();
			}
    		
    		model.addObject("user", request.getSession().getAttribute("user"));
    		model.addObject("survey", "baseline_survey_page4");
    		return model; 
    	} 
    }
    @RequestMapping(value="/baseline_survey_page5")
    public ModelAndView baselineSurveyPage5(HttpServletRequest request) {
    	if(request.getSession().getAttribute("user") == null){
    		return new ModelAndView("redirect:/login");
    	} else {
    		ModelAndView model = new ModelAndView("baseline_survey_page5");
    		UserSurvey userSurvey = userSurveyDao.get(((User)request.getSession().getAttribute("user")).getId(), "baseline_survey_page4");
    		ObjectMapper mapper = new ObjectMapper();
    		try {
				ArrayList<Question> myObjects = mapper.readValue(userSurvey.getResponse(), new TypeReference<ArrayList<Question>>(){});
				model.addObject("questions", myObjects);
			} catch (Exception e) {
				e.printStackTrace();
			}
    		
    		model.addObject("user", request.getSession().getAttribute("user"));
    		model.addObject("survey", "baseline_survey_page5");
    		return model; 
    	} 
    }
    @RequestMapping(value="/baseline_survey_page6")
    public ModelAndView baselineSurveyPage6(HttpServletRequest request) {
    	if(request.getSession().getAttribute("user") == null){
    		return new ModelAndView("redirect:/login");
    	} else {
    		ModelAndView model = new ModelAndView("baseline_survey_page6");
    		UserSurvey userSurvey = userSurveyDao.get(((User)request.getSession().getAttribute("user")).getId(), "baseline_survey_page5");
    		ObjectMapper mapper = new ObjectMapper();
    		try {
				ArrayList<Question> myObjects = mapper.readValue(userSurvey.getResponse(), new TypeReference<ArrayList<Question>>(){});
				model.addObject("questions", myObjects);
			} catch (Exception e) {
				e.printStackTrace();
			}
    		
    		model.addObject("user", request.getSession().getAttribute("user"));
    		model.addObject("survey", "baseline_survey_page6");
    		return model; 
    	} 
    }
    @RequestMapping(value="/baseline_survey_page7")
    public ModelAndView baselineSurveyPage7(HttpServletRequest request) {
    	if(request.getSession().getAttribute("user") == null){
    		return new ModelAndView("redirect:/login");
    	} else {
    		ModelAndView model = new ModelAndView("baseline_survey_page7");
    		UserSurvey userSurvey = userSurveyDao.get(((User)request.getSession().getAttribute("user")).getId(), "baseline_survey_page6");
    		ObjectMapper mapper = new ObjectMapper();
    		try {
				ArrayList<Question> myObjects = mapper.readValue(userSurvey.getResponse(), new TypeReference<ArrayList<Question>>(){});
				model.addObject("questions", myObjects);
			} catch (Exception e) {
				e.printStackTrace();
			}
    		
    		model.addObject("user", request.getSession().getAttribute("user"));
    		model.addObject("survey", "baseline_survey_page7");
    		return model; 
    	} 
    }
    @RequestMapping(value="/baseline_survey_page8")
    public ModelAndView baselineSurveyPage8(HttpServletRequest request) {
    	if(request.getSession().getAttribute("user") == null){
    		return new ModelAndView("redirect:/login");
    	} else {
    		ModelAndView model = new ModelAndView("baseline_survey_page8");
    		UserSurvey userSurvey = userSurveyDao.get(((User)request.getSession().getAttribute("user")).getId(), "baseline_survey_page1");
    		ObjectMapper mapper = new ObjectMapper();
    		try {
				ArrayList<Question> myObjects = mapper.readValue(userSurvey.getResponse(), new TypeReference<ArrayList<Question>>(){});
				model.addObject("questions", myObjects);
			} catch (Exception e) {
				e.printStackTrace();
			}
    		
    		model.addObject("user", request.getSession().getAttribute("user"));
    		model.addObject("survey", "baseline_survey_page8");
    		return model; 
    	} 
    }
    
    @RequestMapping(value="/six_week_survey_page1")
    public ModelAndView sixWeekSurveyPage1(HttpServletRequest request) {
    	if(request.getSession().getAttribute("user") == null){
    		return new ModelAndView("redirect:/login");
    	} else {
    		ModelAndView model = new ModelAndView("six_week_survey_page1");
    		model.addObject("user", request.getSession().getAttribute("user"));
    		model.addObject("survey", "six_week_survey_page1");
    		return model; 
    	} 
    }
    @RequestMapping(value="/six_week_survey_page2")
    public ModelAndView sixWeekSurveyPage2(HttpServletRequest request) {
    	if(request.getSession().getAttribute("user") == null){
    		return new ModelAndView("redirect:/login");
    	} else {
    		ModelAndView model = new ModelAndView("six_week_survey_page2");
    		UserSurvey userSurvey = userSurveyDao.get(((User)request.getSession().getAttribute("user")).getId(), "six_week_survey_page1");
    		ObjectMapper mapper = new ObjectMapper();
    		try {
				ArrayList<Question> myObjects = mapper.readValue(userSurvey.getResponse(), new TypeReference<ArrayList<Question>>(){});
				model.addObject("questions", myObjects);
			} catch (Exception e) {
				e.printStackTrace();
			}
    		
    		model.addObject("user", request.getSession().getAttribute("user"));
    		model.addObject("survey", "six_week_survey_page2");
    		return model; 
    	} 
    }
    @RequestMapping(value="/six_week_survey_page3")
    public ModelAndView sixWeekSurveyPage3(HttpServletRequest request) {
    	if(request.getSession().getAttribute("user") == null){
    		return new ModelAndView("redirect:/login");
    	} else {
    		ModelAndView model = new ModelAndView("six_week_survey_page3");
    		UserSurvey userSurvey = userSurveyDao.get(((User)request.getSession().getAttribute("user")).getId(), "six_week_survey_page2");
    		ObjectMapper mapper = new ObjectMapper();
    		try {
				ArrayList<Question> myObjects = mapper.readValue(userSurvey.getResponse(), new TypeReference<ArrayList<Question>>(){});
				model.addObject("questions", myObjects);
			} catch (Exception e) {
				e.printStackTrace();
			}
    		
    		model.addObject("user", request.getSession().getAttribute("user"));
    		model.addObject("survey", "six_week_survey_page3");
    		return model; 
    	} 
    }
    @RequestMapping(value="/six_week_survey_page4")
    public ModelAndView sixWeekSurveyPage4(HttpServletRequest request) {
    	if(request.getSession().getAttribute("user") == null){
    		return new ModelAndView("redirect:/login");
    	} else {
    		ModelAndView model = new ModelAndView("six_week_survey_page4");
    		UserSurvey userSurvey = userSurveyDao.get(((User)request.getSession().getAttribute("user")).getId(), "six_week_survey_page3");
    		ObjectMapper mapper = new ObjectMapper();
    		try {
				ArrayList<Question> myObjects = mapper.readValue(userSurvey.getResponse(), new TypeReference<ArrayList<Question>>(){});
				model.addObject("questions", myObjects);
			} catch (Exception e) {
				e.printStackTrace();
			}
    		
    		model.addObject("user", request.getSession().getAttribute("user"));
    		model.addObject("survey", "six_week_survey_page4");
    		return model; 
    	} 
    }
    @RequestMapping(value="/six_week_survey_page5")
    public ModelAndView sixWeekSurveyPage5(HttpServletRequest request) {
    	if(request.getSession().getAttribute("user") == null){
    		return new ModelAndView("redirect:/login");
    	} else {
    		ModelAndView model = new ModelAndView("six_week_survey_page5");
    		UserSurvey userSurvey = userSurveyDao.get(((User)request.getSession().getAttribute("user")).getId(), "six_week_survey_page4");
    		ObjectMapper mapper = new ObjectMapper();
    		try {
				ArrayList<Question> myObjects = mapper.readValue(userSurvey.getResponse(), new TypeReference<ArrayList<Question>>(){});
				model.addObject("questions", myObjects);
			} catch (Exception e) {
				e.printStackTrace();
			}
    		
    		model.addObject("user", request.getSession().getAttribute("user"));
    		model.addObject("survey", "six_week_survey_page5");
    		return model; 
    	} 
    }
    @RequestMapping(value="/six_week_survey_page6")
    public ModelAndView sixWeekSurveyPage6(HttpServletRequest request) {
    	if(request.getSession().getAttribute("user") == null){
    		return new ModelAndView("redirect:/login");
    	} else {
    		ModelAndView model = new ModelAndView("six_week_survey_page6");
    		UserSurvey userSurvey = userSurveyDao.get(((User)request.getSession().getAttribute("user")).getId(), "six_week_survey_page5");
    		ObjectMapper mapper = new ObjectMapper();
    		try {
				ArrayList<Question> myObjects = mapper.readValue(userSurvey.getResponse(), new TypeReference<ArrayList<Question>>(){});
				model.addObject("questions", myObjects);
			} catch (Exception e) {
				e.printStackTrace();
			}
    		
    		model.addObject("user", request.getSession().getAttribute("user"));
    		model.addObject("survey", "six_week_survey_page6");
    		return model; 
    	} 
    }
    @RequestMapping(value="/six_week_survey_page7")
    public ModelAndView sixWeekSurveyPage7(HttpServletRequest request) {
    	if(request.getSession().getAttribute("user") == null){
    		return new ModelAndView("redirect:/login");
    	} else {
    		ModelAndView model = new ModelAndView("six_week_survey_page7");
    		UserSurvey userSurvey = userSurveyDao.get(((User)request.getSession().getAttribute("user")).getId(), "six_week_survey_page6");
    		ObjectMapper mapper = new ObjectMapper();
    		try {
				ArrayList<Question> myObjects = mapper.readValue(userSurvey.getResponse(), new TypeReference<ArrayList<Question>>(){});
				model.addObject("questions", myObjects);
			} catch (Exception e) {
				e.printStackTrace();
			}
    		
    		model.addObject("user", request.getSession().getAttribute("user"));
    		model.addObject("survey", "six_week_survey_page7");
    		return model; 
    	} 
    }
    @RequestMapping(value="/six_week_survey_page8")
    public ModelAndView sixWeekSurveyPage8(HttpServletRequest request) {
    	if(request.getSession().getAttribute("user") == null){
    		return new ModelAndView("redirect:/login");
    	} else {
    		ModelAndView model = new ModelAndView("six_week_survey_page8");
    		UserSurvey userSurvey = userSurveyDao.get(((User)request.getSession().getAttribute("user")).getId(), "six_week_survey_page1");
    		ObjectMapper mapper = new ObjectMapper();
    		try {
				ArrayList<Question> myObjects = mapper.readValue(userSurvey.getResponse(), new TypeReference<ArrayList<Question>>(){});
				model.addObject("questions", myObjects);
			} catch (Exception e) {
				e.printStackTrace();
			}
    		
    		model.addObject("user", request.getSession().getAttribute("user"));
    		model.addObject("survey", "six_week_survey_page8");
    		return model; 
    	} 
    }
    
    @RequestMapping(value="/survey_complete")
    public ModelAndView complete() {
        ModelAndView model = new ModelAndView("survey_complete");
//        MailService.SendSimpleMessage();
        return model;
    }

    @RequestMapping(value="/survey_baseline/{pageNo}")
    public ModelAndView baselineSurvey_all(@PathVariable("pageNo") int pageNo,HttpServletRequest request) {
    	if(request.getSession().getAttribute("user") == null){
    		return new ModelAndView("redirect:/login");
    	} else {
    		User user=(User)request.getSession().getAttribute("user");
    		//fetches all the questions to be displayed in the Page
    		String surveyName="baseline",prevsurveyName="baseline";
    		if(pageNo==3)
    			surveyName="cea";
    		else if(pageNo==4)
    			prevsurveyName="cea";
    		else if(pageNo==6)
    			surveyName="pss";
    		else if(pageNo==7){
    			surveyName="rcq";
    			prevsurveyName="pss";
    		}
    		else if(pageNo==8){
    			prevsurveyName="rcq";
    		}
    		List<Question> listQuestions = questionDao.getSurvey(surveyName,pageNo);
    		if(pageNo==1){
    			//listQuestions.remove(new Question(23));
    			//listQuestions.remove(new Question(59));
    			if(!user.getIstoApp().equals("Y")){
    				listQuestions.remove(new Question(107));
        		}
    		}
    		
    		ObjectMapper mapper = new ObjectMapper();
    		if(pageNo>1){
    			//gets the user survey response Object
    			//UserSurvey userSurvey = userSurveyDao.get(((User)request.getSession().getAttribute("user")).getId(), "baseline_survey_page"+(pageNo-1));
    			List<UserSurveyResponse> userSurvey=userSurveyDao.getUserSurveyResponse(((User)request.getSession().getAttribute("user")).getId(),"baseline_survey_page"+(pageNo-1));
    			
    			try {
    				//ArrayList<Question> myObjects = mapper.readValue(userSurvey.getResponse(), new TypeReference<ArrayList<Question>>(){});
    				ArrayList<Question> myObjects = (ArrayList<Question>)FeedbackManager.createUserSurveyObj(userSurvey,questionDao.getSurvey(prevsurveyName,pageNo-1));
    				//logic to fetch only the questions to the displayed from all the questions to be displayed for the page
    				if(pageNo==2){
    					boolean canShow = false;
    					HashMap<Integer, String> map = new HashMap<Integer, String>();
    					//fetch the specific question
    					int index = myObjects.indexOf(new Question(18));
    					if(index > -1) {
    						//get the sub questions of the specific question and put it in map
    						for(SubQuestion sq : myObjects.get(index).getSubquestions()) {
    							map.put(sq.getId(), sq.getAnswer());
    							//if value is 2 then Have used in the last 30 days
    							if(sq.getAnswer() != null && sq.getAnswer().equals("2")){
    								canShow = true;
    							}
    						}
    					}
    					if(canShow){
    						//fetch the sub question id answer
    						String answer = map.get(11);
    						//Compare it with 2 to check Have used in the last 30 days
    						if(answer != null && !answer.equals("2")) {
    							index=listQuestions.indexOf(new Question(19));
    							if(index>-1){
    								listQuestions.get(index).getSubquestions().remove(new SubQuestion(15));
    							}
    						}
    						answer = map.get(12);
    						if(answer != null && !answer.equals("2")) {
    							index=listQuestions.indexOf(new Question(19));
    							if(index>-1){
    								listQuestions.get(index).getSubquestions().remove(new SubQuestion(16));
    							}
    						}
    					}else{
    						//index=listQuestions.indexOf(new Question(19));
    						listQuestions.remove(new Question(19));
    					}
    				}else if(pageNo==5){
    					boolean canShow = false;
    					HashMap<Integer, String> map = new HashMap<Integer, String>();
    					int index = myObjects.indexOf(new Question(100));

    					for(SubQuestion sq : myObjects.get(index).getSubquestions()) {
    						map.put(sq.getId(), sq.getAnswer());
    						if(sq.getAnswer() != null && sq.getAnswer().equals("1")){
    							canShow = true;
    						}
    					}
    					if(canShow){
    						//fetch the sub question id answer
    						int i=180,j=204;
    						for(int k=0;k<24;k++){
    							String answer = map.get(i+k);
        						if(answer != null && !answer.equals("1")) {
        							index=listQuestions.indexOf(new Question(103));
        							if(index>-1){
        								listQuestions.get(index).getSubquestions().remove(new SubQuestion(j+k));
        							}
        						}
    						}
    						i=248;j=272;
    						for(int k=0;k<24;k++){
    							String answer = map.get(i+k);
        						if(answer != null && !answer.equals("1")) {
        							index=listQuestions.indexOf(new Question(103));
        							if(index>-1){
        								listQuestions.get(index).getSubquestions().remove(new SubQuestion(j+k));
        							}
        						}
    						}
    					}
    				}
    				
    			} catch (Exception e) {
    				e.printStackTrace();
    			}
    		}
    		String questionListJsonTemplate="{\"status\":0,\"message\":null,\"data\":[]}";
    		try {
				//System.out.println("Json String ::"+mapper.writeValueAsString(listQuestions));
    			questionListJsonTemplate="{\"status\":0,\"message\":null,\"data\":"+mapper.writeValueAsString(listQuestions)+"}";
			} catch (JsonGenerationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (JsonMappingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    		ModelAndView model = new ModelAndView("baseline_survey_page");
    		model.addObject("questionList", listQuestions);
    		model.addObject("questionListJsonTemplate", questionListJsonTemplate);
    		model.addObject("user", request.getSession().getAttribute("user"));
    		model.addObject("survey", "baseline_survey_page"+pageNo);
    		model.addObject("pageNo",pageNo);
    		return model; 
    	} 
    }
    
    @RequestMapping(value="/survey_sixweek/{pageNo}")
    public ModelAndView sixWeekSurvey_all(@PathVariable("pageNo") int pageNo,HttpServletRequest request) {
    	if(request.getSession().getAttribute("user") == null){
    		return new ModelAndView("redirect:/login");
    	} else {
    		User user=(User)request.getSession().getAttribute("user");
    		//fetches all the questions to be displayed in the Page
    		String surveyName="baseline",prevsurveyName="baseline";
    		if(pageNo==3)
    			surveyName="cea";
    		else if(pageNo==4)
    			prevsurveyName="cea";
    		else if(pageNo==6)
    			surveyName="pss";
    		else if(pageNo==7){
    			surveyName="rcq";
    			prevsurveyName="pss";
    		}
    		else if(pageNo==8){
    			prevsurveyName="rcq";
    		}
    		List<Question> listQuestions = questionDao.getSixWeekSurvey(surveyName,pageNo);
    		
    		ObjectMapper mapper = new ObjectMapper();
    		if(pageNo>1){
    			//gets the user survey response Object
    			//UserSurvey userSurvey = userSurveyDao.get(((User)request.getSession().getAttribute("user")).getId(), "baseline_survey_page"+(pageNo-1));
    			List<UserSurveyResponse> userSurvey=userSurveyDao.getUserSurveyResponse(((User)request.getSession().getAttribute("user")).getId(),"six_week_survey_page"+(pageNo-1));
    			
    			try {
    				//ArrayList<Question> myObjects = mapper.readValue(userSurvey.getResponse(), new TypeReference<ArrayList<Question>>(){});
    				ArrayList<Question> myObjects = (ArrayList<Question>)FeedbackManager.createUserSurveyObj(userSurvey,questionDao.getSixWeekSurvey(prevsurveyName,pageNo-1));
    				//logic to fetch only the questions to the displayed from all the questions to be displayed for the page
    				if(pageNo==2){
    					boolean canShow = false;
    					HashMap<Integer, String> map = new HashMap<Integer, String>();
    					//fetch the specific question
    					int index = myObjects.indexOf(new Question(18));
    					if(index > -1) {
    						//get the sub questions of the specific question and put it in map
    						for(SubQuestion sq : myObjects.get(index).getSubquestions()) {
    							map.put(sq.getId(), sq.getAnswer());
    							//if value is 2 then Have used in the last 30 days
    							if(sq.getAnswer() != null && sq.getAnswer().equals("2")){
    								canShow = true;
    							}
    						}
    					}
    					if(canShow){
    						//fetch the sub question id answer
    						String answer = map.get(11);
    						//Compare it with 2 to check Have used in the last 30 days
    						if(answer != null && !answer.equals("2")) {
    							index=listQuestions.indexOf(new Question(19));
    							if(index>-1){
    								listQuestions.get(index).getSubquestions().remove(new SubQuestion(15));
    							}
    						}
    						answer = map.get(12);
    						if(answer != null && !answer.equals("2")) {
    							index=listQuestions.indexOf(new Question(19));
    							if(index>-1){
    								listQuestions.get(index).getSubquestions().remove(new SubQuestion(16));
    							}
    						}
    					}else{
    						//index=listQuestions.indexOf(new Question(19));
    						listQuestions.remove(new Question(19));
    					}
    				}else if(pageNo==5){
    					boolean canShow = false;
    					HashMap<Integer, String> map = new HashMap<Integer, String>();
    					int index = myObjects.indexOf(new Question(100));

    					for(SubQuestion sq : myObjects.get(index).getSubquestions()) {
    						map.put(sq.getId(), sq.getAnswer());
    						if(sq.getAnswer() != null && sq.getAnswer().equals("1")){
    							canShow = true;
    						}
    					}
    					if(canShow){
    						//fetch the sub question id answer
    						int i=180,j=204;
    						for(int k=0;k<24;k++){
    							String answer = map.get(i+k);
        						if(answer != null && !answer.equals("1")) {
        							index=listQuestions.indexOf(new Question(103));
        							if(index>-1){
        								listQuestions.get(index).getSubquestions().remove(new SubQuestion(j+k));
        							}
        						}
    						}
    						i=248;j=272;
    						for(int k=0;k<24;k++){
    							String answer = map.get(i+k);
        						if(answer != null && !answer.equals("1")) {
        							index=listQuestions.indexOf(new Question(103));
        							if(index>-1){
        								listQuestions.get(index).getSubquestions().remove(new SubQuestion(j+k));
        							}
        						}
    						}
    					}
    				}
    				
    			} catch (Exception e) {
    				e.printStackTrace();
    			}
    		}
    		String questionListJsonTemplate="{\"status\":0,\"message\":null,\"data\":[]}";
    		try {
				//System.out.println("Json String ::"+mapper.writeValueAsString(listQuestions));
    			questionListJsonTemplate="{\"status\":0,\"message\":null,\"data\":"+mapper.writeValueAsString(listQuestions)+"}";
			} catch (JsonGenerationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (JsonMappingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    		ModelAndView model = new ModelAndView("six_week_survey_page");
    		model.addObject("questionList", listQuestions);
    		model.addObject("questionListJsonTemplate", questionListJsonTemplate);
    		model.addObject("user", request.getSession().getAttribute("user"));
    		model.addObject("survey", "six_week_survey_page"+pageNo);
    		model.addObject("pageNo",pageNo);
    		return model; 
    	} 
    }
    
    /**
     * This gets called for every survey form submission. It saves user responses to the database.
     * For the last page submission, it starts MI flow by sending first two welcome messages to user. 
     * @param request
     * @return
     */
    @RequestMapping(value = "/apps/submitSurveyPage", method = RequestMethod.POST)
    public @ResponseBody Response submitSurveyPage(@RequestBody SurveyResponse request) {
    	Response response = new Response();
    	User user = userDao.getUserFromToken(request.getToken());
    	if(user != null) {
    		ObjectMapper mapper = new ObjectMapper(); 
    		try {
				String jsonInString = mapper.writeValueAsString(request.getQuestions());
				UserSurvey survey = new UserSurvey();
				UserSurveyResponse userResponse;
				for (Question q : request.getQuestions()) {
					if(q.getSubquestions().isEmpty()){
						if (q.getAnswer() != null && !q.getAnswer().equals("")) {
							userResponse = new UserSurveyResponse();
							userResponse.setId(user.getId());
							userResponse.setSurvey(request.getSurvey());
							userResponse.setQuestionId(q.getId());
							userResponse.setAnswer(q.getAnswer());
							userSurveyDao.saveOrUpdate(userResponse);
						}
					}
					else{
						for (SubQuestion sq : q.getSubquestions()) {
							if (sq.getAnswer() != null && !sq.getAnswer().equals("")) {
								userResponse = new UserSurveyResponse();
								userResponse.setId(user.getId());
								userResponse.setSurvey(request.getSurvey());
								userResponse.setQuestionId(q.getId());
								userResponse.setSubQuestionId(sq.getId());
								userResponse.setSubAnswer(sq.getAnswer());
								userSurveyDao.saveOrUpdate(userResponse);
								
							}
						}	
					}
				}
	    		survey.setId(user.getId());
	    		survey.setResponse(jsonInString);
	    		survey.setSurvey(request.getSurvey());
	    		userSurveyDao.saveOrUpdate(survey);
	    		
	    		response.setStatus(Response.SUCCESS);
	    		
	    		//create MI plan for this user
	    		if(request.getSurvey() != null && request.getSurvey().equals("baseline_survey_page8")){
	    			//update user registration date;
	    			user.setRegistrationDate(new Date(System.currentTimeMillis()).toString());
	    			userDao.saveOrUpdate(user);
	    			feedbackManager.createFeedback(user);
	    			miService.sentWelcomeMessages(user.getId());
	    		}
	    		if(request.getSurvey() != null && request.getSurvey().equals("six_week_survey_page8")){
	    			//update the six week completed flag;
	    			user.setSixWeekFlag("Y");
	    			userDao.saveOrUpdate(user);
	    			EmailUtil.sendMessage(user.getRandomized_id());
	    		}
			} catch (IOException e) {
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
    @RequestMapping(value = "/apps/apis/getSurveyCsv", method = RequestMethod.POST)
	public @ResponseBody Response getSurveyCsv(HttpServletRequest request) {
    		Response response = new Response();
    		response.setStatus(Response.SUCCESS);
    		
    		ArrayList<Survey> surveyList = new ArrayList<Survey>();

    		List<User> userList = userDao.list();
    		for(User user: userList){
    			Survey survey = feedbackManager.getAllSurveyQuestionsWithFeedback(user);
    			surveyList.add(survey);
    		}
    		
    		
    		response.setData(surveyList);
    	
		return response;
	}
    @RequestMapping(value = "/apps/apis/getNewSurveyCsv", method = RequestMethod.POST)
	public @ResponseBody Response getNewSurveyCsv(HttpServletRequest request) {
    		Response response = new Response();
    		response.setStatus(Response.SUCCESS);
    		
    		ArrayList<Survey> surveyList = new ArrayList<Survey>();
    		List<User> userList = userDao.list();
    		for(User user: userList){
    			Survey survey = feedbackManager.getAllNewSurveyQuestionsWithFeedback(user);
    			if(survey!=null && survey.getUserSurveyList()!=null && survey.getUserSurveyList().size()>0){
    				surveyList.add(survey);
    			}
    		}
    		
    		response.setData(surveyList);
    	
		return response;
	}
    /**
     * Handle request to download an Excel document
     */
    @SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(value = "/downloadSurveyResults", method = RequestMethod.GET)
	public ModelAndView downloadExcel(HttpServletRequest request) {
		if (request.getSession().getAttribute("user") == null) {
			return new ModelAndView("redirect:/login");
		} else {

			ArrayList<HashMap<String, ArrayList<ArrayList<String>>>> resultList = new ArrayList<HashMap<String, ArrayList<ArrayList<String>>>>();

			List<Question> listQuestions1 = questionDao.getSurvey("baseline", 1);
			List<Question> listQuestions2 = questionDao.getSurvey("baseline", 2);
			List<Question> listQuestions3 = questionDao.getSurvey("cea", 3);
			List<Question> listQuestions4 = questionDao.getSurvey("baseline", 4);
			List<Question> listQuestions5 = questionDao.getSurvey("baseline", 5);
			List<Question> listQuestions6 = questionDao.getSurvey("pss", 6);
			List<Question> listQuestions7 = questionDao.getSurvey("rcq", 7);
			List<Question> listQuestions8 = questionDao.getSurvey("baseline", 8);

			ArrayList<List<Question>> listQuestions = new ArrayList<List<Question>>();

			listQuestions.add(listQuestions1);
			listQuestions.add(listQuestions2);
			listQuestions.add(listQuestions3);
			listQuestions.add(listQuestions4);
			listQuestions.add(listQuestions5);
			listQuestions.add(listQuestions6);
			listQuestions.add(listQuestions7);
			listQuestions.add(listQuestions8);

			ArrayList<ArrayList<String>> sheetName = new ArrayList<ArrayList<String>>();
			ArrayList<String> tempList = new ArrayList<String>();
			tempList.add("Survey Metadata");
			sheetName.add(tempList);

			ArrayList<ArrayList<String>> header = new ArrayList<ArrayList<String>>();
			tempList = new ArrayList<String>();
			tempList.add("Question ID");
			tempList.add("Question Text");
			int optionsCount = 0;
			for (List<Question> lq : listQuestions) {
				for (Question q : lq) {
					if (q.getOptions() != null && q.getOptions().size() > optionsCount)
						optionsCount = q.getOptions().size();
				}
			}
			for (int i = 1; i <= optionsCount; i++) {
				tempList.add("option" + i + "_text");
				tempList.add("option" + i + "_value");
			}
			header.add(tempList);

			// create some sample data
			ArrayList<ArrayList<String>> data = new ArrayList<ArrayList<String>>();
			for (List<Question> lq : listQuestions) {
				for (Question q : lq) {
					tempList = new ArrayList<String>();
					tempList.add(String.valueOf(q.getId()));
					tempList.add(q.getText());
					for (Option o : q.getOptions()) {
						tempList.add(o.getText());
						tempList.add(String.valueOf(o.getValue()));
					}
					data.add(tempList);
					if (q.getSubquestions() != null && q.getSubquestions().size() > 0) {
						for (SubQuestion sq : q.getSubquestions()) {
							tempList = new ArrayList<String>();
							tempList.add(String.valueOf(q.getId()) + "_" + String.valueOf(sq.getId()));
							tempList.add(sq.getText());
							data.add(tempList);
						}
					}
				}
			}

			HashMap<String, ArrayList<ArrayList<String>>> excelMap = new HashMap<String, ArrayList<ArrayList<String>>>();
			excelMap.put("SheetName", sheetName);
			excelMap.put("header", header);
			excelMap.put("data", data);
			resultList.add(excelMap);

			
			 HashMap<Integer,ArrayList> surveyList = new  HashMap<Integer,ArrayList>();
			 List<User> userList = userDao.list();
			 
			 for(User user: userList){
				 List<UserSurveyResponse> userSurvey1 = userSurveyDao.getUserSurveyResponse(user.getId(),
							"baseline_survey_page1");
					List<UserSurveyResponse> userSurvey2 = userSurveyDao.getUserSurveyResponse(user.getId(),
							"baseline_survey_page2");
					List<UserSurveyResponse> userSurvey3 = userSurveyDao.getUserSurveyResponse(user.getId(),
							"baseline_survey_page3");
					List<UserSurveyResponse> userSurvey4 = userSurveyDao.getUserSurveyResponse(user.getId(),
							"baseline_survey_page4");
					List<UserSurveyResponse> userSurvey5 = userSurveyDao.getUserSurveyResponse(user.getId(),
							"baseline_survey_page5");
					List<UserSurveyResponse> userSurvey6 = userSurveyDao.getUserSurveyResponse(user.getId(),
							"baseline_survey_page6");
					List<UserSurveyResponse> userSurvey7 = userSurveyDao.getUserSurveyResponse(user.getId(),
							"baseline_survey_page7");
					List<UserSurveyResponse> userSurvey8 = userSurveyDao.getUserSurveyResponse(user.getId(),
							"baseline_survey_page8");
					
					ArrayList<List<UserSurveyResponse>> survey=new ArrayList<List<UserSurveyResponse>>();
					
					survey.add(userSurvey1);
					survey.add(userSurvey2);
					survey.add(userSurvey3);
					survey.add(userSurvey4);
					survey.add(userSurvey5);
					survey.add(userSurvey6);
					survey.add(userSurvey7);
					survey.add(userSurvey8);
					
				 //Survey survey =feedbackManager.getAllNewSurveyQuestionsWithFeedback(user);
				 if(survey!=null && survey.size()>0){ 
					 ArrayList tempList1 = new ArrayList();
					 tempList1.add(user);
					 tempList1.add(survey);
					 surveyList.put(user.getId(), tempList1); 
				 } 
			 }
			 
			 if(surveyList!=null && surveyList.size()>0){
				 
				 ArrayList<ArrayList<String>> sheetName1 = new ArrayList<ArrayList<String>>();
				 tempList = new ArrayList<String>();
				 tempList.add("Survey Results");
				 sheetName1.add(tempList);
				 
				 ArrayList<ArrayList<String>> header1 = new ArrayList<ArrayList<String>>();
				 tempList = new ArrayList<String>();
				 tempList.add("Study ID");
				 tempList.add("User ID");
				 tempList.add("First Name");
				 for(ArrayList<String> headerData:data){
					 tempList.add(headerData.get(0));
				 }
				 tempList.add("Frequency of drinking");
				 tempList.add("Frequency of drinking percentile");
				 tempList.add("Quantity of drinking");
				 tempList.add("Quantity of drinking percentile");
				 tempList.add("Average number of drinks per week");
				 tempList.add("Highest number of drinks per week");
				 tempList.add("Typical BAC");
				 tempList.add("Typical BAC hours until you are sober");
				 tempList.add("Peak BAC");
				 tempList.add("Peak BAC hours until you are sober");
				 tempList.add("Alcohol use score");
				 tempList.add("Risk score for AUDIT");
				 tempList.add("Genetic risk");
				 
				 header1.add(tempList);
				 
				// create some sample data
					ArrayList<ArrayList<String>> data1 = new ArrayList<ArrayList<String>>();
					for(User user: userList){
						if(user.getRandomized_id()!=null && !user.getRandomized_id().trim().equals("") 
								&& user.getRegistrationDate()!=null && !user.getRegistrationDate().trim().equals("")
						){
							ArrayList tempSurveyList=surveyList.get(user.getId());
							ArrayList<List<UserSurveyResponse>> tempSurvey=(ArrayList<List<UserSurveyResponse>>) tempSurveyList.get(1);
							if(tempSurvey!=null && tempSurvey.size()==8){
								tempList = new ArrayList<String>();
								tempList.add(user.getRandomized_id());
								tempList.add(String.valueOf(user.getId()));
								tempList.add(user.getFirstName());
								HashMap<String,String> dataMap= new HashMap<String,String>();
								for(List<UserSurveyResponse> userSurvey:tempSurvey){
									for(UserSurveyResponse userSurveyResponse:userSurvey){
										dataMap.put(String.valueOf(userSurveyResponse.getQuestionId()), userSurveyResponse.getAnswer()==null?"null":userSurveyResponse.getAnswer());
										if(userSurveyResponse.getSubQuestionId()!=-1){
											dataMap.put(String.valueOf(userSurveyResponse.getQuestionId())+"_"+String.valueOf(userSurveyResponse.getSubQuestionId()), userSurveyResponse.getSubAnswer()==null?"null":userSurveyResponse.getSubAnswer());
										}
									}
								}
								for(ArrayList<String> headerData:data){
									tempList.add(dataMap.get(headerData.get(0))==null?"null":dataMap.get(headerData.get(0)));
								}
								Feedback feedback = feedbackDao.get(user.getId());
								ObjectMapper mapper = new ObjectMapper();
								try {
									PF pf = mapper.readValue(feedback.getFeedback(), PF.class);
									tempList.add(String.valueOf(pf.alcoholUsage));
									tempList.add(String.valueOf(pf.alcoholPercentile));
									tempList.add(String.valueOf(pf.averageDrink));
									tempList.add(String.valueOf(pf.drinkPercentile));
									tempList.add(String.valueOf(pf.total));
									tempList.add(String.valueOf(pf.maxTotal));
									tempList.add(String.valueOf(pf.typicalBAC));
									tempList.add(String.valueOf(pf.typicalSober));
									tempList.add(String.valueOf(pf.peakBAC));
									tempList.add(String.valueOf(pf.peakSober));
									tempList.add(String.valueOf(pf.byaacqScore));
									tempList.add(String.valueOf(pf.auditScore));
									tempList.add(String.valueOf(pf.geneticRisk));
								} catch (JsonParseException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								} catch (JsonMappingException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								} catch (IOException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								data1.add(tempList);
							}
						}
					}
				 
				 excelMap=new HashMap<String,ArrayList<ArrayList<String>>>();
				 excelMap.put("SheetName",sheetName1); 
				 excelMap.put("header",header1); 
				 excelMap.put("data", data1); 
				 resultList.add(excelMap);
				
				 //get Six Week Results Data
				 resultList=sixWeekSurveyResults(resultList);
				 
			 }
			  

			// return a view which will be resolved by an excel view resolver
			return new ModelAndView("excelView", "excelData", resultList);
		}
	}
	
    private ArrayList<HashMap<String, ArrayList<ArrayList<String>>>> sixWeekSurveyResults(
			ArrayList<HashMap<String, ArrayList<ArrayList<String>>>> resultList) {
    	
    	List<Question> listQuestions1 = questionDao.getSixWeekSurvey("baseline", 1);
		List<Question> listQuestions2 = questionDao.getSixWeekSurvey("baseline", 2);
		List<Question> listQuestions3 = questionDao.getSixWeekSurvey("cea", 3);
		List<Question> listQuestions4 = questionDao.getSixWeekSurvey("baseline", 4);
		List<Question> listQuestions5 = questionDao.getSixWeekSurvey("baseline", 5);
		List<Question> listQuestions6 = questionDao.getSixWeekSurvey("pss", 6);
		List<Question> listQuestions7 = questionDao.getSixWeekSurvey("rcq", 7);
		List<Question> listQuestions8 = questionDao.getSixWeekSurvey("baseline", 8);

		ArrayList<List<Question>> listQuestions = new ArrayList<List<Question>>();

		listQuestions.add(listQuestions1);
		listQuestions.add(listQuestions2);
		listQuestions.add(listQuestions3);
		listQuestions.add(listQuestions4);
		listQuestions.add(listQuestions5);
		listQuestions.add(listQuestions6);
		listQuestions.add(listQuestions7);
		listQuestions.add(listQuestions8);

		ArrayList<ArrayList<String>> sheetName = new ArrayList<ArrayList<String>>();
		ArrayList<String> tempList = new ArrayList<String>();
		tempList.add("Six Week Survey Metadata");
		sheetName.add(tempList);

		ArrayList<ArrayList<String>> header = new ArrayList<ArrayList<String>>();
		tempList = new ArrayList<String>();
		tempList.add("Question ID");
		tempList.add("Question Text");
		int optionsCount = 0;
		for (List<Question> lq : listQuestions) {
			for (Question q : lq) {
				if (q.getOptions() != null && q.getOptions().size() > optionsCount)
					optionsCount = q.getOptions().size();
			}
		}
		for (int i = 1; i <= optionsCount; i++) {
			tempList.add("option" + i + "_text");
			tempList.add("option" + i + "_value");
		}
		header.add(tempList);

		// create some sample data
		ArrayList<ArrayList<String>> data = new ArrayList<ArrayList<String>>();
		for (List<Question> lq : listQuestions) {
			for (Question q : lq) {
				tempList = new ArrayList<String>();
				tempList.add(String.valueOf(q.getId()));
				tempList.add(q.getText());
				for (Option o : q.getOptions()) {
					tempList.add(o.getText());
					tempList.add(String.valueOf(o.getValue()));
				}
				data.add(tempList);
				if (q.getSubquestions() != null && q.getSubquestions().size() > 0) {
					for (SubQuestion sq : q.getSubquestions()) {
						tempList = new ArrayList<String>();
						tempList.add(String.valueOf(q.getId()) + "_" + String.valueOf(sq.getId()));
						tempList.add(sq.getText());
						data.add(tempList);
					}
				}
			}
		}

		HashMap<String, ArrayList<ArrayList<String>>> excelMap = new HashMap<String, ArrayList<ArrayList<String>>>();
		excelMap.put("SheetName", sheetName);
		excelMap.put("header", header);
		excelMap.put("data", data);
		resultList.add(excelMap);

		
		 HashMap<Integer,ArrayList> surveyList = new  HashMap<Integer,ArrayList>();
		 List<User> userList = userDao.list();
		 
		 for(User user: userList){
			 List<UserSurveyResponse> userSurvey1 = userSurveyDao.getUserSurveyResponse(user.getId(),
						"six_week_survey_page1");
				List<UserSurveyResponse> userSurvey2 = userSurveyDao.getUserSurveyResponse(user.getId(),
						"six_week_survey_page2");
				List<UserSurveyResponse> userSurvey3 = userSurveyDao.getUserSurveyResponse(user.getId(),
						"six_week_survey_page3");
				List<UserSurveyResponse> userSurvey4 = userSurveyDao.getUserSurveyResponse(user.getId(),
						"six_week_survey_page4");
				List<UserSurveyResponse> userSurvey5 = userSurveyDao.getUserSurveyResponse(user.getId(),
						"six_week_survey_page5");
				List<UserSurveyResponse> userSurvey6 = userSurveyDao.getUserSurveyResponse(user.getId(),
						"six_week_survey_page6");
				List<UserSurveyResponse> userSurvey7 = userSurveyDao.getUserSurveyResponse(user.getId(),
						"six_week_survey_page7");
				List<UserSurveyResponse> userSurvey8 = userSurveyDao.getUserSurveyResponse(user.getId(),
						"six_week_survey_page8");
				
				ArrayList<List<UserSurveyResponse>> survey=new ArrayList<List<UserSurveyResponse>>();
				
				survey.add(userSurvey1);
				survey.add(userSurvey2);
				survey.add(userSurvey3);
				survey.add(userSurvey4);
				survey.add(userSurvey5);
				survey.add(userSurvey6);
				survey.add(userSurvey7);
				survey.add(userSurvey8);
				
			 //Survey survey =feedbackManager.getAllNewSurveyQuestionsWithFeedback(user);
			 if(survey!=null && survey.size()>0){ 
				 ArrayList tempList1 = new ArrayList();
				 tempList1.add(user);
				 tempList1.add(survey);
				 surveyList.put(user.getId(), tempList1); 
			 } 
		 }
		 
		 if(surveyList!=null && surveyList.size()>0){
			 
			 ArrayList<ArrayList<String>> sheetName1 = new ArrayList<ArrayList<String>>();
			 tempList = new ArrayList<String>();
			 tempList.add("Six Week Survey Results");
			 sheetName1.add(tempList);
			 
			 ArrayList<ArrayList<String>> header1 = new ArrayList<ArrayList<String>>();
			 tempList = new ArrayList<String>();
			 tempList.add("Study ID");
			 tempList.add("User ID");
			 tempList.add("First Name");
			 for(ArrayList<String> headerData:data){
				 tempList.add(headerData.get(0));
			 }
			 
			 header1.add(tempList);
			 
			// create some sample data
				ArrayList<ArrayList<String>> data1 = new ArrayList<ArrayList<String>>();
				for(User user: userList){
					if(user.getRandomized_id()!=null && !user.getRandomized_id().trim().equals("") 
							&& user.getRegistrationDate()!=null && !user.getRegistrationDate().trim().equals("") && user.getSixWeekFlag().equals("Y")
					){
						ArrayList tempSurveyList=surveyList.get(user.getId());
						ArrayList<List<UserSurveyResponse>> tempSurvey=(ArrayList<List<UserSurveyResponse>>) tempSurveyList.get(1);
						if(tempSurvey!=null && tempSurvey.size()==8){
							tempList = new ArrayList<String>();
							tempList.add(user.getRandomized_id());
							tempList.add(String.valueOf(user.getId()));
							tempList.add(user.getFirstName());
							HashMap<String,String> dataMap= new HashMap<String,String>();
							for(List<UserSurveyResponse> userSurvey:tempSurvey){
								for(UserSurveyResponse userSurveyResponse:userSurvey){
									dataMap.put(String.valueOf(userSurveyResponse.getQuestionId()), userSurveyResponse.getAnswer()==null?"null":userSurveyResponse.getAnswer());
									if(userSurveyResponse.getSubQuestionId()!=-1){
										dataMap.put(String.valueOf(userSurveyResponse.getQuestionId())+"_"+String.valueOf(userSurveyResponse.getSubQuestionId()), userSurveyResponse.getSubAnswer()==null?"null":userSurveyResponse.getSubAnswer());
									}
								}
							}
							for(ArrayList<String> headerData:data){
								tempList.add(dataMap.get(headerData.get(0))==null?"null":dataMap.get(headerData.get(0)));
							}
							data1.add(tempList);
						}
					}
				}
			 
			 excelMap=new HashMap<String,ArrayList<ArrayList<String>>>();
			 excelMap.put("SheetName",sheetName1); 
			 excelMap.put("header",header1); 
			 excelMap.put("data", data1); 
			 resultList.add(excelMap);
	}
		return resultList;
    }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//********************** following methods are not is use **********************
    @Deprecated
    @RequestMapping(value = "/apps/submitSurvey", method = RequestMethod.POST)
    public @ResponseBody Response submitSurvey(@RequestBody SurveyResponse request) {
    	System.out.println("@@TempSubmit Input Survey : "+request);
    	Response response = new Response();
    	User user = userDao.getUserFromToken(request.getToken());
    	if(user != null) {
    		ObjectMapper mapper = new ObjectMapper(); 
    		try {
				String jsonInString = mapper.writeValueAsString(request.getQuestions());
				UserSurvey survey = new UserSurvey();
	    		survey.setId(user.getId());
	    		survey.setResponse(jsonInString);
	    		survey.setSurvey(request.getSurvey());
	    		userSurveyDao.saveOrUpdate(survey);
	    		
	    		response.setStatus(Response.SUCCESS);
	    		
	    		//create MI plan for this user
//	    		MiSerive.createMIPlan(user.getId());
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
    @Deprecated
    @RequestMapping(value="/survey_baseline")
    public ModelAndView baselineSurvey(HttpServletRequest request) {
    	if(request.getSession().getAttribute("user") == null){
    		return new ModelAndView("redirect:/login");
    	} else {
//    		List<Question> listQuestions = questionDao.list();
    		List<Question> listQuestions = questionDao.getSurvey("baseline");
    		Collections.sort(listQuestions, Question.Comparators.INDEX);
    		ModelAndView model = new ModelAndView("survey");
    		model.addObject("questionList", listQuestions);
    		model.addObject("user", request.getSession().getAttribute("user"));
    		model.addObject("survey", "baseline");
    		return model; 
    	} 
    }
    @Deprecated
    @RequestMapping(value="/survey_six_week")
    public ModelAndView sixWeekSurvey(HttpServletRequest request) {
    	if(request.getSession().getAttribute("user") == null){
    		return new ModelAndView("redirect:/login");
    	} else {
    		List<Question> listQuestions = questionDao.getSurvey("baseline");
    		listQuestions = SurveyService.filterSixWeekSurvey(listQuestions);
    		Collections.sort(listQuestions, Question.Comparators.INDEX);
    		ModelAndView model = new ModelAndView("survey");
    		model.addObject("questionList", listQuestions);
    		model.addObject("user", request.getSession().getAttribute("user"));
    		model.addObject("survey", "six_week");
    		return model; 
    	} 
    }
    @Deprecated
    @RequestMapping(value="/survey_b_yaacq")
    public ModelAndView bYaacqSurvey(HttpServletRequest request) {
    	if(request.getSession().getAttribute("user") == null){
    		return new ModelAndView("redirect:/login");
    	} else {
    		List<Question> listQuestions = questionDao.getSurvey("b_yaacq");
    		Collections.sort(listQuestions, Question.Comparators.INDEX);
    		ModelAndView model = new ModelAndView("survey");
    		model.addObject("questionList", listQuestions);
    		model.addObject("user", request.getSession().getAttribute("user"));
    		model.addObject("survey", "b_yaacq");
    		return model; 
    	} 
    }
    @Deprecated
    @RequestMapping(value="/survey_cea")
    public ModelAndView ceaSurvey(HttpServletRequest request) {
    	if(request.getSession().getAttribute("user") == null){
    		return new ModelAndView("redirect:/login");
    	} else {
    		List<Question> listQuestions = questionDao.getSurvey("cea");
    		Collections.sort(listQuestions, Question.Comparators.INDEX);
    		ModelAndView model = new ModelAndView("survey");
    		model.addObject("questionList", listQuestions);
    		model.addObject("user", request.getSession().getAttribute("user"));
    		model.addObject("survey", "cea");
    		return model; 
    	} 
    }
    @Deprecated
    @RequestMapping(value="/survey_ddq")
    public ModelAndView ddqSurvey(HttpServletRequest request) {
    	if(request.getSession().getAttribute("user") == null){
    		return new ModelAndView("redirect:/login");
    	} else {
    		List<Question> listQuestions = questionDao.getSurvey("ddq");
    		Collections.sort(listQuestions, Question.Comparators.INDEX);
    		ModelAndView model = new ModelAndView("survey");
    		model.addObject("questionList", listQuestions);
    		model.addObject("user", request.getSession().getAttribute("user"));
    		model.addObject("survey", "ddq");
    		return model; 
    	} 
    }
    @Deprecated
    @RequestMapping(value="/survey_pss")
    public ModelAndView pssSurvey(HttpServletRequest request) {
    	if(request.getSession().getAttribute("user") == null){
    		return new ModelAndView("redirect:/login");
    	} else {
    		List<Question> listQuestions = questionDao.getSurvey("pss");
    		Collections.sort(listQuestions, Question.Comparators.INDEX);
    		ModelAndView model = new ModelAndView("survey");
    		model.addObject("questionList", listQuestions);
    		model.addObject("user", request.getSession().getAttribute("user"));
    		model.addObject("survey", "pss");
    		return model; 
    	} 
    }
    @Deprecated
    @RequestMapping(value="/survey_rcq")
    public ModelAndView rcqSurvey(HttpServletRequest request) {
    	if(request.getSession().getAttribute("user") == null){
    		return new ModelAndView("redirect:/login");
    	} else {
    		List<Question> listQuestions = questionDao.getSurvey("rcq");
    		Collections.sort(listQuestions, Question.Comparators.INDEX);
    		ModelAndView model = new ModelAndView("survey");
    		model.addObject("questionList", listQuestions);
    		model.addObject("user", request.getSession().getAttribute("user"));
    		model.addObject("survey", "rcq");
    		return model; 
    	} 
    }
    
    @RequestMapping(value = "/apps/getSurvey", method = RequestMethod.POST)
	public @ResponseBody Response getSurvey(@RequestBody MHealthRequest request) {
    	System.out.println("@@ Got : "+request);
    	Response response = new Response();
    	User user = userDao.getUserFromToken(request.getToken());
    	if(user != null) {
    		response.setStatus(Response.SUCCESS);
//    		List<Question> listQuestions = questionDao.list();
    		List<Question> listQuestions;
    		if(request.getSurvey().equals("six_week")){
    			listQuestions = questionDao.getSurvey("baseline");
    			listQuestions = SurveyService.filterSixWeekSurvey(listQuestions);
    		} else {
    			listQuestions = questionDao.getSurvey(request.getSurvey());
    		}
    		response.setData(listQuestions);
    	} else {
    		response.setStatus(Response.ERROR);
    		response.setMessage(Constants.User.INVALID_TOKEN);
    	}
    	
		return response;
	}
    
    
//    @RequestMapping(value = "/User/new", method = RequestMethod.GET)
//    public ModelAndView newUser() {
//        ModelAndView model = new ModelAndView("UserForm");
//        model.addObject("user", new User());
//        return model;      
//    }
//     
//    @RequestMapping(value = "/User/edit", method = RequestMethod.GET)
//    public ModelAndView editUser(HttpServletRequest request) {
//        int userId = Integer.parseInt(request.getParameter("id"));
//        User user = questionDao.get(userId);
//        ModelAndView model = new ModelAndView("UserForm");
//        model.addObject("user", user);
//        return model;      
//    }
//     
//    @RequestMapping(value = "/User/delete", method = RequestMethod.GET)
//    public ModelAndView deleteUser(HttpServletRequest request) {
//        int userId = Integer.parseInt(request.getParameter("id"));
//        questionDao.delete(userId);
//        return new ModelAndView("redirect:/User");     
//    }
    
}
