<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register Page</title>
</head>
<body>
	<form:form method="post" action="createUser">
		<table>
			<tr>
				<td>Name :</td>
				<td><form:input path="name" /><form:errors path="name"></form:errors></td>
			</tr>
			<tr>
				<td>Surname :</td>
				<td><form:input path="surname" /><form:errors path="surname"></form:errors></td>
			</tr>
			<tr>
				<td>Mail :</td>
				<td><form:input path="mail" /><form:errors path="mail"></form:errors></td>
			</tr>
			<tr>
				<td>Password :</td>
				<td><form:password path="password"/><form:errors path="password"></form:errors></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Save" /></td>
			</tr>
		</table>
	</form:form>
</body>
</html>