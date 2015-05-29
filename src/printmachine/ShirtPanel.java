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
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author alfarie
 */
public class ShirtPanel extends JPanel implements Runnable{
    private int PosX=150,PosY=150;
    private int width=640,height=360;
    private long frameRate = 500;
    private String shirtImageURL;
    private Image shirtImage;
    private int imagePos=0;
    int i=0;
    ShirtPanel(){
        PosX = (int)(PosX * MainFrame.Rw);
        PosY = (int)(PosY * MainFrame.Rh);
        width = (int)(width * MainFrame.Rw);
        height = (int)(height * MainFrame.Rh);
        setPreferredSize(new Dimension(width,height));
        setBounds(PosX,PosY,width,height);
        /*shirtImageURL = ShirtPanel.class.getResource("../shirtImage/shirtScreen.png").getPath();
        shirtImage = Toolkit.getDefaultToolkit().getImage(shirtImageURL);
        setPreferredSize(new Dimension(width,height));
        setBounds(PosX,PosY,width,height);
       try{ new Thread(this).start();}catch(Exception e){}*/
        repaint();
        new Thread(this).start();
        
        
    }
     
    @Override
    public void paint(Graphics gr){
        gr.setColor(Color.white);
        gr.fillRect(0, 0, width, height);
       /* gr.drawImage(shirtImage, (width/2)-shirtImage.getWidth(this)/2, 0, (width/2)+shirtImage.getWidth(this)/2, height, 0, 0+imagePos, 305, 278+imagePos, this);
        imagePos+=278;
        if(imagePos>=1668) imagePos=0;*/
        gr.dispose();
    }

    @Override
    public void run() {
        while(true){
            repaint();
            try{ Thread.sleep(100);}catch(Exception e){System.out.println(e.getStackTrace());}
        }
    }
}
