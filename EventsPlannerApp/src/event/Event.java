/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package event;

import java.time.LocalDate;
import java.util.ArrayList;
import person.Host;
import person.Participant;

/**
 *
 * @author Casper
 */
public class Event { //dogadjaj
    private String name;
    private LocalDate startDate;
    private LocalDate endDate;
    private String description;
    private Host host;
    private ArrayList<Event> listOfSubEvents; //lista dogadjaja koji pripadaju ovome dogadjaju

    public Event(String name, LocalDate startDate, LocalDate endDate, String description, Host host) {
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
        this.description = description;
        this.host = host;
        listOfSubEvents = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Host getHost() {
        return host;
    }

    public void setHost(Host host) {
        this.host = host;
    }

    public ArrayList<Event> getListOfSubEvents() {
        return listOfSubEvents;
    }

    public void setListOfSubEvents(ArrayList<Event> listOfSubEvents) {
        this.listOfSubEvents = listOfSubEvents;
    }

    @Override
    public String toString() {
        return this.name;
    }
    public String toCSV(){
        return "Event;"+this.getName()+";"+this.getStartDate()+";"+this.getEndDate()+";"+this.getDescription()+
                ";"+this.getHost()+";"+this.getListOfSubEvents();
    }


    
}
