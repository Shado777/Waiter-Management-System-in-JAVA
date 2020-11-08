package ManagerialChoises;

import java.awt.*;
import java.awt.event.*;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.*;
import java.io.FileNotFoundException;

public class ShowEmp extends JFrame{
    //Attributes
    private JPanel Pn1,Pn2,Pn3,PnSing,PnAllEmp,PnSearchEmp,PnShow,PnBut;
    private JLabel LbTitle,LbTitle1,LbTitle2,LbName,LbSurname,LbUsername,LbTips,LbHours,LbWage;
    private JLabel LbP1,LbP2,LbP3,LbP4,LbP5,LbP6,LbP7,LbP8,LbP9,LbP10,LbP11, LbLP1,LbLP2,LbLP3;
    private JTextField FldName,FldSurname,FldUsername,FldTips,FldHours,FldWage;
    private JButton BtSingEmp,BtAllEmployees,BtWeekly,BtMonthly,BtPrint,BtExit;
    private JScrollPane Scroll1;
    private JTable Tbl1;
    private Font LbFont,CBoxFont,BtFont,FldFont;
    
    //Constructor
    public ShowEmp() {
        //JFrame
        super("Show Employee Report");
        setSize(1300,800);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());
        
        //Panels
        Pn1 = new JPanel();
        Pn1.setBackground(Color.LIGHT_GRAY);
        
        Pn2 = new JPanel(new BorderLayout());
        Pn2.setBackground(Color.WHITE);
        
        Pn3 = new JPanel(new BorderLayout());
        Pn3.setBackground(Color.DARK_GRAY);
        
        PnSing = new JPanel(new BorderLayout());
        PnSing.setBackground(Color.WHITE);
        
        PnAllEmp = new JPanel(new BorderLayout());
        PnAllEmp.setBackground(Color.WHITE);
        
        PnSearchEmp = new JPanel(new GridLayout(0,2,10,5));
        PnSearchEmp.setBackground(Color.WHITE);
        
        PnShow = new JPanel(new GridLayout(0,3,5,5));
        PnShow.setBackground(Color.WHITE);
        
        PnBut = new JPanel(new GridLayout(0,1,5,5));
        PnBut.setBackground(Color.DARK_GRAY);
        
        //Fonts
        LbFont = new Font("Arial",Font.BOLD,30);
        CBoxFont = new Font("Arial",Font.BOLD,25);
        BtFont = new Font("Arial",Font.BOLD,25);
        FldFont = new Font("Arial",Font.BOLD,25);
        
        //Labels
        LbLP1 = new JLabel("");
        LbLP2 = new JLabel("");
        LbLP3 = new JLabel("");
        
        LbP1 = new JLabel("");
        LbP2 = new JLabel("");
        LbP3 = new JLabel("");
        LbP4 = new JLabel("");
        LbP5 = new JLabel("");
        LbP6 = new JLabel("");
        
        LbP7 = new JLabel("");
        LbP8 = new JLabel("");
        LbP9 = new JLabel("");
        LbP10 = new JLabel("");
        LbP11 = new JLabel("");
        
        LbTitle = new JLabel("Show Employee Stats");
        LbTitle.setFont(LbFont);
        LbTitle.setForeground(Color.BLACK);
        
        LbTitle1 = new JLabel("<html><u>Single Employee stats :</u></html>");
        LbTitle1.setFont(LbFont);
        LbTitle1.setForeground(Color.BLACK);
        
        LbTitle2 = new JLabel("<html><u>All Employee Stats:</u></html>");
        LbTitle2.setFont(LbFont);
        LbTitle2.setForeground(Color.BLACK);
        
        LbName = new JLabel("Waiter Name:");
        LbName.setFont(LbFont);
        LbName.setForeground(Color.BLACK);
        
        LbSurname = new JLabel("Waiter Surname:");
        LbSurname.setFont(LbFont);
        LbSurname.setForeground(Color.BLACK);
        
        LbUsername = new JLabel("Waiter Username:");
        LbUsername.setFont(LbFont);
        LbUsername.setForeground(Color.BLACK);
        
        LbTips = new JLabel("Waiter Tips");
        LbTips.setFont(LbFont);
        LbTips.setForeground(Color.BLACK);
        
        LbHours = new JLabel("Waiter hours");
        LbHours.setFont(LbFont);
        LbHours.setForeground(Color.BLACK);
        
        LbWage = new JLabel("Waiter wage");
        LbWage.setFont(LbFont);
        LbWage.setForeground(Color.BLACK);
        
        //Fields
        FldName = new JTextField(10);
        FldName.setFont(LbFont);
        FldName.setBackground(Color.LIGHT_GRAY);
        
        FldSurname = new JTextField(10);
        FldSurname.setFont(LbFont);
        FldSurname.setBackground(Color.LIGHT_GRAY);
        
        FldUsername = new JTextField(10);
        FldUsername.setFont(LbFont);
        FldUsername.setBackground(Color.LIGHT_GRAY);
        
        FldTips = new JTextField();
        FldTips.setFont(LbFont);
        FldTips.setBackground(Color.LIGHT_GRAY);
        
        FldHours = new JTextField();
        FldHours.setFont(LbFont);
        FldHours.setBackground(Color.LIGHT_GRAY);
        
        FldWage = new JTextField();
        FldWage.setFont(LbFont);
        FldWage.setBackground(Color.LIGHT_GRAY);
        
        //Table
        String Hostname = "Localhost";
        String Username = "root";
        String Password = "RohaN@777!";
        String Db = "m.m.a.r.s";
        String URL = "jdbc:mysql://"+Hostname+":3306/"+Db;
        
        try {
            
            Connection DbCon = DriverManager.getConnection(URL,Username,Password);
            Tbl1= new JTable();
            Tbl1.setSize(800,500);
            Tbl1.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
            String [] colName = {"WaiterName","Waiter Surname","Hours","Wage","Tips"};
            
            DefaultTableModel model1 = new DefaultTableModel();
            model1.setColumnIdentifiers(colName);
            //model1.addRow(new Object[]{"w_Name","w_Surname","mth_Hours","mth_Wage","mth_Tips"});
            String QueryTbl = "SELECT waiter.w_Name, waiter.w_Surname, monthly.mth_Hours, monthly.mth_Wage, monthly.mth_Tips"
                    + " FROM waiter INNER JOIN monthly ON waiter.w_ID=monthly.w_ID";
            PreparedStatement pdStat = DbCon.prepareStatement(QueryTbl);
            ResultSet rsTb = pdStat.executeQuery();
            while(rsTb.next()) {
                
                String A = rsTb.getString(1);
                String B = rsTb.getString(2);
                String C = rsTb.getString(3);
                String D = rsTb.getString(4);
                String E = rsTb.getString(5);
                model1.addRow(new Object[]{A,B,C,D,E}); 
            }
            Tbl1.setModel(model1);
            Tbl1.setVisible(true); 
            
        } 
        catch (SQLException ex) {
            Logger.getLogger(ShowEmp.class.getName()).log(Level.SEVERE, null, ex);
        }
        /*
        String [] colName = {"WaiterName","Waiter Surname","Hours","Wage","Tips"};
        String [][] rows = {{" "," "," "," "," "},{" "," "," "," "," "},{" "," "," "," "," "},
            {" "," "," "," "," "},{" "," "," "," "," "},{" "," "," "," "," "},{" "," "," "," "," "},
        {" "," "," "," "," "},{" "," "," "," "," "},{" "," "," "," "," "}};
        */
        Font f = new Font("Arial",Font.BOLD, 30);
        UIManager.put("TableHeader.font", f);
        /*
        Tbl1= new JTable(rows,colName);
        Tbl1.setPreferredScrollableViewportSize(new Dimension(500,110));
        */
        Font f2 = new Font("Arial",Font.PLAIN, 25);
        Tbl1.setFont(f2);
       
        //Scrollpane
        Scroll1 = new JScrollPane(Tbl1);
        
        //Buttons
        BtSingEmp = new JButton("Search Employee");
        BtSingEmp.setBackground(Color.GREEN);
        BtSingEmp.setToolTipText("Click here to search for a single employee"); 
        BtSingEmp.setFont(BtFont);
        BtSingEmp.addActionListener(new SingEmp()); 
        
        BtAllEmployees = new JButton("Search All Employees");
        BtAllEmployees.setBackground(Color.GREEN);
        BtAllEmployees.setToolTipText("Click here to search for all employees"); 
        BtAllEmployees.setFont(BtFont);
        
        BtWeekly = new JButton("Weekly");
        BtWeekly.setBackground(Color.CYAN);
        BtWeekly.setToolTipText("Click here to search weekly"); 
        BtWeekly.setFont(BtFont);
        BtWeekly.addActionListener(new weekEmp()); 
        
        BtMonthly = new JButton("Monthly");
        BtMonthly.setBackground(Color.CYAN);
        BtMonthly.setToolTipText("Click here to search monthly"); 
        BtMonthly.setFont(BtFont);
        BtMonthly.addActionListener(new MonthEmp()); 
                
        BtPrint = new JButton("Print report");
        BtPrint.setBackground(Color.YELLOW);
        BtPrint.setToolTipText("Click here print the report of employees"); 
        BtPrint.setFont(BtFont);
        BtPrint.addActionListener(new Print()); 
        
        BtExit = new JButton("Exit");
        BtExit.setBackground(Color.RED);
        BtExit.setToolTipText("Click here to Exit the page"); 
        BtExit.setFont(BtFont);
        BtExit.addActionListener(new BtExit());
        
        //add panel
        //SubPanels
        //PnSearch
        PnSearchEmp.add(LbLP1);
        PnSearchEmp.add(LbLP2);
        PnSearchEmp.add(LbName);
        PnSearchEmp.add(LbName);
        PnSearchEmp.add(FldName);
        PnSearchEmp.add(LbSurname);
        PnSearchEmp.add(FldSurname);
        PnSearchEmp.add(LbUsername);
        PnSearchEmp.add(FldUsername);
        
        //PanelShow
        PnShow.add(LbP1);
        PnShow.add(LbP2);
        PnShow.add(LbP3);
        PnShow.add(LbTips);
        PnShow.add(LbHours);
        PnShow.add(LbWage);
        PnShow.add(FldTips);
        PnShow.add(FldHours);
        PnShow.add(FldWage);
        PnShow.add(LbP4);
        PnShow.add(LbP5);
        PnShow.add(LbP6);
        
        PnSing.add(LbTitle1, BorderLayout.NORTH);
        PnSing.add(PnSearchEmp, BorderLayout.CENTER);
        PnSing.add(PnShow, BorderLayout.SOUTH);
        
        PnAllEmp.add(LbTitle2, BorderLayout.NORTH);
        PnAllEmp.add(Scroll1, BorderLayout.CENTER);
        
        PnBut.add(LbLP3);
        PnBut.add(BtSingEmp);
        PnBut.add(LbP7);
        PnBut.add(BtAllEmployees);
        PnBut.add(LbP8);
        PnBut.add(BtWeekly);
        PnBut.add(LbP9);
        PnBut.add(BtMonthly);
        PnBut.add(LbP10);
        PnBut.add(BtPrint);
        PnBut.add(LbP11);
        PnBut.add(BtExit);
        
        
        //MainPanels
        //Pane1
        Pn1.add(LbTitle);
        
        //Panel2
        Pn2.add(PnSing, BorderLayout.NORTH);
        Pn2.add(PnAllEmp, BorderLayout.CENTER);
        
        //Panel 3
        Pn3.add(PnBut, BorderLayout.NORTH);
        
        //add JFrame
        add(Pn1, BorderLayout.NORTH);
        add(Pn2, BorderLayout.CENTER);
        add(Pn3, BorderLayout.EAST);
        //pack();
        setVisible(false);
    }
    //Methods and events
    //Single
    class SingEmp implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
           String HostName = "localhost";
           String Db = "m.m.a.r.s";
           String UserName = "root";
           String Password = "RohaN@777!";
           String URL = "jdbc:mysql://"+HostName+":3306/"+Db;
           
           int WaiterID = 0;
           String UserTxt = FldUsername.getText();
           int UserHours = 0;
           double UserTips = 0;
           double UserWage = 0;
            
            try {
                Connection DbCon = DriverManager.getConnection(URL,UserName,Password);
                Statement DbStat1 = DbCon.createStatement();
                String Query1 = "SELECT w_ID FROM waiter WHERE w_Username='"+UserTxt+"'";
                ResultSet rs1 = DbStat1.executeQuery(Query1);
                
                while(rs1.next()) {
                    WaiterID = WaiterID +rs1.getInt("w_ID");
                    Statement DbStat2 = DbCon.createStatement();
                    String Query2 = "SELECT wk_Hours,wk_Tips,wk_Wage FROM weekly WHERE w_ID='"+WaiterID+"'";
                    ResultSet rs2 = DbStat2.executeQuery(Query2);
                    while(rs2.next()) {
                        UserHours = rs2.getInt("wk_Hours");
                        UserTips = rs2.getDouble("wk_Tips");
                        UserWage = rs2.getDouble("wk_Wage");
                        
                        FldHours.setText(Integer.toString(UserHours));
                        FldTips.setText(Double.toString(UserTips));
                        FldWage.setText(Double.toString(UserWage));
                        
                    }
                    rs2.close();
                }
                rs1.close();
                DbCon.close();
            } 
            catch (SQLException ex) {
                Logger.getLogger(ShowEmp.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    
    }
    
    //All button
    class allEmp implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            
        }
    
    }
    
    //Weekly
    class weekEmp implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
           String HostName = "localhost";
           String Db = "m.m.a.r.s";
           String UserName = "root";
           String Password = "RohaN@777!";
           String URL = "jdbc:mysql://"+HostName+":3306/"+Db;
           
           int WaiterID = 0;
           String UserTxt = FldUsername.getText();
           int UserHours = 0;
           double UserTips = 0;
           double UserWage = 0;
           
            try {
                Connection DbCon = DriverManager.getConnection(URL,UserName,Password);
                Statement DbStat1 = DbCon.createStatement();
                String Query1 = "SELECT w_ID FROM waiter WHERE w_Username='"+UserTxt+"'";
                ResultSet rs1 = DbStat1.executeQuery(Query1);
                
                while(rs1.next()) {
                    WaiterID = WaiterID +rs1.getInt("w_ID");
                    Statement DbStat2 = DbCon.createStatement();
                    String Query2 = "SELECT wk_Hours,wk_Tips,wk_Wage FROM weekly WHERE w_ID='"+WaiterID+"'";
                    ResultSet rs2 = DbStat2.executeQuery(Query2);
                    while(rs2.next()) {
                        UserHours = rs2.getInt("wk_Hours");
                        UserTips = rs2.getDouble("wk_Tips");
                        UserWage = rs2.getDouble("wk_Wage");
                        
                        FldHours.setText(Integer.toString(UserHours));
                        FldTips.setText(Double.toString(UserTips));
                        FldWage.setText(Double.toString(UserWage));
                        
                    }
                    rs2.close();
                }
                rs1.close();
                DbCon.close();
            }
            catch (SQLException ex) {
                Logger.getLogger(ShowEmp.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    
    }
    
    //Monthly
    class MonthEmp implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
           String HostName = "localhost";
           String Db = "m.m.a.r.s";
           String UserName = "root";
           String Password = "RohaN@777!";
           String URL = "jdbc:mysql://"+HostName+":3306/"+Db;
           int WaiterID = 0;
           String UserTxt = FldUsername.getText();
           int UserHours = 0;
           double UserTips = 0;
           double UserWage = 0;
           
            try {
                Connection DbCon = DriverManager.getConnection(URL,UserName,Password);
                Statement DbStat1 = DbCon.createStatement();
                String Query1 = "SELECT w_ID FROM waiter WHERE w_Username='"+UserTxt+"'";
                ResultSet rs1 = DbStat1.executeQuery(Query1);
                
                while(rs1.next()) {
                    WaiterID = WaiterID +rs1.getInt("w_ID");
                    Statement DbStat2 = DbCon.createStatement();
                    String Query2 = "SELECT mth_Hours,mth_Tips,mth_Wage FROM monthly WHERE w_ID='"+WaiterID+"'";
                    ResultSet rs2 = DbStat2.executeQuery(Query2);
                    while(rs2.next()) {
                        UserHours = rs2.getInt("mth_Hours");
                        UserTips = rs2.getDouble("mth_Tips");
                        UserWage = rs2.getDouble("mth_Wage");
                        
                        FldHours.setText(Integer.toString(UserHours));
                        FldTips.setText(Double.toString(UserTips));
                        FldWage.setText(Double.toString(UserWage));
                        
                    }
                    rs2.close();
                }
                rs1.close();
                DbCon.close();
            } 
            catch (SQLException ex) {
                Logger.getLogger(ShowEmp.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    
    }
    
    //print
    class Print implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            UIManager.put("OptionPane.messageFont", new Font("Arial",Font.PLAIN,20));
            UIManager.put("OptionPane.buttonFont", new Font("Arial",Font.PLAIN,20));
            JOptionPane.showMessageDialog(null, "The JTable is being processed to the printer");
            JOptionPane.showMessageDialog(null, "Cant connect to printer at this moment!");
        }
    
    }
    //Exit button
    class BtExit implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            UIManager.put("OptionPane.messageFont", new Font("Arial",Font.PLAIN,20));
            UIManager.put("OptionPane.buttonFont", new Font("Arial",Font.PLAIN,20));
            int Op2 = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit the Form?",""
                    + "Exit!",JOptionPane.YES_NO_OPTION);
           if(Op2 == JOptionPane.YES_OPTION) {
               dispose();
           } 
        }
    
    }
    //end of form
}
