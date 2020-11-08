/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WaiterMainForm;

import LoginFrames.LoginChoise;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class NewWaiterMenu extends JFrame{
    
    private JPanel Pn1,Pn2,Pn3;
    private JLabel LbMenu,LbDate,LbTotalTips,LbUsername, lb1,lb2,lb3,lb4,lb5,lb6;
    private JTextField fld1, fld2, fld3;
    private JButton BtNewCus, BtLogOut;
    private String txt1 = "";
            
    public NewWaiterMenu(String name) {
        super("Waiter Main Menu");
        setSize(600,400);
        setLocationRelativeTo(null);
        this.setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        //Panels
        Pn1 = new JPanel();
        Pn1.setBackground(Color.LIGHT_GRAY);
        
        Pn2 = new JPanel(new GridLayout(0,2,5,5));
        Pn2.setBackground(Color.WHITE);
        
        Pn3 = new JPanel();
        Pn3.setBackground(Color.DARK_GRAY);
        
        //Labels
        lb1 = new JLabel();
        lb2 = new JLabel();
        lb3 = new JLabel();
        lb4 = new JLabel();
        lb5 = new JLabel();
        lb6 = new JLabel();
        
        LbMenu = new JLabel("Waiter Main Menu");
        LbMenu.setFont(new Font("Arial", Font.BOLD,20));
        LbMenu.setForeground(Color.BLACK);
        
        LbDate = new JLabel("Date: ");
        LbDate.setFont(new Font("Arial", Font.BOLD,20));
        LbDate.setForeground(Color.BLACK);
        
        LbTotalTips = new JLabel("Total Daily Tips: ");
        LbTotalTips.setFont(new Font("Arial", Font.BOLD,20));
        LbTotalTips.setForeground(Color.BLACK);
        
        LbUsername = new JLabel("Username: ");
        LbUsername.setFont(new Font("Arial", Font.BOLD,20));
        LbUsername.setForeground(Color.BLACK);
        
        //TextFields
        //Getting system data and time
	LocalDate now1 = LocalDate.now();
        java.sql.Date sqlDate = java.sql.Date.valueOf(now1);
        String date1 = sqlDate.toString();
        
        //Jtextfield 1
        fld1 = new JTextField(date1); //Adding time to fld1
        fld1.setFont(new Font("Arial",Font.BOLD,20));
        fld1.setBackground(Color.LIGHT_GRAY);
        fld1.setEditable(false);
        fld1.setToolTipText("Current date and time"); 
        
        //Jtextfield 3
        fld3 = new JTextField(name);
        fld3.setFont(new Font("Arial",Font.BOLD,20));
        fld3.setBackground(Color.LIGHT_GRAY);
        fld3.setEditable(false);
        
        //Jtextfield 2
        double numTip = 0.00;
        String nameDb = fld3.getText();
        //Getting values from database
        double numtipDb = 0.00;
        
        //Database connection
        String Hostname = "Localhost";
        String Username = "root";
        String Password = "RohaN@777!";
        String Db = "w.m.s";
        String URL = "jdbc:mysql://"+Hostname+":3306/"+Db;
        
        try {
            Connection DbCon = DriverManager.getConnection(URL,Username,Password);
//            Statement DbStat1 = DbCon.createStatement();
//            String Query1 = "SELECT w_Username FROM tipsofcustomers WHERE w_Username='"+nameDb+"'";
//            ResultSet rs1 = DbStat1.executeQuery(Query1);
            
            Statement DbStat2 = DbCon.createStatement(); 
            
//            CallableStatement DbStat1 = DbCon.prepareCall("{? = New_TotTips(?,?)}"); 
//            DbStat1.registerOutParameter(1,Types.DOUBLE);
//            String dbCallSt1 = nameDb;
//            String dbCallSt2 = sqlDate.toString();
//            
//            DbStat1.setString(dbCallSt1,dbCallSt2);
//            DbStat1.execute();
//            
//            numtipDb = DbStat1.getDouble(1);
//            numTip = numTip + numtipDb; 

            String Query2 = "SELECT SUM(tips) FROM tipsofcustomers WHERE date='"+sqlDate+"' and w_Username='"+nameDb+"'";
            ResultSet rs2 = DbStat2.executeQuery(Query2);
            
            while(rs2.next()) {
                
                numtipDb = rs2.getDouble(1);
            }
            numTip = numTip + numtipDb;
            rs2.close();
           
        }
        catch (SQLException ex) {
            Logger.getLogger(NewWaiterMenu.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //Setting values
        fld2 = new JTextField("R "+numTip);
        fld2.setFont(new Font("Arial",Font.BOLD,20));
        fld2.setBackground(Color.LIGHT_GRAY);
        fld2.setEditable(false);
        fld2.setToolTipText("Total tips for the night"); 
        
        //Button
        BtNewCus = new JButton("New Customer");
        BtNewCus.setFont(new Font("Arial",Font.BOLD,20));
        BtNewCus.setForeground(Color.BLACK);
        BtNewCus.setBackground(Color.GREEN);
        BtNewCus.setToolTipText("Click here to return to the previous page");
        BtNewCus.addActionListener(new NewCusBT());
        
        BtLogOut = new JButton("Log Out");
        BtLogOut.setFont(new Font("Arial",Font.BOLD,20));
        BtLogOut.setForeground(Color.BLACK);
        BtLogOut.setBackground(Color.ORANGE);
        BtLogOut.setToolTipText("Click here to return to the previous page");
        BtLogOut.addActionListener(new LogoutBt()); 
        //adding to panels
        
        //Panel1
        Pn1.add(LbMenu);
        
        //Panel2
        Pn2.add(lb1);
        Pn2.add(lb2);
        Pn2.add(LbDate);
        Pn2.add(fld1);
        Pn2.add(LbTotalTips);
        Pn2.add(fld2);
        Pn2.add(LbUsername);
        Pn2.add(fld3);
        Pn2.add(lb3);
        Pn2.add(lb4);
        
        //Panel3
        Pn3.add(BtNewCus);
        Pn3.add(BtLogOut);
        
        //Adding to JFrame
        add(Pn1, BorderLayout.NORTH);
        add(Pn2, BorderLayout.CENTER);
        add(Pn3, BorderLayout.SOUTH);
        setVisible(false);
    }
    class NewCusBT implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
             txt1 = fld3.getText();
             CaptureTips tip1 = new CaptureTips(txt1);
             tip1.setVisible(true);
             dispose();
        }
    }
    
    class LogoutBt implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
           UIManager.put("OptionPane.messageFont", new Font("Arial",Font.PLAIN,20));
            UIManager.put("OptionPane.buttonFont", new Font("Arial",Font.PLAIN,20));
            int Op1 = JOptionPane.showConfirmDialog(null, "Are you sure you want to logout?",""
                    + "Exit!",JOptionPane.YES_NO_OPTION);
            if(Op1 == JOptionPane.YES_OPTION) {
                LoginChoise LCFrame = new LoginChoise();
                LCFrame.setVisible(true);
                dispose();
            }
        }
    }
}