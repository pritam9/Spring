package com.uncc.mhealth.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;

public class BacLog {
	private int id;
	private int user_id;
	private int drinks;
	private double bac;
	private String log_date;
	private int beer;
	private int wine;
	private int shots;
	private int liquor;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public int getDrinks() {
		return drinks;
	}

	public void setDrinks(int drinks) {
		this.drinks = drinks;
	}

	public double getBac() {
		return bac;
	}

	public void setBac(double bac) {
		this.bac = bac;
	}

	public String getLog_date() {
		return log_date;
	}

	public void setLog_date(String log_date) {
		this.log_date = log_date;
	}

	public int getBeer() {
		return beer;
	}

	public void setBeer(int beer) {
		this.beer = beer;
	}

	public int getWine() {
		return wine;
	}

	public void setWine(int wine) {
		this.wine = wine;
	}

	public int getShots() {
		return shots;
	}

	public void setShots(int shots) {
		this.shots = shots;
	}

	public int getLiquor() {
		return liquor;
	}

	public void setLiquor(int liquor) {
		this.liquor = liquor;
	}

	@Override
	public String toString() {
		return "BacLog [id=" + id + ", user_id=" + user_id + ", drinks=" + drinks + ", bac=" + bac + ", log_date="
				+ log_date + ", beer=" + beer + ", wine=" + wine + ", shots=" + shots + ", liquor=" + liquor + "]";
	}

	public static Comparator<BacLog> bacLogComparator = new Comparator<BacLog>() {

		public int compare(BacLog bac1, BacLog bac2) {

			
			try {
				Date bac1Date = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy").parse(bac1.getLog_date());
				Date bac2Date = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy").parse(bac2.getLog_date());
				// ascending order
				return bac1Date.compareTo(bac2Date);
				// descending order
				// return fruitName2.compareTo(fruitName1);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return 0;

		}

	};

}
