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
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author alfarie
 */
public class MainPanel extends JPanel {
    MainPanel(){
        setLayout(null);
        setPreferredSize(new Dimension((int)MainFrame.width,(int)MainFrame.height));
        setBounds(0, 0, (int)MainFrame.width, 110*(int)MainFrame.Rh);
        
        
        
        
        ShirtPanel shPane = new ShirtPanel();
        add(shPane);
    }
    
    @Override
    public void paint(Graphics g){
        g.setColor(Color.white);
        g.fillRect(0, 0, (int) MainFrame.width, 110);
    }
    
}
