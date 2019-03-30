/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Oracle;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
 
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
public class newfunction extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
 
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
 
        String nsss = request.getParameter("txttUser");
        String psss = request.getParameter("txttPass");
 
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection(
                    "jdbc:oracle:thin:@localhost:1521:xe", "system", "system");
 
            PreparedStatement ps = con
                    .prepareStatement("insert into login values(?,?)");
 
            ps.setString(1, nsss);
            ps.setString(2, psss);
 
            int i = ps.executeUpdate();
            if (i > 0)
                out.print("You are successfully registered...");
                response.sendRedirect("login.jsp");
 
        } catch (Exception e2) {
            System.out.println(e2);
        }
 
        out.close();
    }
 
}
