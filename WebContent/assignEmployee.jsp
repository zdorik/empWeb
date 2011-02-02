<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Назначение проекта сотруднику</title>
</head>
<body>
	<c:import url="menu.jsp"></c:import>
	<form action="assignEmpUpdate" method="post">
	<table>
		<tr>
			<td>Проект</td>
			<td>${project.name}</td>
		</tr>
		<tr>
			<td>Сотрудник</td>
			<td>
				<select name="employee">
					<option value="-1">-Выберите сотрудника-</option>
					<c:forEach items="${employees}" var="employee">
					<option value="${employee.id}">
						${employee.name}
					</option>
					</c:forEach>					
				</select>
			</td>
		</tr>		
		<tr>
			<td colspan="2"><input type="submit" value="Сохранить изменения" /></td>
		</tr>
	</table>
	</form>
</body>
</html>