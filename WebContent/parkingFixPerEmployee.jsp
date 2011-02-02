<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Закрепление парковочного места за сотрудником</title>
</head>
<body>
	<c:import url="menu.jsp"></c:import>
	<form action="fixEmpUpdate" method="post">
	<table>
		<tr>
			<td>Местоположение</td>
			<td>${parkingspace.location}</td>
		</tr>
		<tr>
			<td>Номер места</td>
			<td>${parkingspace.lot}</td>
		</tr>
		<tr>
			<td>Сотрудник</td>
			<td>
				<select name="employee">
					<option value="-1">-освободить место-</option>
					<c:forEach items="${employees}" var="employee">
					<option value="${employee.id}" 
							<c:if test="${employee.id == parkingspace.employee.id}">selected</c:if>>
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