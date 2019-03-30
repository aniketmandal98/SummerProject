package Oracle;

import Oracle.ping;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLRecoverableException;
import java.lang.NullPointerException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import iptable.JavaConnectDb;
import oracle.jdbc.OraclePreparedStatement;
import oracle.jdbc.OracleResultSet;

@WebServlet("/Oracle")
public class Oracle extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public Oracle() {
        super();
        // TODO Auto-generated constructor stub
    }

    //static String var;

    /*public static String sendPingRequest(String ipAddress)
            throws UnknownHostException, IOException {
        InetAddress geek = InetAddress.getByName(ipAddress);
        System.out.println("Sending Ping Request to " + ipAddress);
        if (geek.isReachable(5000)) //System.out.println("Host is reachable");
        {
            var = "UP";
        } else //System.out.println("Sorry ! We can't reach to this host");
        {
            var = "DOWN";
        }

        return var;
    }*/

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        Connection conn = JavaConnectDb.connectDB();
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        try {
            String sql = "select * from ipaddress";
            OraclePreparedStatement pst = (OraclePreparedStatement) conn.prepareStatement(sql);
            OracleResultSet rs = (OracleResultSet) pst.executeQuery();
            //StringBuffer str= new StringBuffer();
            //str.append("<table border=1><tr><th>ipadd</th><th>STATUS</th></tr>");

            List<String> l = new ArrayList<>();
            while (rs.next()) {
                l.add(rs.getString(1));
                //String ipadd=rs.getString(1);
                ////sendPingRequest(ipadd);
                //str.append("<tr><th>"+ipadd+"</th></th><th>"+var+"</th></tr>");
            }
            request.setAttribute("ipad", l);
            
            request.getRequestDispatcher("newjsp.jsp").forward(request, response);
            //str.append("</table>");
            //out.println(str);
            conn.close();
        } catch (Exception e) {
            System.err.println(e);
            out.println("catch exeption");
        } finally {
            out.close();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }

}
