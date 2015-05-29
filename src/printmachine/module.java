/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package printmachine;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author alfarie
 */
public class module {
    headPrint[] head;
    int count;
    module(){
        count = 0 ;
        head = new headPrint[2];
    }
    public void addHead(headPrint h){
        if(count < 2){
            head[count] = h;
            count++;
        }
    }
    /*public void  drawModule(Graphics g,int PosX , int PosY){
        g.drawImage(head[0].getImage(), PosX, PosY, null);
        g.setColor(Color.BLUE);
        g.fillRect(PosX+headPrint.width, PosY+30, 10, 150);
        g.drawImage(head[1].getImage(), PosX+70+10, PosY, null);
    } */
}
