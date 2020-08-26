<%@page import="by.itClass.constants.Constants"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib uri="/WEB-INF/c.tld" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>New conference page</title>
		<script type="text/javascript" src='<c:url value="/js/main.js"/>'></script>
		<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
	</head>
	<body>
		<h2>New Conference</h2>
		
		<form id="newConfForm" method="post" action='<c:url value="/addConf"/>'>
			<p>Conference data:</p>
			<input type="text" name="<%= Constants.TITLE_LABEL %>" placeholder="Title"> <br>
			<input type="text" name="<%=Constants.DESCR_CONF_LABEL%>" placeholder="Description" style="height: 150px;"> <br>
			<input type="text" name="<%= Constants.PLACE_LABEL %>" placeholder="Place"> <br>
			<input type="date" name="<%= Constants.DATE_LABEL %>" placeholder="Date"> <br>
			
			<p>Events:</p>
			<div id="event">
				<input type="text" name="<%= Constants.DESCR_EVENTS_LABEL %>" placeholder="Description" required> <br>
				<input type="time" name="<%= Constants.TIMES_LABEL %>" placeholder="Time" required> <br><br>
			</div>
		</form>
		<p><a href="JavaScript:addEvent()">Add event</a></p>
		<input type="submit" value="Create conference" form="newConfForm">
		
	</body>
</html>