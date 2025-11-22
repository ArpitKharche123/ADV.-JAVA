<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student Registration</title>
<style>
    body { font-family: Arial, sans-serif; }
    .container { width: 400px; margin: 50px auto; padding: 20px; border: 1px solid #ccc; border-radius: 5px; }
    label { display: block; margin-top: 10px; font-weight: bold; }
    input[type="text"], input[type="email"], input[type="number"] { width: 100%; padding: 8px; margin-top: 5px; box-sizing: border-box; }
    .gender-group label { display: inline-block; font-weight: normal; margin-right: 15px; }
    .gender-group input { margin-right: 5px; }
    button { padding: 10px 15px; background-color: #007bff; color: white; border: none; border-radius: 4px; cursor: pointer; margin-top: 20px; }
</style>
</head>
<body>
<div class="container">
    <h1>Student Registration</h1>
    
    <form action="register" method="post">
        
        <label for="name">Student Name:</label>
        <input type="text" id="name" name="name" required>

        <label for="email">Email:</label>
        <input type="email" id="email" name="email" required>
        
        <label for="age">Age:</label>
        <input type="number" id="age" name="age" min="1" max="100" required>
        
        <label>Gender:</label>
        <div class="gender-group">
            <label>
                <input type="radio" name="gender" value="Male" required> Male
            </label>
            <label>
                <input type="radio" name="gender" value="Female"> Female
            </label>
        </div>
        
        <button type="submit">Register Student</button>
        
    </form>
</div>
</body>
</html>