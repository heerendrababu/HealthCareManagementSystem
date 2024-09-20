<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Page</title>
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
    .login-container, .admin-container {
        background-color: #fff;
        padding: 20px;
        border-radius: 8px;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        text-align: center;
    }
    table {
        margin: 0 auto;
    }
    td {
        padding: 10px;
    }
    input[type="email"], input[type="password"], input[type="submit"] {
        width: 100%;
        padding: 8px;
        margin: 5px 0;
        box-sizing: border-box;
        border: 1px solid #ccc;
        border-radius: 4px;
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
    h2 {
        text-align: center;
        color: #333;
    }
</style>
</head>
<body>
   <div>
       <%
           // Check if the admin is logged in by retrieving the session attribute
           Boolean isLoggedIn = (Boolean)request.getAttribute("isLoggedIn"); // Type mismatch: cannot convert from Object to Boolean
           if (isLoggedIn != null && isLoggedIn) {
       %>
           <!-- Content to show after successful login -->
           <div class="admin-container">
               <h2>Welcome Admin</h2>
               <form action="adminpage" method="post">
                   <input type="submit" name="getdoctorslist" value="Show Doctor List" />
                   <input type="submit" name="Ddetails" value="Add Doctors Details" />
               </form>
           </div>
       <%
           } else {
       %>
           <!-- Show the login form if not logged in -->
           <div class="login-container">
               <form action="adminlogin" method="post">
                   <h2>Admin Login</h2>
                   <table>
                       <tr>
                           <td>Email:</td>
                           <td><input type="email" name="tbEmail" required /></td>
                       </tr>
                       <tr>
                           <td>Password:</td>
                           <td><input type="password" name="tbPass" required /></td>
                       </tr>
                       <tr>
                           <td colspan="2" style="text-align: center;">
                               <input type="submit" name="tbSubmit" value="Login" />
                           </td>
                       </tr>
                   </table>
               </form>
               <p style="color:red;">
                   <%= request.getAttribute("ErrorMessage") != null ? request.getAttribute("ErrorMessage") : "" %>
               </p>
           </div>
       <%
           }
       %>
   </div>
</body>
</html>
