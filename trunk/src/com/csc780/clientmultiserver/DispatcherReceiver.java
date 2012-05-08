package com.csc780.clientmultiserver;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class DispatcherReceiver {
    private DatagramSocket serverSocket;
    private byte[] receiveData;
    private byte[] sendData;
 
    
    private DatagramPacket receivePacket;
    private DatagramPacket sendPacket;
    
    
    private boolean playerSet=false;
    
    public int firstPlayerData;

    
    public InetAddress firstIPAddress;
    
//    private GameEngine gameEngine;
//    private ServerSending serversending;
//    private ServerSending serversending2;
//    
//    private boolean firstTime=true, secondTime=true;
    
    public void DestroySocket()
    {
    	serverSocket.close();
    	receivePacket=null;
    	sendPacket=null;
    }
    
    //Constructor
    public DispatcherReceiver()
    {   
       receiveData = new byte[24]; 
       sendData = new byte[24]; 
        
       try {
            serverSocket = new DatagramSocket(9800);
        } catch (SocketException ex) {
            Logger.getLogger(DispatcherReceiver.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //returns the port for receiver server
    public String assignReceiver(DatagramPacket receivePacket)
    {
        String y=new String(receivePacket.getData());
        String temp=y.substring(0, receivePacket.getLength());
        
        //x is the port of receiving client
        int x=Integer.parseInt(temp);

            firstPlayerData=x;
            this.firstIPAddress=receivePacket.getAddress();
            
            System.out.println("Player1 receive from::" + this.firstIPAddress + "::port::" + x);
      
            return "1:9876";   //returns player1 idand port
      
    }
    

    public void runReceivingDispather()
    {  
       int i=0;
      
       try {
         //change this to 2 loops
         while(i<1)
         {
         //  receiveData  = new byte[12]; 
            
           receivePacket = 
             new DatagramPacket(receiveData, receiveData.length); 

           System.out.println("Dispatcher");
           serverSocket.receive(receivePacket);
           
           
           String temp=this.assignReceiver(receivePacket);
           
           //returns the port number for receiver server
           sendData=temp.getBytes();
           
           
           InetAddress address=receivePacket.getAddress();
           int tempPort=receivePacket.getPort();
           
           sendPacket = 
                    new DatagramPacket(sendData, sendData.length, address, 
                               tempPort); 
               
           serverSocket.send(sendPacket);
      
         i++;
         }
       } catch (IOException ex) {
                Logger.getLogger(DispatcherReceiver.class.getName()).log(Level.SEVERE, null, ex);
       }     
    }
    
}

