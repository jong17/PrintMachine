/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package printmachine;

import java.awt.Container;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author lateh
 */
public class PrintMachine {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        MainFrame frame = new MainFrame();
        //System.out.println((int)(210*MainFrame.Rw));
         String current = System.getProperty("user.dir");
         System.out.println(current);
        new simState();
    }
}

