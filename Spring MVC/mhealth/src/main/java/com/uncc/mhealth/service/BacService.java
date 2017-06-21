package com.uncc.mhealth.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.WeekFields;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import com.uncc.mhealth.dao.BacLogDAO;
import com.uncc.mhealth.model.BacLog;
import com.uncc.mhealth.utils.CalendarUtils;

import javafx.util.Pair;

public class BacService {
	public static BacLog getBacForYesterday(int user_id, BacLogDAO bacLogDao){
		List<BacLog> yesterdayBacLogList = new ArrayList<BacLog>();
		List<BacLog> userBacLogList = bacLogDao.get(user_id);
		for(BacLog bl : userBacLogList){
			long days = CalendarUtils.calculateCurrentDays(bl.getLog_date());
			System.out.println("BAC log : "+bl.getLog_date()+ " & days : "+days);
			if(days == 2){
				yesterdayBacLogList.add(bl);
			}
		}
		
		if(yesterdayBacLogList.size() < 1){
			return null;
		}
		
		//select max bac if any
		BacLog log = yesterdayBacLogList.get(0);
		for(BacLog bl : yesterdayBacLogList){
			if(bl.getBac() > log.getBac()){
				log = bl;
			}
		}
		
		return log;
	}
	
	protected static int getWeekOfYear(LocalDate date) {
        WeekFields wf = WeekFields.of(Locale.getDefault());
        return date.get(wf.weekOfYear());
    }
	
	
	@Deprecated
	public static List<Pair<Integer, Integer>> getDatedAvgBacForAllUsers(BacLogDAO bacLogDao){
		List<Pair<Integer, Integer>> avgBacLogList = new ArrayList<Pair<Integer, Integer>>();
		Map<Integer, Integer> weekBacList = new HashMap<Integer, Integer>(); 
		List<BacLog> userBacLogList = bacLogDao.list();
		for(BacLog bl : userBacLogList){
			
			Date theSameDate;
			try {
				theSameDate = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy").parse(bl.getLog_date());
				int week = getWeekOfYear(theSameDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
				Integer drinksCount = weekBacList.get(week);
				if (drinksCount == null)
					drinksCount = 0;
				drinksCount = drinksCount + bl.getDrinks();
				weekBacList.put(week, drinksCount);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				System.out.println("@@@Error occured");
			}
			
		}
		
		if(weekBacList.size() < 1){
			return null;
		}
		
		Iterator<Map.Entry<Integer, Integer>> iterator = weekBacList.entrySet().iterator();
		while(iterator.hasNext()){
		   Map.Entry<Integer, Integer> entry = iterator.next();
		   Pair<Integer, Integer> a = new Pair<Integer, Integer>(entry.getKey(), entry.getValue());
		   
		   avgBacLogList.add(a);
		}

		
		return avgBacLogList;
	}
}
