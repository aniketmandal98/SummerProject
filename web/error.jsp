<%-- 
    Document   : error
    Created on : May 29, 2018, 12:19:47 PM
    Author     : nEW u
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ERROR</title>
    </head>
    <body background="images/ksks.png">
        <%
            response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");
            response.setHeader("Pragma", "no-cache");
            response.setHeader("Expires", "0");
        %>
    <center><h1>Sorry! the username or password is incorrect.</h1></center>
    <center><img src="images/dino.JPG" style="width:90px;height:90px;" /></center>
    <br> <br> <form action="login.jsp">
        <center> <a href="login.jsp">Redirect to login page</a> </center>

    </form>
</body>
</html>
