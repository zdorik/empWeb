<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Добавление нового работника</title>
</head>
<body>
	<c:import url="menu.jsp"></c:import>
	<form action="addEmployee" method="post">
	<table>
		<tr>
			<td>Имя</td>
			<td><input name="name" type="text" /></td>
		</tr>
		<tr>
			<td>Зарплата</td>
			<td><input name="salary" type="text" /></td>
		</tr>
		<tr>
			<td>Департамент</td>
			<td>
				<select name="department">
					<option value="-1">-Выберите департамент-</option>
					<c:forEach items="${departments}" var="department">
						<option value="${department.id}">${department.name}</option>
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