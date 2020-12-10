<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri= "http://www.springframework.org/tags/form" prefix="spring"%> 
<%@taglib uri="http://www.springframework.org/security/tags" prefix="security" %>     
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%-- when user logs in, its details are maintained in object principal --%>
<h1>Hello <security:authentication property="principal.username"/> ( <security:authentication property="principal.authorities"/> ) </h1>
<hr/>
<%-- Logout option has to spring-form --%>
<spring:form action="${pageContext.request.contextPath}/logout" method="POST">
	<input type="submit" value="Logout" />
</spring:form>
<security:authorize access="hasRole('STUDENT')">
	<hr/>
	<a href="${pageContext.request.contextPath}/student/home">Student Dashboard</a>
</security:authorize>

<security:authorize access="hasRole('EMPLOYEE')">
<hr/>
<a href="${pageContext.request.contextPath}/employee/home">Employee Dashboard</a>
</security:authorize>
</body>
</html>








