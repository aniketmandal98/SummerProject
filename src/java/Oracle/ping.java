package Oracle;

import SendEmail.EmailSend;
import java.awt.Color;
import java.awt.Graphics;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class ping {

    static String var;
    
    static String emailId = "aniketmandal98@gmail.com";
    
    public static String sendPingRequest(String ipAddress)
            throws UnknownHostException, IOException {
        
        //StringBuilder htmlBuilder = new StringBuilder();
        InetAddress geek = InetAddress.getByName(ipAddress);
        System.out.println("Sending Ping Request to " + ipAddress);
        
        if (geek.isReachable(5000)) //System.out.println("Host is reachable");
        {
            var = "UP";
           
        } else //System.out.println("Sorry ! We can't reach to this host");
        {
            var = "DOWN";
            EmailSend.email(ipAddress, emailId);

        }

        return var;
    }

}
