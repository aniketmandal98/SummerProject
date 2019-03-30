package Oracle;

import java.sql.*;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginAction extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
                Connection conn= JavaConnectDb.connectDB();
		response.setContentType("text/html");
		
		String un=request.getParameter("Username");
		String pw=request.getParameter("Password");
		
		//Connect to mysql and verify username password
		
		try {
		PreparedStatement ps = conn.prepareStatement("select username,password from login where Username=? and Password=?");
		ps.setString(1, un);
		ps.setString(2, pw);
 
		ResultSet rs = ps.executeQuery();
 
		while (rs.next()) {
			response.sendRedirect("OracleConnected.jsp");
			return;
		}
		response.sendRedirect("error.jsp");
		return;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    {
        System.out.println("OUTPUT");
    }


}
