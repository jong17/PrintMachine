/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package printmachine;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author alfarie
 */
public class ShirtPanel extends JPanel {
    private int PosX=150,PosY=150;
    private int width=640,height=360;
    ShirtPanel(){
        PosX = PosX * (int)MainFrame.Rw;
        PosY = PosY * (int)MainFrame.Rh;
        width = width * (int)MainFrame.Rw;
        height = height * (int)MainFrame.Rh;
        
        setPreferredSize(new Dimension(width,height));
        setBounds(PosX,PosY,width,height);
        //add(new JButton("sdfasdf"));
        repaint();
    }
     
    @Override
    public void paint(Graphics gr){
        gr.setColor(Color.white);
        gr.fillRect(0, 0, width, height);
    }
}
