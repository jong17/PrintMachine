/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package printmachine;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import javax.swing.JOptionPane;
import javax.swing.Timer;

/**
 *
 * @author alfarie
 */
public class machineInfo {
    static ArrayList<headPrint> headList =new ArrayList<headPrint>();
    static ArrayList<Integer> module = new ArrayList<Integer>();
    
    static Image headStanby = Toolkit.getDefaultToolkit().createImage("./src/printmachine/image/head.png");
    static Image headHeat =  Toolkit.getDefaultToolkit().createImage("./src/printmachine/image/headHeat.png");
    static Image headPrint =  Toolkit.getDefaultToolkit().createImage("./src/printmachine/image/headPrint.png");
    
    static Image startButton1 = Toolkit.getDefaultToolkit().createImage("./src/printmachine/image/start1.png");
    static Image startButton2 = Toolkit.getDefaultToolkit().createImage("./src/printmachine/image/start2.png");
    
    static Image stopButton1 = Toolkit.getDefaultToolkit().createImage("./src/printmachine/image/stop1.png");
    static Image stopButton2  = Toolkit.getDefaultToolkit().createImage("./src/printmachine/image/stop2.png");
    static Image skipButton1 = Toolkit.getDefaultToolkit().createImage("./src/printmachine/image/skip1.png");
    static Image skipButton2 = Toolkit.getDefaultToolkit().createImage("./src/printmachine/image/skip2.png");
    
    static Image shirtScreenImage =Toolkit.getDefaultToolkit().createImage("./src/printmachine/image/shirtScreen.png");
    static Image shirtImage = Toolkit.getDefaultToolkit().createImage("./src/printmachine/image/shirt.png");
    
    static boolean workingMode = false;
    
    /**author jong
     * 
     * 
     * 
    */
    static double tpp=5000; //เวลาที่ใช้ผลิตเสื้อ 1 ตัว
    static int numberShirtPicture = 6;
    static double fpsScreenShirt = tpp/numberShirtPicture;
    
    //ตัวแบรนับเวลาการทำงาน
    static int timeCounter=0;
    static long dh,dm,ds; 
    static long rh,rm,rs;
    static long durationTimeMillis,remainingTimeMillis,workingTimeMillis=130,millis;
    static Timer time;
    
    //test
    static long t_old=0;
    static long tb;
    static long ta;

    
    
    machineInfo(){
        
    }
    
    public static  void addHead(headPrint h){
        if(headList.size() < 20){
            headList.add(h);
            System.out.println("addHead()");
        }
        else{
            JOptionPane.showMessageDialog(  null,
                                            "not enough power to drive motor.",
                                            "OverLoad",
                                            JOptionPane.WARNING_MESSAGE
            );
        }
    }
    public static void addModule(int type){
        
        module.add(type);
        for(int a : module){
            System.out.print(a);
        }
        switch(type){
            case 0:
                addHead(new headPrint());
                addHead(new headPrint());
                addHead(new headPrint());
                break;
            case 1:
                addHead(new headPrint());
                addHead(new headPrint());
                break;
            case 2:
                addHead(new headPrint());
                addHead(new headPrint());
                addHead(new headPrint());
                break;
        }      
    }
    /**author jong
     * 
     * 
     * 
     */
    public static void setTimer(){
        time = new Timer(500,new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent event) 
        {
            setDurationWorkingTime();
            setRemainingTime();
            
        }});
        time.setRepeats(true);
        //time.start();
    }
    
    public static void setDurationWorkingTime(){
        t_old = System.currentTimeMillis() - t_old;
        System.out.println(t_old);
        t_old = System.currentTimeMillis();
        
        timeCounter+=1;
        if(timeCounter==2){
            ds += 1;
            if(ds%60==0){
                ds = 0;
                dm += 1;
                if(dm%60==0){
                    dm = 0;
                    dh += 1;
                }
            }
            timeCounter=0;
        }
    }
    
    public static void setRemainingTime(){
    durationTimeMillis = dh*3600+dm*60+ds;
        remainingTimeMillis = workingTimeMillis - durationTimeMillis;
        if(remainingTimeMillis<=0) {
            rh=0;
            rm=0;
            rs=0;
        }
        else{
            rh = TimeUnit.MILLISECONDS.toHours(remainingTimeMillis);
            millis = remainingTimeMillis-TimeUnit.HOURS.toMillis(rh);
            rm = TimeUnit.MILLISECONDS.toMinutes(millis);
            millis -= TimeUnit.MINUTES.toMillis(rm);
            rs = TimeUnit.MILLISECONDS.toSeconds(millis);
        }
    }
    
    public static String printTime(int mode){
        
        if(mode==0){
            String hh = Long.toString(rh);
            String mm = Long.toString(rm);
            String ss = Long.toString(rs);
            if(rh<10) hh="0"+Long.toString(rh);
            if(rm<10) mm="0"+Long.toString(rm);
            if(rs<10) ss="0"+Long.toString(rs);
            if(timeCounter==0) return hh+":"+mm+":"+ss;
            else return hh+" "+mm+" "+ss;
        }
        else{
            String hh = Long.toString(dh);
            String mm = Long.toString(dm);
            String ss = Long.toString(ds);
            if(dh<10) hh="0"+Long.toString(dh);
            if(dm<10) mm="0"+Long.toString(dm);
            if(ds<10) ss="0"+Long.toString(ds);
            if(timeCounter==0) return hh+":"+mm+":"+ss;
            else return hh+" "+mm+" "+ss;
        }
            
    }
}
