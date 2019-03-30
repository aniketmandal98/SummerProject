<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>

<html:html>
    <html:base />
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">

        <title>
            Portal
        </title>
        <script language="javascript"  src='<html:rewrite page="/JavaScript/validate.js" />' ></script>
        <style type="text/css">
            /* Add a black background color to the top navigation */
            .topnav {
                background-color: #333;
                overflow: hidden;
            }

            /* Style the links inside the navigation bar */
            .topnav a {
                float: left;
                color: #f2f2f2;
                text-align: center;
                padding: 14px 16px;
                text-decoration: none;
                font-size: 17px;
            }

            /* Change the color of links on hover */
            .topnav a:hover {
                background-color: #ddd;
                color: black;
            }

            /* Add a color to the active/current link */
            .topnav a.active {
                background-color: #4CAF50;
                color: white;
            }
        </style>
        <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js">
        </script>
        <style>
            .content{
                display:none;
            }
            .preload {
                margin:0;
                position:absolute;
                top:50%;
                left: 50%;
                margun-right: -50%;
                transform:translate(-50%,-50%);
            }
        </style>
        <style>
            .btn-login
            {
                padding: 15px 25px;
                color: #fff;
                background-color: #2ECC70;
                border: none;
                border-radius: 4px;
                border-bottom: 4px solid #27AE60;
            }
            a{
                text-decoration: none;
                color: white;
                font-family: sans-serif;

            }
            a:hover
            {
                color: coral;
                font-weight: bold;

            }
        </style>
    </head>
    <body background="images/back.jpg">
        <div class="topnav"> 
            <a class="active" href="success.jsp">Home</a>
            <a href="login.jsp">Login</a>
            <a href="register.jsp">Signup</a>

        </div> 
        <br>
        <br>
        <br>
        <br>
        <br>
        <br>
        <br>
        <font color="black" size="7"><b><center>
                Portal Login Page

            </center></b></font></br>

    <center><img src="images/dvc.jpg" style="width:100px;height:100px;"></center>

    <br><br>
    <p align="right">
    <center><form action="login.jsp"><input type="submit" value="Click here to Login" class="btn-login"></input></form></center><br>
    </p>

    </body>
</html:html>
