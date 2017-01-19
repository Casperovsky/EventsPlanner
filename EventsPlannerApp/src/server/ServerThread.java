/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import event.Event;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import person.Host;
import person.Participant;

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
//            ArrayList<Host> h = Server.hostModule.getAll();
//            ArrayList<Participant> p = Server.participantModule.getAll();
//            ArrayList<Event> e = Server.eventModule.getAll();
            if(mssg.startsWith("START")){
                System.out.println(Server.hostModule.getAll());
                toClient.writeObject(Server.hostModule.getAll());
                toClient.writeObject(Server.participantModule.getAll());
                toClient.writeObject(Server.eventModule.getAll());
                toClient.flush();
            }
            
            if(mssg.equals("ADDHOST")){
                Server.hostModule.add((Host) fromClient.readObject());
                System.out.println(Server.hostModule.getAll());
            }
            if(mssg.equals("DELETEHOST")){
                Server.hostModule.remove((Host) fromClient.readObject());
                System.out.println(Server.hostModule.getAll());
            }
            
            if(mssg.equals("ADDPARTICIPANT")){
                Server.participantModule.add((Participant) fromClient.readObject());
                System.out.println(Server.participantModule.getAll());
            }
            if(mssg.equals("DELETEPARTICIPANT")){
                Server.participantModule.remove((Participant) fromClient.readObject());
                System.out.println(Server.participantModule.getAll());
            }
            
            if(mssg.equals("ADDEVENT")){
                Server.eventModule.add((Event) fromClient.readObject());
                System.out.println(Server.eventModule.getAll());
            }
            if(mssg.equals("DELETEVENT")){
                Server.eventModule.remove((Event) fromClient.readObject());
                System.out.println(Server.eventModule.getAll());
            }
            
            
            
            
//            fromClient.close();
//            toClient.close();
//            clSckt.close();
        } catch(Exception ex){
            ex.printStackTrace();
        }
        
    }
    
}

