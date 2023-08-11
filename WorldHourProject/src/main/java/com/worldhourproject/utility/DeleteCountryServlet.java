package com.worldhourproject.utility;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.worldhourproject.dao.CountryDAO;

import worldhourproject.controller.WHPView;

/**
 * Servlet implementation class DeleteCountryServlet
 */
public class DeleteCountryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteCountryServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		
		PrintWriter pw = response.getWriter();
		
		pw = response.getWriter();
		int id = Integer.parseInt(request.getParameter("id"));
		CountryDAO cdao = new CountryDAO(JDBCDataSource.getCon());
		boolean res = cdao.deleteCountry(id);
		if(res) {
			System.out.print("\nData deleted!\n");
			response.sendRedirect(WHPView.AdminPage);
		}
		else {
			System.out.print("\nSomething went wrong!\n");
		}
		pw.flush();
		pw.close();
	}

}
