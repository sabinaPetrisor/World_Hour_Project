<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="worldhourproject.controller.WHPView"%>
<!DOCTYPE html>
<html>
<head>
	<meta name="viewport" content="width=device-width, initial-scale=1" charset="UTF-8">
	<title>World Hour Project Add Country</title>
	<style> <%@include file="../css/navbar.css" %> </style>
	<style> <%@include file="../css/admin.css" %> </style>
	<style> <%@include file="../css/add-page-admin.css" %> </style>
</head>
<body>
	<%@include file="navbar.jsp" %>
	
	<div class="content-container">
		<p class="content-container-title">Add a New Country</p>
		<div class="add-form-container">
			<form class="add-form" action="<%=WHPView.AddCountryServlet %>" method="post">
				<label for="cname">Country Name</label>
				<input type="text" placeholder="Type a Country Name" class="insert-text" id="cname" name="cname">
				<label for="ccapital">Country Capital</label>
				<input type="text" placeholder="Type Country's Capital" class="insert-text" id="ccapital" name="ccapital">
				<label for="ccontinent">Country Continent</label>
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
				<div class="btn-container">
					<button type="submit" class="add-button" id="add-button">Add Country</button>
				</div>
			</form>
		</div>
		<div id="successful-db-insertion">
			<script type="text/javascript" src="//ajax.googleapis.com/ajax/libs/jquery/1.5.1/jquery.js"></script>
			<script type="text/javascript"><%@include file="../javascript/dropdown-list-selection.js" %></script>
		</div>
	</div>
</body>
</html>