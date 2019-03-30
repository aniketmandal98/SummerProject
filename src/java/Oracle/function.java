package Oracle;

import java.sql.*;
import Oracle.JavaConnectDb;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class function extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
                PrintWriter out= response.getWriter();
                Connection conn= JavaConnectDb.connectDB();
		response.setContentType("text/html");
		
		String unn=request.getParameter("txtUser");
		String pww=request.getParameter("txtPass");
		
		// Connect to mysql and verify username password
		
		try {
		PreparedStatement ps = conn.prepareStatement("select * from admin where adminusername=? and adminpassword=?");
		ps.setString(1, unn);
		ps.setString(2, pww);
 
		ResultSet rs = ps.executeQuery();
 
		while (rs.next()) {
			response.sendRedirect("newuser.jsp");
			return;
		}
		response.sendRedirect("errorerror.jsp");
		return;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
                        out.println("exception");
		}
	}
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    {
        System.out.println("OUTPUT");
    }


}
