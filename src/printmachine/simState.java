/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package printmachine;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author alfarie
 */
public class simState extends JFrame{
    JTextField choose ;
    simState(){
       setTitle("simAll");
       setSize(new Dimension(650,200));
       setLayout(new FlowLayout());
       ButtonTest();
       
       choose = new JTextField();
       choose.setPreferredSize(new Dimension(50,50));
       add(new JLabel("Machine Number : "));
       add(choose);
       
       
       setDefaultCloseOperation(EXIT_ON_CLOSE);
       setVisible(true);
    }
    private void ButtonTest(){
        
        int posY = 20;
        JButton bt = new JButton("add Module1");
        //bt.setBounds(300, posY, 200, 50);
        bt.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                machineInfo.addModule(0);
            }
        });
        JButton bt2 = new JButton("add Module2");
        //bt2.setBounds(550, posY, 200, 50);
        bt2.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                machineInfo.addModule(1);
            }
        });
        JButton bt3 = new JButton("add Module3");
        //bt3.setBounds(800, posY, 200, 50);
        bt3.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                machineInfo.addModule(2);
            }
        }); 
        
        JButton bt4 = new JButton("set Heat");
        //bt4.setBounds(1050, posY, 200, 50);
        bt4.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                
                int mnumber = Integer.parseInt(choose.getText());
                mnumber--;
                choose.setText("");
                try {machineInfo.headList.get(mnumber).setHeat();}catch(IndexOutOfBoundsException e){
                    JOptionPane.showMessageDialog(  null,
                                            "head isn't exist",
                                            "error",
                                            JOptionPane.WARNING_MESSAGE
                    );
                
                }
            }
        }); 
        JButton bt5 = new JButton("set Print");
        //bt5.setBounds(1300, posY, 200, 50);
        bt5.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                int mnumber = Integer.parseInt(choose.getText());
                mnumber--;
                choose.setText("");
                try {machineInfo.headList.get(mnumber).setPrint();}catch(IndexOutOfBoundsException e){
                    JOptionPane.showMessageDialog(  null,
                                            "head isn't exist",
                                            "error",
                                            JOptionPane.WARNING_MESSAGE
                    );
                
                }
            }
        }); 
        
        JButton bt6 = new JButton("set standby");
        //bt6.setBounds(1550, posY, 200, 50);
        bt6.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                int mnumber = Integer.parseInt(choose.getText());
                mnumber--;
                choose.setText("");
                try {machineInfo.headList.get(mnumber).setStanby();}catch(IndexOutOfBoundsException e){
                    JOptionPane.showMessageDialog(  null,
                                            "head isn't exist",
                                            "error",
                                            JOptionPane.WARNING_MESSAGE
                    );
                
                }
            }
        }); 
        
        add(bt);
        add(bt2);
        add(bt3);
        add(bt4);
        add(bt5);
        add(bt6);
    }
}
