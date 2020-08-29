<%@page import="by.itClass.constants.Constants"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib uri="/WEB-INF/c.tld" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Conference</title>
		<script type="text/javascript" src='<c:url value="/js/main.js"/>'></script>
		<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
	</head>
	<body>
	 <header class="bg-light">
		<jsp:include page="/header.jsp"/>
	  </header>
	<div class="d-flex flex-column align-items-center">
	<div class="mb-4">
		<h2 class="mb-4 mt-2">Conference info</h2>
		<p class="pl-2">Title: ${conf.title}</p>
		<p class="pl-2">Place: ${conf.place}</p>
		<p class="pl-2">Date: ${conf.date}</p>
		<p class="pl-2">Description: ${conf.descr}</p>
		<p class="pl-2">Author: ${conf.user}</p>
	</div>
		
		<h3>Conference program</h3>
		
		<table class="table table-bordered mt-4 w-50">
			<tr>
				<th>ID</th>
				<th>Event name</th>
				<th>Time</th>
			</tr>
			<c:forEach var="event" items="${conf.events}">
				<tr>
					<td>${event.id}</td>
					<td>${event.descr}</td>
					<td>${event.time}</td>				
				</tr>
			</c:forEach>
		</table>
		</div>
		<form id="menuForm" method="post" action='<c:url value="/confCont"/>'>
			<input type="hidden" name="<%= Constants.SECTION_LABEL %>">
		</form>
	</body>
</html>