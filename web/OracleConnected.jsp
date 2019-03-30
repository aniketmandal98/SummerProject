<%-- 
    Document   : OracleConnected
    Created on : May 29, 2018, 2:03:26 PM
    Author     : nEW u
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/css; charset=UTF-8">
        <title>Connection Established</title>
    <head>
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
    <body background="images/babk.jpg">

        <div class="topnav"> 
            <a class="active" href="success.jsp">Home</a>
            <a href="login.jsp">Logout</a>

        </div> 
        <%
            response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");
            response.setHeader("Proagma", "no-cache");
            response.setHeader("Expires", "0");
        %>
    <center><h1>Oracle has been connected</h1></center>
    <br>
    Username of the oracle server is: system
    <br>
    Password of the oracle server is: system
    <form action="NewIp" method="post">
        <center>IPADDRESS: <input type="text" name="IP"/>
            <input type="submit" value="submit"/>
        </center>
    </form>
    <br><br>
    <form action="Oracle">
        
        <center><input type="submit" value="Click to View the IPADDRESSES" /></center>

    </form>
    <br><br>

</body>
</html>
