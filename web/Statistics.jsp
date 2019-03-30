<%-- 
    Document   : Statistics
    Created on : Jun 14, 2018, 12:39:44 AM
    Author     : nEW u
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>DISK STATISTICS</title>
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
        <style>
            .btn-login
            {
                padding: 15px 25px;
                color: #fff;
                background-color: #2ECC71;
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
    <body>
        <div class="topnav"> 
            <a class="active" href="success.jsp">Home</a>
            <a href="login.jsp">Logout</a>
            

        </div> 
    <CENTER>  <h1>DISK STATISTICS</h1> </CENTER>
    <center>
        <form action="Statistics">
            <input type="submit" value="192.168.43.100" class="btn-login">
        </form>
        <br>
        <form action="Statistics2">
            <input type="submit" value="192.168.43.102" class="btn-login">
        </form>
        <br>
        <form action="statistics">
            <input type="submit" value="192.168.43.104" class="btn-login">
        </form>
       
    </center>
</body>
</html>
