<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<style>
table, th, td {
    border: 1px solid black;
    border-collapse: collapse;
}
th, td {
    padding: 5px;
    text-align: left;    
}
.btn {
 display: inline-block;
 margin-top: 50px;
 background: #333;
 color: #fff;
 text-align: center;
 padding: 10px;
 text-decoration: none;
}
.btn:hover {
opacity: .7;
}
</style> 

<title>Marks</title>

</head>
<body>

	<h2>${consoleMessage}</h2>
	
		<p>Welcome ${name}, please see below student's grades:</p>

	<table>
		<tr>
			<th>Name</th>
			<th>Grade</th>
			<th>Subject</th>
		</tr>

		<c:forEach var="item" items="${listUserGradeObjects}">	
		<tr>
		<td>${item.getName()}</td>
		<td>${item.getGrade().getGrade()}</td>
		<td>${item.getSubject()}</td>
		</tr>	
		
	</c:forEach>
	
	</table>
	
	

<c:if test="${sessionScope.isAdmin == 1}">
<a href = "AddGradePanel" class = "btn">Add Grade</a>
<a  href = "updateGradePanel" class = "btn">Update Grade</a>
<a  href = "deleteGradePanel" class = "btn">Delete Grade</a>
</c:if>	
<a href="index.jsp" class="btn">Home</a>
	<a href= "logout" class = "btn">Logout</a>

<c:if test="${sessionScope.action == 'update'}">

	
	
<form id ="updateGrade" action="updateGrade" method ="post">
<p>Update Student's Grade</p>
<!--Select Student-->
<label for="Student">Student: </label>
<select name = "Student">
	<c:forEach var="item" items="${listUsers}">
 		<option>${item.getName()}</option>
	</c:forEach>
</select>

<!--Select Subject-->
<label for="Subject">Subject: </label>
<select name = "Subject">
	<c:forEach var="item" items="${listSubjects}">
 		<option name = "subject">${item}</option>
	</c:forEach>
</select>

<!--Select Grade-->
<label for="Grade">Grade: </label>
<select name = "grade">
 	<option value="2">2</option>
 	<option value="3">3</option>
  	<option value="4">4</option>
   	<option value="5">5</option>
    <option value="6">6</option>
</select>

<label for="Grade">New Grade: </label>
<select name = "newGrade">
 	<option value="2">2</option>
 	<option value="3">3</option>
  	<option value="4">4</option>
   	<option value="5">5</option>
    <option value="6">6</option>
</select>
<input type="submit" value= "update">
</form>
</c:if>	
	
	
	
	
	
<c:if test="${sessionScope.action == 'add'}">

<form id="addGrade" action="addGrade" method="post">
<p>Insert Student's Grade</p>
<!--Select Student-->
<label for="Student">Student: </label>
<select name = "Student">
	<c:forEach var="item" items="${listUsers}">
 		<option>${item.getName()}</option>
	</c:forEach>
</select>

<!--Select Subject-->
<label for="Subject">Subject: </label>
<select name = "Subject">
	<c:forEach var="item" items="${listSubjects}">
 		<option name = "subject">${item}</option>
	</c:forEach>
</select>

<!--Select Grade-->
<label for="Grade">Grade: </label>
<select name = "grade">
 	<option value="2">2</option>
 	<option value="3">3</option>
  	<option value="4">4</option>
   	<option value="5">5</option>
    <option value="6">6</option>
</select>

<input type="submit" value= "Add Grade">
</form>
</c:if>


<c:if test="${sessionScope.action == 'delete'}">
<form id="deleteGrade" action="deleteGrade" method="post">
<p>Delete Student's Grade</p>
<!--Select Student-->
<label for="Student">Student: </label>
<select name = "Student">
	<c:forEach var="item" items="${listUsers}">
 		<option>${item.getName()}</option>
	</c:forEach>
</select>

<!--Select Subject-->
<label for="Subject">Subject: </label>
<select name = "Subject">
	<c:forEach var="item" items="${listSubjects}">
 		<option name = "subject">${item}</option>
	</c:forEach>
</select>

<!--Select Grade-->
<label for="Grade">Grade: </label>
<select name = "grade">
 	<option value="2">2</option>
 	<option value="3">3</option>
  	<option value="4">4</option>
   	<option value="5">5</option>
    <option value="6">6</option>
</select>

<input type="submit" value= "Delete Grade">
</form>

</c:if>


</body>
</html>