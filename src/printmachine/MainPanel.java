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
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author alfarie
 */
public class MainPanel extends JPanel{
    private int PosX=0,PosY=0;
    private int width=(int)MainFrame.width,height=130;
    autoPanel auPane;
    MainFrame Main;
    MainPanel(MainFrame M){
        Main = M;
        setLayout(null);
        PosX = (int)(PosX * MainFrame.Rw);
        PosY = (int)(PosY * MainFrame.Rh);
        width = (int)(width * MainFrame.Rw);
        height = (int)(height * MainFrame.Rh);
        add(new infoButton());
        add(new autoButton());
        add(new settingButton());
        setBounds(PosX , PosY, width, height);
    }
    class infoButton extends JLabel implements MouseListener{
    private int PosX=0,PosY=0;
    private int width=300,height=130;
    ImageIcon dIm,cIm;
    infoButton(){
            machineInfo.infoButton1 = machineInfo.infoButton1.getScaledInstance((int)(width*MainFrame.Rw), (int)(height*MainFrame.Rh),  Image.SCALE_SMOOTH);
            machineInfo.infoButton2 = machineInfo.infoButton2.getScaledInstance((int)(width*MainFrame.Rw), (int)(height*MainFrame.Rh),  Image.SCALE_SMOOTH);
            dIm = new ImageIcon(machineInfo.infoButton1);
            cIm = new ImageIcon(machineInfo.infoButton2);
            PosX = (int)(PosX * MainFrame.Rw);
            PosY = (int)(PosY * MainFrame.Rh);
            width = (int)(width * MainFrame.Rw);
            height = (int)(height * MainFrame.Rh);
            setBounds(PosX,PosY,width,height);
            setIcon(dIm);
            addMouseListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent me) {
        System.out.println("start");
        Main.rmAll();
       
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
class autoButton extends JLabel implements MouseListener{
    private int PosX=300,PosY=0;
    private int width=300,height=130;
    ImageIcon dIm,cIm;
    
    autoButton(){
            machineInfo.autoButton1 = machineInfo.autoButton1.getScaledInstance((int)(width*MainFrame.Rw), (int)(height*MainFrame.Rh),  Image.SCALE_SMOOTH);
            machineInfo.autoButton2 = machineInfo.autoButton2.getScaledInstance((int)(width*MainFrame.Rw), (int)(height*MainFrame.Rh),  Image.SCALE_SMOOTH);
            dIm = new ImageIcon(machineInfo.autoButton1);
            cIm = new ImageIcon(machineInfo.autoButton2);
            PosX = (int)(PosX * MainFrame.Rw);
            PosY = (int)(PosY * MainFrame.Rh);
            width = (int)(width * MainFrame.Rw);
            height = (int)(height * MainFrame.Rh);
            setBounds(PosX,PosY,width,height);
            setIcon(dIm);
            addMouseListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent me) {
        Main.setAll();
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
class settingButton extends JLabel implements MouseListener{
    private int PosX=600,PosY=0;
    private int width=300,height=130;
    ImageIcon dIm,cIm;
    settingButton(){
            machineInfo.settingButton1 = machineInfo.settingButton1.getScaledInstance((int)(width*MainFrame.Rw), (int)(height*MainFrame.Rh),  Image.SCALE_SMOOTH);
            machineInfo.settingButton2 = machineInfo.settingButton2.getScaledInstance((int)(width*MainFrame.Rw), (int)(height*MainFrame.Rh),  Image.SCALE_SMOOTH);
            dIm = new ImageIcon(machineInfo.settingButton1);
            cIm = new ImageIcon(machineInfo.settingButton2);
            PosX = (int)(PosX * MainFrame.Rw);
            PosY = (int)(PosY * MainFrame.Rh);
            width = (int)(width * MainFrame.Rw);
            height = (int)(height * MainFrame.Rh);
            setBounds(PosX,PosY,width,height);
            setIcon(dIm);
            addMouseListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent me) {
        
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

