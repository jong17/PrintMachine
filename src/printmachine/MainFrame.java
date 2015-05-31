/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package printmachine;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
/**
 *
 * @author alfarie
 */
public class MainFrame extends JFrame{
    final Dimension screenSize;
    public static double width,height;
    final static int w = 1920;
    final static int h = 1080;
    static double Rw,Rh;
    Image background;
    MainPanel mPane;
    autoPanel auPane;
    
    MainFrame(){
        Container cPane = getContentPane();
        cPane.setLayout(null);
        screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        width = screenSize.getWidth();
        height = screenSize.getHeight();
        Rw = width /w ;
        Rh = height / h;
        
        mPane = new MainPanel(this);
        auPane = new autoPanel();
        
        add(mPane);
        add(auPane);
        setbg();
        
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        
        setUndecorated(true);
        setVisible(true);
    }
    
    private void setbg(){
        background = Toolkit.getDefaultToolkit().createImage("./src/printmachine/image/bg.png");
        background = background.getScaledInstance((int)(w*Rw), (int)(h*Rh), Image.SCALE_SMOOTH);
        JLabel l = new JLabel();
        ImageIcon icon = new ImageIcon(background); 
        l.setIcon(icon);
        l.setBounds(0, 0, (int)(w*Rw) , (int)(h*Rh));
        add(l);
    }
    public void setAll(){
        auPane.setVisible(true);
    }
    public void rmAll(){
        auPane.setVisible(false);
    }
}


