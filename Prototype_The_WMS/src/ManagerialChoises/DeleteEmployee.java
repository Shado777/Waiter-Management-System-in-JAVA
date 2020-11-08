package ManagerialChoises;

import ManagerMainForm.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class DeleteEmployee extends JFrame{
    //Attributes
    private JPanel Pn1, Pn2, Pn3;
    private Box Hor1,Hor2,Hor3,Vert1,Vert2,Vert3,Vert4,Vert5;
    private JLabel Lb1,Lb2,Lb3,Lb4,Lb5,Lb6;
    private JTextField Fld3,Fld4,Fld5;
    private JButton Bt1, Bt2, Bt3;
    private JComboBox CBox3;
    
    //Constructor
    public DeleteEmployee() {
        
        //JFrame
        super("Remove Employee");
        setSize(640,280);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());
        
        //JPanel
        Pn1 = new JPanel();
        Pn1.setBackground(Color.LIGHT_GRAY);
        
        Pn2 = new JPanel(new GridLayout(0,2,5,5));
        Pn2.setBackground(Color.WHITE);
        
        Pn3 = new JPanel();
        Pn3.setBackground(Color.DARK_GRAY);
        
        //Label
        Lb1 = new JLabel("This form is for deleting employees");
        Lb1.setFont(new Font("Arial", Font.BOLD, 20));
        Lb1.setForeground(Color.BLACK);
        
        Lb2 = new JLabel("Fill in the credentials and click delete");
        Lb2.setFont(new Font("Arial", Font.BOLD, 20));
        Lb2.setForeground(Color.BLACK);
        
        Lb3 = new JLabel("Employee Type");
        Lb3.setFont(new Font("Arial", Font.BOLD, 20));
        Lb3.setForeground(Color.BLACK);
        
        Lb4 = new JLabel("Employee Name: ");
        Lb4.setFont(new Font("Arial", Font.BOLD, 20));
        Lb4.setForeground(Color.BLACK);
        
        Lb5 = new JLabel("Employee Surname: ");
        Lb5.setFont(new Font("Arial", Font.BOLD, 20));
        Lb5.setForeground(Color.BLACK);
        
        Lb6 = new JLabel("Username: ");
        Lb6.setFont(new Font("Arial", Font.BOLD, 20));
        Lb6.setForeground(Color.BLACK);
        
        //text Fields
        Fld3 = new JTextField(20);
        Fld3.setFont(new Font("Arial", Font.BOLD, 20));
        Fld3.setBackground(Color.LIGHT_GRAY);
        
        Fld4 = new JTextField(20);
        Fld4.setFont(new Font("Arial", Font.BOLD, 20));
        Fld4.setBackground(Color.LIGHT_GRAY);
        
        Fld5 = new JTextField(20);
        Fld5.setFont(new Font("Arial", Font.BOLD, 20));
        Fld5.setBackground(Color.LIGHT_GRAY);
        
        //Buttons
        Bt1 = new JButton("Delete");
        Bt1.setFont(new Font("Arial", Font.BOLD, 20));
        Bt1.setBackground(Color.RED);
        Bt1.setToolTipText("Click this Button to delete employee");
        Bt1.addActionListener(new DeleteBt());
        
        Bt2 = new JButton("Refresh");
        Bt2.setFont(new Font("Arial", Font.BOLD, 20));
        Bt2.setBackground(Color.CYAN);
        Bt2.setToolTipText("Click this Button to clear fields");
        Bt2.addActionListener(new RefreshBt());
        
        Bt3 = new JButton("Cancel");
        Bt3.setFont(new Font("Arial", Font.BOLD, 20));
        Bt3.setBackground(Color.ORANGE);
        Bt3.setToolTipText("Click this Button to cancel and return to previous form");
        Bt3.addActionListener(new CancelBt());
        
        //ComboBox
        String []EmpType = {"Waiter","Manager"};
        CBox3 = new JComboBox(EmpType);
        CBox3.setFont(new Font("Arial", Font.BOLD, 20));
        
        //BoxLayout
        //Horisontal box 1
        Hor1 = Box.createHorizontalBox();
        Hor1.add(Box.createHorizontalStrut(38));
        Hor1.add(Lb1);
        
        //box 2
        Hor2 = Box.createHorizontalBox();
        Hor2.add(Box.createHorizontalStrut(40));
        Hor2.add(Lb2);
        
        //box 3
        Hor3 = Box.createHorizontalBox();
        Hor3.add(Box.createHorizontalStrut(20));
        Hor3.add(Bt1);
        Hor3.add(Box.createHorizontalStrut(20));
        Hor3.add(Bt2);
        Hor3.add(Box.createHorizontalStrut(20));
        Hor3.add(Bt3);
        
        //Vertical box
        Vert1 = Box.createVerticalBox();
        Vert1.add(Box.createVerticalStrut(1));
        Vert1.add(Hor1);
        Vert1.add(Box.createVerticalStrut(5));
        Vert1.add(Hor2);
        Vert1.add(Box.createVerticalStrut(5));
        
        Vert2 = Box.createVerticalBox();
        Vert2.add(Box.createVerticalStrut(5));
        Vert2.add(CBox3);
        
        Vert3 = Box.createVerticalBox();
        Vert3.add(Box.createVerticalStrut(1));
        Vert3.add(Fld3);
        
        Vert4 = Box.createVerticalBox();
        Vert4.add(Box.createVerticalStrut(1));
        Vert4.add(Fld4);
        
        Vert5 = Box.createVerticalBox();
        Vert5.add(Box.createVerticalStrut(1));
        Vert5.add(Fld5);
        Vert5.add(Box.createVerticalStrut(5));
        
        //Adding to Pane
        //Pane 1
        Pn1.add(Vert1);
        
        //Pane2
        Pn2.add(Lb3);
        Pn2.add(Vert2);
        Pn2.add(Lb4);
        Pn2.add(Vert3);
        Pn2.add(Lb5);
        Pn2.add(Vert4);
        Pn2.add(Lb6);
        Pn2.add(Vert5);
        
        
        //Pane3
        Pn3.add(Hor3);
        
        //adding to Jframe
        add(Pn1, BorderLayout.NORTH);
        add(Pn2, BorderLayout.CENTER);
        add(Pn3, BorderLayout.SOUTH);
        setVisible(true);
    }
    //Methods and EventHandlers
    //Delete button
    class DeleteBt implements ActionListener {
        
        @Override
        public void actionPerformed(ActionEvent e) {
            
            //Getting data from fields
            String boxItem = (String)(CBox3.getSelectedItem());
            String nameTxt = Fld3.getText();
            String surnameTxt = Fld4.getText();
            String usernameTxt = Fld5.getText();
            
            //Database connections
            String Hostname = "localhost";
            String Username = "root";
            String Password = "RohaN@777!";
            String Db = "w.m.s";
            String URL = "jdbc:mysql://"+Hostname+":3306/"+Db;
            
            try {
                Connection DbCon = DriverManager.getConnection(URL, Username, Password);
                
                
                //Condition statement for waiter or manager
                //Waiter
                if(boxItem == "Waiter") {
                    Statement DbStat1 = DbCon.createStatement();
                    String Query1 = "SELECT w_Username FROM waiter WHERE w_Username='"+usernameTxt+"'";
                    ResultSet rs1 = DbStat1.executeQuery(Query1);
                    
                    //Checking if there is a user
                    if(rs1.next()) {
                        UIManager.put("OptionPane.messageFont", new Font("Arial",Font.PLAIN,20));
                        UIManager.put("OptionPane.buttonFont", new Font("Arial",Font.PLAIN,20));
                        int option = JOptionPane.showConfirmDialog(null, "You are about to delete an employee"
                            + "\nDo you want to continue?","Alert!",JOptionPane.YES_NO_OPTION);
                        //Condition for yes no option
                        if(option ==JOptionPane.YES_OPTION) {
                            Statement DbStat2 = DbCon.createStatement();
                            String Query2 = "DELETE FROM waiter WHERE w_Name='"+nameTxt+"' "
                                + "AND w_Surname='"+surnameTxt+"' AND w_Username='"+usernameTxt+"'";
                            DbStat2.executeUpdate(Query2);
                            JOptionPane.showMessageDialog(null, "Employee deleted!",""
                                + "Deleted",JOptionPane.PLAIN_MESSAGE);
                        }
                        else {
                            Fld3.setText(null);
                            Fld4.setText(null);
                        }
                        //Condition to exit form
                        int Option = JOptionPane.showConfirmDialog(null,"Do you want to remove another employee?",""
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
                            }
                        rs1.close();
                    }
                    
                    else {
                        UIManager.put("OptionPane.messageFont", new Font("Arial",Font.PLAIN,20));
                        UIManager.put("OptionPane.buttonFont", new Font("Arial",Font.PLAIN,20));
                        JOptionPane.showMessageDialog(null, "User does not exist!",""
                            + "ERROR!",JOptionPane.ERROR_MESSAGE);
                        Fld3.setText(null);
                        Fld4.setText(null);
                        Fld5.setText(null);
                    }
                    
                }
                
                //Manager
                else {
                    
                    Statement DbStat2 = DbCon.createStatement();
                    String Query2 = "SELECT m_Username FROM manager WHERE m_Username='"+usernameTxt+"'";
                    ResultSet rs2 = DbStat2.executeQuery(Query2);
                    
                    if(rs2.next()) {
                        UIManager.put("OptionPane.messageFont", new Font("Arial",Font.PLAIN,20));
                        UIManager.put("OptionPane.buttonFont", new Font("Arial",Font.PLAIN,20));
                        int option = JOptionPane.showConfirmDialog(null, "You are about to delete an employee"
                            + "\nDo you want to continue?","Alert!",JOptionPane.YES_NO_OPTION);
                        //Condition for yes no option
                        if(option ==JOptionPane.YES_OPTION) {
                            Statement DbStat4 = DbCon.createStatement();
                            String Query4 = "DELETE FROM manager WHERE m_Name='"+nameTxt+"' "
                                + "AND m_Surname='"+surnameTxt+"' AND m_Username='"+usernameTxt+"'";
                            DbStat4.executeUpdate(Query4);
                            JOptionPane.showMessageDialog(null, "Employee deleted!",""
                                + "Deleted",JOptionPane.PLAIN_MESSAGE);
                        }
                        else {
                            Fld3.setText(null);
                            Fld4.setText(null);
                        }
                        //Condition to exit form
                        int Option = JOptionPane.showConfirmDialog(null,"Do you want to remove another employee?",""
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
                            }
                       rs2.close();
                    }
                    
                    else {
                    
                        UIManager.put("OptionPane.messageFont", new Font("Arial",Font.PLAIN,20));
                        UIManager.put("OptionPane.buttonFont", new Font("Arial",Font.PLAIN,20));
                        JOptionPane.showMessageDialog(null, "User does not exist!",""
                            + "ERROR!",JOptionPane.ERROR_MESSAGE);
                        Fld3.setText(null);
                        Fld4.setText(null);
                        Fld5.setText(null);
                    }  
                }
                DbCon.close();
            } 
            catch (SQLException ex) {
                Logger.getLogger(DeleteEmployee.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    //Refresh Button
    class RefreshBt implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            Fld3.setText(null);
            Fld4.setText(null);
        }
    }
    //Cancel Button
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
