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
    // constuctor
    MainFrame(){
        Container cPane = getContentPane();
        cPane.setLayout(null);
        screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        width = screenSize.getWidth();
        height = screenSize.getHeight();
        Rw = width /w ;
        Rh = height / h;
        
        
        MainPanel mPane = new MainPanel();
        ShirtPanel shPane = new ShirtPanel();
        StatusPanel stPane = new StatusPanel();
        MachinePanel maPane = new MachinePanel();
        cPane.add(mPane);
        cPane.add(shPane);
        cPane.add(stPane);
        cPane.add(maPane); // pane test aaaa
        
        
        
        
        
        //simState s = new simState();
        //s.st();
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        //setSize((int)width ,(int)height);
        setUndecorated(true);
        setVisible(true);
    }
   
   
}


