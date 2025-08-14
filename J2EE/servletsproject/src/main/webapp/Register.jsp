<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
   <form action="Display.jsp">
        <label for="user_name">User Name:</label><br>
        <input type="text" id="user_name" name="user_name" required><br><br>

        <label for="user_email">Email:</label><br>
        <input type="email" id="user_email" name="user_email" required><br><br>

        <input type="submit">
     </form>
</body>
</html>