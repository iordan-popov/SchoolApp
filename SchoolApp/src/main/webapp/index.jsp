<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<%@ page session="false" %>
<html>
<body>
	<h2>School Grades - Login to see your Grades</h2>

<p>Login Panel</p>
<tr>
	<form id="loginForm" modelAttribute="login" action="loginProcess"
		method="post">
		<label for="username">username</label> 
		<input type="text" name="username" /><br> <label for="password">password</label> <input
			type="password" name="password" /><br> <input type="submit"
			name="submit">
	</form>
</tr>
	<table>
		<tr>
			<td style="font-style: italic; color: red;">${message}</td>
			<!-- This is JSTL expression, if it is shown, it means it is not evaluated or 
			the dependencies are not there -->
		</tr>
		
		<tr>
		<td><a href="registerCon">Register</a></td>
		
		</tr>
		
		<tr>
	
			<br>
			<br>
			
			

		</tr>
	</table>


</body>
</html>
