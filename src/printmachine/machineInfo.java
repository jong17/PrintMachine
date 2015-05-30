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
    
    static boolean workingMode = false;
    
    static double tpp=1000; //เวลาที่ใช้ผลิตเสื้อ 1 ตัว
    
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
    
}
