package Oracle;

import java.sql.Connection;
import java.sql.DriverManager;

public class JavaConnectDb 
{
    public static Connection connectDB() {
		Connection conn= null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1522/xe","system","aniket");
			System.out.println(conn);
                        System.out.println("Conn established");
		}
		catch(Exception e)
                {
			System.err.println(e);
                        System.out.println("Conn failed");
		}
		return conn;
	}
    
}
