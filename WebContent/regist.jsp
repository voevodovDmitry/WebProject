<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri = "/WEB-INF/c.tld" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Registration</title>
		<link href="css/bootstrap.css" rel="stylesheet" type="text/css">
		<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
	</head>
	<body>
		<jsp:include page="/message.jsp"/>
		<h3>Registration</h3>
		
		<p>Enter your details</p>
		<form action='<c:url value = "/regist" />' method="post"> <br>
		
		
			<div style="margin-bottom: 10px"><label for="login" >login:</label> <input type="text" name="login" placeholder="login" style="margin-left: 102px"> </div>
			<div style="margin-bottom: 10px"><label for="password" >password:</label> <input type="text" name="password" placeholder="password" style="margin-left: 74px"></div>
			<div style="margin-bottom: 10px"><label for="name" >name:</label> <input type="text" name="name" placeholder="name" style="margin-left: 100px"> </div>
			<div style="margin-bottom: 10px"><label for="surname" >surname:</label> <input type="text" name="surname" placeholder="surname" style="margin-left: 79px"> </div>
			<div style="margin-bottom: 10px"><label for="email" >email:</label> <input type="email" name="email" placeholder="email" style="margin-left: 98px"></div>	
			 
			
			
			 
			<input type="submit" value="Sing up"> 
			
		
		
		</form>
		<form action="<c:url value = "/index.jsp"/> " name="addForm">
				<button>Back</button>
			</form>
	</body>
</html>