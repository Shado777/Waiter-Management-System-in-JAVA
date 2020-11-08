package ManagerialChoises;

import ManagerMainForm.ManagerMainPageForm;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.logging.*;
import java.util.regex.Pattern;
import javax.swing.*;

public class InsertForm extends JFrame{
    //Attributes
    private JPanel Pn1,Pn2,Pn3;
    private Box Hor1, Hor2;
    private JLabel Lb1,Lb2,Lb3,Lb4,Lb5,Lb6,Lb7,Lb8,Lb9,Lb10;
    private JComboBox CBox2;
    private JTextField Fld3,Fld4,Fld5,Fld6,Fld7,Fld8,Fld9,Fld10;
    private JButton Bt1,Bt2,Bt3;
    
    //Constructor
    public InsertForm() {
        //Initialising JFrame
        super("Insert Employee");
        setSize(900,500);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        //Panels
        
        Pn1 = new JPanel();
        Pn1.setBackground(Color.LIGHT_GRAY);
        
        Pn2 = new JPanel(new GridLayout(0,2,5,5));
        Pn2.setBackground(Color.WHITE);
        
        Pn3 = new JPanel();
        Pn3.setBackground(Color.DARK_GRAY);
        
        //Labels
        Lb1 = new JLabel("Please Fill in the fields and click continue when done");
        Lb1.setFont(new Font("Arial", Font.BOLD,20));
        Lb1.setForeground(Color.BLACK);
        
        Lb2 = new JLabel("Choose for Mangerial or Waiter credentials");
        Lb2.setFont(new Font("Arial", Font.BOLD,20));
        
        Lb3 = new JLabel("Name");
        Lb3.setFont(new Font("Arial", Font.BOLD,20));
        
        Lb4 = new JLabel("Surname");
        Lb4.setFont(new Font("Arial", Font.BOLD,20));
        
        Lb5 = new JLabel("Address");
        Lb5.setFont(new Font("Arial", Font.BOLD,20));
        
        Lb6 = new JLabel("Phone number");
        Lb6.setFont(new Font("Arial", Font.BOLD,20));
        
        Lb7 = new JLabel("Email address");
        Lb7.setFont(new Font("Arial", Font.BOLD,20));
        
        Lb8 = new JLabel("Desired Username");
        Lb8.setFont(new Font("Arial", Font.BOLD,20));
        
        Lb9 = new JLabel("Desired Password");
        Lb9.setFont(new Font("Arial", Font.BOLD,20));
        
        Lb10 = new JLabel("What was your first car?");
        Lb10.setFont(new Font("Arial", Font.BOLD,20));
        Lb10.setToolTipText("This question is for when the desired employee forgot"
                            + " their password");
        //ComboBox
        String[] EmpType = {"Waiter","Manager"};
        CBox2 = new JComboBox(EmpType);
        CBox2.setFont(new Font("Arial",Font.BOLD,20));
        
        //Fields
        Fld3 = new JTextField(20);
        Fld3.setBackground(Color.LIGHT_GRAY);
        Fld3.setFont(new Font("Arial",Font.BOLD,20));
                
        Fld4 = new JTextField(20);
        Fld4.setBackground(Color.LIGHT_GRAY);
        Fld4.setFont(new Font("Arial",Font.BOLD,20));
        
        Fld5 = new JTextField(20);
        Fld5.setBackground(Color.LIGHT_GRAY);
        Fld5.setFont(new Font("Arial",Font.BOLD,20));
        
        Fld6 = new JTextField(20);
        Fld6.setBackground(Color.LIGHT_GRAY);
        Fld6.setFont(new Font("Arial",Font.BOLD,20));
        
        Fld7 = new JTextField(20);
        Fld7.setBackground(Color.LIGHT_GRAY);
        Fld7.setFont(new Font("Arial",Font.BOLD,20));
        
        Fld8 = new JTextField(20);
        Fld8.setBackground(Color.LIGHT_GRAY);
        Fld8.setFont(new Font("Arial",Font.BOLD,20));
        
        Fld9 = new JTextField(20);
        Fld9.setBackground(Color.LIGHT_GRAY);
        Fld9.setFont(new Font("Arial",Font.BOLD,20));
       // Fld9.setToolTipText("No more than 12, and needs to include special characters");
        
        Fld10 = new JTextField(20);
        Fld10.setBackground(Color.LIGHT_GRAY);
        Fld10.setFont(new Font("Arial",Font.BOLD,20));
        
        //Buttons
        Bt1 = new JButton("Continue");
        Bt1.setFont(new Font("Arial",Font.BOLD,20));
        Bt1.setForeground(Color.BLACK);
        Bt1.setBackground(Color.GREEN);
        Bt1.addActionListener(new DoneBt());
        
        Bt2 = new JButton("Refresh");
        Bt2.setFont(new Font("Arial",Font.BOLD,20));
        Bt2.setForeground(Color.BLACK);
        Bt2.setBackground(Color.CYAN);
        Bt2.addActionListener(new RefreshBt());
        
        Bt3 = new JButton("Cancel");
        Bt3.setFont(new Font("Arial",Font.BOLD,20));
        Bt3.setForeground(Color.BLACK);
        Bt3.setBackground(Color.ORANGE);
        Bt3.addActionListener(new CancelBt());
        
        //Adding to Box layouts
        //Box 1
        Hor1 = Box.createHorizontalBox();
        Hor1.add(Box.createHorizontalStrut(10));
        Hor1.add(Lb1);
        Hor1.add(Box.createHorizontalStrut(10));
        
        //Box2
        Hor2 = Box.createHorizontalBox();
        Hor2.add(Box.createHorizontalStrut(5));
        Hor2.add(Bt1);
        Hor2.add(Box.createHorizontalStrut(100));
        Hor2.add(Bt2);
        Hor2.add(Box.createHorizontalStrut(100));
        Hor2.add(Bt3);
        Hor2.add(Box.createHorizontalStrut(5));
        
        //Adding to Panels
        
        //Pn1
        Pn1.add(Hor1);
        
        //Pn2
        Pn2.add(Lb2);
        Pn2.add(CBox2);
        Pn2.add(Lb3);
        Pn2.add(Fld3);
        Pn2.add(Lb4);
        Pn2.add(Fld4);
        Pn2.add(Lb5);
        Pn2.add(Fld5);
        Pn2.add(Lb6);
        Pn2.add(Fld6);
        Pn2.add(Lb7);
        Pn2.add(Fld7);
        Pn2.add(Lb8);
        Pn2.add(Fld8);
        Pn2.add(Lb9);
        Pn2.add(Fld9);
        Pn2.add(Lb10);
        Pn2.add(Fld10);
        
        //Pn3
        Pn3.add(Hor2);
        
        //Jframe
        add(Pn1, BorderLayout.NORTH);
        add(Pn2, BorderLayout.CENTER);
        add(Pn3, BorderLayout.SOUTH);
        setVisible(false);
    }
    //Methods and EventHandlers
    
    //Done Button
    class DoneBt implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            
            //Getting data from ComboBox
            String CBoxItem;
            CBoxItem = (String)(CBox2.getSelectedItem());
            String ManagerID = null;
            
            //Data From fields
            String nameTxt = Fld3.getText();
            String SurnameTxt = Fld4.getText();
            String AddressTxt = Fld5.getText();
            String PhoneTxt = Fld6.getText();
            String EmailTxt = Fld7.getText();
            String UsernameTxt = Fld8.getText();
            String PasswordTxt = Fld9.getText();
            String QuestionTxt = Fld10.getText();
            
            //Checking Credentials
            if(//((Pattern.matches("[a-zA-Z]+{1}", nameTxt)) == true)||
                //((Pattern.matches("[a-zA-Z]+{3}", SurnameTxt))== true)||
                ((Pattern.matches("[0-9]+{1,3}+\\s[a-zA-Z]+\\s[a-zA-Z]+", AddressTxt))==false)||
                ((Pattern.matches("[0-9]+{10}", PhoneTxt)) == false)||
                ((Pattern.matches("^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$", EmailTxt))  == false)||
                ((Pattern.matches("[a-zA-Z]+[0-9]+{4,10}", UsernameTxt)) == false)||    
                ((Pattern.matches("[a-zA-Z]+[@#$%]+[0-9]+{6,20}", PasswordTxt))  == false)) { 
                
                UIManager.put("OptionPane.messageFont", new Font("Arial",Font.PLAIN,20));
                UIManager.put("OptionPane.buttonFont", new Font("Arial",Font.PLAIN,20));
                JOptionPane.showMessageDialog(null, "Credentials Incorect!",""
                  + "ERROR!",JOptionPane.ERROR_MESSAGE);
                  Fld3.setText(null);
                  Fld4.setText(null);
                  Fld5.setText(null); 
                  Fld6.setText(null);
                  Fld7.setText(null); 
                  Fld8.setText(null); 
                  Fld9.setText(null); 
                  Fld10.setText(null); 
            }
            
            else {
                //Database Connection
                String Hostname = "Localhost";
                String Username = "root";
                String Password = "RohaN@777!";
                String Db = "w.m.s";
                String URL = "jdbc:mysql://"+Hostname+":3306/"+Db;
            
                UIManager.put("OptionPane.messageFont", new Font("Arial",Font.PLAIN,20));
                UIManager.put("OptionPane.buttonFont", new Font("Arial",Font.PLAIN,20));
                try {
                
                    Connection DbCon = DriverManager.getConnection(URL,Username,Password);
                
                    Statement DbStMg = DbCon.createStatement();
                    String QueryMng = "SELECT m_Username FROM manager";
                    ResultSet rs = DbStMg.executeQuery(QueryMng);
                
                    while(rs.next()) {
                    String m_Name = rs.getString("m_Username");
                    ManagerID = m_Name;
                    }
                
                    //If statement between Waiter and manager
                    //Waiter
                    if(CBoxItem == "Waiter") {
                   
                        Statement DbStat1 = DbCon.createStatement();
                        String Query1 = "SELECT w_Username FROM waiter WHERE w_Username='"+UsernameTxt+"'";
                        ResultSet rs1 = DbStat1.executeQuery(Query1);
                    
                        //Checking for multiple entries
                        if(rs1.next()) {
                            JOptionPane.showMessageDialog(null, "Can not have multiple entries to the system!",""
                                + "ERROR!",JOptionPane.ERROR_MESSAGE);
                        
                            Fld3.setText(null);
                            Fld4.setText(null);
                            Fld5.setText(null);
                            Fld6.setText(null);
                            Fld7.setText(null);
                            Fld8.setText(null);
                            Fld9.setText(null);
                            Fld10.setText(null);
                            rs1.close();
                        }
                    
                        else {
                            //Adding to database
                            Statement DbStat2 = DbCon.createStatement();
                            String Query2 = "Insert Into waiter (w_Username, w_Name, w_Surname, w_Address, w_Phone,"
                                + " w_Email, w_Wage, w_Password, w_ForgotQ, m_Username) "
                                + "values('"+UsernameTxt+"','"+nameTxt+"','"+SurnameTxt+"','"+AddressTxt+"','"+
                                PhoneTxt+"','"+EmailTxt+"','700','"+PasswordTxt+"','"+
                                QuestionTxt+"','"+ManagerID+"')";
                            DbStat2.executeUpdate(Query2);
                    
                            JOptionPane.showMessageDialog(null, "Employee added to the system!",""
                                + "Added!",JOptionPane.PLAIN_MESSAGE);
                    
                            //Condition to exit form
                            int Option = JOptionPane.showConfirmDialog(null,"Do you want to add another employee?",""
                                +"Confirm!",JOptionPane.YES_NO_OPTION);
                                if(Option != JOptionPane.YES_OPTION) {
                                    ManagerMainPageForm main1 = new ManagerMainPageForm();
                                    main1.setVisible(true);
                                    dispose();
                                }
                                else {
                            
                                    Fld3.setText(null);
                                    Fld4.setText(null);
                                    Fld5.setText(null);
                                    Fld6.setText(null);
                                    Fld7.setText(null);
                                    Fld8.setText(null);
                                    Fld9.setText(null);
                                    Fld10.setText(null);
                                }
                        }
                    }
                
                    //Manager
                    else {
                        
                            Statement DbStat3 = DbCon.createStatement();
                            String Query3 = "SELECT m_Username FROM manager WHERE m_Username='"+UsernameTxt+"'";
                            ResultSet rs3 = DbStat3.executeQuery(Query3);
                    
                            //Checking for multiple entries
                            if(rs3.next()) {
                                JOptionPane.showMessageDialog(null, "Can not have multiple entries to the system!",""
                                + "ERROR!",JOptionPane.ERROR_MESSAGE);
                        
                                Fld3.setText(null);
                                Fld4.setText(null);
                                Fld5.setText(null);
                                Fld6.setText(null);
                                Fld7.setText(null);
                                Fld8.setText(null);
                                Fld9.setText(null);
                                Fld10.setText(null);
                                rs3.close();
                            }
                    
                            else {
                                //Adding to database
                                Statement DbStat4 = DbCon.createStatement();
                                String Query4 = "Insert Into manager (m_Username,m_Name, m_Surname, m_Address, m_Phone,"
                                    + " m_Email, m_Password, m_ForgotQ) "
                                    + "values('"+UsernameTxt+"','"+nameTxt+"','"+SurnameTxt+"','"+AddressTxt+"','"+
                                    PhoneTxt+"','"+EmailTxt+"','"+PasswordTxt+"','"+
                                    QuestionTxt+"')";
                                DbStat4.executeUpdate(Query4);
                                JOptionPane.showMessageDialog(null, "Employee added to the system!",""
                                    + "Added!",JOptionPane.PLAIN_MESSAGE);
                   
                            //Condition to exit form
                            int Option = JOptionPane.showConfirmDialog(null,"Do you want to add another employee?",""
                                +"Confirm!",JOptionPane.YES_NO_OPTION);
                                if(Option != JOptionPane.YES_OPTION) {
                                    ManagerMainPageForm main1 = new ManagerMainPageForm();
                                    main1.setVisible(true);
                                    dispose();
                                }
                                else {
                            
                                    Fld3.setText(null);
                                    Fld4.setText(null);
                                    Fld5.setText(null);
                                    Fld6.setText(null);
                                    Fld7.setText(null);
                                    Fld8.setText(null);
                                    Fld9.setText(null);
                                    Fld10.setText(null);
                                }
                            }
                        
                    }
                
                DbCon.close();
            }
            
                catch (SQLException ex) {
                    Logger.getLogger(InsertForm.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    //Refresh Button
    class RefreshBt implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            Fld3.setText(null);
            Fld4.setText(null);
            Fld5.setText(null);
            Fld6.setText(null);
            Fld7.setText(null);
            Fld8.setText(null);
            Fld9.setText(null);
            Fld10.setText(null);
        }
    }
    //Cancel button
    class CancelBt implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            UIManager.put("OptionPane.messageFont", new Font("Arial",Font.PLAIN,20));
            UIManager.put("OptionPane.buttonFont", new Font("Arial",Font.PLAIN,20));
            int Op1 = JOptionPane.showConfirmDialog(null, "Are you sure you want to return to main menu?",""
                    + "Exit!",JOptionPane.YES_NO_OPTION);
            if(Op1 == JOptionPane.YES_OPTION) {
             ManagerMainPageForm main1 = new ManagerMainPageForm();
             main1.setVisible(true);
             dispose();
            }
        }
    }
    //end of form
}
