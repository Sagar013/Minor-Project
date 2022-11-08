/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mentor.system;

import java.awt.*;
import javax.swing.*;
import java.sql.*;
import java.awt.event.*;
import javax.swing.border.*;
import net.proteanit.sql.DbUtils;

public class FacultyDetails extends JFrame implements ActionListener{
    
    private JPanel contentPane;
    private JTable table;
    private JTextField search;
    private JButton b1, b2, b3;
    
    public void faculty(){
        try{
            Conn con = new Conn();
            String query = "select * from faculty;";
            PreparedStatement st = con.c.prepareStatement(query);
            ResultSet rs = st.executeQuery();
            
            table.setModel(DbUtils.resultSetToTableModel(rs));
            rs.close();
            st.close();
            con.c.close();
        }catch(Exception e){  }
    }
    
    public void searchFaculty(){
        try{
            Conn con = new Conn();
            String se = search.getText();
            String query = "select * from faculty where Department='"+se+"';";
            PreparedStatement st = con.c.prepareStatement(query);
            ResultSet rs = st.executeQuery();
            
            table.setModel(DbUtils.resultSetToTableModel(rs));
            rs.close();
            st.close();
            con.c.close();
        }catch(Exception e){  }
    }
    
    public FacultyDetails(){
        setBounds(350,200,930,475);
        contentPane = new JPanel();
        contentPane.setBackground(Color.WHITE);
        contentPane.setBorder(new EmptyBorder(5,5,5,5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(79,133,1080,282);
        contentPane.add(scrollPane);
        
        table = new JTable();
        
        table.setBackground(new Color(240,248,255));
        table.setForeground(Color.DARK_GRAY);
        table.setFont(new Font("Trebuchet MS", Font.BOLD,16));
        scrollPane.setViewportView(table);
        
        b1 = new JButton("Search");
        b1.addActionListener(this);
        b1.setBorder(new LineBorder(new Color(255,20,147),2,true));
        b1.setForeground(new Color(199,21,133));
        b1.setFont(new Font("Trebuchet MS",Font.BOLD,18));
        b1.setBounds(564,89,138,33);
        contentPane.add(b1);
        
        JLabel l1 = new JLabel("Search Faculty");
        l1.setForeground(new Color(107,142,35));
        l1.setFont(new Font("Trebuchet MS",Font.BOLD | Font.ITALIC,30));
        l1.setBounds(300,15,400,47);
        contentPane.add(l1);
        
        search = new JTextField();
        search.setBackground(new Color(255,240,245));
        search.setBorder(new LineBorder(new Color(255,105,180),2,true));
        search.setForeground(new Color(47,79,79));
        search.setFont(new Font("Trebuchet MS",Font.BOLD | Font.ITALIC,17));
        search.setBounds(189,89,357,33);
        contentPane.add(search);
        
        JLabel l2 = new JLabel("Back");
        l2.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                setVisible(false);
            }
        });
        l2.setForeground(Color.GRAY);
        l2.setFont(new Font("Trebuchet MS",Font.BOLD,18));
        l2.setBounds(97,89,72,33);
        contentPane.add(l2);
        
        JPanel panel = new JPanel();
        panel.setBorder(new TitledBorder(new LineBorder(new Color(0,128,128),3,true),"Faculty-Details",TitledBorder.LEADING,TitledBorder.TOP,null,new Color(0,128,0)));
        panel.setBounds(67,54,1100,368);
        contentPane.add(panel);
        panel.setBackground(Color.WHITE);
        faculty();
        setSize(1200,500);
        
    }
    
    public void actionPerformed(ActionEvent ae){
        try{
            Conn con = new Conn();
            if(ae.getSource() == b1){
                searchFaculty();
            }
        }catch(Exception e){ e.printStackTrace(); }
    }
    
    public static void main(String[] args){
        new FacultyDetails().setVisible(true);
    }
}
