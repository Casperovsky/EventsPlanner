/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import event.Event;
import java.util.ArrayList;

/**
 *
 * @author MK9
 */
public class EventsModule {
    public static  ArrayList<Event> events = new ArrayList<>();
    
    public void addAll(ArrayList<Event> ev){
        events.addAll(ev);
    }
    
    public void add(Event e){
        events.add(e);
    }
    public void remove(Event e){
        events.remove(e);
    }
    
    public ArrayList<Event> getAll(){
        return events;
    }
    
}
