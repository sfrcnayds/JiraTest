<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body onload="document.f.j_username.focus()">
	<form name="f" action="${pageContext.request.contextPath}/login" method='POST'>
		<table>
			<tr>
				<td>Email:</td>
				<td><input type="text" name='userEmail' id="userEmail" value=''></td>
			</tr>
			<tr>
				<td>Password:</td>
				<td><input type="password" name='userPassword' id="userPassword"/></td>
			</tr>
			<tr>
				<td colspan="2"><input name="submit" type="submit"
					value='Login' /></td>
			</tr>
		</table>
	</form>

</body>
</html>