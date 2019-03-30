package Oracle;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;
import com.jcraft.jsch.UIKeyboardInteractive;
import com.jcraft.jsch.UserInfo;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Properties;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

public class statistics extends HttpServlet {

    static String Dstat = new String();

    public static String DS(HttpServletRequest request, HttpServletResponse response) {
        try {
            JSch jsch = new JSch();

            String host = null;

            /*host=JOptionPane.showInputDialog("Enter username@hostname",
                                         System.getProperty("user.name")+
                                         "@localhost");*/
            String[] a = {"root@192.168.43.104", "root@192.168.43.102"};
            //String a1="root@192.168.43.100";

            /*String user=host.substring(0, host.indexOf('@'));
      host=host.substring(host.indexOf('@')+1);

      Session session=jsch.getSession(user, host, 22);*/
            System.out.println("red hat");
            String user = a[0].substring(0, a[0].indexOf('@'));
            a[0] = a[0].substring(a[0].indexOf('@') + 1);
            Session session = jsch.getSession(user, a[0], 22);

            // username and password will be given via UserInfo interface.
            UserInfo ui = new MyUserInfo();
            //String passwd="root";
            session.setUserInfo(ui);
            Properties config = new Properties();
            config.put("StrictHostKeyChecking", "no");
            session.setConfig(config);
            session.setPassword("root");

            session.connect();

            /*String command=JOptionPane.showInputDialog("Enter command", 
                                                 "set|grep SSH");*/
            String command = "df -h";

            Channel channel = session.openChannel("exec");
            ((ChannelExec) channel).setCommand(command);

            channel.setInputStream(null);

            ((ChannelExec) channel).setErrStream(System.err);

            InputStream in = channel.getInputStream();

            channel.connect();

            byte[] tmp = new byte[1024];

            //int k=0;
            while (true) {
                while (in.available() > 0) {
                    int i = in.read(tmp, 0, 1024);
                    if (i < 0) {
                        break;
                    }

                    Dstat = new String(tmp, 0, i);
                    HttpSession sc = request.getSession();
                    sc.setAttribute("dstat", Dstat);
                    //request.getRequestDispatcher("Statistics.jsp").forward(request,response);
                    // response.getWriter().println(Dstat);
                    System.out.print(Dstat);
                    System.out.println();
                    System.out.println();
                    System.out.println();
                    String[] token = Dstat.split("\n");

                    response.getWriter().println("<html>"
                            + "<title>DISK STATISTICS</title><font color=\"blue\">"
                            + "<center><head>DISK STATISTICS</head><style>\n"
                            + "            .btn-login\n"
                            + "            {\n"
                            + "                padding: 15px 25px;\n"
                            + "                color: #fff;\n"
                            + "                background-color: #2ECC71;\n"
                            + "                border: none;\n"
                            + "                border-radius: 4px;\n"
                            + "                border-bottom: 4px solid #27AE60;\n"
                            + "            }\n"
                            + "            a{\n"
                            + "                text-decoration: none;\n"
                            + "                color: white;\n"
                            + "                font-family: sans-serif;\n"
                            + "\n"
                            + "            }\n"
                            + "            a:hover\n"
                            + "            {\n"
                            + "                color: coral;\n"
                            + "                font-weight: bold;\n"
                            + "\n"
                            + "            }\n"
                            + "        </style></center>"
                            + "<body background=\"images\\dark.jpg\">"
                            +"<center><h2>DISK STATS OF IP: 192.168.43.104</h2></center>"
                            + "<center>"
                            + "<table border=15 cellpadding=20% bgcolor=\"white\">");
                    for (int j = 0; j < token.length; j++) {
                        System.out.println(token[j]);
                        String[] tkn = token[j].split(" ");
                        // System.out.println(tkn.length);
                        response.getWriter().println("<tr>");
                        // response.getWriter().println("<td>"+ token[j] +" </td>  ");

                        for (int k = 0; k < tkn.length; k++) {
                            if (!(tkn[k].equals(" ") || tkn[k].equals(""))) {
                                response.getWriter().println("<td>" + tkn[k] + "</td>");
                            }
                        }
                        response.getWriter().println("</tr>");

                    }
                    response.getWriter().println("</table>"
                            + "<br>"
                            + "<form action=\"Statistics.jsp\">"
                            + "<input type=\"submit\" value=\"back\" class=\"btn-login\">"
                            + "</form>"
                            + "<br><br><br><br><br><br><br><br><br><br><br><br><br><br></center>"
                            + "</body>"
                            + "</html>");

                }
                System.out.println("HEYAAA!!");
                //System.out.println(k);
                //Session session1= request.getSession("Disk", Dstat);

                if (channel.isClosed()) {
                    if (in.available() > 0) {
                        continue;
                    }
                    System.out.println("exit-status: " + channel.getExitStatus());
                    break;
                }
                try {
                    Thread.sleep(1000);
                } catch (Exception ee) {
                }
            }
            channel.disconnect();
            session.disconnect();
            //}
        } catch (Exception e) {
            System.out.println(e);
        }
        return Dstat;
    }

    public static class MyUserInfo implements UserInfo, UIKeyboardInteractive {

        public String getPassword() {
            return passwd;
        }

        public boolean promptYesNo(String str) {
            Object[] options = {"yes", "no"};
            int foo = JOptionPane.showOptionDialog(null,
                    str,
                    "Warning",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.WARNING_MESSAGE,
                    null, options, options[0]);
            return foo == 0;
        }

        String passwd = "root";
        //JTextField passwordField=(JTextField)new JPasswordField(20);

        /* public String getPassphrase(){ return null; }
    public boolean promptPassphrase(String message){ return true; }
    public boolean promptPassword(String message){
      Object[] ob={passwordField}; 
      int result=
        JOptionPane.showConfirmDialog(null, ob, message,
                                      JOptionPane.OK_CANCEL_OPTION);
      if(result==JOptionPane.OK_OPTION){
        passwd=passwordField.getText();
        return true;
      }
      else{ 
        return false; 
      }
    }
    public void showMessage(String message){
      JOptionPane.showMessageDialog(null, message);
    }
    final GridBagConstraints gbc = 
      new GridBagConstraints(0,0,1,1,1,1,
                             GridBagConstraints.NORTHWEST,
                             GridBagConstraints.NONE,
                             new Insets(0,0,0,0),0,0);
    private Container panel;
    public String[] promptKeyboardInteractive(String destination,
                                              String name,
                                              String instruction,
                                              String[] prompt,
                                              boolean[] echo){
      panel = new JPanel();
      panel.setLayout(new GridBagLayout());

      gbc.weightx = 1.0;
      gbc.gridwidth = GridBagConstraints.REMAINDER;
      gbc.gridx = 0;
      panel.add(new JLabel(instruction), gbc);
      gbc.gridy++;

      gbc.gridwidth = GridBagConstraints.RELATIVE;

      JTextField[] texts=new JTextField[prompt.length];
      for(int i=0; i<prompt.length; i++){
        gbc.fill = GridBagConstraints.NONE;
        gbc.gridx = 0;
        gbc.weightx = 1;
        panel.add(new JLabel(prompt[i]),gbc);

        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weighty = 1;
        if(echo[i]){
          texts[i]=new JTextField(20);
        }
        else{
          texts[i]=new JPasswordField(20);
        }
        panel.add(texts[i], gbc);
        gbc.gridy++;
      }

      if(JOptionPane.showConfirmDialog(null, panel, 
                                       destination+": "+name,
                                       JOptionPane.OK_CANCEL_OPTION,
                                       JOptionPane.QUESTION_MESSAGE)
         ==JOptionPane.OK_OPTION){
        String[] response=new String[prompt.length];
        for(int i=0; i<prompt.length; i++){
          response[i]=texts[i].getText();
        }
	return response;
      }
      else{
        return null;  // cancel
      }
    }

        @Override
        public boolean promptYesNo(String string) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }*/
        @Override
        public String getPassphrase() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public boolean promptPassword(String string) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public boolean promptPassphrase(String string) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void showMessage(String string) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public String[] promptKeyboardInteractive(String string, String string1, String string2, String[] strings, boolean[] blns) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        statistics.DS(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
