<%@page import="UnderstandingJsp.Student"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
		
	<%
	//Fetching Student objects from request and session objects
	
	Student student=(Student)request.getAttribute("student");
	//lives for one HTTP request
	
	//or
	
	Student student2=(Student)session.getAttribute("student");
	//lives across multiple requests from the same client
	
	%>
	
	<h1>
	Student Info:<br>
	Id: <%=student2.id %> <br>
	Name: <%=student2.name %><br>
	Email: <%=student2.email %><br>
	</h1>
</body>
</html>