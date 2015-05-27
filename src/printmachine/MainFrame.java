/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package printmachine;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JButton;
import javax.swing.JFrame;

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
        cPane.add(maPane);
        
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        //setSize(1000,1000);
        setUndecorated(true);
        setVisible(true);
    }
    
    
}
