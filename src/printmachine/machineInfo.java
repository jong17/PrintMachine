/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package printmachine;

import java.awt.Image;
import java.awt.Toolkit;
import java.util.ArrayList;
import javax.swing.JOptionPane;

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
    
    static Image background = Toolkit.getDefaultToolkit().createImage("./src/printmachine/image/bg.png");
    static Image infoButton1 = Toolkit.getDefaultToolkit().createImage("./src/printmachine/image/info1.png");
    static Image infoButton2 = Toolkit.getDefaultToolkit().createImage("./src/printmachine/image/info2.png");
    
    static Image autoButton1 = Toolkit.getDefaultToolkit().createImage("./src/printmachine/image/automatic1.png");
    static Image autoButton2 = Toolkit.getDefaultToolkit().createImage("./src/printmachine/image/automatic2.png");
    
    static Image settingButton1 = Toolkit.getDefaultToolkit().createImage("./src/printmachine/image/setting1.png");
    static Image settingButton2 = Toolkit.getDefaultToolkit().createImage("./src/printmachine/image/setting2.png");
    
    static boolean workingMode = false;
    
    static double totalWorkingTime;
    static double lastHeadScreentTime=500;
    static double latencyTime=2000;
    static double tpp;
    static int numHead=2;
    static int numShirt=10;
    static int numberShirtPicture = 6;
    
    static TimeCounter timer; //คลาสนับเวลา
    
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
    public static void setTimer(){
        setSuccesShirtScreen();
        setTotalWorkingTime();
        timer = new TimeCounter();
    }
    
    public static String printTime(int mode){
        
        if(mode==0){
            String hh = Long.toString(timer.rh);
            String mm = Long.toString(timer.rm);
            String ss = Long.toString(timer.rs);
            if(timer.rh<10) hh="0"+Long.toString(timer.rh);
            if(timer.rm<10) mm="0"+Long.toString(timer.rm);
            if(timer.rs<10) ss="0"+Long.toString(timer.rs);
            //if(timeCounter==0) return hh+":"+mm+":"+ss;
            if(timer.t<500) return hh+":"+mm+":"+ss;
            else return hh+" "+mm+" "+ss;
        }
        else{
            String hh = Long.toString(timer.h);
            String mm = Long.toString(timer.m);
            String ss = Long.toString(timer.s);
            if(timer.h<10) hh="0"+Long.toString(timer.h);
            if(timer.m<10) mm="0"+Long.toString(timer.m);
            if(timer.s<10) ss="0"+Long.toString(timer.s);
            if(timer.t<500) return hh+":"+mm+":"+ss;
            else return hh+" "+mm+" "+ss;
        }
            
    }
    public static double setSuccesShirtScreen(){
        if(StatusPanel.countShirt==0)
            return tpp = lastHeadScreentTime*numHead+latencyTime;
        else
            return tpp = latencyTime+lastHeadScreentTime;
        
    }
    
    public static void setTotalWorkingTime(){
        totalWorkingTime = (tpp+numShirt*(latencyTime+lastHeadScreentTime))/1000;
    }
}
    

