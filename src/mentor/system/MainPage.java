/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mentor.system;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.*;

public class MainPage extends JFrame implements ActionListener{
    JPanel panel1;
    JLabel l2,l3;
    MainPage(){
        super("University of Petroleum and Energy Sciences");
        
        setSize(1920,1030);
        
        
        panel1 = new JPanel();
        setContentPane(panel1);
        //panel1.setSize(1900, 680);
        panel1.setLayout(null);
        panel1.setBackground(Color.WHITE);
        
        ImageIcon ic1 = new ImageIcon(ClassLoader.getSystemResource("mentor/system/Icons/Logo.jfif"));
        Image i4 = ic1.getImage().getScaledInstance(200, 100, Image.SCALE_DEFAULT); //950
        ImageIcon icc4 = new ImageIcon(i4);
        JLabel l2 = new JLabel(icc4);
        panel1.add(l2);
        
        l3 = new JLabel("  WELCOME TO UPES!                                                                                     ");
        l3.setForeground(new Color(107,142,35));
        l3.setFont(new Font("Trebuchet MS",Font.BOLD | Font.ITALIC,48));
        l3.setLocation(100, 100);
        panel1.add(l3);
        
        ImageIcon ic = new ImageIcon(ClassLoader.getSystemResource("mentor/system/Icons/First.jpg"));
        Image i3 = ic.getImage().getScaledInstance(1900, 680, Image.SCALE_DEFAULT); //950
        ImageIcon icc3 = new ImageIcon(i3);
        JLabel l1 = new JLabel(icc3);
        panel1.add(l1);
        //add(l1);
        
        JMenuBar mb = new JMenuBar();
        
        JMenu faculty = new JMenu("Faculty Details");
        JMenuItem u1 = new JMenuItem("Faculty");
        faculty.setForeground(Color.BLUE);
        u1.setFont(new Font("monospaced", Font.BOLD,16));
        u1.setMnemonic('A');
        u1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, ActionEvent.CTRL_MASK));
        u1.setBackground(Color.WHITE);
        
        u1.addActionListener(this);
        
        JMenu mentor = new JMenu("Mentor List");
        JMenuItem m1 = new JMenuItem("Major Project");
        JMenuItem m2 = new JMenuItem("Minor Project");
        mentor.setForeground(Color.red);
        
        m1.setFont(new Font("monospaced", Font.BOLD,16));
        m1.setMnemonic('B');
        m1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_M, ActionEvent.CTRL_MASK));
        m1.setBackground(Color.WHITE);
        
        m2.setFont(new Font("monospaced", Font.BOLD,16));
        m2.setMnemonic('C');
        m2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, ActionEvent.CTRL_MASK));
        m2.setBackground(Color.WHITE);
        
        m1.addActionListener(this);
        m2.addActionListener(this);
        
        JMenu exit = new JMenu("Exit");
        JMenuItem ex = new JMenuItem("Exit");
        exit.setForeground(Color.BLUE);
        ex.setFont(new Font("monospaced", Font.BOLD,16));
        ex.setMnemonic('D');
        ex.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, ActionEvent.CTRL_MASK));
        ex.setBackground(Color.WHITE);
        
        ex.addActionListener(this);
        faculty.add(u1);
        mentor.add(m1);
        mentor.add(m2);
        exit.add(ex);
        
        mb.add(faculty);
        mb.add(mentor);
        mb.add(exit);
        setJMenuBar(mb);
        
        setFont(new Font("Senserif", Font.BOLD,16));
        setLayout(new FlowLayout());
        setVisible(false);
    }
    
    public void actionPerformed(ActionEvent ae){
        String msg = ae.getActionCommand();
        if(msg.equals("Faculty")){
            new FacultyDetails().setVisible(true);
        }
        else if(msg.equals("Major Project")){
            new MentorMajor().setVisible(true);
        }
        else if(msg.equals("Minor Project")){
            new MentorMinor().setVisible(true);
        }
        else if(msg.equals("Exit")){
            System.exit(0);
        }
    }
}
