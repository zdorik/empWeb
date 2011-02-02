<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Парковочные места</title>
</head>
<body>
	<c:import url="menu.jsp"></c:import>
	<table border="1" cellspacing="2" cellpadding="2">
		<thead>
		<tr>
			<th>Местоположение</th>
			<th>Номер места</th>
			<th>Сотрудник</th>
		</tr>
		</thead>	
		<tbody>
		<c:forEach items="${parkingSpaces}" var="parkingSpace">
		<tr>
			<td><c:out value="${parkingSpace.location}"/></td>
			<td><c:out value="${parkingSpace.lot}"/></td>
			<td>
			<c:if test="${not empty parkingSpace.employee}"><c:out value="${parkingSpace.employee.name}"/></c:if>
			<c:if test="${empty parkingSpace.employee}">-свободно-</c:if>
			<a href="fixEmpEdit?parkingSpaceId=${parkingSpace.id}">изменить</a>
			</td>				
		</tr>
		</c:forEach>
		</tbody>
	</table>
</body>
</html>