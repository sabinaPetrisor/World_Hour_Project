package com.worldhourproject.bean;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.TimeZone;

public class CountryBean {
	private int id;
	private String country_name;
	private String country_capital;
	private String country_continent;
	
	public CountryBean() {
		
	}
	
	public CountryBean(int id, String country_name, String country_capital, String country_continent) {
		this.id = id;
		this.country_name = country_name;
		this.country_capital = country_capital;
		this.country_continent = country_continent;

	}
	
	public CountryBean(String country_name, String country_capital, String country_continent) {
		this.country_name = country_name;
		this.country_capital = country_capital;
		this.country_continent = country_continent;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCountry_name() {
		return country_name;
	}

	public void setCountry_name(String country_name) {
		this.country_name = country_name;
	}

	public String getCountry_capital() {
		return country_capital;
	}

	public void setCountry_capital(String country_capital) {
		this.country_capital = country_capital;
	}

	public String getCountry_continent() {
		return country_continent;
	}

	public void setCountry_continent(String country_continent) {
		this.country_continent = country_continent;
	}
	
	public String getCountryDate() {
		LocalDateTime cdate_time = LocalDateTime.now(TimeZone.getTimeZone(country_continent+"/"+country_capital).toZoneId());
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		String currDateStr = dtf.format(cdate_time); 
		return currDateStr;
	}
	
	public String getCountryTime() {
		LocalDateTime cdate_time = LocalDateTime.now(TimeZone.getTimeZone(country_continent+"/"+country_capital).toZoneId());
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");
		String currTimeStr = dtf.format(cdate_time); 
		return currTimeStr;
	}
	
	public String getCountryDateTime() {
		LocalDateTime cdate_time = LocalDateTime.now(TimeZone.getTimeZone(country_continent+"/"+country_capital).toZoneId());
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		String currDateStr = dtf.format(cdate_time); 
		return currDateStr;
	}
}
