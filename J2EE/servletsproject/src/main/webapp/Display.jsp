<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- Fetching username in Scriptlet tag -->
  <%
	String name=request.getParameter("user_name");
%>
<h1>
	User name: <%=name %><br>
	<!-- Fetching username in Expression tag -->
	Email: <%=request.getParameter("user_email") %>
</h1>
 
</body>
</html>