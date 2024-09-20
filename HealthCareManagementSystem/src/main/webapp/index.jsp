<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>HealthCareManagementSystem</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>

<style>
.dropdown-menu a.dropdown-item {
    color: #000;
}

.dropdown-menu a.dropdown-item:hover {
    background-color: #ccc; /* Gray hover effect */
    color: #000;
}
</style>
</head>
<body style="background-color:#f5f5f5; text-decoration: none; text-align: center;">

<br/><br/><br/><br/><br/>
<span class="display-1"><span style="color:grey;">RE</span><span style="color:red;">ME</span><span style="color:grey;">DY</span></span><h1> HOSPITAL</h1>
<br/><br/><br/>

<div class="container">
    <div class="row justify-content-center">
        <div class="col-md-6">
            <div class="dropdown">
                <button class="btn btn-primary dropdown-toggle" type="button" id="loginDropdown" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    Login
                </button>
                <div class="dropdown-menu" aria-labelledby="loginDropdown">
                    <a class="dropdown-item" href="Admin.jsp">Admin Login</a>
                    <a class="dropdown-item" href="Doctor.jsp">Doctor Login</a>
                    <a class="dropdown-item" href="Patient.jsp">Patient Login</a>
                </div>
            </div>
        </div>
    </div>
</div>

</body>
</html>
