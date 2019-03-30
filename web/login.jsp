<%-- 
    Document   : login
    Created on : Jun 1, 2018, 1:03:12 PM
    Author     : nEW u
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
    <head>
        <title>Login Page</title>
        <meta charset="UTF-6">
        <link rel="stylesheet" type="text/css" href="css/style.css"/>
        <link rel="stylesheet" type="text/css" href="css/font-awesome.css"/>
    </head>
    <body background="images/dvc2.jpg">
        <%
            response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");
            response.setHeader("Pragma", "no-cache");
            response.setHeader("Expires", "0");
        %>
    <center><h1><b>Welcome to login page</b></h1></center>
    <div class="container">
        <form action="LoginAction" method="post">
            <div class="form-input">
                <center>
                    <img src="images/dvc.jpg"/> </center>
                <center> <input type="text" name="Username" value="" placeholder="Enter Username"> </center>

            </div>
            <div class="form-input">
                <center>    <input type="password" name="Password" value="" placeholder="Enter password"> </center>

            </div>
            <input type="submit" name="submit" value="login" class="btn-login">
            <br><br>
        </form>
        <a href="forgetpass.jsp">Forget Password </a><br>
        <br>
        <a href="register.jsp">Register</a><br>
        <br>
    </div>
</body>



</html>