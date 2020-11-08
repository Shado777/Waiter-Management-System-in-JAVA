package ManagerMainForm;

import LoginFrames.*;
import ManagerialChoises.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ManagerMainPageForm extends JFrame{
    
    //Attributes
    private Box Hor1, Hor2, Hor3, Hor4,HorIcon, Vert1, Vertp2;
    private JPanel Pn1, Pn2,Pn3;
    private JLabel Lb1,Lb2,Lb3, LbTitle, LbIcon;
    private JButton Bt1,Bt2,Bt3,Bt4,BtShow;
    private Icon MMARS;
    
    //Constructor
    public ManagerMainPageForm() {
        //JFrame
        super("Manager Main Page");
        setSize(1000,1000);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        
        //Panel1
        Pn1 = new JPanel();
        Pn1.setBackground(Color.LIGHT_GRAY);
        
        Pn2 = new JPanel();
        Pn2.setBackground(Color.WHITE);
        
        Pn3 = new JPanel();
        Pn3.setBackground(Color.DARK_GRAY);
        
        //Labels
        LbTitle = new JLabel("Manager Main Menu");
        LbTitle .setFont(new Font("Arial",Font.BOLD,30));
        LbTitle .setForeground(Color.BLACK);
        
        //Icon for label
        ClassLoader loader = this.getClass().getClassLoader();
        java.net.URL imageUrl = loader.getResource("Logo2.jpg");
        MMARS = new ImageIcon(imageUrl);
        //Labels
        LbIcon = new JLabel(MMARS);
        
        Lb1 = new JLabel("Click here to Insert an Employee: ");
        Lb1.setFont(new Font("Arial",Font.BOLD,30));
        Lb1.setForeground(Color.BLACK);
        
        Lb2 = new JLabel("Click here to Delete an Employee: ");
        Lb2.setFont(new Font("Arial",Font.BOLD,30));
        Lb2.setForeground(Color.BLACK);
        
        Lb3 = new JLabel("Click here to Show an Employee report: ");
        Lb3.setFont(new Font("Arial",Font.BOLD,30));
        Lb3.setForeground(Color.BLACK);
        
        //Buttons
        Bt1 = new JButton("Insert Employee");     
        Bt1.setFont(new Font("Arial", Font.BOLD, 25));
        Bt1.setBackground(Color.CYAN);
        Bt1.setForeground(Color.BLACK);
        Bt1.setToolTipText("By Clicking this button a"
                           + " new form will open to enter a "
                            + "desired waiter or manager");
        Bt1.addActionListener(new InsertBt());
        
        BtShow = new JButton("Show Employee ");;
        BtShow.setFont(new Font("Arial", Font.BOLD, 25));
        BtShow.setBackground(Color.CYAN);
        BtShow.setForeground(Color.BLACK);
        BtShow.setToolTipText("By Clicking this button a"
                           + " new form will open to see a "
                            + "desired waiter or manager stats");
        BtShow.addActionListener(new showEmp());
        
        Bt2 = new JButton("Delete Employee");
        Bt2.setFont(new Font("Arial", Font.BOLD, 25));
        Bt2.setBackground(Color.CYAN);
        Bt2.setForeground(Color.BLACK);
        Bt2.setToolTipText("By Clicking this button a"
                           + " new form will open to delete a "
                            + "desired waiter or manager");
        Bt2.addActionListener(new DeleteBt());
        
        Bt3 = new JButton("Loging Out");
        Bt3.setFont(new Font("Arial", Font.BOLD, 25));
        Bt3.setBackground(Color.ORANGE);
        Bt3.setForeground(Color.BLACK);
        Bt3.setToolTipText("Click here to Log out and returning to Login Choise");
        Bt3.addActionListener(new LogOutBt());
        
        Bt4 = new JButton("Exit");
        Bt4.setFont(new Font("Arial", Font.BOLD, 25));
        Bt4.setBackground(Color.RED);
        Bt4.setForeground(Color.BLACK);
        Bt4.setToolTipText("Click here to exit program");
        Bt4.addActionListener(new ExitBt());
        
        //Boxes
        Hor1 = Box.createHorizontalBox();
        Hor1.add(Box.createHorizontalStrut(2));
        Hor1.add(Lb1);
        Hor1.add(Box.createHorizontalStrut(180));
        Hor1.add(Bt1);
        
        Hor2 = Box.createHorizontalBox();
        Hor2.add(Box.createHorizontalStrut(6));
        Hor2.add(Lb2);
        Hor2.add(Box.createHorizontalStrut(171));
        Hor2.add(Bt2);
        
        Hor4 = Box.createHorizontalBox();
        Hor4.add(Box.createHorizontalStrut(4));
        Hor4.add(Lb3);
        Hor4.add(Box.createHorizontalStrut(86));
        Hor4.add(BtShow);
        
        HorIcon = Box.createHorizontalBox();
        HorIcon.add(Box.createHorizontalStrut(20));
        HorIcon.add(LbIcon);
        
        
        Hor3 = Box.createHorizontalBox();
        Hor3.add(Box.createHorizontalStrut(20));
        Hor3.add(Bt3);
        Hor3.add(Box.createHorizontalStrut(10));
        Hor3.add(Bt4);
        
        //Vert1
        Vert1 = Box.createVerticalBox();
        Vert1.add(Hor1);
        Vert1.add(Hor2);
        Vert1.add(Hor4);
        
        //Vertp2
        Vertp2 = Box.createVerticalBox();
        Vertp2.add(HorIcon);
        Vertp2.add(Vert1);
        
        //adding panel
        //Pane1
        Pn1.add(LbTitle);
        
        //Pane2
        Pn2.add(Vertp2);
        
        //Pane3
        Pn3.add(Hor3);
        
        //Jframe
        add(Pn1, BorderLayout.NORTH);
        add(Pn2, BorderLayout.CENTER);
        add(Pn3, BorderLayout.SOUTH);
        pack();
        setVisible(false);
    }
    
    //methods and Eventhandlers
    
    //Button for insert button
    class InsertBt implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            InsertForm InEmpFrame = new InsertForm();
            InEmpFrame.setVisible(true);
            dispose();
        }
    }
    //Button to delete employee
    class DeleteBt implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            DeleteEmployee delEmpFrame = new DeleteEmployee();
            delEmpFrame.setVisible(true);
            dispose();
        }
    }
    //Button for loging out and return to login page
    class LogOutBt implements ActionListener {

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
    //Btton to show stats
    class showEmp implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            NewShowEmployee EmpRFrame = new NewShowEmployee();
            EmpRFrame.setVisible(true);
            dispose();
        }
    
    }
    //Button for exiting program
    class ExitBt implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            UIManager.put("OptionPane.messageFont", new Font("Arial",Font.PLAIN,20));
            UIManager.put("OptionPane.buttonFont", new Font("Arial",Font.PLAIN,20));
            int Op2 = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit the program?",""
                    + "Exit!",JOptionPane.YES_NO_OPTION);
           if(Op2 == JOptionPane.YES_OPTION) {
               System.exit(0);
           } 
        }
    }
    //end of form
}
