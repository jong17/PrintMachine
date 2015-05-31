/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package printmachine;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import static printmachine.MainFrame.w;
/**
 *
 * @author alfarie
 */
public class autoPanel extends JPanel{
    private int PosX=0,PosY=130;
    private int width=1920,height=950;
    ShirtPanel shPane;
    StatusPanel stPane;
    MachinePanel maPane;
    Image background;
    autoPanel(){
        setLayout(null);
        PosX = (int)(PosX * MainFrame.Rw);
        PosY = (int)(PosY * MainFrame.Rh);
        width = (int)(width * MainFrame.Rw);
        height = (int)(height * MainFrame.Rh);
        System.out.println(PosY);
        setBounds(PosX,PosY,width,height);
        shPane = new ShirtPanel();
        stPane = new StatusPanel();
        maPane = new MachinePanel();
        add(maPane);
        add(shPane);
        add(stPane);
        setbg();
    }
    private void setbg(){
        background = Toolkit.getDefaultToolkit().createImage("./src/printmachine/image/bg.png");
        background = background.getScaledInstance((int)(width*MainFrame.Rw), (int)(height*MainFrame.Rh), Image.SCALE_SMOOTH);
        JLabel l = new JLabel();
        ImageIcon icon = new ImageIcon(background); 
        l.setIcon(icon);
        l.setBounds(0, 0, (int)(width*MainFrame.Rw) , (int)(height*MainFrame.Rh));
        add(l);
    }
    
}