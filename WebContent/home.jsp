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
	<body id="home">
		<header>
			<jsp:include page="/header.jsp"/>
		</header>
		<div class="d-flex justify-content-center flex-column m-2">
		<div>
		<h2>Personal info:</h2>
		<p>Name: ${user.name}</p>
		<p>Surname: ${user.surname}</p>
		<p>Email: ${user.email}</p>
		
		<h2>Conferences</h2>
		
		<jsp:include page="/viewConf.jsp"/>
		
		<table>
			<tr>
				<td><a href='<c:url value="/addConf.jsp"/>'>Create conference</a></td>
				<td><a href="JavaScript:sendOperationForm('delete')">Delete conferences</a></td>
				<td><a href="JavaScript:sendOperationForm('done')">Done conferences</a></td>
			</tr>
		</table>
		
		<br><br>
		<a href='<c:url value="/confCont"/>'>Back</a>
		
		<form id="operationForm" method="post" action='<c:url value="/operation"/>'>
			<input type="hidden" name="<%= Constants.OPERATION_LABEL %>">
		</form>
		</div>
		</div>
		<script>
		  const buttonGoToHomePage = document.getElementById('buttonGoToHomePage');
		  const buttonGoToMyConfereces = document.getElementById('buttonGoToMyConfereces');
		  buttonGoToHomePage.classList.remove('d-none');
		  buttonGoToMyConfereces.classList.add('d-none');
		</script>
	</body>
</html>