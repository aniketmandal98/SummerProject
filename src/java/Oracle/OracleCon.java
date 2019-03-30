package Oracle;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class OracleCon extends HttpServlet
    {
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
      
        String ab=request.getParameter("txtuser");
        String bc=request.getParameter("txtpass");
        try
        {
            if(ab.equals("system") && bc.equals("system"))
            {
                response.sendRedirect("OracleConnected.jsp");
            }
            else
            {
                response.sendRedirect("OracleFailure.jsp");
            }
        }
        catch(IOException e)
        {
            System.out.println(e);
        }
    }

}
