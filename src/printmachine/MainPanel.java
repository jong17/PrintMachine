/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package printmachine;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author alfarie
 */
public class MainPanel extends JPanel{
    MainPanel(){
        setLayout(null);
        setPreferredSize(new Dimension((int)MainFrame.width,(int)MainFrame.height));
        setBounds(0, 0, (int)MainFrame.width, (int)(110*MainFrame.Rh));
        
    }
     
    
}
