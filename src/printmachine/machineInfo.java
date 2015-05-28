/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package printmachine;

import java.util.ArrayList;

/**
 *
 * @author alfarie
 */
public class machineInfo {
    static ArrayList<headPrint> headList =new ArrayList<headPrint>();
    static ArrayList<Integer> module = new ArrayList<Integer>();
    machineInfo(){
        
    }
    public static  void addHead(headPrint h){
        headList.add(h);
        System.out.println("addHead()");
    }
    
}
