<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Список проектов</title>
</head>
<body>
	<c:import url="menu.jsp"></c:import>
	<table border="1" cellspacing="2" cellpadding="2">
		<thead>
		<tr>
			<th>Название проекта</th>
			<th>Список исполнителей</th>
		</tr>
		</thead>
		<tbody>
		<c:forEach items="${projects}" var="project">
		<tr>
			<td style="color:blue;"><c:out value="${project.name}"/></td>
			<td>
			<c:forEach items="${project.employees}" var="employee">
				<c:out value="${employee.name}"/><br/>	
			</c:forEach>
			<c:if test="${empty project.employees}">-нет исполнителей-</c:if>
			</td>
			<td><a href="assignEmpEdit?projectId=${project.id}">добавить исполнителя</a></td>				
		</tr>
		</c:forEach>
		</tbody>
	</table>
</body>
</html>