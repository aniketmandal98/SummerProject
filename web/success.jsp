<%-- 
    Document   : success
    Created on : May 29, 2018, 12:18:54 PM
    Author     : nEW u
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Portal</title>
    </head>
    <body background="images/babk.jpg">
        <%
            response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");
            response.setHeader("Pragma", "no-cache");
            response.setHeader("Expires", "0");
        %>
    <center><h1><font color="black">WELCOME! You have logged in to the portal</h1></center>
    <br>
    <br>
    <br>
    <center>
        <form action="OracleIDPASS.jsp" method="post">
            <input type="submit" value="Click to Connect to Oracle">
        </form>
    </center>
</body>
</html>
