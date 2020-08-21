<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib uri="/WEB-INF/c.tld" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Conference</title>
	</head>
	<body>
		<h2>Conference info</h2>
		<p>Title: ${conf.title}</p>
		<p>Place:${conf.place}</p>
		<p>Date:${conf.date}</p>
		<p>Description:${conf.descr}</p>
		<p>Author:${conf.user}</p>
		
		<h3>Conference program</h3>
		
		<table>
			<tr>
				<th>id</th>
				<th>description</th>
				<th>time</th>
			</tr>
			<c:forEach var="event" items="${conf.events}">
				<tr>
					<td>${event.id}</td>
					<td>${event.descr}</td>
					<td>${event.time}</td>				
				</tr>
			</c:forEach>
		</table>
		
		<a href='<c:url value="/index.jsp"/>'>Back</a>
	</body>
</html>