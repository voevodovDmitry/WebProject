<%@page import="by.itClass.constants.Constants"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib uri="/WEB-INF/c.tld" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Home page</title>
		<script type="text/javascript" src='<c:url value="/js/main.js"/>'></script>
		<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
	</head>
	<body>
		<jsp:include page="/header.jsp"/>
    	<div class="d-flex justify-content-center flex-column">
			<h2 class="align-self-center mb-4">Personal info</h2>
			<div class="align-self-center mb-4">
				<p>Name: ${user.name}</p>
				<p>Surname: ${user.surname}</p>
				<p>Email: ${user.email}</p>
			</div>
			<h2 class="align-self-center">Conferences</h2>
			<jsp:include page="/viewConf.jsp"/>
	    	<ul id="actions" class="list-unstyled align-self-center d-none">
		  		<li><a href="JavaScript:sendOperationForm('delete')">Delete conferences</a></li>
		  		<li><a href="JavaScript:sendOperationForm('done')">Done conferences</a></li>
			</ul>
			<h2 class="align-self-center">
				<u><a style="width: 150px;" href='<c:url value="/addConf.jsp"/>'>Create conference</a></u>
			</h2>
			<form id="operationForm" method="post" action='<c:url value="/operation"/>'>
				<input type="hidden" name="<%= Constants.OPERATION_LABEL %>">
			</form>
		</div>
		<script src='<c:url value="/js/home.js"/>'></script>
	</body>
</html>