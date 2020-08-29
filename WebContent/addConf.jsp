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
	  <header class="bg-light">
		<jsp:include page="/header.jsp"/>
	  </header>
		<h2 class="text-center pt-4 pb-4">New Conference</h2>
		
		<div class="d-flex flex-column align-items-center mb-4">
		<form id="newConfForm" style="width: 30%;" class="form-group" method="post" action='<c:url value="/addConf"/>'>
			<p class="text-center" style="font-size: 20px;">Conference data:</p>
			<input class="form-control mb-4" type="text" name="<%= Constants.TITLE_LABEL %>" placeholder="Title">
			<textarea class="form-control mb-4" name="<%=Constants.DESCR_CONF_LABEL%>" placeholder="Description" style="height: 150px;"></textarea>
			<input class="form-control mb-4" type="text" name="<%= Constants.PLACE_LABEL %>" placeholder="Place">
			<input class="form-control mb-4" type="date" name="<%= Constants.DATE_LABEL %>" placeholder="Date">
			
			<p>Conference program:</p>
			<div id="event">
				<input class="form-control mb-4" type="text" name="<%= Constants.DESCR_EVENTS_LABEL %>" placeholder="Name" required>
				<input class="form-control" type="time" name="<%= Constants.TIMES_LABEL %>" placeholder="Time" required>
			</div>
		</form>
		
		<p><a href="JavaScript:addEvent()">Add event +</a></p>
		<input class="btn btn-primary" type="submit" value="Create conference" form="newConfForm">
		</div>
		<form id="menuForm" method="post" action='<c:url value="/confCont"/>'>
		   <input type="hidden" name="<%= Constants.SECTION_LABEL %>">
		</form>
	</body>
</html>