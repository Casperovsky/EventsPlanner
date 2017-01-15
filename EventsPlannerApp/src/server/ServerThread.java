/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import person.Host;

/**
 *
 * @author Casper
 */
public class ServerThread extends Thread{
    private Socket clSckt; //client socket
    private int clNumber;
    public ObjectOutputStream toClient;
    public ObjectInputStream fromClient;
    
    public ServerThread(Socket clSckt, int clNumber){
        this.clSckt = clSckt;
        this.clNumber = clNumber;
        start();
    }
    public void run(){
        try{
            toClient = new ObjectOutputStream(clSckt.getOutputStream());
            fromClient = new ObjectInputStream(clSckt.getInputStream());
            
            clSckt.setKeepAlive(true);
            String mssg = (String)fromClient.readObject();
            System.out.println(mssg);
            if(mssg.startsWith("START")){
                System.out.println(Server.hosts);
                toClient.writeObject(Server.hosts);
                toClient.writeObject(Server.participants);
                toClient.writeObject(Server.events);
                toClient.flush();
            }
            if(mssg.equals("HOST")){
                Server.hosts.add((Host) fromClient.readObject());
                System.out.println(Server.hosts);
            }
            
            fromClient.close();
            toClient.close();
            clSckt.close();
        } catch(Exception ex){
            ex.printStackTrace();
        }
        
    }
    
}

