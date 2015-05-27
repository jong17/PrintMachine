/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package printmachine;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JPanel;

/**
 *
 * @author alfarie
 */
public class StatusPanel extends JPanel{
    private int PosX=890,PosY=150;
    private int width=880,height=360;
    StatusPanel(){
        PosX = (int)(PosX * MainFrame.Rw);
        PosY = (int)(PosY * MainFrame.Rh);
        width = (int)(width * MainFrame.Rw);
        height = (int)(height * MainFrame.Rh);
        setPreferredSize(new Dimension(width,height));
        setBounds(PosX,PosY,width,height);
    }
    
    @Override
    public void paint(Graphics g){
        g.setColor(Color.white);
        g.fillRect(0, 0, width, height);
    }
}
