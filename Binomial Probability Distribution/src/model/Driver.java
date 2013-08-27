package model;


import javax.swing.JFrame;
import javax.swing.JPanel;

public class Driver extends JFrame{
    
    JPanel MainUI = new JPanel();
    
    public Driver(){   
        this.setSize(465, 600);      
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.add(MainUI);
        this.setVisible(true); 
    }
    
    public void ChangePanel(JPanel Panel){
        this.repaint();
        this.remove(MainUI);
        this.MainUI = Panel;
        this.add(Panel);
        this.setVisible(true);      
    }
}
