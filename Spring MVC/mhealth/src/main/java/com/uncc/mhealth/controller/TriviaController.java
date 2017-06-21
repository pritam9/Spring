package com.uncc.mhealth.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.uncc.mhealth.config.Constants;
import com.uncc.mhealth.dao.TriviaQuestionDAO;
import com.uncc.mhealth.dao.TriviaScoreDAO;
import com.uncc.mhealth.dao.UserDAO;
import com.uncc.mhealth.model.Response;
import com.uncc.mhealth.model.TriviaQuestion;
import com.uncc.mhealth.model.TriviaResponse;
import com.uncc.mhealth.model.TriviaScore;
import com.uncc.mhealth.model.User;
import com.uncc.mhealth.service.FeedbackManager;

@Controller
public class TriviaController {
	@Autowired
	private TriviaQuestionDAO triviaQuestionDao;
	@Autowired
	private UserDAO userDao;
	@Autowired
	private TriviaScoreDAO triviaScoreDao;
	@Autowired
	private FeedbackManager feedbackManager;

	@RequestMapping(value = "/apps/apis/trivia/list", method = RequestMethod.POST)
	public @ResponseBody Response getTriviaList(HttpServletRequest request) {
		Response response = new Response();

		String token = request.getParameter(Constants.Parameter.SESSION_TOKEN);
		String category = request.getParameter(Constants.Parameter.CATEGORY);
		User user = userDao.getUserFromToken(token);
		if (user != null) {
			List<TriviaQuestion> listQuestions = triviaQuestionDao.list(Integer.parseInt(category));
			response.setData(listQuestions);
			response.setStatus(Response.SUCCESS);
			response.setData(listQuestions);
		} else {
			response.setStatus(Response.ERROR);
			response.setMessage(Constants.User.INVALID_TOKEN);
		}
		return response;
	}

	@RequestMapping(value = "/apps/apis/trivia/scoreboard", method = RequestMethod.POST)
	public @ResponseBody Response getScoreBoard(HttpServletRequest request) {
		Response response = new Response();

		String token = request.getParameter(Constants.Parameter.SESSION_TOKEN);
		User user = userDao.getUserFromToken(token);
		if (user != null) {
			List<TriviaScore> scoreboard = triviaScoreDao.list();
			for (TriviaScore score : scoreboard) {
				User scorer = userDao.get(score.getUser_id());
				score.setNickname(scorer.getNickname());
				score.setGender(feedbackManager.getGender(scorer.getId()));
			}
			response.setStatus(Response.SUCCESS);
			response.setData(scoreboard);
		} else {
			response.setStatus(Response.ERROR);
			response.setMessage(Constants.User.INVALID_TOKEN);
		}
		return response;
	}

	@RequestMapping(value = "/apps/apis/trivia/answer/set", method = RequestMethod.POST)
	public @ResponseBody Response setTriviaAnswer(HttpServletRequest request) {
		Response response = new Response();

		String token = request.getParameter(Constants.Parameter.SESSION_TOKEN);
		String correct = request.getParameter(Constants.Parameter.IS_CORRECT);
		User user = userDao.getUserFromToken(token);
		if (user != null) {
			TriviaScore score = triviaScoreDao.get(user.getId());
			if (score == null) {
				score = new TriviaScore();
				score.setUser_id(user.getId());
			}
			if (correct != null && correct.equals("1")) {
				score.setScore(score.getScore() + 10);
			}
			triviaScoreDao.saveOrUpdate(score);
			response.setData(score);
			response.setStatus(Response.SUCCESS);

		} else {
			response.setStatus(Response.ERROR);
			response.setMessage(Constants.User.INVALID_TOKEN);
		}
		return response;
	}

	@RequestMapping(value = "/apps/apis/rounds/score/set", method = RequestMethod.POST)
	public @ResponseBody Response setRoundsScore(HttpServletRequest request) {
		Response response = new Response();

		String token = request.getParameter(Constants.Parameter.SESSION_TOKEN);
		String time = request.getParameter(Constants.Parameter.TIME);
		User user = userDao.getUserFromToken(token);
		if (user != null) {
			TriviaScore score = triviaScoreDao.get(user.getId());
			if (score == null) {
				score = new TriviaScore();
				score.setUser_id(user.getId());
			}
			if (time != null) {
				long roundScore = 0;
				try {
					roundScore = Long.parseLong(time);
				} catch (Exception e) {

				}
				if (roundScore > score.getTime()) {
					score.setTime(roundScore);
				}
			}
			triviaScoreDao.saveOrUpdate(score);
			response.setData(score);
			response.setStatus(Response.SUCCESS);

		} else {
			response.setStatus(Response.ERROR);
			response.setMessage(Constants.User.INVALID_TOKEN);
		}
		return response;
	}

	// TODO: ********** following methods are not being used **************
	@Deprecated
	@RequestMapping(value = "/add_trivia")
	public ModelAndView home(HttpServletRequest request) {
		if (request.getSession().getAttribute("user") == null) {
			return new ModelAndView("redirect:/login");
		} else {
			ModelAndView model = new ModelAndView("add_trivia");
			model.addObject("user", request.getSession().getAttribute("user"));
			return model;
		}
	}

	@Deprecated
	@RequestMapping(value = "/apps/submitTrivia", method = RequestMethod.POST)
	public @ResponseBody Response submitSurvey(@RequestBody TriviaResponse request) {
		System.out.println("@@TempSubmit Input Trivia : " + request);
		Response response = new Response();
		User user = userDao.getUserFromToken(request.getToken());
		if (user != null) {
			triviaQuestionDao.saveOrUpdate(request.getQuestion());
			response.setStatus(Response.SUCCESS);

		} else {
			response.setStatus(Response.ERROR);
			response.setMessage(Constants.User.INVALID_TOKEN);
		}

		return response;
	}

	@Deprecated
	@RequestMapping(value = "/apps/submitTriviaScore", method = RequestMethod.POST)
	public @ResponseBody Response submitTriviaScore(@RequestBody TriviaScore request) {
		System.out.println("@@TempSubmit Input TriviaGame : " + request);
		Response response = new Response();
		User user = userDao.getUserFromToken(request.getToken());
		if (user != null) {

			response.setStatus(Response.SUCCESS);
			request.setUser_id(user.getId());

		} else {
			response.setStatus(Response.ERROR);
			response.setMessage(Constants.User.INVALID_TOKEN);
		}

		return response;
	}

	// @RequestMapping(value = "/User/new", method = RequestMethod.GET)
	// public ModelAndView newUser() {
	// ModelAndView model = new ModelAndView("UserForm");
	// model.addObject("user", new User());
	// return model;
	// }
	//
	// @RequestMapping(value = "/User/edit", method = RequestMethod.GET)
	// public ModelAndView editUser(HttpServletRequest request) {
	// int userId = Integer.parseInt(request.getParameter("id"));
	// User user = questionDao.get(userId);
	// ModelAndView model = new ModelAndView("UserForm");
	// model.addObject("user", user);
	// return model;
	// }
	//
	// @RequestMapping(value = "/User/delete", method = RequestMethod.GET)
	// public ModelAndView deleteUser(HttpServletRequest request) {
	// int userId = Integer.parseInt(request.getParameter("id"));
	// questionDao.delete(userId);
	// return new ModelAndView("redirect:/User");
	// }

}
