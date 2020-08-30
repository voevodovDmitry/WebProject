<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri = "/WEB-INF/c.tld" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Registration</title>
		<link href="css/bootstrap.css" rel="stylesheet" type="text/css">
		<link
		  rel="stylesheet"
		  href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
		  integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk"
		  crossorigin="anonymous"
		>
	</head>
	<body class="bg-light">
		<div class="m-4 mt-4">			
			<a  href='<c:url value="/login.jsp"/>'>
				<svg width="1em" height="1em" viewBox="0 0 16 16" class="bi bi-arrow-left" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
 					<path fill-rule="evenodd" d="M15 8a.5.5 0 0 0-.5-.5H2.707l3.147-3.146a.5.5 0 1 0-.708-.708l-4 4a.5.5 0 0 0 0 .708l4 4a.5.5 0 0 0 .708-.708L2.707 8.5H14.5A.5.5 0 0 0 15 8z"/>
				</svg>
				Back
			</a>
		</div>
		<div class="d-flex justify-content-center flex-column align-items-center border border-black bg-white m-auto w-50">
			<jsp:include page="/message.jsp"/>
			<h3 class="mb-4">Enter your details</h3>
			<form action='<c:url value = "/regist" />' method="post"> 	
				<label for="login" >login:</label> <input  class="form-control mb-4" type="text" name="login" placeholder="login" > 
				<label for="password" >password:</label> <input  class="form-control mb-4" type="text" name="password" placeholder="password" >
				<label for="name" >name:</label> <input type="text"  class="form-control mb-4" name="name" placeholder="name" > 
				<label for="surname" >surname:</label> <input type="text"  class="form-control mb-4" name="surname" placeholder="surname" > 
				<label for="email" >email:</label> <input type="email"  class="form-control mb-4" name="email" placeholder="email" >
				<input class="btn btn-success w-50 mb-4 mt-2 w-100" type="submit" value="Sing up"> 
			</form>
		</div>
	</body>
</html>