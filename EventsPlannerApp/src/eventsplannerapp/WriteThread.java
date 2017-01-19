/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eventsplannerapp;

import event.Event;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import person.Host;
import person.Participant;

/**
 *
 * @author Casper
 */
public class WriteThread extends Thread{
    private String command;
    private Object obj;
    
    public WriteThread(String command, Object obj){
        this.command = command;
        this.obj = obj;
        start();
    }
    public void run(){
        try{
            Socket conn = new Socket("localhost",9000);
            ObjectOutputStream out = new ObjectOutputStream(conn.getOutputStream());
            ObjectInputStream in = new ObjectInputStream(conn.getInputStream());
            out.writeObject(command);
            out.writeObject(obj);
            out.flush();
            
            if(command.equals("START")){
                MainPageController.allHosts.addAll((ArrayList<Host>) in.readObject());
                MainPageController.allParticipants.addAll((ArrayList<Participant>) in.readObject());
                MainPageController.allEvents.addAll((ArrayList<Event>) in.readObject());
            }
            
            
            out.close();
            in.close();
            conn.close();
        } catch(Exception ex){
            ex.printStackTrace();
        }
    }
}
