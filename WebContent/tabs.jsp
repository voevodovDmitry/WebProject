<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="/WEB-INF/c.tld" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
  <ul id="filter" class="list-unstyled d-flex">
	<li id="firstTab" class="${(param.active_tab eq 'today' or empty param.active_tab) ? 'm-2 p-2 border-primary rounded border' : 'm-2 p-2'}"><a href="JavaScript:sendMenuForm('today')">Today</a></li>
	<li class="${(param.active_tab eq 'tomorrow') ? 'm-2 p-2 border-primary rounded border' : 'm-2 p-2'}"><a href="JavaScript:sendMenuForm('tomorrow')">Tomorrow</a></li>
	<li class="${(param.active_tab eq 'someday') ? 'm-2 p-2 border-primary rounded border' : 'm-2 p-2'}"><a href="JavaScript:sendMenuForm('someday')">Someday</a></li>
	<li class="${(param.active_tab eq 'old') ? 'm-2 p-2 border-primary rounded border' : 'm-2 p-2'}"><a href="JavaScript:sendMenuForm('old')">Old</a></li>
	<li class="${(param.active_tab eq 'all') ? 'm-2 p-2 border-primary rounded border' : 'm-2 p-2'}"><a href="JavaScript:sendMenuForm('all')">All</a></li>				
 </ul>
</body>
</html>