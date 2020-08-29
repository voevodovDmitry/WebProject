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
	<body class="bg-light">
	<div class="d-flex">
	 <div class="d-flex justify-content-center flex-column align-items-center border border-black bg-white m-auto">
		<jsp:include page="/message.jsp"/>
		
		<h2 class="mt-4 mb-5 mr-5 ml-5">Welcome to WebProject</h2>
		<form class="w-50" method="post" action='<c:url value="/login"/>'>
			<input class="form-control mb-4" type="text" name="<%= Constants.LOGIN_LABEL %>" placeholder="Login">
			<input class="form-control mb-4" type="password" name="<%= Constants.PASSWORD_LABEL %>" placeholder="Password">
			<input class="btn btn-primary mb-4 w-100 form-control" type="submit" value="Sign in">
		</form>
		<span>Not registered?</span>
		<a class="btn btn-success w-50 mb-4 mt-2" href='<c:url value="/regist.jsp"/>'>Registration</a>
		</div>
		</div>
	</body>
</html>