<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib uri="/WEB-INF/c.tld" prefix="c" %>

<header class="bg-light">
<c:choose>
	<c:when test="${not empty user}">
		<div class="d-flex justify-content-end align-items-center">
		   <span>Hello, ${user.login}!</span> <a id="buttonGoToMyConfereces" class="btn btn-primary m-2 ml-3" href="JavaScript:sendMenuForm('user')">Go to my conferences</a>
		   <a id="buttonGoToHomePage" class="btn btn-primary m-2 ml-3" href='<c:url value="/confCont"/>'>Go to home page</a>
		   <a class="btn btn-secondary m-2 mr-4" href='<c:url value="/logout"/>'>Logout</a>
        </div>
	</c:when>
	<c:otherwise>
		<div class="d-flex justify-content-end">
		    <a class="btn btn-primary m-2" href='<c:url value="/login.jsp"/>'>Login</a>
		    <a class="btn btn-secondary m-2" href='<c:url value="/regist.jsp"/>'>Registration</a>
	    </div>
	</c:otherwise>
</c:choose>
</header>