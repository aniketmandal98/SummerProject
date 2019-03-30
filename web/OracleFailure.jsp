<%-- 
    Document   : OracleFailure
    Created on : Jun 5, 2018, 12:15:53 PM
    Author     : nEW u
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <body>
        <%
            response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");
            response.setHeader("Pragma", "no-cache");
            response.setHeader("Expires", "0");
        %>
        <h4>Error! The Username and(or) Password you have entered is invalid. </h4>
        <br>
        <br>
        <form action="OracleIDPASS.jsp">
            <input type="submit" value="Retry" align="left">            
        </form>
        <br>
        <br>
        <form action="login.jsp">
            <input type="submit" value="LogOut" align="right">
        </form>
    </body>
</html>
