<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri= "http://www.springframework.org/tags/form" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>Login here...</h2>
<hr/>
<core:if test="${param.error != null}">
	<i>Invalid Credentials!</i>
</core:if>
<br/>
<spring:form action="${pageContext.request.contextPath}/validate" method="POST">
	<div>
		<div><label>Enter login id</label></div>
		<div><input type="text" name="username"/></div>
	</div>
	<br/>
	<div>
		<div><label>Enter password</label></div>
		<div><input type="password" name="password"/></div>
	</div>
	<br/>
	<div>
		<input type="submit" value="Login"> 
	</div>
</spring:form>
<br/>
<core:if test="${param.logout != null}">
	<i>You have been logged out successfully!</i>
</core:if>
</body>
</html>