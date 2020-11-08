package LoginFrames;

import Forgot_Password.Forgot_Password_Q;
import ManagerMainForm.ManagerMainPageForm;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.logging.*;
import javax.swing.*;

public class ManagerLogin extends JFrame{
    //Attributes
    private JPanel Pn1,Pn2,Pn3;
    private JLabel  LbUser, LbPass, LbForm;
    private JTextField Fld1;
    private JPasswordField Pfld1;
    private Box Hors1, Hors2, Hors3, Hors4;
    private Box Vert1;
    private JButton Bt1,Bt2,Bt3,Bt4,BtForgotPass;
    private JCheckBox Smiley1;
    private Icon Smiley;
    
    //Constructor
    public ManagerLogin() {
    //JFrame container
        super("Manager Login!");
        setSize(800,400);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());
       
        //Initialising JPanel
        Pn1 = new JPanel();
        Pn1.setBackground(Color.LIGHT_GRAY);
        
        Pn2 = new JPanel(new FlowLayout());
        Pn2.setBackground(Color.WHITE);
        
        Pn3 = new JPanel();
        Pn3.setBackground(Color.DARK_GRAY);
        
        //Labels
        //Labels pane 2
        LbUser = new JLabel("Username: ");
        LbUser.setForeground(Color.BLACK);
        LbUser.setFont(new Font("Arial",Font.BOLD,30));
        
        LbPass = new JLabel("Password: ");
        LbPass.setForeground(Color.BLACK);
        LbPass.setFont(new Font("Arial",Font.BOLD,30));
        
        LbForm = new JLabel("Manager Login");
        LbForm.setForeground(Color.BLACK);
        LbForm.setFont(new Font("Arial",Font.BOLD,30));
        
        //fields pane 2
        Fld1 = new JTextField(20);
        Fld1.setBackground(Color.LIGHT_GRAY);
        Fld1.setFont(new Font("Arial",Font.BOLD,25));
        
        Pfld1 = new JPasswordField(20);
        Pfld1.setBackground(Color.LIGHT_GRAY);
        Pfld1.setFont(new Font("Arial",Font.BOLD,25));
        Pfld1.setEchoChar('*');
        //Button for Showing password
        
        //Icon
        ClassLoader loader = this.getClass().getClassLoader();
        java.net.URL imageUrl = loader.getResource("Smiley.jpg");
        Smiley = new ImageIcon(imageUrl);
        
        //Button
        Smiley1 = new JCheckBox();
        Smiley1.addItemListener(new ShowPass());
        Smiley1.setIcon(Smiley);
        Smiley1.setToolTipText("Click on icon to Show and hide password");
         
        //Adding to Pane1
        //Adding to Box Layouts for Pane 2
      
        //Horisontal Box
        //HorBox4
        Hors4 = Box.createHorizontalBox();
        Hors4.add(Box.createHorizontalStrut(50));
        Hors4.add(LbForm);
        
        //HorBox1
        Hors1 = Box.createHorizontalBox();
        Hors1.add(LbUser);
        Hors1.add(Box.createHorizontalStrut(20));
        Hors1.add(Fld1);
        
        //HorBox2
        Hors2 = Box.createHorizontalBox();
        Hors2.add(LbPass);
        Hors2.add(Box.createHorizontalStrut(20));
        Hors2.add(Pfld1);
        Hors2.add(Box.createHorizontalStrut(2));
        Hors2.add(Smiley1);
        
        //Forgot Password Button
        BtForgotPass = new JButton("I Forgot my password");
        BtForgotPass.setFont(new Font("Arial",Font.BOLD,20));
        BtForgotPass.setBackground(Color.WHITE);
        BtForgotPass.setForeground(Color.BLACK);
        BtForgotPass.setToolTipText("Click here to retrieve password");
        BtForgotPass.addActionListener(new ForgetBT());
        
        
        //Vertical Box
        Vert1 = Box.createVerticalBox();
        Vert1.add(Box.createVerticalStrut(90));
        Vert1.add(Hors1);
        Vert1.add(Box.createVerticalStrut(20));
        Vert1.add(Hors2);
        Vert1.add(Box.createVerticalStrut(20));
        Vert1.add(BtForgotPass);
        Vert1.add(Box.createVerticalStrut(10));
        
        //adding to pane2;
        Pn2.add(Vert1);
        
        //Buttons
        Bt1 = new JButton("Login");
        Bt1.setFont(new Font("Arial",Font.BOLD,25));
        Bt1.setBackground(Color.GREEN);
        Bt1.setForeground(Color.BLACK);
        Bt1.setToolTipText("Click here to accept crediantials and "
                            + "continue to next form");
        Bt1.addActionListener(new LoginBt());
        
        Bt2 = new JButton("Refresh");
        Bt2.setFont(new Font("Arial",Font.BOLD,25));
        Bt2.setBackground(Color.CYAN);
        Bt2.setForeground(Color.BLACK);
        Bt2.setToolTipText("Click here to clear all the fields");
        Bt2.addActionListener(new ClearBt());
        
        Bt3 = new JButton("Exit");
        Bt3.setFont(new Font("Arial",Font.BOLD,25));
        Bt3.setBackground(Color.RED);
        Bt3.setForeground(Color.BLACK);
        Bt3.setToolTipText("Click here to exit program");
        Bt3.addActionListener(new ExitBt());
        
        Bt4 = new JButton("Previous");
        Bt4.setFont(new Font("Arial",Font.BOLD,25));
        Bt4.setBackground(Color.ORANGE);
        Bt4.setForeground(Color.BLACK);
        Bt4.setToolTipText("Click here to go back to previous page");
        Bt4.addActionListener(new BackBt());
        
   
        
        //Button Box
        Hors3 = Box.createHorizontalBox();
        Hors3.add(Bt1);
        Hors3.add(Box.createHorizontalStrut(20));
        Hors3.add(Bt2);
        Hors3.add(Box.createHorizontalStrut(20));
        Hors3.add(Bt4);
        Hors3.add(Box.createHorizontalStrut(20));
        Hors3.add(Bt3);
        
        //adding to pane3 and 1
        Pn1.add(LbForm);
        Pn3.add(Hors3);
        
        //Frame
        add(Pn1, BorderLayout.NORTH);
        add(Pn2, BorderLayout.CENTER);
        add(Pn3, BorderLayout.SOUTH);
        
        setVisible(false);
    }
    
    //Methods and event handlers
    
    //Showing password icon
    class ShowPass implements ItemListener {

        @Override
        public void itemStateChanged(ItemEvent e) {
            if(Smiley1.isSelected()) {
                Pfld1.setEchoChar((char)0);
            }
            else {
                Pfld1.setEchoChar('*');
            }
        }
    }
    
    //Login Button
    class LoginBt implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String HostName = "localhost";
            String Db = "w.m.s";
            String UserName = "root";
            String Password = "RohaN@777!";
            String URL = "jdbc:mysql://"+HostName+":3306/"+Db;
            
            //Getting from Gui
            String Fuser = Fld1.getText();
            
            char[] Fpass = Pfld1.getPassword();
            String FSpass = new String(Fpass);
            
            try {
                Connection DbCon = DriverManager.getConnection(URL,UserName,Password);
                Statement Dbstmt = DbCon.createStatement();
                String Query1 = "SELECT * FROM manager WHERE m_Username='"+Fuser+"' and m_Password='"+FSpass+"'";
                ResultSet rs = Dbstmt.executeQuery(Query1);
               
                    //Condition statement for checking username and password
                    if(rs.next()){
                        ManagerMainPageForm ManagerMain = new ManagerMainPageForm();
                        ManagerMain.setVisible(true);
                        setVisible(false);
                        dispose();
                    }
                    else {
                        UIManager.put("OptionPane.messageFont", new Font("Arial",Font.PLAIN,20));
                        UIManager.put("OptionPane.buttonFont", new Font("Arial",Font.PLAIN,20));
                        JOptionPane.showMessageDialog(null," Username and Password Incorrect! "
                                + "\nTry Again!");
                        Fld1.setText(null);
                        Pfld1.setText(null);
                    }
                
                rs.close();
                DbCon.close();
            }
            catch (SQLException ex) {
                Logger.getLogger(ManagerLogin.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    //Clear fields
    class ClearBt implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            Fld1.setText(null);
            Pfld1.setText(null);
        }
    }
    
    //Exit program
    class ExitBt implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            UIManager.put("OptionPane.messageFont", new Font("Arial",Font.PLAIN,20));
            UIManager.put("OptionPane.buttonFont", new Font("Arial",Font.PLAIN,20));
           int Op = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit the program?",""
                   + "Exit!",JOptionPane.YES_NO_OPTION);
           if(Op == JOptionPane.YES_OPTION) {
               System.exit(0);
           } 
        }
    }
    
    //Back Button
    class BackBt implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
           LoginChoise LCFrame = new LoginChoise();
           dispose();
        }
    }
    //forgot password
    class ForgetBT implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            Forgot_Password_Q forget = new Forgot_Password_Q();
            forget.setVisible(true);
        }
    }
    //end of form
}
