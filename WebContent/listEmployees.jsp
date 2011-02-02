<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Список работников</title>
</head>
<body>
	<c:import url="menu.jsp"></c:import>
	<a href="addEmployee">Новый</a>
	<table>
		<thead>
			<tr>
				<th>Имя</th>
				<th>Зарплата</th>
				<th>Департамент</th>
				<th></th>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${employees}" var="employee">
			<tr>
				<td><a href="projectsByEmp?empId=${employee.id}"><c:out value="${employee.name}"/></a></td>
				<td><c:out value="${employee.salary}"/></td>
				<td><c:out value="${employee.department.name}"/></td>
				<td>
					<a href="deleteEmployee?empId=${employee.id}">Удалить</a>
					<a href="editEmployee?empId=${employee.id}">Редактировать</a>
				</td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
</body>
</html>