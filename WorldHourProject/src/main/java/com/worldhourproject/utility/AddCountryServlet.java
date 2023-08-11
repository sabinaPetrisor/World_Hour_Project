package com.worldhourproject.utility;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.TimeZone;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.worldhourproject.bean.CountryBean;
import com.worldhourproject.dao.CountryDAO;

/**
 * Servlet implementation class AddCountryServlet
 */
public class AddCountryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddCountryServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		
		PrintWriter pw = response.getWriter();
		
		pw = response.getWriter();
		
		String cname = request.getParameter("cname");
		String ccapital = request.getParameter("ccapital");
		String ccontinent = request.getParameter("ccontinent");
		
		//LocalDateTime cdate_time = LocalDateTime.now(TimeZone.getTimeZone(ccontinent+"/"+ccapital).toZoneId());
		//LocalDate cdate = cdate_time.toLocalDate();
		//LocalTime ctime = cdate_time.toLocalTime();
		/*DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		String cdate = dtf.format(cdate_time);*/
		
		System.out.print("Data inserted is: "+ cname + ", " + ccapital + ", " + ccontinent);
		
		CountryBean country = new CountryBean(cname, ccapital, ccontinent);
		
		CountryDAO dataToAdd = new CountryDAO(JDBCDataSource.getCon());
		//HttpSession session = request.getSession();
		boolean res = dataToAdd.insertCountry(country);
		if(res) {
			System.out.print("\nData inserted!\n");
		}
		else {
			System.out.print("\nSomething went wrong!\n");
		}
		pw.flush();
		pw.close();
	}

}