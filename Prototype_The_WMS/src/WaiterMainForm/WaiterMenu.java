package WaiterMainForm;

import LoginFrames.LoginChoise;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.time.Duration;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

public class WaiterMenu extends JFrame{
    //Attributes
    private JPanel Pn1,Pn2,Pn3,Pn4,Pn5,Pn6;
    private Box Vert1,Hbox1,BTBoxS,BTBoxE;
    private JLabel LbTitle,LbWaiterName,LbTableNum,LbCaptureTips,LbTotalTips;
    private JComboBox WaiterBox; 
    private JComboBox<Integer>TableNumBox2;
    private JTextField FldTips,FldTotTips;
    private JTable Tbl1;
    private JScrollPane Scroll1;
    private Font LbFont,CBoxFont,FieldTipsFont;
    private JButton BtLogOutS,BtExit,BtNewMt,BtNewWk,BtNextCus,BtLogOut,BtLogOn;
    //private int [] WaiterIdTime = {1,2,3};
    private LocalTime start1;
    private LocalTime start2;
    private LocalTime start3;
    private LocalTime end1;
    private LocalTime end2;
    private LocalTime end3;
    
    public WaiterMenu() {
        //JFrame
        super("Waiter Menu");
        setSize(1300,600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLayout(new BorderLayout());
        
        //Jpanel
        Pn1 = new JPanel();
        Pn1.setBackground(Color.LIGHT_GRAY);
        
        Pn2 = new JPanel(new BorderLayout());
        Pn2.setBackground(Color.WHITE);
        
        Pn3 = new JPanel(new GridLayout(0,2,20,10));
        Pn3.setBackground(Color.WHITE);
        
        Pn4 = new JPanel();
        Pn4.setBackground(Color.WHITE);
        
        Pn5 = new JPanel();
        Pn5.setBackground(Color.DARK_GRAY);
        
        Pn6 = new JPanel();
        Pn6.setBackground(Color.DARK_GRAY);
        
        //Fonts
        LbFont = new Font("Arial",Font.BOLD,30);
        CBoxFont = new Font("Arial",Font.BOLD,25);
        FieldTipsFont = new Font("Arial",Font.BOLD,20);
        
        //Label
        LbTitle = new JLabel("Waiter Main Menu");
        LbTitle.setFont(LbFont);
        LbTitle.setForeground(Color.BLACK);

        LbWaiterName = new JLabel("Waiter Username:");
        LbWaiterName.setFont(LbFont);
        LbWaiterName.setForeground(Color.BLACK);
        
        LbTableNum = new JLabel("Table num:");
        LbTableNum.setFont(LbFont);
        LbTableNum.setForeground(Color.BLACK);
        
        LbCaptureTips = new JLabel("Tips of table to be captured");
        LbCaptureTips.setFont(LbFont);
        LbCaptureTips.setForeground(Color.BLACK);
        
        LbTotalTips = new JLabel("Total Tips of the night");
        LbTotalTips.setFont(LbFont);
        LbTotalTips.setForeground(Color.BLACK);
        
        //ComboBox
        
        WaiterBox = new JComboBox();
        WaiterBox.setFont(CBoxFont);
        WaiterBox.setBackground(Color.LIGHT_GRAY);
        WaiterBox.setForeground(Color.BLACK);

        String HostName = "localhost";
        String Db = "m.m.a.r.s";
        String UserName = "root";
        String Password = "RohaN@777!";
        String URL = "jdbc:mysql://"+HostName+":3306/"+Db;
        String WaiterList = null;
        
        try {
            Connection DbCon1 = DriverManager.getConnection(URL,UserName,Password);
            Statement Dbstat1 = DbCon1.createStatement();
            String Query1 = "SELECT w_Username FROM waiter";
            ResultSet rs1 = Dbstat1.executeQuery(Query1);
            
            while(rs1.next()) {
                WaiterList = rs1.getString("w_Username");
                WaiterBox.addItem(WaiterList); 
            }
            
           rs1.close();;
           DbCon1.close();
        } 
        catch (SQLException ex) {
            Logger.getLogger(WaiterMenu.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        //TableNumber
        int num = 1;
        TableNumBox2 = new JComboBox<>();
        TableNumBox2.setFont(CBoxFont);
        TableNumBox2.setBackground(Color.LIGHT_GRAY);
        TableNumBox2.setForeground(Color.BLACK);
        for(int x = 0; x< 20 ;x++) {
            TableNumBox2.addItem(num);
            num++;
        }
        
        //TextFields
        FldTips = new JTextField(10);
        FldTips.setFont(FieldTipsFont);
        FldTips.setBackground(Color.LIGHT_GRAY);
        FldTips.setForeground(Color.BLACK);
        
        FldTotTips = new JTextField(20);
        FldTotTips.setText("0"); 
        FldTotTips.setFont(FieldTipsFont);
        FldTotTips.setBackground(Color.LIGHT_GRAY);
        FldTotTips.setForeground(Color.BLACK);
        
        try {
            //JTabels
            Connection DbCon = DriverManager.getConnection(URL,UserName,Password);
            Tbl1= new JTable();
            Tbl1.setSize(800,500);
            Tbl1.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
            String [] colName = {"Total Tips per Table","Table Number",};
            
            DefaultTableModel model1 = new DefaultTableModel();
            model1.setColumnIdentifiers(colName);
            
            String QueryTbl = "SELECT * FROM tablecustomerpaid";
            PreparedStatement pdStat = DbCon.prepareStatement(QueryTbl);
            ResultSet rsTb = pdStat.executeQuery();
            
            while(rsTb.next()) {
                
                String A = rsTb.getString(1);
                String B = rsTb.getString(2);
                model1.addRow(new Object[]{A,B}); 
            }
            Tbl1.setModel(model1);
            Tbl1.setVisible(true); 
        } 
        catch (SQLException ex) {
            Logger.getLogger(WaiterMenu.class.getName()).log(Level.SEVERE, null, ex);
        }
        /*
        String [] colName = {"Table Number","Total Tips Per Table"};
        String [][] rows = {{" "," "},{" "," "},{" "," "},{" "," "},{" "," "}};
*/
        Font f = new Font("Arial",Font.BOLD, 30);

        UIManager.put("TableHeader.font", f);
        //Tbl1= new JTable(rows,colName);
        Tbl1.setPreferredScrollableViewportSize(new Dimension(500,110));
        
        Font f2 = new Font("Arial",Font.PLAIN, 25);
        Tbl1.setFont(f2);
         
        //ScrollPane
        Scroll1 = new JScrollPane(Tbl1);
        
        //Buttons
        BtLogOutS = new JButton("Logout of the system");
        BtLogOutS.setBackground(Color.ORANGE);
        BtLogOutS.setToolTipText("Click here to Log out of the System");
        BtLogOutS.setFont(new Font("Arial",Font.BOLD,25)); 
        BtLogOutS.addActionListener(new BTLogoutS());
        
        BtExit = new JButton("Exit");
        BtExit.setBackground(Color.RED);
        BtExit.setToolTipText("Click here to exit the System");
        BtExit.setFont(new Font("Arial",Font.BOLD,25)); 
        BtExit.addActionListener(new BTExit());
        
        BtNewMt = new JButton("Start new Month");
        BtNewMt.setBackground(Color.CYAN);
        BtNewMt.setToolTipText("Click here to start a new month for the waiter");
        BtNewMt.setFont(new Font("Arial",Font.BOLD,25)); 
        BtNewMt.addActionListener(new MonthBt()); 
        
        BtNewWk = new JButton("Start new Week");
        BtNewWk.setBackground(Color.CYAN);
        BtNewWk.setToolTipText("Click here to start a new week for the waiter");
        BtNewWk.setFont(new Font("Arial",Font.BOLD,25)); 
        BtNewWk.addActionListener(new WeekBt()); 
        
        BtNextCus = new JButton("Capture Customer Tip");
        BtNextCus.setBackground(Color.CYAN);
        BtNextCus.setToolTipText("Click here to capture tips of old client and reset tips for new client");
        BtNextCus.setFont(new Font("Arial",Font.BOLD,25)); 
        BtNextCus.addActionListener(new BtCapture());
        
        BtLogOut = new JButton("End Shift");
        BtLogOut.setBackground(Color.YELLOW);
        BtLogOut.setToolTipText("Click here capture end of shift");
        BtLogOut.setFont(new Font("Arial",Font.BOLD,25));
        BtLogOut.addActionListener(new EndShift()); 
        
        BtLogOn = new JButton("Begin Shift");
        BtLogOn.setBackground(Color.GREEN);
        BtLogOn.setToolTipText("Click here to capture the begining of the shift");
        BtLogOn.setFont(new Font("Arial",Font.BOLD,25)); 
        BtLogOn.addActionListener(new StartBt()); 
        
        
        //Adding to boxes
        //Hbox1
        
        Hbox1 = Box.createHorizontalBox();
        Hbox1.add(LbTotalTips);
        Hbox1.add(Box.createHorizontalStrut(30));
        Hbox1.add(FldTotTips);
        
        //BTBoxS
        BTBoxS = Box.createHorizontalBox();
        BTBoxS.add(Box.createHorizontalStrut(30));
        BTBoxS.add(BtLogOutS);
        BTBoxS.add(Box.createHorizontalStrut(20));
        BTBoxS.add(BtExit);
        
        //BTBoxE
        BTBoxE = Box.createVerticalBox();
        BTBoxE.add(Box.createVerticalStrut(10));
        BTBoxE.add(BtNextCus);
        BTBoxE.add(Box.createVerticalStrut(20));
        BTBoxE.add(BtNewMt);
        BTBoxE.add(Box.createVerticalStrut(20));
        BTBoxE.add(BtNewWk);
        BTBoxE.add(Box.createVerticalStrut(20));
        BTBoxE.add(BtLogOn);
        BTBoxE.add(Box.createVerticalStrut(20));
        BTBoxE.add(BtLogOut);
        
        
        
        //Vert1
        Vert1 = Box.createVerticalBox();
        Vert1.add(Box.createVerticalStrut(10));
        Vert1.add(Scroll1);
        Vert1.add(Box.createVerticalStrut(20));
        Vert1.add(Hbox1);
        
        //adding to panes
        //Panel1
        Pn1.add(LbTitle);
        
        //Panel3
        Pn3.add(LbWaiterName);
        Pn3.add(WaiterBox);
        Pn3.add(LbTableNum);
        Pn3.add(TableNumBox2);
        Pn3.add(LbCaptureTips);
        Pn3.add(FldTips);
        
        //Panel 4
        Pn4.add(Vert1);
        
        //Panel5
        Pn5.add(BTBoxE);
        
        //Panel6
        Pn6.add(BTBoxS);
        
        //Panel2
        Pn2.add(Pn3, BorderLayout.NORTH);
        Pn2.add(Pn4, BorderLayout.CENTER);
        
        //JFrame
        add(Pn1, BorderLayout.NORTH);
        add(Pn2, BorderLayout.CENTER);
        add(Pn5, BorderLayout.EAST);
        add(Pn6, BorderLayout.SOUTH);
        setVisible(false);
    }
    
    //Methods and event handlers
    
    //Capture new Customer tips
    class BtCapture implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
           String HostName = "localhost";
           String Db = "m.m.a.r.s";
           String UserName = "root";
           String Password = "RohaN@777!";
           String URL = "jdbc:mysql://"+HostName+":3306/"+Db;
           
           String SelectedUser = (String)WaiterBox.getSelectedItem();
           int TableNum1 = (int)TableNumBox2.getSelectedItem();
           int WaiterID =0;
           int TipsCap = Integer.parseInt(FldTips.getText());
           int TotTips = Integer.parseInt(FldTotTips.getText());
           int TipsWeek =0;
        
            try {
                Connection DbCon = DriverManager.getConnection(URL,UserName,Password);
                Statement DbStat2 = DbCon.createStatement();
                String Query2 = "SELECT w_ID FROM waiter WHERE w_Username='"+SelectedUser+"'";
                ResultSet rs2 = DbStat2.executeQuery(Query2);
                
                if(rs2.next()) {
                    WaiterID =WaiterID + rs2.getInt("w_ID");
                    Statement DbStat3 = DbCon.createStatement();
                    String Query3 = "UPDATE tablecustomerpaid SET Table_Tips ='"+TipsCap+"'"
                            + " WHERE Table_Num='"+TableNum1+"'";
                    DbStat3.executeUpdate(Query3);
                
                    Statement DbStat4 = DbCon.createStatement();
                    String Query4 = "SELECT w_TotalTips FROM waitertable WHERE w_ID='"+WaiterID+"'";
                    ResultSet rs4 = DbStat4.executeQuery(Query4);
                    
                    if(rs4.next()) {
                        
                        TotTips = TotTips + rs4.getInt("w_TotalTips");
                        Statement DbStat5 = DbCon.createStatement();
                        String Query5 = "UPDATE waitertable SET w_TotalTips='"+TipsCap+"' "
                                + "WHERE Table_Num='"+TableNum1+"'";
                        DbStat5.executeUpdate(Query5);
                        
                        TotTips = TotTips + TipsCap;
                        String TotTxt = Integer.toString(TotTips);
                        FldTotTips.setText(TotTxt);
                    }
                    
                    Statement DbStat6 = DbCon.createStatement();
                    String Query6 = "SELECT wk_Tips FROM weekly WHERE w_ID='"+WaiterID+"'";
                    ResultSet rs6 = DbStat6.executeQuery(Query6);
                    
                    while(rs6.next()) {
                        TipsWeek = TipsWeek + rs6.getInt("wk_Tips");
                        
                    
                    
                    Statement DbStat7 = DbCon.createStatement();
                    String Query7 = "UPDATE weekly SET wk_Tips='"+TipsWeek+"' WHERE w_ID='"+WaiterID+"'";
                    DbStat7.executeUpdate(Query7);
                    rs4.close();
                    rs2.close();
                    }
                    
                }
                
                DbCon.close();
            }
            catch (SQLException ex) {
                Logger.getLogger(WaiterMenu.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    //Month bt
    class MonthBt implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
           String HostName = "localhost";
           String Db = "m.m.a.r.s";
           String UserName = "root";
           String Password = "RohaN@777!";
           String URL = "jdbc:mysql://"+HostName+":3306/"+Db;
           
           String SelectedUser = (String)WaiterBox.getSelectedItem();
           int WaiterID =0;
           
            try {
                Connection DbCon = DriverManager.getConnection(URL,UserName,Password);
                Statement DbStat2 = DbCon.createStatement();
                String Query2 = "SELECT w_ID FROM waiter WHERE w_Username='"+SelectedUser+"'";
                ResultSet rs2 = DbStat2.executeQuery(Query2);
                
                 if(rs2.next()) {
                    WaiterID =WaiterID + rs2.getInt("w_ID");
                    Statement DbStat3 = DbCon.createStatement();
                    String Query3 = "UPDATE monthly SET mth_Hours='0', mth_Tips='0' WHERE w_ID='"+WaiterID+"'";
                    DbStat3.executeUpdate(Query3);
                 }
                 rs2.close();
                 DbCon.close();
            } 
            catch (SQLException ex) {
                Logger.getLogger(WaiterMenu.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    //Weekly
    class WeekBt implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
           String HostName = "localhost";
           String Db = "m.m.a.r.s";
           String UserName = "root";
           String Password = "RohaN@777!";
           String URL = "jdbc:mysql://"+HostName+":3306/"+Db;
           
           String SelectedUser = (String)WaiterBox.getSelectedItem();
           int WaiterID =0;
           
            try {
                Connection DbCon = DriverManager.getConnection(URL,UserName,Password);
                Statement DbStat2 = DbCon.createStatement();
                String Query2 = "SELECT w_ID FROM waiter WHERE w_Username='"+SelectedUser+"'";
                ResultSet rs2 = DbStat2.executeQuery(Query2);
                
                 if(rs2.next()) {
                    WaiterID =WaiterID + rs2.getInt("w_ID");
                    Statement DbStat3 = DbCon.createStatement();
                    String Query3 = "UPDATE weekly SET wk_Hours='0', wk_Tips='0' WHERE w_ID='"+WaiterID+"'";
                    DbStat3.executeUpdate(Query3);
                 }
                 rs2.close();
                 DbCon.close();
            } 
            catch (SQLException ex) {
                Logger.getLogger(WaiterMenu.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    
    
    }
    
    //Start Shift button
    class StartBt implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
           String HostName = "localhost";
           String Db = "m.m.a.r.s";
           String UserName = "root";
           String Password = "RohaN@777!";
           String URL = "jdbc:mysql://"+HostName+":3306/"+Db;
           
           String SelectedUser = (String)WaiterBox.getSelectedItem();
           int WaiterID =0;
           
            try {
                Connection DbCon = DriverManager.getConnection(URL,UserName,Password);
                Statement DbStat2 = DbCon.createStatement();
                String Query2 = "SELECT w_ID FROM waiter WHERE w_Username='"+SelectedUser+"'";
                ResultSet rs2 = DbStat2.executeQuery(Query2);
                
                if(rs2.next()) {
                    WaiterID =WaiterID + rs2.getInt("w_ID");
                    
                    if(WaiterID == 1) {
                        start1 = LocalTime.now();
                    }
                    
                    else if(WaiterID == 2) {
                        start2 = LocalTime.now();
                    }
                    
                    else if(WaiterID == 3) {
                        start3 = LocalTime.now();
                    }
                }
                
            } 
            catch (SQLException ex) {
                Logger.getLogger(WaiterMenu.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    //End Shift
    class EndShift implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
           String HostName = "localhost";
           String Db = "m.m.a.r.s";
           String UserName = "root";
           String Password = "RohaN@777!";
           String URL = "jdbc:mysql://"+HostName+":3306/"+Db;
           
           String SelectedUser = (String)WaiterBox.getSelectedItem();
           int WaiterID =0;
           int timeWk = 0;
           int timeMth = 0;
           
            try {
                Connection DbCon = DriverManager.getConnection(URL,UserName,Password);
                Statement DbStat2 = DbCon.createStatement();
                String Query2 = "SELECT w_ID FROM waiter WHERE w_Username='"+SelectedUser+"'";
                ResultSet rs2 = DbStat2.executeQuery(Query2);
                
                if(rs2.next()) {
                    WaiterID =WaiterID + rs2.getInt("w_ID");
                    
                    if(WaiterID == 1) {
                        end1 = LocalTime.now();
                        int elapsed = (int) Duration.between(start1, end1).toHours();
                        
                        
                        
                        //Weekly
                        Statement DbStat3 = DbCon.createStatement();
                        String Query3 = "SELECT wk_Hours FROM weekly WHERE w_ID='"+WaiterID+"'";
                        ResultSet rs3 = DbStat3.executeQuery(Query3);
                        while(rs3.next()) {
                            timeWk = timeWk + rs3.getInt("wk_Hours");
                            timeWk = timeWk+ elapsed;
                        }
                        Statement DbStat4 = DbCon.createStatement();
                        String Query4 = "UPDATE weekly SET wk_Hours='"+timeWk+"' WHERE w_ID='"+WaiterID+"'";
                        DbStat4.executeUpdate(Query4);
                        
                        //monthly
                        Statement DbStat5 = DbCon.createStatement();
                        String Query5 = "SELECT mth_Hours FROM monthly WHERE w_ID='"+WaiterID+"'";
                        ResultSet rs5 = DbStat5.executeQuery(Query5);
                        while(rs5.next()) {
                            timeMth = timeMth + rs3.getInt("wk_Hours");
                            timeMth = timeMth+ elapsed;
                        }
                        Statement DbStat6 = DbCon.createStatement();
                        String Query6 = "UPDATE monthly SET mth_Hours='"+timeMth+"' WHERE w_ID='"+WaiterID+"'";
                        DbStat6.executeUpdate(Query6);
                        
                        rs3.close();
                        rs5.close();
                        
                    }
                    
                    else if(WaiterID == 2) {
                        end2 = LocalTime.now();
                        int elapsed = (int) Duration.between(start2, end2).toHours();
                        
                        //Weekly
                        Statement DbStat3 = DbCon.createStatement();
                        String Query3 = "SELECT wk_Hours FROM weekly WHERE w_ID='"+WaiterID+"'";
                        ResultSet rs3 = DbStat3.executeQuery(Query3);
                        while(rs3.next()) {
                            timeWk = timeWk + rs3.getInt("wk_Hours");
                            timeWk = timeWk+ elapsed;
                        }
                        Statement DbStat4 = DbCon.createStatement();
                        String Query4 = "UPDATE weekly SET wk_Hours='"+timeWk+"' WHERE w_ID='"+WaiterID+"'";
                        DbStat4.executeUpdate(Query4);
                        
                        //monthly
                        Statement DbStat5 = DbCon.createStatement();
                        String Query5 = "SELECT mth_Hours FROM monthly WHERE w_ID='"+WaiterID+"'";
                        ResultSet rs5 = DbStat5.executeQuery(Query5);
                        while(rs5.next()) {
                            timeMth = timeMth + rs3.getInt("wk_Hours");
                            timeMth = timeMth+ elapsed;
                        }
                        Statement DbStat6 = DbCon.createStatement();
                        String Query6 = "UPDATE monthly SET mth_Hours='"+timeMth+"' WHERE w_ID='"+WaiterID+"'";
                        DbStat6.executeUpdate(Query6);
                        rs3.close();
                        rs5.close();
                    }
                    
                    else if(WaiterID == 3) {
                        end3 = LocalTime.now();
                        int elapsed = (int) Duration.between(start3, end3).toHours();
                       
                        //Weekly
                        Statement DbStat3 = DbCon.createStatement();
                        String Query3 = "SELECT wk_Hours FROM weekly WHERE w_ID='"+WaiterID+"'";
                        ResultSet rs3 = DbStat3.executeQuery(Query3);
                        while(rs3.next()) {
                            timeWk = timeWk + rs3.getInt("wk_Hours");
                            timeWk = timeWk+ elapsed;
                        }
                        Statement DbStat4 = DbCon.createStatement();
                        String Query4 = "UPDATE weekly SET wk_Hours='"+timeWk+"' WHERE w_ID='"+WaiterID+"'";
                        DbStat4.executeUpdate(Query4);
                        
                        //monthly
                        Statement DbStat5 = DbCon.createStatement();
                        String Query5 = "SELECT mth_Hours FROM monthly WHERE w_ID='"+WaiterID+"'";
                        ResultSet rs5 = DbStat5.executeQuery(Query5);
                        while(rs5.next()) {
                            timeMth = timeMth + rs3.getInt("wk_Hours");
                            timeMth = timeMth+ elapsed;
                        }
                        Statement DbStat6 = DbCon.createStatement();
                        String Query6 = "UPDATE monthly SET mth_Hours='"+timeMth+"' WHERE w_ID='"+WaiterID+"'";
                        DbStat6.executeUpdate(Query6);
                        
                        rs3.close();
                        rs5.close();
                    }
                    
                }
               
                rs2.close();
            } 
            catch (SQLException ex) {
                Logger.getLogger(WaiterMenu.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    //Logout of system Button
    class BTLogoutS implements ActionListener {

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
    //Exit Button
    class BTExit implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            UIManager.put("OptionPane.messageFont", new Font("Arial",Font.PLAIN,20));
            UIManager.put("OptionPane.buttonFont", new Font("Arial",Font.PLAIN,20));
            int Op1 = JOptionPane.showConfirmDialog(null, "Are you sure you want to Exit?",""
                    + "Exit!",JOptionPane.YES_NO_OPTION);
            if(Op1 == JOptionPane.YES_OPTION) {
                
                System.exit(0);
            }
        }
    }
    //end of form
    
}
