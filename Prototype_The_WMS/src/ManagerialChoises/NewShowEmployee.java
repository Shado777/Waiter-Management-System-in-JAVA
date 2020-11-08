package ManagerialChoises;

import ManagerMainForm.ManagerMainPageForm;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class NewShowEmployee extends JFrame{
    
    private JPanel Pn1,Pn2,Pn3;
    private JLabel LbMenu;
    private JTable Tbl1;
    private JButton BtEmployee,BtPrevious;
    private JScrollPane Scroll1;
    
    public NewShowEmployee() {
    
        super("Employee Statistics");
        setSize(1000,700);
        setLocationRelativeTo(null);
        //this.setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        //Panels
        Pn1 = new JPanel();
        Pn1.setBackground(Color.LIGHT_GRAY);
        
        Pn2 = new JPanel();
        Pn2.setBackground(Color.WHITE);
        
        Pn3 = new JPanel();
        Pn3.setBackground(Color.DARK_GRAY);
        
        //Labels
        LbMenu = new JLabel("All Employee Statistics");
        LbMenu.setFont(new Font("Arial", Font.BOLD,20));
        LbMenu.setForeground(Color.BLACK);
        
        //Tabels

        String Hostname = "Localhost";
        String Username = "root";
        String Password = "RohaN@777!";
        String Db = "w.m.s";
        String URL = "jdbc:mysql://"+Hostname+":3306/"+Db;
        
        try {
            Connection DbCon = DriverManager.getConnection(URL,Username,Password);
            Tbl1= new JTable();
            Tbl1.setSize(200,700);
            Tbl1.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
            
            String [] colName = {"Name","Wage","Monthly Tips","Income"};
            DefaultTableModel model1 = new DefaultTableModel();
            model1.setColumnIdentifiers(colName);
            String QueryTbl = "SELECT waiter.w_Name, waiter.w_Wage, monthly.MonthlyTips, monthly.Income"
                    + " FROM waiter INNER JOIN monthly ON waiter.w_Username = monthly.w_Username";
            PreparedStatement pdStat = DbCon.prepareStatement(QueryTbl);
            ResultSet rsTb = pdStat.executeQuery();
            while(rsTb.next()) {
                
                String A = rsTb.getString(1);
                String B = rsTb.getString(2);
                String C = rsTb.getString(3);
                String D = rsTb.getString(4);
                
                model1.addRow(new Object[]{A,B,C,D}); 
            }
            Tbl1.setModel(model1);
            Tbl1.setVisible(true); 
        } 
        catch (SQLException ex) {
            
        }
 
        Font f = new Font("Arial",Font.BOLD, 25);
        UIManager.put("TableHeader.font", f);
  
        Font f2 = new Font("Arial",Font.PLAIN, 20);
        Tbl1.setFont(f2);
        
        //Scroll Pane 
        Scroll1 = new JScrollPane(Tbl1);
       
        //Buttons
        BtEmployee = new JButton("View Single Employee");
        BtEmployee.setFont(new Font("Arial",Font.BOLD,20));
        BtEmployee.setForeground(Color.BLACK);
        BtEmployee.setBackground(Color.GREEN);
        BtEmployee.setToolTipText("Click here to search for a single employee satistics");
        BtEmployee.addActionListener(new EmployeeBt());
        
        BtPrevious = new JButton("Previous");
        BtPrevious.setFont(new Font("Arial",Font.BOLD,20));
        BtPrevious.setForeground(Color.BLACK);
        BtPrevious.setBackground(Color.ORANGE);
        BtPrevious.setToolTipText("Click here to return to the main menu");
        BtPrevious.addActionListener(new PreviousBt()); 
        
        //Adding to Panels
        Pn1.add(LbMenu);
        Pn2.add(Scroll1);
        Pn3.add(BtEmployee);
        Pn3.add(BtPrevious);
        
        //Adding to JFrame
        add(Pn1, BorderLayout.NORTH);
        add(Pn2, BorderLayout.CENTER);
        add(Pn3, BorderLayout.SOUTH);
        pack();
        setVisible(true);
    }
    //Events
    //Show single employee
    class EmployeeBt implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            SearchSingleEmp snglEmp = new SearchSingleEmp();
            snglEmp.setVisible(true);
            dispose();
        }
    }
    //Return to main
    class PreviousBt implements ActionListener {

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
}
