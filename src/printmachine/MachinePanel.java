/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package printmachine;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * null layout setting
 * @author alfarie
 */
public class MachinePanel extends JPanel  {
    private int PosX=100,PosY=550;
    private int width=1720,height=500;
    int i = 0;
    Image bg;
     headPrint head1 = new headPrint();
     headPrint head2 = new headPrint();
     module m = new module();
     module m2 = new module();
    
    MachinePanel(){
        setLayout(null);
        PosX = (int)(PosX * MainFrame.Rw);
        PosY = (int)(PosY * MainFrame.Rh);
        width = (int)(width * MainFrame.Rw);
        height = (int)(height * MainFrame.Rh);
        
        setBounds(PosX,PosY,width,height);
        
        add(new subMachinePanel1());
        add(new subMachinePanel2());
        setbg();
        
    }
    private void setbg(){
        bg = Toolkit.getDefaultToolkit().createImage(MainFrame.class.getResource("../src/bgMachine.png").getPath());
        bg = bg.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        JLabel l = new JLabel();
        ImageIcon icon = new ImageIcon(bg); 
        l.setIcon(icon);
        l.setBounds(0, 0, width, height);
        add(l);
    }
}

class subMachinePanel2 extends JComponent{
    private int PosX=0,PosY=300;
    private int width=1720,height=200;
    subButton start,skip,stop;
    subMachinePanel2(){
        setLayout(null);
        PosX = (int)(PosX * MainFrame.Rw);
        PosY = (int)(PosY * MainFrame.Rh);
        width = (int)(width * MainFrame.Rw);
        height = (int)(height * MainFrame.Rh);
        setBounds(PosX,PosY,width,height);
        
        start = new startButton(0,0);
        skip = new skipButton(750,0);
        stop = new stopButton(1520,0);
        add(start);
        add(skip);
        add(stop);
        int number =5;
        //new Thread(this).start();
    }
    
    class startButton extends subButton implements MouseListener {
        public startButton(int X, int Y) {
            super( X, Y);
            machineInfo.startButton1 = machineInfo.startButton1.getScaledInstance((int)(200*MainFrame.Rw), (int)(200*MainFrame.Rh),  Image.SCALE_SMOOTH);
            machineInfo.startButton2 = machineInfo.startButton2.getScaledInstance((int)(200*MainFrame.Rw), (int)(200*MainFrame.Rh),  Image.SCALE_SMOOTH);
            dIm = new ImageIcon(machineInfo.startButton1);
            cIm = new ImageIcon(machineInfo.startButton2);
            setIcon(dIm);
            addMouseListener(this);
        }
        @Override
        public void mouseClicked(MouseEvent me) {
            machineInfo.workingMode = true;
        }
        @Override
        public void mousePressed(MouseEvent me) {
            setIcon(cIm);
        }
        @Override
        public void mouseReleased(MouseEvent me) {
            setIcon(dIm);
        }
        @Override
        public void mouseEntered(MouseEvent me) {
            
        }
        @Override
        public void mouseExited(MouseEvent me) {
            
        }
    }
    class skipButton extends subButton implements MouseListener {
        public skipButton(int X, int Y) {
            super( X, Y);
            machineInfo.skipButton1 = machineInfo.skipButton1.getScaledInstance((int)(200*MainFrame.Rw), (int)(200*MainFrame.Rh),  Image.SCALE_SMOOTH);
            machineInfo.skipButton2 = machineInfo.skipButton2.getScaledInstance((int)(200*MainFrame.Rw), (int)(200*MainFrame.Rh),  Image.SCALE_SMOOTH);
            dIm = new ImageIcon(machineInfo.skipButton1);
            cIm = new ImageIcon(machineInfo.skipButton2);
            setIcon(dIm);
            addMouseListener(this);
        }
        @Override
        public void mouseClicked(MouseEvent me) {
            machineInfo.workingMode = true;
        }
        @Override
        public void mousePressed(MouseEvent me) {
            setIcon(cIm);
        }
        @Override
        public void mouseReleased(MouseEvent me) {
            setIcon(dIm);
        }
        @Override
        public void mouseEntered(MouseEvent me) {
            
        }
        @Override
        public void mouseExited(MouseEvent me) {
            
        }
    }
    
    class stopButton extends subButton implements MouseListener {
        public stopButton(int X, int Y) {
            super( X, Y);
            machineInfo.stopButton1 = machineInfo.stopButton1.getScaledInstance((int)(200*MainFrame.Rw), (int)(200*MainFrame.Rh),  Image.SCALE_SMOOTH);
            machineInfo.stopButton2 = machineInfo.stopButton2.getScaledInstance((int)(200*MainFrame.Rw), (int)(200*MainFrame.Rh),  Image.SCALE_SMOOTH);
            dIm = new ImageIcon(machineInfo.stopButton1);
            cIm = new ImageIcon(machineInfo.stopButton2);
            setIcon(dIm);
            addMouseListener(this);
        }
        @Override
        public void mouseClicked(MouseEvent me) {
            machineInfo.workingMode = false;
            ShirtPanel.imagePos = 0;
            ShirtPanel.t = 0;
            ShirtPanel.t_old = 0;
        }
        @Override
        public void mousePressed(MouseEvent me) {
            setIcon(cIm);
        }
        @Override
        public void mouseReleased(MouseEvent me) {
            setIcon(dIm);
        }
        @Override
        public void mouseEntered(MouseEvent me) {
            
        }
        @Override
        public void mouseExited(MouseEvent me) {
            
        }
    }
   
}


class subMachinePanel1 extends JComponent implements Runnable{
     private int PosX=0,PosY=0;
     private int width=1720,height=250;
     
    subMachinePanel1(){
        setLayout(new FlowLayout(FlowLayout.CENTER));
        PosX = (int)(PosX * MainFrame.Rw);
        PosY = (int)(PosY * MainFrame.Rh);
        width = (int)(width * MainFrame.Rw);
        height = (int)(height * MainFrame.Rh);
        
        setBounds(PosX,PosY,width,height);
        new Thread(this).start();
    }
    @Override
    public void run() {
        while(true){
            try{
                //System.out.println(machineInfo.headList.size());
                for(int i = 0,j=0; i < machineInfo.module.size() ;i++ ){
                    if(machineInfo.module.get(i) == 0){
                        add(machineInfo.headList.get(j++).getComponent());
                        add(machineInfo.headList.get(j++).getComponent());
                        add(machineInfo.headList.get(j++).getComponent());
                        addGap();
                    }
                    else if(machineInfo.module.get(i) == 1){
                        add(machineInfo.headList.get(j++).getComponent());
                        add(machineInfo.headList.get(j++).getComponent());
                        addGap();
                    }
                    else if(machineInfo.module.get(i) == 2){
                        add(machineInfo.headList.get(j++).getComponent());
                        add(machineInfo.headList.get(j++).getComponent());
                        add(machineInfo.headList.get(j++).getComponent());
                        addGap();
                    }
                    
                }
                validate();
                Thread.sleep(50);
            }catch(Exception e){}
            removeAll();
        }
    }
    
    private void addGap(){
        JLabel gap = new JLabel();
        gap.setPreferredSize(new Dimension(15,200));
        add(gap);
    }
    
}

class subButton extends JLabel{
     private int PosX,PosY;
     private int width=200,height=200;
     ImageIcon dIm,cIm;
    subButton(int X,int Y){
        super("staasdf");
        PosX = (int)(X * MainFrame.Rw);
        PosY = (int)(Y * MainFrame.Rh);
        width = (int)(width * MainFrame.Rw);
        height = (int)(height * MainFrame.Rh);
        
        setBounds(PosX,PosY,width,height);
    }
}




