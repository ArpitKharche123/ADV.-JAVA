<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
<!-- Declaration Tag
It is used to declare the variables or methods of a java.
 -->
	<%!
	int radius=10;
	double area(int radius){
		return Math.PI*radius*radius;
	}
	
	int add(int a,int b){
		return a+b;
	}
	%>
	
<!-- Expression Tag
	This tag is used to print/display results on web browser.
 -->	
 <h1>
 	Radius= <%= radius %> <br>
	Area= <%=area(radius) %>
 </h1>
 
 <!-- Scriptlet tag   
 	This tag is used to write java logic for dynamic response.
	Anything inside this tag will be returned within the service() method!.
  -->
  
  <%
  int sum=add(12, 13);
  %>
  <h1>Sum is: <%=sum %></h1>
	
	
	<!-- include directive 
	It is used to include the contents of one JSP file into another
	-->
	<h1>
	<%@include file="Register.jsp" %>
	</h1>
</body>
</html>