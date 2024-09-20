<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Email Verification</title>
<style>
    body {
        font-family: Arial, sans-serif;
        display: flex;
        justify-content: center;
        align-items: center;
        height: 100vh;
        margin: 0;
        background-color: #f2f2f2;
    }
    .container {
        background-color: #fff;
        padding: 20px;
        border-radius: 8px;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        text-align: center;
        width: 80%;
        max-width: 500px;
    }
    h1 {
        color: #333;
    }
    p {
        color: #666;
        margin: 20px 0;
    }
    input[type="text"], input[type="submit"] {
        width: 100%;
        padding: 10px;
        margin: 10px 0;
        box-sizing: border-box;
        border-radius: 4px;
    }
    input[type="text"] {
        border: 1px solid #ccc;
        background-color: #f9f9f9;
    }
    input[type="submit"] {
        background-color: #4CAF50;
        color: white;
        border: none;
        cursor: pointer;
    }
    input[type="submit"]:hover {
        background-color: #45a049;
    }
</style>
</head>
<body>
<div class="container">
    <h1>Verification</h1>
    <form action="verifyEmail" method="post">
        <input type="text" name="email" placeholder="Enter your email address" required />
        <input type="submit" value="Verify" />
    </form>
     <p style="color:red;">
        <%= request.getAttribute("verifyMessage") != null ? request.getAttribute("verifyMessage") : "" %>
       </p>
</div>
</body>
</html>
