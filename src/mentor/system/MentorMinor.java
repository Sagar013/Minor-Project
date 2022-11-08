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


public class MentorMinor extends JFrame{
    private final JPanel contentPane;
    private final JTable table;
    
    public void mentors(){
        try{
            Conn con = new Conn();
            String query = "select * from minor_project;";
            PreparedStatement st = con.c.prepareStatement(query);
            ResultSet rs = st.executeQuery();
            
            table.setModel(DbUtils.resultSetToTableModel(rs));
            rs.close();
            st.close();
            con.c.close();
        }catch(Exception e){  }
    }
    
    public MentorMinor(){
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
      
        
        JLabel l1 = new JLabel("Mentors For Project");
        l1.setForeground(new Color(107,142,35));
        l1.setFont(new Font("Trebuchet MS",Font.BOLD | Font.ITALIC,30));
        l1.setBounds(300,15,400,47);
        contentPane.add(l1);
        
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
        panel.setBorder(new TitledBorder(new LineBorder(new Color(0,128,128),3,true),"Minor-Project",TitledBorder.LEADING,TitledBorder.TOP,null,new Color(0,128,0)));
        panel.setBounds(67,54,1100,368);
        contentPane.add(panel);
        panel.setBackground(Color.WHITE);
        mentors();
        setSize(1200,500);
        
    }
    
    public static void main(String[] args){
        new MentorMinor().setVisible(true);
    }
}
