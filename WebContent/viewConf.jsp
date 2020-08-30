<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib uri="/WEB-INF/c.tld" prefix="c" %>

<div class="d-flex justify-content-center">
	<c:choose>
		<c:when test="${confList.size() != 0}">
			<table class="table table-bordered mt-4 w-50">
				<tr>
					<th>Title</th>
					<th>Place</th>
					<th>Date</th>
					<th>State</th>
				</tr>
				<c:forEach var="conf" items="${confList}">
					<tr>
						<td>
							<c:url var="lookConfURL" value="/lookConf">
								<c:param value="${conf.id}" name="id"/>
							</c:url>
							<a href='${lookConfURL}'>${conf.title}</a>
						</td>
						<td>${conf.place}</td>
						<td>${conf.date}</td>
						<td>${conf.state}</td>
						<td><input type="checkbox" name="ids" value="${conf.id}" form="operationForm"></td>
					</tr>
				</c:forEach>
			</table>
		</c:when>
		<c:otherwise>
			<p class="mt-4" style="font-size: 20px;">Sorry, there isn't any conference</p>	
		</c:otherwise>
	</c:choose>
</div>