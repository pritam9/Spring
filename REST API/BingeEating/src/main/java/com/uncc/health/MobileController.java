package com.uncc.health;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SignatureException;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.auth0.jwt.JWTSigner;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.JWTVerifyException;
import com.uncc.health.binge.hibernate.Appointment;
import com.uncc.health.binge.hibernate.DailyData;
import com.uncc.health.binge.hibernate.Notifications;
import com.uncc.health.binge.hibernate.PhysicalData;
import com.uncc.health.binge.hibernate.User;
import com.uncc.health.binge.hibernate.WeeklyData;
import com.uncc.health.binge.model.EncapsulatedUserDetails;
import com.uncc.health.binge.model.MobileResponse;
import com.uncc.health.binge.model.Response;
import com.uncc.health.binge.service.BingeService;
import com.uncc.health.binge.service.MobileService;

@Controller
public class MobileController {

	@Autowired
	private MobileService mobileService;
	//JWT issuer and secret
	final String issuer = "https://mydomain.com/";
	final String secret = "{{a secret used for signing}}";
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@RequestMapping(value = "/binge/user/login", method = RequestMethod.POST)
	public @ResponseBody Response userLogin(HttpServletRequest request) {
		Response response = new Response();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		User user = mobileService.getUserWithCredentials(username,password);
		if(user!=null)
		{
			EncapsulatedUserDetails userDetails=new EncapsulatedUserDetails();
			userDetails.setFirstName(user.getF_name());
			userDetails.setLastName(user.getL_name());
			userDetails.setUser_id(user.getP_id()+"");
			userDetails.setStep(user.getStep()+"");
			userDetails.setStart_date(user.getS_date());
			MobileResponse mResponse = new MobileResponse();
			
			//Generate token using JWT
			final long iat = System.currentTimeMillis() / 1000l; // issued at claim 
			final long exp = iat + 18000L; // expires claim. In this case the token expires in 30 minutes

			final JWTSigner signer = new JWTSigner(secret);
			final HashMap<String, Object> claims = new HashMap<String, Object>();
			claims.put("iss", issuer);
			claims.put("exp", exp);
			claims.put("iat", iat);
			claims.put("username", username);
			claims.put("role", "USER");
			final String jwt = signer.sign(claims);
			mResponse.setData(userDetails);
			mResponse.setToken(jwt);
			response.setStatus(Response.SUCCESS);
			response.setMessage("Login Successful!");
			response.setData(mResponse);
			return response;
		}
		response.setStatus(Response.ERROR);
		response.setMessage("Login Failed!");
		response.setData("Invalid login Credentails");
		return response;
	}
	
	@RequestMapping(value = "/binge/user/get/daily/food", method = RequestMethod.GET)
	public @ResponseBody Response getFood(HttpServletRequest request) {
		Response response = new Response();
		String token = (String) request.getParameter("token");
		String date = request.getParameter("date_requested");
		final JWTVerifier verifier = new JWTVerifier(secret);
		Map<String, Object> claims;
		try {
			claims = verifier.verify(token);
			String username = (String) claims.get("username");
			List<DailyData> dailyFoodLog = mobileService.getFoodData(username,date);
			
				MobileResponse mResponse = new MobileResponse();
				mResponse.setData(dailyFoodLog);
				//mResponse.setToken(token);
				mResponse.setValidity("30 mins");
				response.setData(mResponse);
				response.setMessage("Succcess!");
				response.setStatus(Response.SUCCESS);
				return response;
			
		} catch (InvalidKeyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SignatureException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JWTVerifyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.setData("Invalid token/Error getting data");
		response.setMessage("Failure!");
		response.setStatus(Response.ERROR);
		return response;
		
	}
	
	@RequestMapping(value = "/binge/user/get/daywise/food", method = RequestMethod.GET)
	public @ResponseBody Response getDaywiseFood(HttpServletRequest request) {
		Response response = new Response();
		String token = (String) request.getParameter("token");
		String date = request.getParameter("date_requested");
		final JWTVerifier verifier = new JWTVerifier(secret);
		Map<String, Object> claims;
		try {
			claims = verifier.verify(token);
			int username = Integer.parseInt((String)claims.get("username"));
			List<DailyData> dailyFoodLog = mobileService.getDaywiseFood(username);
			
				MobileResponse mResponse = new MobileResponse();
				mResponse.setData(dailyFoodLog);
				//mResponse.setToken(token);
				mResponse.setValidity("30 mins");
				response.setData(mResponse);
				response.setMessage("Succcess!");
				response.setStatus(Response.SUCCESS);
				return response;
			
		} catch (InvalidKeyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SignatureException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JWTVerifyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.setData("Invalid token/Error getting data");
		response.setMessage("Failure!");
		response.setStatus(Response.ERROR);
		return response;
		
	}
	
	
	@RequestMapping(value = "/binge/user/get/daily/activity", method = RequestMethod.GET)
	public @ResponseBody Response getPhysicalActivity(HttpServletRequest request) {
		Response response = new Response();
		String token = (String) request.getParameter("token");
		String date = request.getParameter("date_requested");
		final JWTVerifier verifier = new JWTVerifier(secret);
		Map<String, Object> claims;
		try {
			claims = verifier.verify(token);
			String username = (String) claims.get("username");
			List<PhysicalData> dailyActivityLog = mobileService.getPhysicalActivity(username,date);
			
				MobileResponse mResponse = new MobileResponse();
				mResponse.setData(dailyActivityLog);
				//mResponse.setToken(token);
				mResponse.setValidity("30 mins");
				response.setData(mResponse);
				response.setMessage("Succcess!");
				response.setStatus(Response.SUCCESS);
				return response;
			
		} catch (InvalidKeyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SignatureException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JWTVerifyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.setData("Invalid token/Error getting data");
		response.setMessage("Failure!");
		response.setStatus(Response.ERROR);
		return response;
		
	}
	
	//Get Notifications
	@RequestMapping(value = "/binge/user/get/daily/notifications", method = RequestMethod.GET)
	public @ResponseBody Response getnotifications(HttpServletRequest request) {
		Response response = new Response();
		String token = (String) request.getParameter("token");
		//String date = request.getParameter("date_requested");
		final JWTVerifier verifier = new JWTVerifier(secret);
		Map<String, Object> claims;
		try {
			claims = verifier.verify(token);
			String username = (String) claims.get("username");
			List<Notifications> myNotifications = mobileService.getNotifications(username);
			
				MobileResponse mResponse = new MobileResponse();
				mResponse.setData(myNotifications);
				//mResponse.setToken(token);
				mResponse.setValidity("30 mins");
				response.setData(mResponse);
				response.setMessage("Succcess!");
				response.setStatus(Response.SUCCESS);
				return response;
			
		} catch (InvalidKeyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SignatureException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JWTVerifyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.setData("Invalid token/Error getting data");
		response.setMessage("Failure!");
		response.setStatus(Response.ERROR);
		return response;
		
	}
	
	//Add Food log to db
	@RequestMapping(value = "/binge/user/post/daily/food", method = RequestMethod.POST)
	public @ResponseBody Response addFoodLog(HttpServletRequest request) {
		Response response = new Response();
		String token = (String) request.getParameter("token");
		// get date from date and time
		
		
		
		//String date = request.getParameter("date_requested");
		final JWTVerifier verifier = new JWTVerifier(secret);
		Map<String, Object> claims;
		try {
			claims = verifier.verify(token);
			String username = (String) claims.get("username");
			DailyData foodLog = new DailyData();
			foodLog.setA_date(mobileService.getDate(request.getParameter("actual_date"),request.getParameter("actual_time")));
			if(request.getParameter("binge").equalsIgnoreCase("y"))
				foodLog.setBinge(true);
			foodLog.setContext(request.getParameter("context"));
			foodLog.setFeelings(request.getParameter("feelings"));
			foodLog.setFood(request.getParameter("food"));
			foodLog.setI_date(new Date
					(Calendar.getInstance().getTimeInMillis()));
			foodLog.setNo_of_day(1);
			foodLog.setServings(Integer.parseInt(request.getParameter("servings")));
			if(request.getParameter("vld").equalsIgnoreCase("y"))
				foodLog.setVld(true);
			foodLog.setP_id(Integer.parseInt(username));
			foodLog.setImg_url(request.getParameter("img_url"));
			if(mobileService.saveFoodLog(foodLog)){
				MobileResponse mResponse = new MobileResponse();
				mResponse.setData(foodLog);
				mResponse.setToken(token);
				mResponse.setValidity("30 mins");
				response.setData(mResponse);
				response.setMessage("Succcess!");
				response.setStatus(Response.SUCCESS);
				return response;
			}
			
				
			
		} catch (InvalidKeyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SignatureException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JWTVerifyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.setData("Invalid token/Error getting data");
		response.setMessage("Failure!");
		response.setStatus(Response.ERROR);
		return response;
		
	}
	
	
	//Add Physical Activity to db
		@RequestMapping(value = "/binge/user/post/daily/activity", method = RequestMethod.POST)
		public @ResponseBody Response addActivityLog(HttpServletRequest request) {
			Response response = new Response();
			String token = (String) request.getParameter("token");
			// get date from date and time
			
			
			
			//String date = request.getParameter("date_requested");
			final JWTVerifier verifier = new JWTVerifier(secret);
			Map<String, Object> claims;
			try {
				claims = verifier.verify(token);
				String username = (String) claims.get("username");
				PhysicalData activityLog = new PhysicalData();
				activityLog.setA_date(mobileService.getDate(request.getParameter("actual_date"),request.getParameter("actual_time")));
				activityLog.setActivity(request.getParameter("activity"));
				activityLog.setDuration(Integer.parseInt(request.getParameter("duration")));
				activityLog.setNo_of_day(1);
				activityLog.setI_date(new Date(Calendar.getInstance().getTimeInMillis()));
				activityLog.setP_id(Integer.parseInt(username));
				if(mobileService.saveActivityLog(activityLog)){
					MobileResponse mResponse = new MobileResponse();
					mResponse.setData(activityLog);
					mResponse.setToken(token);
					mResponse.setValidity("30 mins");
					response.setData(mResponse);
					response.setMessage("Succcess!");
					response.setStatus(Response.SUCCESS);
					return response;
				}
				
					
				
			} catch (InvalidKeyException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NoSuchAlgorithmException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SignatureException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (JWTVerifyException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			response.setData("Invalid token/Error getting data");
			response.setMessage("Failure!");
			response.setStatus(Response.ERROR);
			return response;
			
		}

	// Get Weekly Data
		@RequestMapping(value="/binge/user/get/weekly/data",method=RequestMethod.GET)
		public @ResponseBody Response getWeeklyData(HttpServletRequest request) {
			Response response = new Response();

			String token = (String) request.getParameter("token");

			final JWTVerifier verifier = new JWTVerifier(secret);

			Map<String, Object> claims;
			try {
				claims = verifier.verify(token);
				int user_id = Integer.parseInt((String)claims.get("username"));
				
					//String p_id = request.getParameter("id");
					List<WeeklyData> daily_data = mobileService.getWeeklyData(user_id);
					response.setData(daily_data);
					response.setMessage("Data retrieval successful!!");
					response.setStatus(Response.SUCCESS);
					return response;
				

			} catch (InvalidKeyException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NoSuchAlgorithmException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SignatureException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (JWTVerifyException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			response.setData("Token Not Set!!");
			response.setMessage("Error Retriving Data for the user");
			response.setStatus(Response.ERROR);

			return response;
		}
		
		//
		@RequestMapping(value="/binge/user/update/weekly/data",method=RequestMethod.POST)
		public @ResponseBody Response updateWeeklyData(HttpServletRequest request) {
			Response response = new Response();

			String token = (String) request.getParameter("token");

			final JWTVerifier verifier = new JWTVerifier(secret);

			Map<String, Object> claims;
			try {
				claims = verifier.verify(token);
				int user_id = Integer.parseInt((String)claims.get("username"));
				int week_id = Integer.parseInt(request.getParameter("w_id"));
				String event_data = request.getParameter("event_data");
				int weight = Integer.parseInt(request.getParameter("weight"));
				int good_days = Integer.parseInt(request.getParameter("good_days"));
					//String p_id = request.getParameter("id");
					WeeklyData updatedData = mobileService.getWeeklyDataToUpdate(week_id); 
					updatedData.setWeight(weight);
					updatedData.setGood_days(good_days);
					updatedData.setEvent_data(event_data);
					mobileService.updateWeeklyData(updatedData);
					response.setData(updatedData);
					response.setMessage("Data retrieval successful!!");
					response.setStatus(Response.SUCCESS);
					return response;
				

			} catch (InvalidKeyException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NoSuchAlgorithmException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SignatureException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (JWTVerifyException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			response.setData("Token Not Set!!");
			response.setMessage("Error Retriving Data for the user");
			response.setStatus(Response.ERROR);

			return response;
		}
		
		
}
