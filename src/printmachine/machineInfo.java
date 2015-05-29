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
    
    static Image headStanby = Toolkit.getDefaultToolkit().createImage(MainFrame.class.getResource("./image/head.png").getPath());
    static Image headHeat = Toolkit.getDefaultToolkit().createImage(MainFrame.class.getResource("./image/headHeat.png").getPath());
    static Image headPrint = Toolkit.getDefaultToolkit().createImage(MainFrame.class.getResource("./image/headPrint.png").getPath());
    
    static Image startButton1 = Toolkit.getDefaultToolkit().createImage(MainFrame.class.getResource("./image/start1.png").getPath());
    static Image startButton2 = Toolkit.getDefaultToolkit().createImage(MainFrame.class.getResource("./image/start2.png").getPath());
    static Image stopButton1 = Toolkit.getDefaultToolkit().createImage(MainFrame.class.getResource("./image/stop1.png").getPath());
    static Image stopButton2  = Toolkit.getDefaultToolkit().createImage(MainFrame.class.getResource("./image/stop2.png").getPath());
    static Image skipButton1 = Toolkit.getDefaultToolkit().createImage(MainFrame.class.getResource("./image/skip1.png").getPath());
    static Image skipButton2 = Toolkit.getDefaultToolkit().createImage(MainFrame.class.getResource("./image/skip2.png").getPath());
    
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
