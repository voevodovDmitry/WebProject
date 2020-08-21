<%@page import="by.itClass.constants.Constants"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib uri="/WEB-INF/c.tld" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Conferences list</title>
		<script type="text/javascript" src='<c:url value="/js/main.js"/>'></script>
	</head>
	<body>
		<header>
			<jsp:include page="/header.jsp"/>
		</header>
		<table>
			<tr>
				<th><a href="JavaScript:sendMenuForm('today')">Today</a></th>
				<th><a href="JavaScript:sendMenuForm('tomorrow')">Tomorrow</a></th>
				<th><a href="JavaScript:sendMenuForm('someday')">Someday</a></th>
				<th><a href="JavaScript:sendMenuForm('old')">Old</a></th>
				<th><a href="JavaScript:sendMenuForm('all')">All</a></th>
			</tr>
		</table>
		
		<br><br>
		<jsp:include page="/viewConf.jsp"/>
		
		<form id="menuForm" method="post" action='<c:url value="/confCont"/>'>
			<input type="hidden" name="<%= Constants.SECTION_LABEL %>">
		</form>
	</body>
</html>