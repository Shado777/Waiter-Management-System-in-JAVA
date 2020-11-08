package LoginFrames;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class LoginChoise extends JFrame{
    //Attributes
    private JPanel Pn1,Pn2, Pn3;
    private JLabel Lb1,Lb2,Lb3;
    private JButton Bt1,Bt2;
    private Box Hor1,Hor2,Hor3,Vert1,Vert2;
    private Icon MMARS;
    //Constructor
    public LoginChoise() {
        //JFrame container
        super("Login Choice");
        setSize(1300,800);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //Initializing and editing Panel
        Pn1 = new JPanel();
        Pn1.setBackground(Color.WHITE);
        
        Pn2 = new JPanel();
        Pn2.setBackground(Color.WHITE);
        
        Pn3 = new JPanel();
        Pn3.setBackground(Color.DARK_GRAY);
        
        //Initializing and editing Labels
        
        //Burger Icon
        ClassLoader loader = this.getClass().getClassLoader();
        java.net.URL imageUrl = loader.getResource("Logo1.jpg");
        MMARS = new ImageIcon(imageUrl);
        Lb3 = new JLabel(MMARS);
        
        //Label Font
        Font lFont = new Font("arial", Font.ITALIC, 30);
        
        //Label1
        Lb1 = new JLabel("Welcome to M.M.A.R.S Burgers App");
        Lb1.setFont(lFont);
        Lb1.setForeground(Color.BLACK);
        
        //Label2
        Lb2 = new JLabel("To choose login type click on one of the buttons");
        Lb2.setFont(lFont);
        Lb2.setForeground(Color.BLACK);
        
        //Initializing and editing Buttons
        //Button Font
        Font BFont = new Font("arial", Font.BOLD, 25);
        
        //Button1
        Bt1 = new JButton("Manager");
        Bt1.setBackground(Color.GREEN);
        Bt1.setForeground(Color.BLACK);
        Bt1.setFont(BFont);
        Bt1.setToolTipText("Click here for manager login");
        Bt1.addActionListener(new ManagerChoise());
        
        //Button2
        Bt2 = new JButton("Waiter");
        Bt2.setBackground(Color.CYAN);
        Bt2.setForeground(Color.BLACK);
        Bt2.setFont(BFont);
        Bt2.setToolTipText("Click here for waiter login");
        Bt2.addActionListener(new WaiterChoise());
        
        //Initializing and editing BoxLayout
        //Horizontal Box
        Hor1 = Box.createHorizontalBox();
        Hor1.add(Box.createHorizontalStrut(15));
        Hor1.add(Bt1);
        Hor1.add(Box.createHorizontalStrut(20));
        Hor1.add(Bt2);
        
        //Hor2
        Hor2 = Box.createHorizontalBox();
        Hor2.add(Box.createHorizontalStrut(10));
        Hor2.add(Lb1);
        Hor2.add(Box.createHorizontalStrut(10));
        
        //Hor3
        Hor3 = Box.createHorizontalBox();
        Hor3.add(Box.createHorizontalStrut(10));
        Hor3.add(Lb2);
        Hor3.add(Box.createHorizontalStrut(10));
        
        //Vertical Box
        Vert1 = Box.createVerticalBox();
        Vert1.add(Hor2);
        Vert1.add(Box.createVerticalStrut(10));
        Vert1.add(Hor3);
        Vert1.add(Box.createVerticalStrut(10));
        
        Vert2 = Box.createHorizontalBox();
        Vert2.add(Box.createHorizontalStrut(5));
        Vert2.add(Lb3);
        Vert2.add(Box.createHorizontalStrut(5));
        
        //Panel Finalizer
        Pn1.add(Vert1);
        Pn2.add(Vert2);
        Pn3.add(Hor1);
        
        //JFrame container finalising
        add(Pn1, BorderLayout.NORTH);
        add(Pn2, BorderLayout.CENTER);
        add(Pn3, BorderLayout.SOUTH);
        pack();
        setVisible(true);
    }
    
    //Methods and event handlers
    
    //Choosing Manager
    class ManagerChoise implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            ManagerLogin Login1= new ManagerLogin();
            Login1.setVisible(true);
            dispose();
        }
    }
    
    //Choosing Waiter
    class WaiterChoise implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            WaiterLogin Login2 = new WaiterLogin();
            Login2.setVisible(true);
            dispose();
        }
    }
    //end of form
}
