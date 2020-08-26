<%@page import="by.itClass.constants.Constants"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib uri="/WEB-INF/c.tld" prefix="c" %>
<!DOCTYPE html>
	<html>
	<head>
		<meta charset="UTF-8">
		<title>Login page</title>
		<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
	</head>
	<body>
		<jsp:include page="/message.jsp"/>
		<h2>Login</h2>
		<form method="post" action='<c:url value="/login"/>'>
			<input type="text" name="<%= Constants.LOGIN_LABEL %>" placeholder="Login">	<br><br>
			<input type="password" name="<%= Constants.PASSWORD_LABEL %>" placeholder="Password"> <br><br>
			<input type="submit" value="Login">
		</form>
		
		<br>
		<a href='<c:url value="/index.jsp"/>'>Back to start page</a>
	</body>
</html>