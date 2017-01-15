/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import event.Event;
import eventsplannerapp.MainPageController;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import person.Host;
import person.Participant;
import person.Visitor;

/**
 *
 * @author Casper
 */
public class Server {
    public static  ArrayList<Event> events = new ArrayList<>();
    public static ArrayList<Host> hosts = new ArrayList<>();
    public static ArrayList<Participant> participants = new ArrayList<>();
//    public static ObservableList<Host> allHosts = FXCollections.observableArrayList();
//    public static ObservableList<Participant> allParticipants = FXCollections.observableArrayList();
//    public static ObservableList<Event> allEvents = FXCollections.observableArrayList();
//    public static ObservableList<Visitor> allVisitors = FXCollections.observableArrayList();
    
    public static void main(String[] args){
    try{
        startUp();
        System.out.println("Server is up...");
        ServerSocket srvSckt = new ServerSocket(9000);
        int clNumber = 0;
        while(true){
            Socket client = srvSckt.accept();
            System.out.println("#" + (++clNumber) + " is accepted");
            ServerThread srvThrd = new ServerThread(client,clNumber);
            System.out.println("- Thread for client " + clNumber + " is started");
        }
    
    } catch(Exception e){
        System.out.println("[Server error] "+e);
    }
    }
    public static void startUp(){
        try{
            FileInputStream fis = new FileInputStream("src/save/allEvents.dat");
            ObjectInputStream ois = new ObjectInputStream(fis);
            events.addAll((ArrayList<Event>) ois.readObject());
            fis = new FileInputStream("src/save/allHosts.dat");
            ois = new ObjectInputStream(fis);
            hosts.addAll((ArrayList<Host>) ois.readObject());
            fis = new FileInputStream("src/save/allParticipants.dat");
            ois = new ObjectInputStream(fis);
            participants.addAll((ArrayList<Participant>) ois.readObject());
        } catch(Exception e){
            System.out.println("[uvoz] " + e);
        }   
    }
    
}
