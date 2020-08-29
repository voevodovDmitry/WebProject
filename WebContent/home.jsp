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
		<header class="bg-light">
			<jsp:include page="/header.jsp"/>
		</header>
     <div class="d-flex justify-content-center flex-column">
		<h2 class="align-self-center mb-4">Personal info</h2>
		<div class="align-self-center mb-4">
		  <p>Name: ${user.name}</p>
		  <p>Surname: ${user.surname}</p>
		  <p>Email: ${user.email}</p>
		</div>
		
		<h2 class="align-self-center">Conferences</h2>
		
		<jsp:include page="/viewConf.jsp"/>
		
	    <ul id="actions" class="list-unstyled align-self-center d-none">
		  <li><a href="JavaScript:sendOperationForm('delete')">Delete conferences</a></li>
		  <li><a href="JavaScript:sendOperationForm('done')">Done conferences</a></li>
		</ul>
		<h2 class="align-self-center">
			<u><a style="width: 150px;" href='<c:url value="/addConf.jsp"/>'>Create conference</a></u>
		</h2>
		
		<form id="operationForm" method="post" action='<c:url value="/operation"/>'>
			<input type="hidden" name="<%= Constants.OPERATION_LABEL %>">
		</form>
		</div>

		<script>
		  const buttonGoToHomePage = document.getElementById('buttonGoToHomePage');
		  const buttonGoToMyConfereces = document.getElementById('buttonGoToMyConfereces');
		  buttonGoToHomePage.classList.remove('d-none');
		  buttonGoToMyConfereces.classList.add('d-none');
		  
	      const isChecked = (checkboxes) => {
	          let isChecked = false;
	          for (i = 0; i < checkboxes.length; i++) {
	            isChecked = checkboxes[i].checked;
	            if (isChecked) {
	              break;
	            }
	          }
	          return isChecked;
	        };

	        const actions = document.getElementById('actions');
	        const checkboxes = document.getElementsByName('ids');

	        checkboxes.forEach((checkbox) => {
	          checkbox.addEventListener('change', () => {
	            if (isChecked(checkboxes)) {
	              if (actions.classList.contains('d-none')) {
	            	  actions.classList.remove('d-none');
	              } 
	            } else {
		          if (!actions.classList.contains('d-none')) {
		            actions.classList.add('d-none');
		          }
	            }
	          });
	        });
		  
		</script>
	</body>
</html>