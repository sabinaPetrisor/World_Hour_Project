package com.worldhourproject.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import com.worldhourproject.bean.CountryBean;
import com.worldhourproject.utility.JDBCDataSource;

public class CountryDAO {
	private static final String INSERT_COUNTRY = "insert into country_date_time (country_name, country_capital, country_continent) values(?, ?, ?)";
	private static final String UPDATE_COUNTRY = "update country_date_time set country_name=?, country_capital=?, country_continent=? where id=?";
	private static final String LIST_ALL_COUNTRIES = "select * from country_date_time";
	private static final String GET_COUNTRY_BY_ID = "select * from country_date_time where id=?";
	private static final String DELETE_COUNTRY = "delete from country_date_time where id=?";
	private static final String GET_COUNTRY_INFO = "select * from country_date_time where country_name=?";
	private static Connection con;
	
	public CountryDAO(Connection con) {
		super();
		this.con = con;
	}
	
	public static boolean insertCountry(CountryBean country) {
		boolean inserted = false;
		//CountryBean res = null;
		try {
			//PreparedStatement stmt = con.prepareStatement("insert into country_date_time values(?,?,?,?,?)");
			//stmt.setInt(1, nextId());
			PreparedStatement stmt = con.prepareStatement(INSERT_COUNTRY);
			stmt.setString(1, country.getCountry_name());
			stmt.setString(2, country.getCountry_capital());
			stmt.setString(3, country.getCountry_continent());
			//stmt.setString(4, country.getCountry_date_time());
			//stmt.setTime(5, Time.valueOf(country.getCountry_time()));
			int i = stmt.executeUpdate();
			if(i == 1) {
				inserted = true;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return inserted;
	}
	
	public static boolean updateCountry(CountryBean country) {
		boolean inserted = false;
		//CountryBean res = null;
		try {
			//PreparedStatement stmt = con.prepareStatement("insert into country_date_time values(?,?,?,?,?)");
			//stmt.setInt(1, nextId());
			PreparedStatement stmt = con.prepareStatement(UPDATE_COUNTRY);
			stmt.setString(1, country.getCountry_name());
			stmt.setString(2, country.getCountry_capital());
			stmt.setString(3, country.getCountry_continent());
			stmt.setInt(4, country.getId());
			//stmt.setString(4, country.getCountry_date_time());
			//stmt.setTime(5, Time.valueOf(country.getCountry_time()));
			int i = stmt.executeUpdate();
			if(i == 1) {
				inserted = true;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return inserted;
	}
	
	public List<CountryBean> getAllCountries() {
		List<CountryBean> countryList = new ArrayList<CountryBean>();
		CountryBean country = null;
		try {
			PreparedStatement stmt = con.prepareStatement(LIST_ALL_COUNTRIES);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				country = new CountryBean();
				country.setId(rs.getInt(1));
				country.setCountry_name(rs.getString(2));
				country.setCountry_capital(rs.getString(3));
				country.setCountry_continent(rs.getString(4));
				countryList.add(country);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return countryList;
	}
	
	public CountryBean getCountryById(int id) {
		CountryBean cb = null;
		PreparedStatement stmt;
		try {
			stmt = con.prepareStatement(GET_COUNTRY_BY_ID);
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				cb = new CountryBean();
				cb.setId(rs.getInt(1));
				cb.setCountry_name(rs.getString(2));
				cb.setCountry_capital(rs.getString(3));
				cb.setCountry_continent(rs.getString(4));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cb;
	}
	
	public boolean deleteCountry(int id) {
		boolean deleted = false;
		try {
			//PreparedStatement stmt = con.prepareStatement("insert into country_date_time values(?,?,?,?,?)");
			//stmt.setInt(1, nextId());
			PreparedStatement stmt = con.prepareStatement(DELETE_COUNTRY);
			stmt.setInt(1, id);
			//stmt.setString(4, country.getCountry_date_time());
			//stmt.setTime(5, Time.valueOf(country.getCountry_time()));
			int i = stmt.executeUpdate();
			if(i == 1) {
				deleted = true;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return deleted;
	}
	
	public CountryBean getCountryInfo(String country_name) {
		CountryBean country = null;
		try {
			PreparedStatement stmt = con.prepareStatement(GET_COUNTRY_INFO);
			stmt.setString(1, country_name);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				country = new CountryBean();
				country.setId(rs.getInt(1));
				country.setCountry_name(rs.getString(2));
				country.setCountry_capital(rs.getString(3));
				country.setCountry_continent(rs.getString(4));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return country;
	}
}
