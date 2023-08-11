<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.util.List"%>
<%@page import="com.worldhourproject.utility.JDBCDataSource"%>
<%@page import="worldhourproject.controller.WHPView"%>
<%@page import="com.worldhourproject.dao.CountryDAO"%>
<%@page import="com.worldhourproject.bean.CountryBean"%>
<!DOCTYPE html>
<html>
<head>
	<meta name="viewport" content="width=device-width, initial-scale=1" charset="UTF-8">
	<title>World Hour Project Add Country</title>
	<style> <%@include file="../css/navbar.css" %> </style>
	<style> <%@include file="../css/admin.css" %> </style>
	<style> <%@include file="../css/add-page-admin.css" %> </style>
	<script type="text/javascript" src="//ajax.googleapis.com/ajax/libs/jquery/1.5.1/jquery.js"></script>
	<script type="text/javascript"><%@include file="../javascript/set-default-dropdown-list-value.js" %></script>
</head>
<body>
	<%@include file="navbar.jsp" %>
	
	<div class="content-container">
		<p class="content-container-title">Edit Country</p>
		
		<%
			int id = Integer.parseInt(request.getParameter("id"));
			CountryDAO cdao = new CountryDAO(JDBCDataSource.getCon());
			CountryBean cb = cdao.getCountryById(id);
		%>
		<div class="add-form-container">
			<form class="add-form" action="<%=WHPView.EditCountryServlet %>" method="post">
				<label for="cname">Country Name</label>
				<input type="text" value="<%=cb.getCountry_name() %>" class="insert-text" id="cname" name="cname">
				<label for="ccapital">Country Capital</label>
				<input type="text" value="<%=cb.getCountry_capital() %>" class="insert-text" id="ccapital" name="ccapital">
				<label for="ccontinent">Country Continent</label>
				<input type="hidden" value="<%=cb.getCountry_continent() %>" id="ccontinentval">
				<select class="option-selection" id="ccontinent" name="ccontinent">
					<option value="Africa" selected>Africa</option>
					<option value="America">America</option>
					<option value="Asia">Asia</option>
					<option value="Atlantic">Atlantic</option>
					<option value="Australia">Australia</option>
					<option value="Europe">Europe</option>
					<option value="Indian">Indian</option>
					<option value="Pacific">Pacific</option>
				</select>
				<input type="hidden" name="id" value="<%=cb.getId() %>">
				<div class="btn-container">
					<button type="submit" class="add-button" id="add-button">Edit Country</button>
				</div>
			</form>
		</div>
	</div>
</body>
</html>