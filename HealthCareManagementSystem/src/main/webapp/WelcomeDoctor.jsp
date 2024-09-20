<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Doctor Page</title>
<style>
    body {
        font-family: Arial, sans-serif;
        display: flex;
        justify-content: center;
        align-items: center;
        height: 100vh;
        margin: 0;
        background-color: lightgray;
    }
    .container {
        background-color: white;
        padding: 20px;
        border-radius: 8px;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        text-align: center;
    }
    h2 {
        color: black;
    }
    input[type="button"] {
        width: 200px;
        padding: 10px;
        margin: 10px;
        border: none;
        border-radius: 4px;
        cursor: pointer;
        font-size: 16px;
    }
    input[type="button"].get-details {
        background-color: dodgerblue;
        color: white;
    }
    input[type="button"].get-details:hover {
        background-color: darkblue;
    }
    input[type="button"].send-reports {
        background-color: red;
        color: white;
    }
    input[type="button"].send-reports:hover {
        background-color: darkred;
    }
</style>
</head>
<body>
<div class="container">
    <h2>Welcome Doctor</h2>
    <form action="getPatientDetails" method="post">
        <input type="button" name="getDetails" value="Get Patient Details"/>
        <input type="button" name="sendReports" value="Send Reports To Patient"/>
    </form>
</div>
</body>
</html>

<!-- name Attribute: Typically used to identify form controls when submitting form data. 
It's useful for server-side processing but does not affect styling directly.
class Attribute: Used to apply CSS styles to elements and can be used for JavaScript manipulation. 
It is not directly related to form submission. -->
