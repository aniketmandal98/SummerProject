<%-- 
    Document   : mail
    Created on : Jun 12, 2018, 11:38:57 PM
    Author     : nEW u
--%>

<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Inform the users about the status </h1>
        <%@page import="SendEmail.EmailSend"%>
        <%
                        List<String> l = (List<String>) 
                                request.getAttribute("ipad");
                         
                        for (String s : l) {

                    %>
                    <tr>
                        <td><%=   s%></td><td><%=    EmailSend.email(s)%></td>
                    </tr>
                    <%
                        }
                    %>
    </body>
</html>
