/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WaiterMainForm;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;


public class CaptureTips extends JFrame{
    
    private JPanel Pn1,Pn2;
    private JLabel LbDate,LbTotalTips,LbUsername,LbTableNum, lb1,lb2,lb3,lb4,lb5,lb6;
    private JTextField fld1, fld2, fld3, fld4;
    private JButton BtSubmit,BtCancel;
    private java.sql.Date sqlDate;
    //NewWaiterMenu main1 = new NewWaiterMenu();
    
    public CaptureTips(String name) {
        super("Capture Tips of customer");
        setSize(600,400);
        setLocationRelativeTo(null);
        this.setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        //Panels
        Pn2 = new JPanel();
        Pn2.setBackground(Color.DARK_GRAY);
        
        Pn1 = new JPanel(new GridLayout(0,2,5,5));
        Pn1.setBackground(Color.WHITE);
        
        //Labels
        lb1 = new JLabel();
        lb2 = new JLabel();
        lb3 = new JLabel();
        lb4 = new JLabel();
        lb5 = new JLabel();
        lb6 = new JLabel();

        LbDate = new JLabel("Date: ");
        LbDate.setFont(new Font("Arial", Font.BOLD,20));
        LbDate.setForeground(Color.BLACK);
        
        LbTotalTips = new JLabel("Tips: ");
        LbTotalTips.setFont(new Font("Arial", Font.BOLD,20));
        LbTotalTips.setForeground(Color.BLACK);
        
        LbUsername = new JLabel("Username: ");
        LbUsername.setFont(new Font("Arial", Font.BOLD,20));
        LbUsername.setForeground(Color.BLACK);
        
        LbTableNum = new JLabel("Table Number: ");
        LbTableNum.setFont(new Font("Arial", Font.BOLD,20));
        LbTableNum.setForeground(Color.BLACK);
        
        //TextFields
        //fld1
        fld1 = new JTextField();
        fld1.setFont(new Font("Arial",Font.BOLD,20));
        fld1.setBackground(Color.LIGHT_GRAY);
        
        //fld2
        fld2 = new JTextField(name);
        fld2.setFont(new Font("Arial",Font.BOLD,20));
        fld2.setBackground(Color.LIGHT_GRAY);
        fld2.setEditable(false);
        
        //Getting system data and time for fld3
        LocalDate now1 = LocalDate.now();
        sqlDate = java.sql.Date.valueOf(now1);
        String date1 = sqlDate.toString();
        
        fld3 = new JTextField(date1);
        fld3.setFont(new Font("Arial",Font.BOLD,20));
        fld3.setBackground(Color.LIGHT_GRAY);
        fld3.setEditable(false);
        
        //fld4
        fld4 = new JTextField();
        fld4.setFont(new Font("Arial",Font.BOLD,20));
        fld4.setBackground(Color.LIGHT_GRAY);
        
        //Button
        BtSubmit = new JButton("Submit");
        BtSubmit.setFont(new Font("Arial",Font.BOLD,20));
        BtSubmit.setForeground(Color.BLACK);
        BtSubmit.setBackground(Color.GREEN);
        BtSubmit.setToolTipText("Click here to send to the system");
        BtSubmit.addActionListener(new SubmitBt()); 
        
        //cancel
        BtCancel = new JButton("Cancel");
        BtCancel.setFont(new Font("Arial",Font.BOLD,20));
        BtCancel.setForeground(Color.BLACK);
        BtCancel.setBackground(Color.ORANGE);
        BtCancel.setToolTipText("Click here to return to the previous page");
        BtCancel.addActionListener(new CancelBt());

        //Adding to Panels
        
        //Panel1
        Pn1.add(lb1);
        Pn1.add(lb2);
        Pn1.add(LbTableNum);
        Pn1.add(fld1);
        Pn1.add(LbUsername);
        Pn1.add(fld2);
        Pn1.add(LbDate);
        Pn1.add(fld3);
        Pn1.add(LbTotalTips);
        Pn1.add(fld4);
        Pn1.add(lb3);
        Pn1.add(lb4);
        
        //Panel2
        Pn2.add(BtSubmit);
        Pn2.add(BtCancel);
        
        //adding to JFrame
        add(Pn1, BorderLayout.CENTER);
        add(Pn2, BorderLayout.SOUTH);
        setVisible(false); 
    }
    //Event handlers
    class CancelBt implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String UserName = fld2.getText();
            UIManager.put("OptionPane.messageFont", new Font("Arial",Font.PLAIN,20));
            UIManager.put("OptionPane.buttonFont", new Font("Arial",Font.PLAIN,20));
            int Option = JOptionPane.showConfirmDialog(null,"Are you sure you want to cancel?",""
                        +"Confirm!",JOptionPane.YES_NO_OPTION);
                if(Option == JOptionPane.YES_OPTION) {
                    dispose();
                    NewWaiterMenu waiterMenuFrame = new NewWaiterMenu(UserName);
                    waiterMenuFrame.setVisible(true);
                }
        }
    }
    
    class SubmitBt implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            //Getting values for inserting customer tips
            String TblNum1 = fld1.getText();
            String UserName = fld2.getText();
            String Tips1 = fld4.getText();
            int TblString = Integer.parseInt(TblNum1);
            double tips2 = Double.parseDouble(Tips1);
            double tipsDataBase = 0;
            double tipsToAdd = 0;
            double incomeDb = 0;
            double incomeToAdd = 0;
            double monthlyDb = 0;
            double monthlyTipDbToAdd = 0;
            
//            if((TblString < 25)||(TblString == 0)) {
//            
//                UIManager.put("OptionPane.messageFont", new Font("Arial",Font.PLAIN,20));
//                UIManager.put("OptionPane.buttonFont", new Font("Arial",Font.PLAIN,20));
//                JOptionPane.showMessageDialog(null, "Cant have Table number set at 0 or more table than 25!",""
//                  + "ERROR!",JOptionPane.ERROR_MESSAGE);
//            }
            
            //else{
            //Database connection
            String Hostname = "Localhost";
            String Username = "root";
            String Password = "RohaN@777!";
            String Db = "w.m.s";
            String URL = "jdbc:mysql://"+Hostname+":3306/"+Db;
            
            UIManager.put("OptionPane.messageFont", new Font("Arial",Font.PLAIN,20));
            UIManager.put("OptionPane.buttonFont", new Font("Arial",Font.PLAIN,20));
            
            try {
                Connection DbCon = DriverManager.getConnection(URL,Username,Password);
                Statement DbStat1 = DbCon.createStatement();
                String Query1 = "SELECT date,tablenum FROM tipsofcustomers WHERE date='"+sqlDate+"' and w_Username='"+UserName+"' and tablenum='"+TblNum1+"'";
                ResultSet rs1 = DbStat1.executeQuery(Query1);
               
                if(rs1.next()) {
                    
                    Statement DbStat2 = DbCon.createStatement();
                    String Query2 = "SELECT tips FROM tipsofcustomers WHERE date='"+sqlDate+"' and w_Username='"+UserName+"' and tablenum='"+TblNum1+"'";
                    ResultSet rs2 = DbStat2.executeQuery(Query2);
                    while(rs2.next()) {
                
                        tipsDataBase = rs2.getDouble("tips");
                    }
                        tipsToAdd = tipsToAdd + tipsDataBase;
                        tipsToAdd = tipsToAdd + tips2;
                    rs2.close();
                    
                    Statement DbStat4 = DbCon.createStatement();
                    String Query4 = "UPDATE tipsofcustomers SET tips='"+tipsToAdd+"' WHERE date='"+sqlDate+"' and w_Username='"+UserName+"' and tablenum='"+TblNum1+"'";
                    DbStat4.executeUpdate(Query4);
                    JOptionPane.showMessageDialog(null, "Customer tips added to table!",""
                            + "Added!",JOptionPane.PLAIN_MESSAGE);
                    rs1.close();
                } 
                
                else {
                    Statement DbStat3 = DbCon.createStatement();
                    String Query3 = "INSERT INTO tipsofcustomers(date,tablenum,tips,w_Username) "
                            + "VALUES('"+sqlDate+"','"+TblNum1+"','"+tips2+"','"+UserName+"')";
                    DbStat3.executeUpdate(Query3);
                    JOptionPane.showMessageDialog(null, "Customer tips added to table!",""
                            + "Added!",JOptionPane.PLAIN_MESSAGE);
                }
                    
                    Statement DbStat4 = DbCon.createStatement();
                    String Query4 = "SELECT w_Username FROM monthly WHERE w_Username='"+UserName+"'";
                    ResultSet rs4 = DbStat4.executeQuery(Query4);
                    
                    if(rs4.next()) {
                        Statement DbStat5 = DbCon.createStatement();
                        String Query5 = "SELECT Income, MonthlyTips FROM monthly WHERE w_Username='"+UserName+"'";
                        ResultSet rs5 = DbStat5.executeQuery(Query5);
                        while(rs5.next()) {
                        
                            incomeDb = rs5.getDouble("Income");
                            monthlyDb = rs5.getDouble("MonthlyTips");
                        }
                        incomeToAdd = incomeToAdd + incomeDb;
                        monthlyTipDbToAdd =monthlyTipDbToAdd + monthlyDb;
                        
                        monthlyTipDbToAdd = monthlyTipDbToAdd + tips2;
                        incomeToAdd = incomeToAdd + tips2;
                        rs5.close();
                        
                        Statement DbStat6 = DbCon.createStatement();
                        String Query6 = "UPDATE monthly SET Income = '"+incomeToAdd+"', MonthlyTips = '"+monthlyTipDbToAdd+"' "
                                + "WHERE w_Username='"+UserName+"'";
                        DbStat6.executeUpdate(Query6);
                        rs4.close();
                    }
                    else {
                        
                        monthlyTipDbToAdd = monthlyTipDbToAdd + tips2;
                        incomeToAdd = incomeToAdd + 700+ tips2;
                        
                        Statement DbStat7 = DbCon.createStatement();
                        String Query7 = "INSERT INTO  monthly(Income,MonthlyTips,w_Username) "
                                + "VALUES('"+incomeToAdd+"','"+monthlyTipDbToAdd+"','"+UserName+"')";
                        DbStat7.executeUpdate(Query7);
                    }
                    
                    DbCon.close();
                    NewWaiterMenu waiterMenuFrame = new NewWaiterMenu(UserName);
                    waiterMenuFrame.setVisible(true);
                    setVisible(false);
                    dispose();
                
            } 
            catch (SQLException ex) {
                
            }
        }
        //}
    }
}
