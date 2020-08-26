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
		<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
	</head>
	<body id="allConferences">

		<jsp:include page="/header.jsp"/>

		<main class="d-flex justify-content-center flex-column">
			<div class="d-flex justify-content-center">
				<jsp:include page="/tabs.jsp">
				 <jsp:param name="active_tab" value="${sectionNumber}" />
				</jsp:include>
				</div>
				<jsp:include page="/viewConf.jsp"/>
				
				<form id="menuForm" method="post" action='<c:url value="/confCont"/>'>
					<input type="hidden" name="<%= Constants.SECTION_LABEL %>">
				</form>
			
		</main>
			
		<script>
		  const buttonGoToHomePage = document.getElementById('buttonGoToHomePage');
		  const buttonGoToMyConfereces = document.getElementById('buttonGoToMyConfereces');
		  buttonGoToHomePage.classList.add('d-none');
		  buttonGoToMyConfereces.classList.remove('d-none');
		  const checkboxes = document.querySelectorAll("input[name*='ids']");
		  checkboxes.forEach((elem) => elem.parentElement.classList.add('d-none'));
		</script>
	</body>
</html>