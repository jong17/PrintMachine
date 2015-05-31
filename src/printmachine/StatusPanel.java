/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package printmachine;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.Timer;
import static printmachine.ShirtPanel.fps;

/**
 *
 * @author alfarie
 */
public class StatusPanel extends JPanel implements Runnable{
    private int PosX=890,PosY=20;
    private int width=880,height=360;
    private int statusFontSize = (int)(30*MainFrame.Rw), countFontSize = (int)(150*MainFrame.Rw),pcsFontSize = (int)(25*MainFrame.Rw);
    private Image stringFrame,countFrame;
    private Timer timer;
    private int count=0;
    private int fps = 1000/60;                                          //fps นำมาจาก machine info class
    private int dh=0,dm=0,ds=0,rh,rm,rs;                                        //ตัวแบรใช้นับเวลา
    private long t=0,t_old=0,t_new,durationTime,remainTime,systemTime=130;      //ตัวแบรใช้นับเวลา
    public static long tcount=0,tcount_old=0,tcount_new;                              //ตัวแบรใช้นับ count
    public static int countShirt=0;                                                   //จำนวนเสื้อที่เสร็จ
   
    
    StatusPanel(){
        PosX = (int)(PosX * MainFrame.Rw);
        PosY = (int)(PosY * MainFrame.Rh);
        width = (int)(width * MainFrame.Rw);
        height = (int)(height * MainFrame.Rh);
        setPreferredSize(new Dimension(width,height));
        setBounds(PosX,PosY,width,height);
        
        stringFrame = Toolkit.getDefaultToolkit().createImage("./src/images/stringFrame.png");
        stringFrame = stringFrame.getScaledInstance((int)(284*MainFrame.Rw), (int)(58*MainFrame.Rh),  Image.SCALE_SMOOTH);
        countFrame = Toolkit.getDefaultToolkit().createImage("./src/printmachine/image/countFrame.png");
        countFrame = countFrame.getScaledInstance((int)(217*MainFrame.Rw), (int)(217*MainFrame.Rh),  Image.SCALE_SMOOTH);
        
        new Thread(this).start();
        timer = new Timer(fps,new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent event) 
        {
            repaint();
            
        }});
        timer.setRepeats(true);
        timer.start();
        //print = new printString();
        
        machineInfo.setTimer();
        
    }
    
    @Override
    public void paint(Graphics g){
        g.setColor(Color.white);
        g.fillRect(0, 0, width, height);
        g.setColor(Color.red);
        int n=0;
        for(int i=0;i<5;i++){
            g.drawImage(stringFrame, (int)(10*MainFrame.Rw), (int)(10*MainFrame.Rh)+n,this);
            n+=(int)((height-20*MainFrame.Rh)/5);
        }
        g.drawImage(countFrame, (int)(width/2+10*MainFrame.Rw), (int)(10*MainFrame.Rh), (int)(width/2-20*MainFrame.Rw), (int)(height-20*MainFrame.Rh), this);
        if(!machineInfo.workingMode){
            g.setFont(new Font("Tahoma",Font.PLAIN,statusFontSize));
            g.drawString("Job Code : ", (int)(20*MainFrame.Rw),(int)(((height-20*MainFrame.Rh)/5)/2+statusFontSize/2+10*MainFrame.Rh));
            g.drawString("Time Per Piece : ", (int)(20*MainFrame.Rw), (int)((((height-20*MainFrame.Rh)/5)*3)/2+10*MainFrame.Rh+statusFontSize/2));
            g.drawString("Piece Per Hour : ", (int)(20*MainFrame.Rw), (int)((((height-20*MainFrame.Rh)/5)*5)/2+10*MainFrame.Rh+statusFontSize/2));
            g.drawString("Remain Time : ", (int)(20*MainFrame.Rw), (int)((((height-20*MainFrame.Rh)/5)*7)/2+10*MainFrame.Rh+statusFontSize/2));
            g.drawString("DurationTime : ", (int)(20*MainFrame.Rw), (int)((((height-20*MainFrame.Rh)/5)*9)/2+10*MainFrame.Rh+statusFontSize/2));
            g.drawString("Count : ",(int)(width/2+20*MainFrame.Rw),(int)(10*MainFrame.Rh+statusFontSize));
            g.setFont(new Font("Tahoma",Font.PLAIN,pcsFontSize));
            g.drawString("pcs",(int)(width-50*MainFrame.Rw),(int)(height-20*MainFrame.Rh));
            
        }
        else{
            g.setFont(new Font("Tahoma",Font.PLAIN,statusFontSize));
            g.drawString("Job Code : "+getJobCode(), (int)(20*MainFrame.Rw),(int)(((height-20*MainFrame.Rh)/5)/2+statusFontSize/2+10*MainFrame.Rh));
            g.drawString("Time Per Piece : "+getTimePerPiece()+" sec", (int)(20*MainFrame.Rw), (int)((((height-20*MainFrame.Rh)/5)*3)/2+10*MainFrame.Rh+statusFontSize/2));
            g.drawString("Piece Per Hour : "+getPiecePerHour()+" pcs", (int)(20*MainFrame.Rw), (int)((((height-20*MainFrame.Rh)/5)*5)/2+10*MainFrame.Rh+statusFontSize/2));
            g.drawString("DurationTime : "+machineInfo.printTime(1), (int)(20*MainFrame.Rw), (int)((((height-20*MainFrame.Rh)/5)*9)/2+10*MainFrame.Rh+statusFontSize/2));
            g.drawString("Remain Time : "+machineInfo.printTime(0), (int)(20*MainFrame.Rw), (int)((((height-20*MainFrame.Rh)/5)*7)/2+10*MainFrame.Rh+statusFontSize/2));
            g.drawString("Count : ",(int)(width/2+20*MainFrame.Rw),(int)(10*MainFrame.Rh+statusFontSize));
            g.setFont(new Font("Tahoma",Font.PLAIN,pcsFontSize));
            g.drawString("pcs",(int)(width-50*MainFrame.Rw),(int)(height-20*MainFrame.Rh));
            drawCount(g);
        }
        g.dispose();
    }   

    @Override
    public void run() {
        /*while(true){
            repaint();
            try{Thread.sleep(500);}catch(Exception e){}
        }*/
    }
    //เวลาใช้งานจริงจะเอามาจากคลาส machine info
    public String getJobCode(){
        return "PM0001TEST";
    }
    //เวลาใช้งานจริงจะเอามาจากคลาส machine info
    public String getTimePerPiece(){
        return "23";
    }
    //เวลาใช้งานจริงจะเอามาจากคลาส machine info
     public String getPiecePerHour(){
        return "100";
    }
    //กำหนดตำแหน่งแนวนอนของ countShirt
    private int setHorizontalCount(int count, int width, int countFrameWidth){ 
        if(count>9999) return (int)(width/2+10*MainFrame.Rw+countFrameWidth/25);
        else if(count>999) return (int)(width/2+10*MainFrame.Rw+countFrameWidth/7);
        else if(count>99) return (int)(width/2+10*MainFrame.Rw+countFrameWidth/4);
        else if(count>9) return (int)(width/2+10*MainFrame.Rw+countFrameWidth/3);
        else return (int)(width/2+10*MainFrame.Rw+(countFrameWidth*MainFrame.Rw)/2);
    }
    
    //author jong
    
    private void drawCount(Graphics g){
        g.setFont(new Font("Tahoma",Font.PLAIN,countFontSize));
        g.drawString(Integer.toString(countShirt), setHorizontalCount(countShirt, width, countFrame.getWidth(this)), (int)(height/2+countFontSize/4));
        tcount_new = System.currentTimeMillis();
        if(machineInfo.timer.shirtSuccessCount()){
            if(countShirt<machineInfo.numShirt)
                countShirt++;
            else{
             System.out.println("dfkjkf");
                machineInfo.timer.interrupt();
            }
            
        }
    }
}
