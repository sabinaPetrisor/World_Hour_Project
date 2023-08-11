package com.worldhourproject.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/*import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;*/
import java.util.ResourceBundle;

public class JDBCDataSource {
	/*public static void main(String[] args) {
		ResourceBundle rb = ResourceBundle.getBundle("worldhourproj.System");
		String url = rb.getString("url");
		System.out.println(url);
		
		try {
			Connection con = DriverManager.getConnection(url, "root", "root");
			System.out.println(con);
			
			LocalDateTime now = LocalDateTime.now();
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
			String currDateStr = dtf.format(now);
			System.out.println(currDateStr);
		
			PreparedStatement pstmt = con.prepareStatement("delete from country_date_time where country_name='Romania'");
			pstmt.execute();
			pstmt = con.prepareStatement("alter table country_date_time auto_increment=1");
			pstmt.execute();
			pstmt = con.prepareStatement("insert into country_date_time(country_name, country_date_time) values (?, ?)");
			pstmt.setString(1, "Romania");
			pstmt.setString(2, currDateStr);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}*/
	
	/*private static JDBCDataSource datasource;
	
	private JDBCDataSource() {
	}
	
	private ComboPooledDataSource cpds = null;
	
	public static JDBCDataSource getInstance() {
		if(datasource == null) {
			ResourceBundle rb = ResourceBundle.getBundle("worldhourproj.System");
			datasource = new JDBCDataSource();
			datasource.cpds = new ComboPooledDataSource();
			try {
				datasource.cpds.setDriverClass(rb.getString("driver"));
			} catch (PropertyVetoException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			datasource.cpds.setJdbcUrl(rb.getString("url"));
			datasource.cpds.setUser(rb.getString("username"));
			datasource.cpds.setPassword(rb.getString("password"));
			datasource.cpds.setAcquireIncrement(Integer.valueOf((String) rb.getString("acquireIncrement")));
			datasource.cpds.setInitialPoolSize(Integer.valueOf((String) rb.getString("initialPoolSize")));
			datasource.cpds.setMaxPoolSize(Integer.valueOf((String) rb.getString("maxPoolSize")));
			datasource.cpds.setMinPoolSize(Integer.valueOf((String) rb.getString("minPoolSize")));
			datasource.cpds.setMaxIdleTime(Integer.valueOf((String) rb.getString("timeout")));
		}
		return datasource;
	}
	
	public static Connection getConnection() throws Exception {
		return getInstance().cpds.getConnection();
	}
	
	public static void closeConnection(Connection conn) {
		if(conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		JDBCDataSource jdbc = new JDBCDataSource();
		try {
			Connection con = jdbc.getConnection();
			System.out.println(con);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}*/
	
	private static Connection con;
	
	public static Connection getCon() {
		ResourceBundle rb = ResourceBundle.getBundle("worldhourproj.System");
		String driver = rb.getString("driver");
		String url = rb.getString("url");
		String username = rb.getString("username");
		String password = rb.getString("password");
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, username, password);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}
	
	/*public static void main(String[] args) {
		JDBCDataSource ds = new JDBCDataSource();
		Connection conn = ds.getCon();
		System.out.println("Con is: " + conn);
	}*/
}
