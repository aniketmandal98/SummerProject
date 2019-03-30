<%-- 
    Document   : OracleIDPASS
    Created on : May 29, 2018, 2:55:28 PM
    Author     : nEW u
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-6">
        <link rel="stylesheet" type="text/css" href="css/style.css"/>
        <link rel="stylesheet" type="text/css" href="css/font-awesome.css"/>
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
    </head>
    <body background="images/lateback.jpg">
        <div class="topnav"> 
            <a class="active" href="success.jsp">Home</a>
            <a href="login.jsp">Logout</a>

        </div>
        <%
            response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");
            response.setHeader("Pragma", "no-cache");
            response.setHeader("Expires", "0");
        %>
    <center><h1><font color="white"> Connect to the Oracle</h1></center>
    <div class="container">
        <form action="OracleCon" method="post">
            <div class="form-input">
                <center>
                    <img src="images/dvc.jpg"/> 
                </center>
                <center>
                    <input type="text" name="txtuser" value="" placeholder="Enter Username"> 
                </center>

            </div>
            <div class="form-input">
                <center>
                    <input type="password" name="txtpass" value="" placeholder="Enter password">
                </center>
            </div>
            <center>
                <input type="submit" name="submit" value="Connect" class="btn-login">
            </center>
            <br><br>
        </form>
    </div>
</body>
</html>
