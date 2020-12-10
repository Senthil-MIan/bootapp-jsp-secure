<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Profile Saved Successfully</h1>
<hr/>
<h2>Saved Details...</h2>
<%-- SpEL --%>
<%-- getter method --%>
<h3>NAME : ${employee.name}</h3>
<h3>EMAIL : ${employee.email}</h3>
<h3>CONTACT: ${employee.contact}</h3>
<h3>DOB: ${employee.dob}</h3>
<h3>FREE PASSES: ${employee.freePasses}</h3>
<h3>COUNTRY: ${employee.country}</h3>
<h3>EMPLOYEE CODE : ${employee.employeeCode}</h3>
<h3>FAVORITE LANGUAGE :</h3>
<ul>
	<core:forEach var="language" items="${employee.favoriteLanguages}">
		<li>${language}</li>
	</core:forEach>
</ul>
</body>
</html>

