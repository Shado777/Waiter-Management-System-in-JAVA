/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManagerialChoises;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Rohan
 */
public class SearchSingleEmp extends JFrame{
    
    private JPanel Pn1,Pn2,Pn3, Pntbl, Pn4, Pn5;
    private Box Hor1,Hor2,Hor3,Hor4,Hor5,Hor6, Vert1;
    private JLabel LbMenu, LbUserName, LbTotalMonthTip ,LbWage, LbIncome, LbFilter, LbTotalTips;
    private JTextField fld1,fld2,fld3,fld4,fld5,fld6;
    private JTable Tbl1;
    private JButton BtSearch,BtFilter,BtExit;
    private JScrollPane Scroll1;
    
    public SearchSingleEmp() {
        
        super("Show single Employee Statistics");
        setSize(1000,700);
        setLocationRelativeTo(null);
       // this.setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        //Panels
        Pn1 = new JPanel();
        Pn1.setBackground(Color.WHITE);
        
        Pn2 = new JPanel();
        Pn2.setBackground(Color.WHITE);
        
        Pntbl = new JPanel();
        Pntbl.setBackground(Color.WHITE);
        
        Pn3 = new JPanel(new GridLayout(0,2,5,5));
        Pn3.setBackground(Color.WHITE);
        
        Pn4 = new JPanel();
        Pn4.setBackground(Color.WHITE);
        
        Pn5 = new JPanel();
        Pn5.setBackground(Color.DARK_GRAY);
        
        //Labels
        LbMenu = new JLabel("Single Employee Statistics");
        LbMenu.setFont(new Font("Arial", Font.BOLD,20));
        LbMenu.setForeground(Color.BLACK);
        
        LbUserName = new JLabel("Username: ");
        LbUserName.setFont(new Font("Arial", Font.BOLD,20));
        LbUserName.setForeground(Color.BLACK);
        
        LbTotalMonthTip = new JLabel("Total monthly tips: ");
        LbTotalMonthTip.setFont(new Font("Arial", Font.BOLD,20));
        LbTotalMonthTip.setForeground(Color.BLACK);
        
        LbWage = new JLabel("Wage: ");
        LbWage.setFont(new Font("Arial", Font.BOLD,20));
        LbWage.setForeground(Color.BLACK);
        
        LbIncome = new JLabel("Income: ");
        LbIncome.setFont(new Font("Arial", Font.BOLD,20));
        LbIncome.setForeground(Color.BLACK);
        
        LbFilter = new JLabel("Filter by Date: ");
        LbFilter.setFont(new Font("Arial", Font.BOLD,20));
        LbFilter.setForeground(Color.BLACK);
        
        LbTotalTips = new JLabel("Total Tips");
        LbTotalTips.setFont(new Font("Arial", Font.BOLD,20));
        LbTotalTips.setForeground(Color.BLACK);
        
        //Fields
        fld1 = new JTextField(8);
        fld1.setFont(new Font("Arial",Font.BOLD,20));
        fld1.setBackground(Color.LIGHT_GRAY);
        
        fld2 = new JTextField(10);
        fld2.setFont(new Font("Arial",Font.BOLD,20));
        fld2.setBackground(Color.LIGHT_GRAY);
        fld2.setEditable(false);
        
        fld3 = new JTextField(10);
        fld3.setFont(new Font("Arial",Font.BOLD,20));
        fld3.setBackground(Color.LIGHT_GRAY);
        fld3.setEditable(false);
        
        fld4 = new JTextField(10);
        fld4.setFont(new Font("Arial",Font.BOLD,20));
        fld4.setBackground(Color.LIGHT_GRAY);
        fld4.setEditable(false);
        
        fld5 = new JTextField("YYYY-MM-DD");
        fld5.setFont(new Font("Arial",Font.BOLD,20));
        fld5.setBackground(Color.LIGHT_GRAY);
        fld5.setToolTipText("Enter the date like the format above"); 
        
        fld6 = new JTextField(10);
        fld6.setFont(new Font("Arial",Font.BOLD,20));
        fld6.setBackground(Color.LIGHT_GRAY);
        fld6.setEditable(false); 
        
        //Table
        
        Tbl1= new JTable();
        Tbl1.setSize(800,500);
        Tbl1.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        
        String [] colName = {"Table Number"," Tips"};
        
        DefaultTableModel model1 = new DefaultTableModel();
        model1.setColumnIdentifiers(colName);
        
        Tbl1.setVisible(true);
       
        Font f = new Font("Arial",Font.BOLD, 25);
        UIManager.put("TableHeader.font", f);
       
     
        Font f2 = new Font("Arial",Font.PLAIN, 20);
        Tbl1.setFont(f2);
        
        // Scroll1
        Scroll1 = new JScrollPane(Tbl1);
        
        //Buttons
        BtSearch = new JButton("Search");
        BtSearch.setFont(new Font("Arial",Font.BOLD,20));
        BtSearch.setForeground(Color.BLACK);
        BtSearch.setBackground(Color.GREEN);
        BtSearch.setToolTipText("Click here to search by name");
        BtSearch.addActionListener(new SearchBT()); 
        
        BtFilter = new JButton("Filter");
        BtFilter.setFont(new Font("Arial",Font.BOLD,20));
        BtFilter.setForeground(Color.BLACK);
        BtFilter.setBackground(Color.CYAN);
        BtFilter.setToolTipText("Click here to search by date and name");
        BtFilter.addActionListener(new FilterBt()); 
        
        BtExit = new JButton("Cancel");
        BtExit.setFont(new Font("Arial",Font.BOLD,20));
        BtExit.setForeground(Color.BLACK);
        BtExit.setBackground(Color.ORANGE);
        BtExit.setToolTipText("Click here to return to the show employee form");
        BtExit.addActionListener(new ExitBt()); 
        
        //Adding to Pntbl
        Pntbl.add(Scroll1);
        
        //Box Layout
        Hor1 = Box.createHorizontalBox();
        Hor1.add(Box.createHorizontalStrut(15));
        Hor1.add(LbUserName);
        Hor1.add(Box.createHorizontalStrut(5));
        Hor1.add(fld1);
        Hor1.add(Box.createHorizontalStrut(15));
        Hor1.add(BtSearch);
        
        Hor2 = Box.createHorizontalBox();
        Hor2.add(Box.createHorizontalStrut(15));
        Hor2.add(LbFilter);
        Hor2.add(Box.createHorizontalStrut(5));
        Hor2.add(fld5);
        Hor2.add(Box.createHorizontalStrut(15));
        Hor2.add(BtFilter);
        
        Hor3 = Box.createHorizontalBox();
        Hor3.add(Box.createHorizontalStrut(15));
        Hor3.add(LbTotalTips);
        Hor3.add(Box.createHorizontalStrut(5));
        Hor3.add(fld6);
        
        Hor4 = Box.createHorizontalBox();
        Hor4.add(Box.createHorizontalStrut(15));
        Hor4.add(LbTotalMonthTip);
        Hor4.add(Box.createHorizontalStrut(81));
        Hor4.add(fld2);
        
        Hor5 = Box.createHorizontalBox();
        Hor5.add(Box.createHorizontalStrut(15));
        Hor5.add(LbWage);
        Hor5.add(Box.createHorizontalStrut(200));
        Hor5.add(fld3);
        
        Hor6 = Box.createHorizontalBox();
        Hor6.add(Box.createHorizontalStrut(15));
        Hor6.add(LbIncome);
        Hor6.add(Box.createHorizontalStrut(185));
        Hor6.add(fld4);
        
        Vert1 = Box.createVerticalBox();
        Vert1.add(Box.createVerticalStrut(10));
        Vert1.add(Hor4);
        Vert1.add(Box.createVerticalStrut(10));
        Vert1.add(Hor5);
        Vert1.add(Box.createVerticalStrut(10));
        Vert1.add(Hor6);
        Vert1.add(Box.createVerticalStrut(20));
        Vert1.add(Hor2);
        Vert1.add(Box.createVerticalStrut(10));
        Vert1.add(Scroll1);
        Vert1.add(Box.createVerticalStrut(10));
        Vert1.add(Hor3);
        
        //Adding to panels
        //Pn1.add(LbMenu);
        
        Pn1.add(Hor1, BorderLayout.NORTH);
        
        Pn2.add(Vert1);
        
        Pn5.add(BtExit);
        
        //Adding to JFrame
        add(Pn1, BorderLayout.NORTH);
        add(Pn2, BorderLayout.CENTER);
        add(Pn5, BorderLayout.SOUTH);
        pack();
        setVisible(false);
    }
    //Events
    //Search by name
    class SearchBT implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            //Variables
           String SUser = fld1.getText();
           double MonthlyDb = 0;
           double WageDb = 0;
           double IncomeDb = 0;
           
           String MonthlyAdd = null;
           String WageAdd = null;
           String IncomeAdd = null;
           
           //Database
           String Hostname = "Localhost";
           String Username = "root";
           String Password = "RohaN@777!";
           String Db = "w.m.s";
           String URL = "jdbc:mysql://"+Hostname+":3306/"+Db;
           
            try {
                Connection DbCon = DriverManager.getConnection(URL,Username,Password);
                Statement DbStat2 = DbCon.createStatement();
                String Query2 = "SELECT Income, MonthlyTips FROM monthly WHERE w_Username='"+SUser+"'";
                ResultSet rs2 = DbStat2.executeQuery(Query2);
                
                while(rs2.next()) {
                    IncomeDb = rs2.getDouble("Income");
                    MonthlyDb = rs2.getDouble("MonthlyTips");
                }
                IncomeAdd = Double.toString(IncomeDb);
                MonthlyAdd = Double.toString(MonthlyDb);
                
                
                
                Statement DbStat3 = DbCon.createStatement();
                String Query3 = "SELECT w_Wage FROM waiter WHERE w_Username='"+SUser+"'";
                ResultSet rs3 = DbStat3.executeQuery(Query3);
                
                while(rs3.next()) {
                    WageDb = rs3.getDouble("w_Wage");
                }
                
                WageAdd = Double.toString(WageDb);
                
                fld2.setText("R "+MonthlyAdd);
                fld3.setText("R "+WageAdd);
                fld4.setText("R "+IncomeAdd);
                
                rs2.close();
                rs3.close();
                
                
                DbCon.close();
            }
            catch (SQLException ex) {
                Logger.getLogger(SearchSingleEmp.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    //Search by Date
    class FilterBt implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            //Variables
            String stringDate = fld5.getText();
            java.sql.Date sqlDate1 = java.sql.Date.valueOf(stringDate);
            String User1 = fld1.getText();
            double TotTipsDateDb = 0;
            String TotTipsDate = null;
             
            /*
            if(((Pattern.matches("([0-9]{4})-([0-9]{2})-([0-9]{2})", stringDate)) == false)) {
            
                UIManager.put("OptionPane.messageFont", new Font("Arial",Font.PLAIN,20));
                UIManager.put("OptionPane.buttonFont", new Font("Arial",Font.PLAIN,20));
                JOptionPane.showMessageDialog(null, "Incorrect format for date!",""
                  + "ERROR!",JOptionPane.ERROR_MESSAGE);
                fld5.setText("YYYY-MM-DD"); 
            }
            */
            //else {
                //Database
                String Hostname = "Localhost";
                String Username = "root";
                String Password = "RohaN@777!";
                String Db = "w.m.s";
                String URL = "jdbc:mysql://"+Hostname+":3306/"+Db;
            
                try {
                    Connection DbCon = DriverManager.getConnection(URL,Username,Password);
                
                    //Table
                    Tbl1.setSize(200,700);
                    Tbl1.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
            
                    String [] colName = {"Table Number"," Tips"};
                    DefaultTableModel model1 = new DefaultTableModel();
                    model1.setColumnIdentifiers(colName);
                    String QueryTbl = "SELECT tablenum,tips FROM tipsofcustomers WHERE date='"+sqlDate1+"' and w_Username='"+User1+"'";
                    PreparedStatement pdStat = DbCon.prepareStatement(QueryTbl);
                    ResultSet rsTb = pdStat.executeQuery();
            
                    while(rsTb.next()) {
                
                        String A = rsTb.getString(1);
                        String B = rsTb.getString(2);
                
                        model1.addRow(new Object[]{A,B}); 
                    }
                    Tbl1.setModel(model1);
                    Tbl1.setVisible(true);
                    Font f = new Font("Arial",Font.BOLD, 25);
                    UIManager.put("TableHeader.font", f);
  
                    Font f2 = new Font("Arial",Font.PLAIN, 20);
                    Tbl1.setFont(f2);
                
                    rsTb.close();
                
                    //TotalTips
                    Statement DbStat1 = DbCon.createStatement();
                    String Query1 = "SELECT SUM(tips) FROM tipsofcustomers WHERE date='"+sqlDate1+"' and w_Username='"+User1+"'";
                    ResultSet rs1 = DbStat1.executeQuery(Query1);
                
                    while(rs1.next()) {
                    
                        TotTipsDateDb = rs1.getDouble(1);
                    }
                    TotTipsDate = Double.toString(TotTipsDateDb);
                    fld6.setText(TotTipsDate); 
                    rs1.close();
                    DbCon.close();
                } 
                catch (SQLException ex) {
                    Logger.getLogger(SearchSingleEmp.class.getName()).log(Level.SEVERE, null, ex);
                }
            //} 
        }
    }
    
    //Exit form
    class ExitBt implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            UIManager.put("OptionPane.messageFont", new Font("Arial",Font.PLAIN,20));
            UIManager.put("OptionPane.buttonFont", new Font("Arial",Font.PLAIN,20));
            int Op1 = JOptionPane.showConfirmDialog(null, "Are you sure you want to return to the previous page?",""
                    + "Exit!",JOptionPane.YES_NO_OPTION);
            if(Op1 == JOptionPane.YES_OPTION) {
             
                NewShowEmployee EmpRFrame = new NewShowEmployee();
                EmpRFrame.setVisible(true);
             dispose();
            }
        }
    }
    //end of form
}
