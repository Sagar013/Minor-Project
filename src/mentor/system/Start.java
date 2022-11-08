/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mentor.system;

import java.awt.*;
import javax.swing.*;
public class Start {
    public static void main(String s[]){
        Frame f = new Frame("Mentor Management System");
        f.setVisible(true);
        int x=1;
        for(int i=2; i<=600; i+=4, x++){
            f.setLocation((800-((i+x)/2)),500-(i/2));
            f.setSize(i+3*x,i+x/2);
            
            try{
                Thread.sleep(7);
            }catch(InterruptedException e){
                
            }
        }
    }
}

class Frame extends JFrame implements Runnable{
    Thread t1;
    Frame(String s){
        super(s);
        setLayout(new FlowLayout());
        ImageIcon c1 = new ImageIcon(ClassLoader.getSystemResource("mentor/system/Icons/First.jpg"));
        Image i1 = c1.getImage().getScaledInstance(1000, 700, Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i1);
        
        JLabel m1 = new JLabel(i2);
        add(m1);
        t1 = new Thread(this);
        t1.start();
    }
    public void run(){
        try{
            Thread.sleep(3000);
            this.setVisible(false);
            Login f1 = new Login();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
