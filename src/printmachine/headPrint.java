/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package printmachine;

import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JLabel;

public class headPrint {
    private Image head;
    private int state;  // 0 = standby , 1 = print,  2 = heat;
    final static int width = 70,height= 160;
    private JLabel heat,stand,print;
    headPrint(){
         state = 0;
         heat = new JLabel();
         machineInfo.headHeat =machineInfo.headHeat.getScaledInstance((int)(width*MainFrame.Rw), (int)(height*MainFrame.Rh), Image.SCALE_FAST);
         machineInfo.headStanby =machineInfo.headStanby.getScaledInstance((int)(width*MainFrame.Rw), (int)(height*MainFrame.Rh), Image.SCALE_FAST);
         machineInfo.headPrint =machineInfo.headPrint.getScaledInstance((int)(width*MainFrame.Rw), (int)(height*MainFrame.Rh), Image.SCALE_FAST);
         ImageIcon h = new ImageIcon(machineInfo.headHeat); 
	 heat.setIcon(h);
         
         stand = new JLabel();
         ImageIcon s = new ImageIcon(machineInfo.headStanby); 
	 stand.setIcon(s);
         
         print = new JLabel();
         ImageIcon p = new ImageIcon(machineInfo.headPrint); 
	 print.setIcon(p);
         
    }
    
    JLabel getComponent(){
        if(state == 0) return stand;
        else if(state == 1 ) return print;
        else if(state  == 2) return heat;
        
        else return stand;
    }
    public void setHeat(){
        state = 2;
    }
    public void setPrint(){
        state = 1;
    }
    public void setStanby(){
       state =0;
    }
}
