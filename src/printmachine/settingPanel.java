/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package printmachine;


import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JButton;
import javax.swing.JPanel;
/**
 *
 * @author alfarie
 */
public class settingPanel extends JPanel{
     static int width=1920,height=950;
     int PosX=0,PosY=130;
     settingPanel(){
        setLayout(null);
        PosX = (int)(PosX * MainFrame.Rw);
        PosY = (int)(PosY * MainFrame.Rh);
        width = (int)(width * MainFrame.Rw);
        height = (int)(height * MainFrame.Rh);
        setBounds(PosX,PosY,width,height);
        
     }
     
}
