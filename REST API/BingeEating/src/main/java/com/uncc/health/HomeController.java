package com.uncc.health;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SignatureException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.auth0.jwt.JWTSigner;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.JWTVerifyException;
import com.auth0.jwt.internal.org.apache.commons.io.output.ByteArrayOutputStream;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.uncc.health.binge.hibernate.Appointment;
import com.uncc.health.binge.hibernate.DailyData;
import com.uncc.health.binge.hibernate.Notifications;
import com.uncc.health.binge.hibernate.PhysicalData;
import com.uncc.health.binge.hibernate.Supporter;
import com.uncc.health.binge.hibernate.User;
import com.uncc.health.binge.model.EncapsulatedUserDetails;
import com.uncc.health.binge.model.MobileResponse;
import com.uncc.health.binge.model.Response;
import com.uncc.health.binge.service.BingeService;




/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	@Autowired
	private BingeService bingeService;
	//JWT issuer and secret
	final String issuer = "https://mydomain.com/";
	final String secret = "{{a secret used for signing}}";
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "Login";
	}
	
	
	// web side login
	@RequestMapping(value = "/binge/adminlogin", method = RequestMethod.POST)
	public @ResponseBody Response adminLogin(HttpServletRequest request) {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		//TODO: validate credentials & upon successful validation start user session
		Response response = new Response();
		Supporter supporter =bingeService.isValidAdmin(username, password); 
		if(supporter!=null)
		{
			System.out.println("admin login role is "+supporter.getRole());
			final long iat = System.currentTimeMillis() / 1000l; // issued at claim 
			final long exp = iat + 1800L; // expires claim. In this case the token expires in 30 minutes

			final JWTSigner signer = new JWTSigner(secret);
			final HashMap<String, Object> claims = new HashMap<String, Object>();
			claims.put("iss", issuer);
			claims.put("exp", exp);
			claims.put("iat", iat);
			claims.put("username", username);
			claims.put("role", supporter.getRole());
			final String jwt = signer.sign(claims);
			System.out.println(jwt);
			request.getSession().setAttribute("token", jwt);
			response.setStatus(Response.SUCCESS);
			request.getSession().setAttribute("ROLE", supporter.getRole());
			//System.out.println("Respose--");
			response.setMessage("Login Success");
			response.setData(supporter);
			//		response.setData();//TODO: response data if needed
		}
		else
		{
			response.setStatus(Response.ERROR);
			response.setMessage("Invalid UserName/Passwrord kindly try again!!");
			response.setData("Invalid");
		}
		return response;
	}
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/homePage", method = RequestMethod.GET)
	public ModelAndView homepage(Locale locale, Model model,HttpServletRequest request) {
		logger.info("Welcome home! The client locale is {}.", locale);
		String token = (String) request.getSession().getAttribute("token");
		final JWTVerifier verifier = new JWTVerifier(secret);
		Map<String, Object> claims;
		ModelAndView modelView;
			try {
				claims = verifier.verify(token);
				modelView = new ModelAndView("homePage");
			} catch (InvalidKeyException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				modelView = new ModelAndView("");
			} catch (NoSuchAlgorithmException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				modelView = new ModelAndView("");
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				modelView = new ModelAndView("");
			} catch (SignatureException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				modelView = new ModelAndView("");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				modelView = new ModelAndView("");
			} catch (JWTVerifyException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				modelView = new ModelAndView("");
			}
			
		return modelView;

		//return "login";
	}
	
	//binge/supporter/myAppointments
	@RequestMapping(value="/binge/supporter/myAppointments",method=RequestMethod.GET)
	public @ResponseBody Response getAppointments(HttpServletRequest request) {
		Response response = new Response();
		logger.info("Inside get myAppointments");
		String token = (String) request.getSession().getAttribute("token");
		final JWTVerifier verifier = new JWTVerifier(secret);
		Map<String, Object> claims;
		
		try {
			claims = verifier.verify(token);
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
		
		response.setStatus(Response.ERROR);
		//System.out.println("Respose--");
		response.setMessage("Session Expired");
		response.setData("Please Login Again!!");
		return response;
	}
	
	//binge/supporter/myUsers
	@RequestMapping(value="/binge/supporter/myUsers",method=RequestMethod.GET)
	public @ResponseBody Response getUsers(HttpServletRequest request) {
		Response response = new Response();
		logger.info("Inside get myAppointments");
		String token = (String) request.getSession().getAttribute("token");
		final JWTVerifier verifier = new JWTVerifier(secret);
		Map<String, Object> claims;
		
		try {
			claims = verifier.verify(token);
			int suporter_id = Integer.parseInt((String)claims.get("username"));
			if(claims.get("role").equals("supporter")){
			List<User> userList = bingeService.getAllUsers(suporter_id);
			response.setData(userList);
			}else{
				List<User> userList = bingeService.getAllUsers(-1);
				response.setData(userList);
			}
			response.setStatus(Response.SUCCESS);
			//System.out.println("Respose--");
			response.setMessage("Got All Patients");
			
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
		
		response.setStatus(Response.ERROR);
		//System.out.println("Respose--");
		response.setMessage("Session Expired");
		response.setData("Please Login Again!!");
		return response;
	}
	
	//binge/supporter/registerPatient
	@RequestMapping(value="/binge/supporter/registerPatient",method=RequestMethod.POST)
	public @ResponseBody Response register(HttpServletRequest request) {
		//TODO: delete the current user session    	
		String first_name = request.getParameter("first_name");
		String last_name = request.getParameter("last_name");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		System.out.println("F Name - "+first_name+" L Name - "+last_name+" Email - "+password);
		//TODO: validate credentials & upon successful validation start user session
		Response response=new Response();
		//String task=request.getParameter("task");
		
		final JWTVerifier verifier = new JWTVerifier(secret);
		String token = (String) request.getSession().getAttribute("token");
		Map<String, Object> claims;
		
		try {
			claims = verifier.verify(token);
			int suporter_id = Integer.parseInt((String)claims.get("username"));
			Supporter supporter = bingeService.getSupporter(suporter_id);
			//supporter.setId(suporter_id);
			User user = new User();
			user.setF_name(first_name);
			user.setL_name(last_name);
			user.setP_id(Integer.parseInt(username));
			user.setPassword(password);
			user.setS_date(new java.sql.Date(Calendar.getInstance().getTimeInMillis()));
			user.setStep(1);
			user.setSupporter(supporter);
			
			bingeService.saveUser(user);
			
			response.setStatus(Response.SUCCESS);
			//System.out.println("Respose--");
			response.setMessage("Patient Added Successfully!");
			response.setData(user);
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
		
		//Add JWT to QR Code
		
		//End of code for 
		response.setMessage("Error Adding Patient to Database");
		response.setStatus(Response.ERROR);
		response.setData("Failure");
		
		//return response;
		return response;
	}
	
	
	@RequestMapping(value = "/binge/web/get/log/activity", method = RequestMethod.GET)
	public @ResponseBody Response getView(HttpServletRequest request, HttpServletResponse response) {
		//logger.info("Welcome home! The client locale is {}.", );
		
		Response jsonResponse = new Response();
		jsonResponse.setData("Invalid token/Error getting data");
		String token = (String) request.getSession().getAttribute("token");
		int p_id = Integer.parseInt(request.getParameter("id"));
		// get date from date and time
		
		
		
		//String date = request.getParameter("date_requested");
		final JWTVerifier verifier = new JWTVerifier(secret);
		Map<String, Object> claims;
		try {
			claims = verifier.verify(token);
			String username = (String) claims.get("username");
			if(((String)claims.get("role")).equalsIgnoreCase("supporter")){
			List<PhysicalData> activity_data = bingeService.getActivityData(p_id);
				jsonResponse.setData(activity_data);
				jsonResponse.setMessage("Succcess!");
				jsonResponse.setStatus(Response.SUCCESS);
				return jsonResponse;
			}
			jsonResponse.setData("User not authorized to get this data");
				
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
		
		jsonResponse.setMessage("Failure!");
		jsonResponse.setStatus(Response.ERROR);
		return jsonResponse;

		//return "login";
	}
	
	//Save notifications for user

	@RequestMapping(value = "/binge/web/post/notification", method = RequestMethod.POST)
	public @ResponseBody Response saveNotification(HttpServletRequest request, HttpServletResponse response) {
		//logger.info("Welcome home! The client locale is {}.", );
		
		Response jsonResponse = new Response();
		jsonResponse.setData("Invalid token/Error getting data");
		String token = (String) request.getSession().getAttribute("token");
		int p_id = Integer.parseInt((String)request.getSession().getAttribute("patient_id"));
		
		String notification_text=request.getParameter("notification_text");
		// get date from date and time
		
		
		
		//String date = request.getParameter("date_requested");
		final JWTVerifier verifier = new JWTVerifier(secret);
		Map<String, Object> claims;
		try {
			claims = verifier.verify(token);
			String username = (String) claims.get("username");
			if(((String)claims.get("role")).equalsIgnoreCase("supporter")){
				Notifications notif = new Notifications();
				notif.setCreated_date_time(new Timestamp(Calendar.getInstance().getTimeInMillis()));
				notif.setNotification_text(notification_text);
				notif.setP_id(p_id);
				if(bingeService.saveNotification(notif)){
				jsonResponse.setData(notif);
				jsonResponse.setMessage("Succcess!");
				jsonResponse.setStatus(Response.SUCCESS);
				return jsonResponse;
				}
			}
			jsonResponse.setData("User not authorized to get this data/Error Saving Data");
				
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
		
		jsonResponse.setMessage("Failure!");
		jsonResponse.setStatus(Response.ERROR);
		return jsonResponse;

		//return "login";
	}
	
	
	// Save Appointments
	@RequestMapping(value = "/binge/web/post/appointment", method = RequestMethod.POST)
	public @ResponseBody Response saveAppointment(HttpServletRequest request, HttpServletResponse response) {
		//logger.info("Welcome home! The client locale is {}.", );
		
		Response jsonResponse = new Response();
		jsonResponse.setData("Invalid token/Error getting data");
		String token = (String) request.getSession().getAttribute("token");
		int p_id = Integer.parseInt(request.getParameter("id"));
		String a_date=request.getParameter("appointment_date");
		String a_time=request.getParameter("appointment_time");
		// get date from date and time
		
		
		
		//String date = request.getParameter("date_requested");
		final JWTVerifier verifier = new JWTVerifier(secret);
		Map<String, Object> claims;
		try {
			claims = verifier.verify(token);
			String username = (String) claims.get("username");
			if(((String)claims.get("role")).equalsIgnoreCase("supporter")){
				Appointment appoint = new Appointment();
				appoint.setCreated_date(new Timestamp(Calendar.getInstance().getTimeInMillis()));
				appoint.setAppointment_date(bingeService.getSqlDate(a_date,a_time));
				appoint.setP_id(p_id);
				
				if(bingeService.saveAppointment(appoint)){
					Notifications notif = new Notifications();
					notif.setCreated_date_time(appoint.getCreated_date());
					notif.setP_id(p_id);
					notif.setType("Appointment");
					notif.setNotification_text("You have an appointment scheduled on "+a_date+" at "+a_time);
					bingeService.saveNotification(notif);
				jsonResponse.setData(appoint);
				jsonResponse.setMessage("Succcess!");
				jsonResponse.setStatus(Response.SUCCESS);
				return jsonResponse;
				}
			}
			jsonResponse.setData("User not authorized to get this data/Error Saving Data");
				
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
		
		jsonResponse.setMessage("Failure!");
		jsonResponse.setStatus(Response.ERROR);
		return jsonResponse;

		//return "login";
	}
	
	
	//binge/user/viewDetails
	@RequestMapping(value = "/viewDetails", method = RequestMethod.GET)
	public ModelAndView viewSurvey(HttpServletRequest request, HttpServletResponse response) {
		//logger.info("Welcome home! The client locale is {}.", );
		String token = (String) request.getSession().getAttribute("token");
		final JWTVerifier verifier = new JWTVerifier(secret);
		Map<String, Object> claims;
		try {
			claims = verifier.verify(token);
		String p_id = request.getParameter("id");
		request.getSession().setAttribute("patient_id", p_id);
		List<DailyData> daily_data = bingeService.getDailyData(p_id);
		User user = bingeService.getUserDetails(p_id);
		EncapsulatedUserDetails userD = new EncapsulatedUserDetails();
		userD.setFirstName(user.getF_name());
		userD.setLastName(user.getL_name());
		userD.setStep(user.getStep()+"");
		userD.setUser_id(user.getP_id()+"");
		userD.setStart_date(user.getS_date());
		request.setAttribute("USER", userD);
		request.setAttribute("daily_data", daily_data);
		ModelAndView modelView = new ModelAndView("SupporterHome");
		return modelView;
		}catch (InvalidKeyException e) {
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
		ModelAndView modelView = new ModelAndView("SupporterHome");
		return modelView;
		//return "login";
	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public ModelAndView logout(HttpServletRequest request, HttpServletResponse response) {
		//logger.info("Welcome home! The client locale is {}.", );
		
		//String p_id = request.getParameter("id");
		request.getSession().invalidate();
		
		ModelAndView modelView = new ModelAndView("Login");
		return modelView;

		//return "login";
	}
}
