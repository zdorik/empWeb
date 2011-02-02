<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Список проектов</title>
</head>
<body>
	<c:import url="menu.jsp"></c:import>
	<h4>Проекты пользователя ${employee.name}</h4>
	<c:if test="${not empty projects}">
	<table>
		<thead>
			<tr>
				<th>Название</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${projects}" var="project">
			<tr>
				<td><c:out value="${project.name}"/></td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	</c:if>
	<c:if test="${empty projects}">Данный пользователь не участвует ни в одном проекте</c:if>
</body>
</html>