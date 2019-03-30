
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
 
public class NewIp extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
 
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
 
        String n = request.getParameter("IP");
 
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection(
                    "jdbc:oracle:thin:@localhost:1521:xe", "system", "system");
 
            PreparedStatement ps = con
                    .prepareStatement("insert into ipaddress values(?)");
 
            ps.setString(1, n);
 
            int i = ps.executeUpdate();
            if (i > 0)
                out.print("IPAdress added successfully.");
 
        } catch (Exception e2) {
            System.out.println(e2);
        }
 
        out.close();
    }
 
}