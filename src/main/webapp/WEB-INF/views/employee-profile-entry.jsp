<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%--Add reference to tag library --%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="spring" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
	.error{
		color: red;
	}
</style>
</head>
<body>
<h2>Profile Management</h2>
<hr/>
<%--
	Map the model object with spring form
	field level mapping : path 
	When a form loads
		call the getter method of class fields
	When form is submitted:
		call the setter methods	
 --%>

<spring:form action="${pageContext.request.contextPath}/employee/profile-save" method="post" modelAttribute="employee">
	<div>
		<div><spring:label path="name">Enter name</spring:label></div>
		<div>
			<spring:input path="name" type="text" />
			<spring:errors path="name" cssClass="error"/>
		</div>
	</div>
	<br/>
	<div>
		<div><spring:label path="email">Enter email</spring:label></div>
		<div><spring:input path="email" type="text" /></div>
	</div>
	<br/>
		<div>
			<div><spring:label path="contact">Enter contact</spring:label></div>
			<div><spring:input path="contact" type="text" /></div>
		</div>
	<br/>
		<div>
			<div><spring:label path="dob">Enter DOB</spring:label></div>
			<div><spring:input path="dob" type="date" /></div>
		</div>
	<br/>
	<div>
			<div><spring:label path="freePasses">Enter Free Passes</spring:label></div>
			<div>
				<spring:input path="freePasses" type="number" />
				<spring:errors path="freePasses" cssClass="error"/>
			</div>
		</div>
	<br/>
	<div><spring:label path="employeeCode">Enter Employee Code</spring:label></div>
			<div>
				<spring:input path="employeeCode" type="text" />
				<%--
					errors tag auto looks for attribute : message
				 --%>
				<spring:errors path="employeeCode" cssClass="error"/>
			</div>
	
	<br/>
	<div>
			<div><spring:label path="country">Enter country</spring:label></div>
			<div>
				<spring:select path="country">
				<spring:options items="${employee.countries}"/>
				<%--
					<spring:option value="FR" label="France"/>
					<spring:option value="IN" label="India"/>
					<spring:option value="GR" label="Germany"/>
					<spring:option value="US" label="USA"/>
				 --%>	
				</spring:select>
			</div>
		</div>
	<br/>
	<div>
		<div><spring:label path="favoriteLanguages">Select Favorite Language</spring:label></div>
		<div>
			<spring:checkbox path="favoriteLanguages" value="Python"/> Python
			<br/>
			<spring:checkbox path="favoriteLanguages" value="Java"/> Java
			<br/>
			<spring:checkbox path="favoriteLanguages" value="C#"/> C#
			<br/>
			<spring:checkbox path="favoriteLanguages" value="Javascript"/> Javascript
			<br/>
		</div>
	</div>
	<br/>
	<div>
		<input type="submit" value="Save" />
	</div>
</spring:form>
</body>
</html>