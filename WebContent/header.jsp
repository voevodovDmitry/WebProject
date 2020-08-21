<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib uri="/WEB-INF/c.tld" prefix="c" %>

<c:choose>
	<c:when test="${not empty user}">
		<span>User: </span> <a href="JavaScript:sendMenuForm('user')">${user.login}</a>
		<a href='<c:url value="/logout"/>'>Logout</a>
	</c:when>
	<c:otherwise>
		<a href='<c:url value="/login.jsp"/>'>Login</a>
		<a href='<c:url value="/regist.jsp"/>'>Registration</a>
	</c:otherwise>
</c:choose>