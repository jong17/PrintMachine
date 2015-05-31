/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package printmachine;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import gnu.io.CommPortIdentifier; 
import gnu.io.NoSuchPortException;
import gnu.io.SerialPort;
import gnu.io.SerialPortEvent; 
import gnu.io.SerialPortEventListener; 
import java.util.Scanner;
/**
 *
 * @author alfarie
 */
public class JavaToArduino implements SerialPortEventListener{
    
    final private String portname = "COM3";
    private BufferedReader reciever;
    private OutputStream sender;
    private CommPortIdentifier portIdentifier;
    private SerialPort serialPort;
    private static final int TIME_OUT = 2000;
    private static final int DATA_RATE = 9600;
    public JavaToArduino(){
        try{
            System.out.print("get portID  ");
            portIdentifier = CommPortIdentifier.getPortIdentifier("COM6");
            System.out.println("Success");
            System.out.print("Open port   ");
            serialPort = (SerialPort) portIdentifier.open(this.getClass().getName(), TIME_OUT);
            System.out.println("Success");
            System.out.println("config Serialport");
            serialPort.setSerialPortParams(DATA_RATE, 8, 1, 0);
            
            reciever = new BufferedReader(new InputStreamReader(serialPort.getInputStream()));
            sender = serialPort.getOutputStream();
            serialPort.addEventListener(this);
	    serialPort.notifyOnDataAvailable(true);
            
            System.out.println("Serial port Established...");
            
            
        }catch(NoSuchPortException e){
            System.out.println("Could not find COM port...");
        }
        catch(Exception e){
            //System.out.println(e);
        }
    }
    public void start(){
        while(true){
                Scanner sc = new Scanner(System.in);
                System.out.print(">> ");
                try{sender.write((sc.nextLine().trim() + "\n").getBytes());} catch(Exception e){}
            }
    }
    public OutputStream getSender(){
        return sender;
    }
    public BufferedReader getReciever(){
        return reciever;
    }
    @Override
    public void serialEvent(SerialPortEvent oEvent) {
        if (oEvent.getEventType() == SerialPortEvent.DATA_AVAILABLE) {
			try {
				String inputLine=reciever.readLine();
				System.out.println(inputLine.getBytes());
			} catch (Exception e) {
				//System.err.println(e.toString());
			}
		}
    }
}

