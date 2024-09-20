<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Doctor Registration Form</title>
<!-- Font Awesome CDN -->
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
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
    .registration-container {
        background-color: white;
        padding: 20px;
        border-radius: 8px;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        width: 100%;
        max-width: 600px;
    }
    table {
        width: 100%;
        margin: 0 auto;
        border-collapse: collapse;
    }
    td {
        padding: 10px;
        text-align: left;
    }
    input[type="text"], input[type="email"], input[type="password"], select {
        width: 100%;
        padding: 8px;
        margin: 5px 0;
        box-sizing: border-box;
        border: 1px solid lightgray;
        border-radius: 4px;
    }
    input[type="submit"] {
        width: 100%;
        background-color: green;
        color: white;
        padding: 10px;
        border: none;
        border-radius: 4px;
        cursor: pointer;
    }
    input[type="submit"]:hover {
        background-color: darkgreen;
    }
    h2 {
        text-align: center;
        color: darkgray;
    }
    .password-container {
        position: relative;
    }
    .eye-icon {
        position: absolute;
        right: 10px;
        top: 50%;
        transform: translateY(-50%);
        cursor: pointer;
        font-size: 18px;
    }
</style>
<script>
    function togglePasswordVisibility(id) {
        var input = document.getElementById(id);
        var eyeIcon = document.getElementById('eye-icon-' + id);
        if (input.type === 'password') {
            input.type = 'text';
            eyeIcon.classList.remove('fa-eye');
            eyeIcon.classList.add('fa-eye-slash');
        } else {
            input.type = 'password';
            eyeIcon.classList.remove('fa-eye-slash');
            eyeIcon.classList.add('fa-eye');
        }
    }

    function validateForm() {
        var password = document.getElementById('password').value;
        var confirmPassword = document.getElementById('confirmPassword').value;
        if (password !== confirmPassword) {
            alert('Passwords do not match!');
            return false;
        }
        return true;
    }
</script>
</head>
<body>
<div class="registration-container">
       <form action="insertdoctor" method="post" onsubmit="return validateForm()">
           <h2>Enter Your Details</h2>
           <table>
               <tr>
                   <td>Name:</td>
                   <td><input type="text" name="docName" /></td>
               </tr>
               <tr>
                   <td>Email:</td>
                   <td><input type="email" name="docEmail" required /></td>
               </tr>
                <tr>
        <td>Mobile Number:</td>
        <td><input type="text" name="mobile" pattern="\d{10}" maxlength="10" title="Please enter a valid 10-digit mobile number" required /></td>
        </tr> <!-- pattern="\d{10}" 'used for particularly requires only integers'-->
        <!--  below code for multiple conditions -->
        <!-- pattern="(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[@$!%*?&])[A-Za-z\d@$!%*?&]{8,}"-->
               <tr>
                   <td>Set Password:</td>
                   <td class="password-container">
                       <input type="password" id="password" name="password" required maxlength="10" />
                       <span class="eye-icon" onclick="togglePasswordVisibility('password')">
                           <i id="eye-icon-password" class="fas fa-eye"></i>
                       </span>
                   </td>
               </tr>
               <tr>
                   <td>Confirm Password:</td>
                   <td class="password-container">
                       <input type="password" id="confirmPassword" name="confirmPassword" required maxlength="10" />
                       <span class="eye-icon" onclick="togglePasswordVisibility('confirmPassword')">
                           <i id="eye-icon-confirmPassword" class="fas fa-eye"></i>
                       </span>
                   </td>
               </tr>
               <tr>
                   <td>Gender:</td>
                   <td>
                       <input type="radio" name="gender" value="Male" /> Male
                       <input type="radio" name="gender" value="Female" /> Female
                       <input type="radio" name="gender" value="Other" /> Other
                   </td>
               </tr>
               <tr>
                   <td>Profession:</td>
                   <td>
                       <select name="profession" required>
                           <option value="">Select Profession</option>
                           <option value="Cardiologist">Cardiologist</option>
                           <option value="Dentist">Dentist</option>
                           <option value="Neurologist">Neurologist</option>
                           <option value="Psychiatrist">Psychiatrist</option>
                           <option value="Dermatologist">Dermatologist</option>
                           <option value="Oncologist">Oncologist</option>
                           <option value="General_Physician">General Physician</option>
                           <option value="Obstetrics and Gynaecology">Obstetrics and Gynaecology</option>
                       </select>
                   </td>
               </tr>
               <tr>
                   <td colspan="2" style="text-align: center;">
                       <input type="submit" value="Register" />
                   </td>
               </tr>
           </table>
       </form>
        
    <!-- Show the registration message -->
    <p style="color:red;">
        <%= request.getAttribute("verifyMessage") != null ? request.getAttribute("verifyMessage") : "" %>
    </p>

    <!-- Conditionally display the 'Back to Login' button -->
    <% 
        Boolean showBackToLogin = (Boolean) request.getAttribute("showBackToLogin");
        if (showBackToLogin != null && showBackToLogin) {
    %>
    <form action="Doctor.jsp" method="get" style="text-align: center;">
        <input type="submit" value="Back to Login Page" />
    </form>
    <% } %>
   </div>
</body>
</html>
