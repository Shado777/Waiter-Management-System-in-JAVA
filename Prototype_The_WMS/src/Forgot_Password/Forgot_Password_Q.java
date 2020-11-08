/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Forgot_Password;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class Forgot_Password_Q extends JFrame {
    
    private JLabel lb1,lb2,lb3,lb4;
    private JLabel Lb1, Lb2, Lb3, Lb4, Lb5;
    private JPanel pn1, pn2, pn3;
    private JComboBox CBox2;
    private JButton BtCancel,BtSearch;
    private JTextField fld1,fld2,fld3;
    
    public Forgot_Password_Q() {
    
        super("Forgot Password");
        setSize(1000,400);
        setLocationRelativeTo(null);
        this.setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        // Panels
        pn1 = new JPanel();
        pn1.setBackground(Color.LIGHT_GRAY);
        
        pn2 = new JPanel(new GridLayout(0,2,5,5));
        pn2.setBackground(Color.WHITE);
        
        pn3 = new JPanel();
        pn3.setBackground(Color.DARK_GRAY);
        
        //Labels 
        //Spacing
        lb1= new JLabel();
        lb2= new JLabel();
        lb3 = new JLabel();
        lb4= new JLabel();
        
        
        //Describing
        Lb1 = new JLabel("Fill in the credentials and answer the question to search forgoten password");
        Lb1.setFont(new Font("Arial", Font.BOLD,20));
        
        Lb2 = new JLabel("Choose for Mangerial or Waiter credentials");
        Lb2.setFont(new Font("Arial", Font.BOLD,20));
        
        
        Lb3 = new JLabel("Username: ");
        Lb3.setFont(new Font("Arial", Font.BOLD,20));
        
        Lb4 = new JLabel("What was your first car: ");
        Lb4.setFont(new Font("Arial", Font.BOLD,20));
        
        Lb5 = new JLabel("Your Password is: ");
        Lb5.setFont(new Font("Arial", Font.BOLD,20));
        
        //ComboBox
        String[] EmpType = {"Waiter","Manager"};
        CBox2 = new JComboBox(EmpType);
        CBox2.setFont(new Font("Arial",Font.BOLD,20));
        
        //Textfields
        fld1 = new JTextField(10);
        fld1.setBackground(Color.LIGHT_GRAY);
        fld1.setFont(new Font("Arial",Font.BOLD,20));
                
        fld2 = new JTextField(10);
        fld2.setBackground(Color.LIGHT_GRAY);
        fld2.setFont(new Font("Arial",Font.BOLD,20));
        
        fld3 = new JTextField(10);
        fld3.setBackground(Color.LIGHT_GRAY);
        fld3.setFont(new Font("Arial",Font.BOLD,20));
        fld3.setEditable(false); 
        
        //Buttons
        BtCancel = new JButton("Cancel");
        BtCancel.setFont(new Font("Arial",Font.BOLD,20));
        BtCancel.setForeground(Color.BLACK);
        BtCancel.setBackground(Color.ORANGE);
        BtCancel.setToolTipText("Click here to return to the previous page");
        BtCancel.addActionListener(new CancelBt());
        
        
        BtSearch = new JButton("Search");
        BtSearch.setFont(new Font("Arial",Font.BOLD,20));
        BtSearch.setForeground(Color.BLACK);
        BtSearch.setBackground(Color.GREEN);
        BtSearch.setToolTipText("Click here to find password");
        BtSearch.addActionListener(new SearchBT()); 
        
        //Panels
        //Panel 1
        pn1.add(Lb1);
        
        //Panel2
        pn2.add(lb1);
        pn2.add(lb2);
        pn2.add(Lb2);
        pn2.add(CBox2);
        pn2.add(Lb3);
        pn2.add(fld1);
        pn2.add(Lb4);
        pn2.add(fld2);
        pn2.add(Lb5);
        pn2.add(fld3);
        pn2.add(lb3);
        pn2.add(lb4);
      
        //Panel3
        pn3.add(BtSearch);
        pn3.add(BtCancel);
        
        
        //JFrame
        add(pn1, BorderLayout.NORTH);
        add(pn2, BorderLayout.CENTER);
        add(pn3, BorderLayout.SOUTH);
        setVisible(true);
    }
    
            
    //Search 
    class SearchBT implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
           
            //Variables
            String CBoxItem = (String)(CBox2.getSelectedItem());
            String Fuser = fld1.getText();
            String Fcar = fld2.getText();
            String FpassDb = null;
            String Fpass = null;
            
            
            //Database
            String Hostname = "Localhost";
            String Username = "root";
            String Password = "RohaN@777!";
            String Db = "w.m.s";
            String URL = "jdbc:mysql://"+Hostname+":3306/"+Db;
            
            UIManager.put("OptionPane.messageFont", new Font("Arial",Font.PLAIN,20));
            UIManager.put("OptionPane.buttonFont", new Font("Arial",Font.PLAIN,20));
            
            try {
                Connection DbCon = DriverManager.getConnection(URL,Username,Password);
                
                if(CBoxItem == "Waiter") {
                  Statement DbStat1 = DbCon.createStatement();
                  String Query1 = "SELECT w_Password FROM waiter WHERE w_Username='"+Fuser+"' and w_ForgotQ='"+Fcar+"'";
                  ResultSet rs1 = DbStat1.executeQuery(Query1);
                  
                  if(rs1.next()) {
                      
                      FpassDb = rs1.getString("w_Password");
                      
                      Fpass = FpassDb;
                      fld3.setText(Fpass); 
                      CBox2.setEditable(false); 
                      rs1.close();
                  }
                  else {
                      
                      JOptionPane.showMessageDialog(null, "Password not found in system!",""
                            + "No Password Found!",JOptionPane.ERROR_MESSAGE);
                      fld1.setText(null);
                      fld2.setText(null);
                  }
                }
                else {
                  Statement DbStat2 = DbCon.createStatement();
                  String Query2 = "SELECT m_Password FROM manager WHERE m_Username='"+Fuser+"' and m_ForgotQ='"+Fcar+"'";
                  ResultSet rs2 = DbStat2.executeQuery(Query2);
                  
                  if(rs2.next()) {
                      
                      FpassDb = rs2.getString("m_Password");
                      
                      Fpass = FpassDb;
                      fld3.setText(Fpass);
                      CBox2.setEditable(false); 
                      rs2.close();
                  }
                  else {
                      
                      JOptionPane.showMessageDialog(null, "Password not found in system!",""
                            + "No Password Found!",JOptionPane.ERROR_MESSAGE);
                      fld1.setText(null);
                      fld2.setText(null);
                  }
                }
                DbCon.close();;
            } 
            catch (SQLException ex) {
                Logger.getLogger(Forgot_Password_Q.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    //Cancwl
    class CancelBt implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            UIManager.put("OptionPane.messageFont", new Font("Arial",Font.PLAIN,20));
            UIManager.put("OptionPane.buttonFont", new Font("Arial",Font.PLAIN,20));
            
            JOptionPane.showMessageDialog(null, "Exiting the Form",""
                            + "Alert!",JOptionPane.PLAIN_MESSAGE);
            dispose();
        }
    }
}
