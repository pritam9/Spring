 package com.uncc.health;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SignatureException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.JWTVerifyException;
import com.uncc.health.binge.hibernate.Appointment;
import com.uncc.health.binge.hibernate.DailyData;
import com.uncc.health.binge.hibernate.Notifications;
import com.uncc.health.binge.hibernate.PhysicalData;
import com.uncc.health.binge.hibernate.StepWiseMessage;
import com.uncc.health.binge.hibernate.Supporter;
import com.uncc.health.binge.hibernate.User;
import com.uncc.health.binge.hibernate.WeeklyData;
import com.uncc.health.binge.model.ChartData;
import com.uncc.health.binge.model.Columns;
import com.uncc.health.binge.model.IndividualColumn;
import com.uncc.health.binge.model.MapData;
import com.uncc.health.binge.model.Response;
import com.uncc.health.binge.model.Rows;
import com.uncc.health.binge.service.BingeService;
import com.uncc.health.binge.service.MobileService;

@Controller
public class AdminController {

	@Autowired
	private BingeService bingeService;
	
	@Autowired
	private MobileService mobileService;
	//JWT issuer and secret
	final String issuer = "https://mydomain.com/";
	final String secret = "{{a secret used for signing}}";

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@RequestMapping(value="/binge/admin/register",method=RequestMethod.POST)
	public @ResponseBody Response registerParticipants(HttpServletRequest request) {
		Response response = new Response();

		String token = (String) request.getSession().getAttribute("token");

		final JWTVerifier verifier = new JWTVerifier(secret);

		Map<String, Object> claims;
		try {
			claims = verifier.verify(token);
			int user_id = Integer.parseInt((String)claims.get("username"));
			String role = (String) claims.get("role");
			if(role.equals("admin")){
				String newUserRole = request.getParameter("role");
				if(newUserRole.equals("supporter")){
					Supporter supporter = new Supporter();
					supporter.setPassword(request.getParameter("password"));
					supporter.setRole(newUserRole);
					bingeService.saveSupporter(supporter);
					response.setData(supporter);
					response.setMessage("Supporter Added successfully!!");
					response.setStatus(Response.SUCCESS);
					return response;
				}else{
					User newUser = new User();
					newUser.setPassword(request.getParameter("password"));
					newUser.setF_name(request.getParameter("first_name"));
					newUser.setL_name(request.getParameter("last_name"));
					newUser.setP_id(Integer.parseInt(request.getParameter("username")));

					newUser.setS_date(new java.sql.Date(Calendar.getInstance().getTimeInMillis()));
					newUser.setStep(1);
					newUser.setSupporter(bingeService.getSupporter(Integer.parseInt(request.getParameter("supporter_id"))));

					bingeService.saveUser(newUser);
					response.setData(newUser);
					response.setMessage("User/Patient Added successfully!!");
					response.setStatus(Response.SUCCESS);
					return response;
				}
			}else{
				response.setData("You are not authorized to perform this action");
				response.setMessage("Error!");
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

		response.setData("Token Not Set!!");
		response.setMessage("Error Adding User/Supporter");
		response.setStatus(Response.ERROR);

		return response;
	}

	//Get Food Data for user
	@RequestMapping(value="/binge/admin/get/user/details/food",method=RequestMethod.GET)
	public @ResponseBody Response getFoodData(HttpServletRequest request) {
		Response response = new Response();

		String token = (String) request.getSession().getAttribute("token");

		final JWTVerifier verifier = new JWTVerifier(secret);

		Map<String, Object> claims;
		try {
			claims = verifier.verify(token);
			int user_id = Integer.parseInt((String)claims.get("username"));
			String role = (String) claims.get("role");
			if(role.equals("admin")||role.equals("supporter")){
				String p_id = request.getParameter("id");
				if(p_id!=null)
				{	List<DailyData> daily_data = bingeService.getDailyData(p_id);
				response.setData(daily_data);
				}else{
					p_id=(String)request.getSession().getAttribute("patient_id");
					List<DailyData> daily_data = bingeService.getDailyData(p_id);
					response.setData(daily_data);
				}
				
				response.setMessage("Data retrieval successful!!");
				response.setStatus(Response.SUCCESS);
				return response;
			}else{
				response.setData("You are not authorized to perform this action");
				response.setMessage("Error!");
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

		response.setData("Token Not Set!!");
		response.setMessage("Error Retriving Data for the user");
		response.setStatus(Response.ERROR);

		return response;
	}

	//Get Activity Data for user
	@RequestMapping(value="/binge/admin/get/user/details/activity",method=RequestMethod.GET)
	public @ResponseBody Response getActivityData(HttpServletRequest request) {
		Response response = new Response();

		String token = (String) request.getSession().getAttribute("token");

		final JWTVerifier verifier = new JWTVerifier(secret);

		Map<String, Object> claims;
		try {
			claims = verifier.verify(token);
			int user_id = Integer.parseInt((String)claims.get("username"));
			String role = (String) claims.get("role");
			if(role.equals("admin")||role.equals("supporter")){
				String p_id = request.getParameter("id");
				if(p_id!=null){
				List<PhysicalData> daily_data = bingeService.getActivityData(Integer.parseInt(p_id));
				response.setData(daily_data);
				}else{
					p_id=(String)request.getSession().getAttribute("patient_id");
					List<PhysicalData> daily_data = bingeService.getActivityData(Integer.parseInt(p_id));
					response.setData(daily_data);
				}
				response.setMessage("Data retrieval successful!!");
				response.setStatus(Response.SUCCESS);
				return response;
			}else{
				response.setData("You are not authorized to perform this action");
				response.setMessage("Error!");
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

		response.setData("Token Not Set!!");
		response.setMessage("Error Retriving Data for the user");
		response.setStatus(Response.ERROR);

		return response;
	}

	//Get Weekly Data for user
	@RequestMapping(value="/binge/admin/get/user/details/weekly",method=RequestMethod.GET)
	public @ResponseBody Response getWeeklyData(HttpServletRequest request) {
		Response response = new Response();

		String token = (String) request.getSession().getAttribute("token");

		final JWTVerifier verifier = new JWTVerifier(secret);

		Map<String, Object> claims;
		try {
			claims = verifier.verify(token);
			int user_id = Integer.parseInt((String)claims.get("username"));
			String role = (String) claims.get("role");
			if(role.equals("admin")||role.equals("supporter")){
				
				String p_id = request.getParameter("id");
				if(p_id!=null){
				List<WeeklyData> daily_data = bingeService.getWeeklyData(Integer.parseInt(p_id));
				response.setData(daily_data);
				}else{
					p_id=(String)request.getSession().getAttribute("patient_id");
					List<WeeklyData> daily_data = bingeService.getWeeklyData(Integer.parseInt(p_id));
					response.setData(daily_data);
				}
				response.setMessage("Data retrieval successful!!");
				response.setStatus(Response.SUCCESS);
				return response;
			}else{
				response.setData("You are not authorized to perform this action");
				response.setMessage("Error!");
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

		response.setData("Token Not Set!!");
		response.setMessage("Error Retriving Data for the user");
		response.setStatus(Response.ERROR);

		return response;
	}
	
	
	///
	@Scheduled(fixedRate=1000*60*60*24)
	public void reportCurrentTime() {
        logger.info("The time is now {}");
        //System.out.println("Schedular Running For User");
        List<Appointment> appointment = mobileService.getUpcomingAppointments();
        //logger.info(appointment.get(0).getAppointment_id()+"");
        for(int i=0;i<appointment.size();i++){
        	Notifications notif = new Notifications();
        	notif.setNotification_text("You have an upcoming Appointment tomorrow.");
        	notif.setP_id(appointment.get(i).getP_id());
        	notif.setCreated_date_time(new Timestamp(Calendar.getInstance().getTimeInMillis()));
        	notif.setType("Reminder");
        	bingeService.saveNotification(notif);
        }
        
    }
	
	@Scheduled(fixedRate=1000*60*60*24)
	public void sendMotivationalMessages() {
        logger.info("The time is now {}");
        //System.out.println("Schedular Running For User");
        List<StepWiseMessage> messages = mobileService.getMotivation();
        Random ran = new Random();
        
        int randomIndex = ran.nextInt(messages.size()-1);
        System.out.println("Object is -"+messages.get(randomIndex).getMessage_text()+" m id is "+messages.get(randomIndex).getM_id()+" step id is "+messages.get(randomIndex).getStep_id());
        bingeService.sendNotif(messages.get(randomIndex));
    }
	
	@RequestMapping(value = "/foodDetails", method = RequestMethod.GET)
	public String foodDetails(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "foodDetails";
	}
	
	@RequestMapping(value = "/viewUserDetails", method = RequestMethod.GET)
	public String viewDetails(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "SupporterHome";
	}
	
	@RequestMapping(value = "/get/food/details", method = RequestMethod.GET)
	public @ResponseBody ChartData getFoodChartData(HttpServletRequest request) {
		//logger.info("Welcome home! The client locale is {}.", locale);
		Response myResponse = new Response();
		String user_id = (String)request.getSession().getAttribute("patient_id");
		ChartData chartData = new ChartData();
		List<Columns> cols=new ArrayList<Columns>();
		Columns col = new Columns();
		col.setId("A");
		col.setLabel("Date");
		col.setType("string");;
		cols.add(col);
		Columns col1 = new Columns();
		col1.setId("B");
		col1.setLabel("Binge");
		col1.setType("number");;
		cols.add(col1);
		Columns col2 = new Columns();
		col2.setId("C");
		col2.setLabel("Servings");
		col2.setType("number");;
		cols.add(col2);
		List<MapData> mapData = new ArrayList<MapData>();
		List<DailyData> dailyData = bingeService.getDailyData(user_id);
		logger.debug(dailyData.size()+"");
		System.out.println("Size of dailyData is - "+dailyData.size());
		int binge=0,serving=0;
		java.sql.Date actualDate=new java.sql.Date(new Date().getTime());
		MapData mData = new MapData();
		List<Rows> rows = new ArrayList<Rows>();
		for(DailyData dData:dailyData){
			mData = new MapData();
			if(dData.getA_date().equals(actualDate)){
				if(dData.isBinge()){
					binge+=1;
				}
				serving+=dData.getServings();
			}else{
				//if(!actualDate.equals(new java.sql.Date(new Date().getTime()))){
					Rows row = new Rows();
					List<IndividualColumn> values = new ArrayList<IndividualColumn>();
					IndividualColumn indi  = new IndividualColumn();
					System.out.println("Else - "+actualDate);
					indi.setV(String.valueOf(actualDate));
					IndividualColumn indi1  = new IndividualColumn();
					indi1.setV(binge);
					IndividualColumn indi2  = new IndividualColumn();
					indi2.setV(serving);
					values.add(0,indi);
					values.add(1,indi1);
					values.add(2,indi2);;
					row.setC(values);
					rows.add(row);
				mData.setBinge(binge);
				mData.setServings(serving);
				mData.setDate(actualDate+"");
				mapData.add(mData);
				//}
				binge=0;
				serving=0;
				if(dData.isBinge()){
					binge+=1;
				}
				serving+=dData.getServings();
				actualDate=dData.getA_date();
			}
			
		}
		if(!actualDate.equals(new java.sql.Date(new Date().getTime()))){
			Rows row = new Rows();
			List<IndividualColumn> values = new ArrayList<IndividualColumn>();
			IndividualColumn indi  = new IndividualColumn();
			indi.setV(String.valueOf(actualDate));
			System.out.println("Value - "+indi.getV());
			IndividualColumn indi1  = new IndividualColumn();
			indi1.setV(binge);
			IndividualColumn indi2  = new IndividualColumn();
			indi2.setV(serving);
			values.add(0,indi);values.add(1,indi1);values.add(2,indi2);;
			row.setC(values);
			rows.add(row);
		mData.setBinge(binge);
		mData.setServings(serving);
		mData.setDate(actualDate+"");
		mapData.add(mData);
		}
		myResponse.setData(mapData);
		myResponse.setMessage("Chart Result Retrieved");
		myResponse.setStatus(Response.SUCCESS);
		chartData.setCols(cols);
		chartData.setRows(rows);
		
		//model.addAttribute("serverTime", formattedDate );
		return chartData;
		//return "{cols: [{id: 'A', label: 'NEW A', type: 'string'},{id: 'B', label: 'B-label', type: 'number'},{id: 'C', label: 'C-label', type: 'date'}],rows: [{c:[{v: 'a'},{v: 1.0, f: 'One'},{v: new Date(2008, 1, 28, 0, 31, 26), f: '2/28/08 12:31 AM'}]},{c:[{v: 'b'},{v: 2.0, f: 'Two'},{v: new Date(2008, 2, 30, 0, 31, 26), f: '3/30/08 12:31 AM'}]},{c:[{v: 'c'},{v: 3.0, f: 'Three'},{v: new Date(2008, 3, 30, 0, 31, 26), f: '4/30/08 12:31 AM'}]}]}";
	}
	
	// Get Data for chart
	@RequestMapping(value = "/get/activity/details", method = RequestMethod.GET)
	public @ResponseBody ChartData getActivityChartData(HttpServletRequest request) {
		//logger.info("Welcome home! The client locale is {}.", locale);
		Response myResponse = new Response();
		String user_id = (String)request.getSession().getAttribute("patient_id");
		ChartData chartData = new ChartData();
		List<Columns> cols=new ArrayList<Columns>();
		Columns col = new Columns();
		col.setId("A");
		col.setLabel("Date");
		col.setType("string");;
		cols.add(col);
		Columns col1 = new Columns();
		col1.setId("B");
		col1.setLabel("Duration");
		col1.setType("number");;
		cols.add(col1);
		List<MapData> mapData = new ArrayList<MapData>();
		List<PhysicalData> daily_data = bingeService.getActivityData(Integer.parseInt(user_id));
		logger.debug(daily_data.size()+"");
		System.out.println("Size of dailyData is - "+daily_data.size());
		//int binge=0,serving=0;
		java.sql.Date actualDate=new java.sql.Date(new Date().getTime());
		MapData mData = new MapData();
		List<Rows> rows = new ArrayList<Rows>();
		for(PhysicalData dData:daily_data){
			
					Rows row = new Rows();
					List<IndividualColumn> values = new ArrayList<IndividualColumn>();
					IndividualColumn indi  = new IndividualColumn();
					System.out.println("Else - "+actualDate);
					indi.setV(String.valueOf(dData.getA_date()));
					IndividualColumn indi1  = new IndividualColumn();
					indi1.setV(dData.getDuration());
					
					values.add(0,indi);
					values.add(1,indi1);
					
					row.setC(values);
					rows.add(row);
				
				mapData.add(mData);
				//}
				
			}
			
		chartData.setCols(cols);
		chartData.setRows(rows);
		
		//model.addAttribute("serverTime", formattedDate );
		return chartData;
		//return "{cols: [{id: 'A', label: 'NEW A', type: 'string'},{id: 'B', label: 'B-label', type: 'number'},{id: 'C', label: 'C-label', type: 'date'}],rows: [{c:[{v: 'a'},{v: 1.0, f: 'One'},{v: new Date(2008, 1, 28, 0, 31, 26), f: '2/28/08 12:31 AM'}]},{c:[{v: 'b'},{v: 2.0, f: 'Two'},{v: new Date(2008, 2, 30, 0, 31, 26), f: '3/30/08 12:31 AM'}]},{c:[{v: 'c'},{v: 3.0, f: 'Three'},{v: new Date(2008, 3, 30, 0, 31, 26), f: '4/30/08 12:31 AM'}]}]}";
	}
	
	// Get Data for chart
		@RequestMapping(value = "/get/weekly/details", method = RequestMethod.GET)
		public @ResponseBody ChartData getWeeklyChartData(HttpServletRequest request) {
			//logger.info("Welcome home! The client locale is {}.", locale);
			Response myResponse = new Response();
			String user_id = (String)request.getSession().getAttribute("patient_id");
			ChartData chartData = new ChartData();
			List<Columns> cols=new ArrayList<Columns>();
			Columns col = new Columns();
			col.setId("A");
			col.setLabel("Week");
			col.setType("string");;
			cols.add(col);
			Columns col1 = new Columns();
			col1.setId("B");
			col1.setLabel("Number of Binges");
			col1.setType("number");;
			cols.add(col1);
			Columns col2 = new Columns();
			col2.setId("C");
			col2.setLabel("Physical Activity");
			col2.setType("number");;
			cols.add(col2);
			Columns col3 = new Columns();
			col3.setId("D");
			col3.setLabel("Good Days");
			col3.setType("number");;
			cols.add(col3);
			Columns col4 = new Columns();
			col4.setId("E");
			col4.setLabel("Fruit and Vegetables");
			col4.setType("number");;
			cols.add(col4);
			
			
			
			List<MapData> mapData = new ArrayList<MapData>();
			List<WeeklyData> daily_data = bingeService.getWeeklyData(Integer.parseInt(user_id));
			logger.debug(daily_data.size()+"");
			System.out.println("Size of dailyData is - "+daily_data.size());
			//int binge=0,serving=0;
			java.sql.Date actualDate=new java.sql.Date(new Date().getTime());
			MapData mData = new MapData();
			List<Rows> rows = new ArrayList<Rows>();
			for(WeeklyData dData:daily_data){
				
						Rows row = new Rows();
						List<IndividualColumn> values = new ArrayList<IndividualColumn>();
						IndividualColumn indi  = new IndividualColumn();
						
						indi.setV(dData.getW_id());
						IndividualColumn indi1  = new IndividualColumn();
						indi1.setV(dData.getBinge());
						IndividualColumn indi2  = new IndividualColumn();
						indi2.setV(dData.getPhysical_activity());
						IndividualColumn indi3  = new IndividualColumn();
						indi3.setV(dData.getGood_days());
						IndividualColumn indi4  = new IndividualColumn();
						indi4.setV(dData.getFruit_vegetables());
						
						values.add(0,indi);
						values.add(1,indi1);
						values.add(2,indi2);
						values.add(3,indi3);
						values.add(4,indi4);
						
						row.setC(values);
						rows.add(row);
					
					mapData.add(mData);
					//}
					
				}
				
			chartData.setCols(cols);
			chartData.setRows(rows);
			
			//model.addAttribute("serverTime", formattedDate );
			return chartData;
			//return "{cols: [{id: 'A', label: 'NEW A', type: 'string'},{id: 'B', label: 'B-label', type: 'number'},{id: 'C', label: 'C-label', type: 'date'}],rows: [{c:[{v: 'a'},{v: 1.0, f: 'One'},{v: new Date(2008, 1, 28, 0, 31, 26), f: '2/28/08 12:31 AM'}]},{c:[{v: 'b'},{v: 2.0, f: 'Two'},{v: new Date(2008, 2, 30, 0, 31, 26), f: '3/30/08 12:31 AM'}]},{c:[{v: 'c'},{v: 3.0, f: 'Three'},{v: new Date(2008, 3, 30, 0, 31, 26), f: '4/30/08 12:31 AM'}]}]}";
		}

}
