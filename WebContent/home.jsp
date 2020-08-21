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
	</head>
	<body>
		<header>
			<jsp:include page="/header.jsp"/>
		</header>
		<h2>Hello ${user.login}</h2>
		<p>Your name: ${user.name}</p>
		<p>Your surname: ${user.surname}</p>
		<p>Your email: ${user.email}</p>
		
		<h3>Conferences</h3>
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
	</body>
</html>