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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.Timer;
/**
 *
 * @author alfarie
 */
public class ShirtPanel extends JPanel implements Runnable{
    private int PosX=150,PosY=20;
    private int width=640,height=360;
    //private long frameRate = 500;
    public static int imagePos=0;
    public static int fps = 30; //เรียกจาก machine info
    private Timer timer;
    static long t=0,t_new,t_old=0; //ตัวแบรวาดรูบสกรีนเสื้อ
    ShirtPanel(){
        PosX = (int)(PosX * MainFrame.Rw);
        PosY = (int)(PosY * MainFrame.Rh);
        width = (int)(width * MainFrame.Rw);
        height = (int)(height * MainFrame.Rh);
        
        setPreferredSize(new Dimension(width,height));
        setBounds(PosX,PosY,width,height);
        try{ new Thread(this).start(); }catch(Exception e){}
        timer = new Timer(fps,new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) 
            {
                repaint();
            }
        });
        timer.setRepeats(true);
        timer.start();
        
    }
     
    @Override
    public void paint(Graphics g){
        g.setColor(Color.white);
        g.fillRect(0, 0, width, height);
        if(!machineInfo.workingMode){
            g.drawImage(machineInfo.shirtImage, (int)(((width/2)-machineInfo.shirtImage.getWidth(this)/2)*MainFrame.Rw), 0, (int)((width/2)+machineInfo.shirtImage.getWidth(this)/2), height, 0, 0, 305, 278, this);
        }else{
            drawShirtScreen(g);
            /*g.drawImage(machineInfo.shirtScreenImage, (int)(((width/2)-machineInfo.shirtScreenImage.getWidth(this)/2)*MainFrame.Rw), 0, (int)((width/2)+machineInfo.shirtScreenImage.getWidth(this)/2), height, 0, 0+imagePos, 305, 278+imagePos, this);
            imagePos+=278;
            if(imagePos>=1668) imagePos=0;*/
        }
        g.dispose();
    }

    @Override
    public void run() {

        /*while(true){
            repaint();
            try{ Thread.sleep(1000);}catch(Exception e){System.out.println(e.getStackTrace());}
        }*/
        
    }
    
    /*public void drawShirt(Graphics g){
        if(g==null){
            System.out.println("kdffjkf");
        }
        g.drawImage(shirtImage,(width/2)-shirtImage.getWidth(this)/2, 0, shirtImage.getWidth(this),height, this);
    }*/
    
   private void drawShirtScreen(Graphics g){
        g.drawImage(machineInfo.shirtScreenImage, (int)(((width/2)-machineInfo.shirtScreenImage.getWidth(this)/2)*MainFrame.Rw), 0, (int)((width/2)+machineInfo.shirtScreenImage.getWidth(this)/2), height, 0, 0+imagePos, 305, 278+imagePos, this);
        t_new = System.currentTimeMillis();
        if(t_old!=0)
            t += t_new - t_old;
        if(t>=(machineInfo.setSuccesShirtScreen()/machineInfo.numberShirtPicture)){  
            if(t_old==0) t=0;
            else{
                imagePos+=278;
                if(imagePos>=1668) imagePos=0;
                t=0;
            }
        }
        t_old = t_new;
    }
}
