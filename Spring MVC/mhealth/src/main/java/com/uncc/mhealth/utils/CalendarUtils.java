package com.uncc.mhealth.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import com.uncc.mhealth.model.User;

public class CalendarUtils {
	/**
	 * calculates current day number from start date
	 * Day one is registration day & so on
	 * @param user
	 * @return
	 */
	public static long calculateCurrentDays(String sStr) {
		// String sStr = "Tue Feb 09 03:48:49 EST 2016";
//		String sStr = user.getRegistrationDate();
		try {
			Date startDate = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy").parse(sStr);
			System.out.println("Start : "+startDate);
			
			Calendar endDate = Calendar.getInstance();
			endDate.set(Calendar.HOUR_OF_DAY, 0);
			endDate.clear(Calendar.AM_PM);
			endDate.set(Calendar.MINUTE, 0);
			endDate.set(Calendar.SECOND, 0);
			endDate.set(Calendar.MILLISECOND, 0);
			
			System.out.println("End : "+endDate);

			Calendar date = Calendar.getInstance();
			  date.setTime(startDate);
			  date.set(Calendar.HOUR_OF_DAY, 0);
			  date.clear(Calendar.AM_PM);
			  date.set(Calendar.MINUTE, 0);
			  date.set(Calendar.SECOND, 0);
			  date.set(Calendar.MILLISECOND, 0);
			  long daysBetween = 1;  
			  while (date.before(endDate)) {  
				  System.out.println(" before");
			    date.add(Calendar.DAY_OF_MONTH, 1);  
			    daysBetween++;  
			  }  
			System.out.println("@@ Current Day : " + daysBetween);
			return daysBetween;
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return -1;
	}
}
