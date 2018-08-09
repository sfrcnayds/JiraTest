<%@page
	import="javax.security.auth.message.callback.PrivateKeyCallback.Request"%>
<%@page import="com.mysql.cj.Session"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page import="com.enoca.web.dao.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form:form method="post" action="createJira">
		<table>
			<tr>
				<td>Reporter :</td>
				<td><input name="name" id="name"
					value="<%=((User) session.getAttribute("loggedUser")).getName()%>"
					readonly /></td>
			</tr>
			<tr>
				<td>Assign :</td>
				<td><select name="selectedUser">
						<c:forEach var="user" items="${users}">
							<option value="${user.getId()}">${user.getName()}</option>
						</c:forEach>
				</select></td>
			</tr>
			<tr>
				<td>Task Tipi :</td>
				<td><select name="selectedType">
						<option value="DEV">DEV</option>
						<option value="DEVOPS">DEVOPS</option>
				</select></td>
			</tr>
			<tr>
				<td>Create Date :</td>
				<td><input type="text" name="createDate" id="createDate"
					value="<%=(new java.util.Date()).toLocaleString()%>" readonly></td>
			</tr>
			<tr>
				<td>Start Date :</td>
				<td><input type="date" name="startDate" id="startDate"></td>
			</tr>
			<tr>
				<td>End Date :</td>
				<td><input type="date" name="endDate" id="endDate"></td>
			</tr>
			<tr>
				<td>Status :</td>
				<td><select name="selectedStatus">
						<option value="OPEN">OPEN</option>
						<option value="IN">In Procces</option>
						<option value="resolved">Resolved</option>
				</select></td>
			</tr>
		</table>
	</form:form>
</body>
</html>