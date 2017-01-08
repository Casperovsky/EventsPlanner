/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package event;

import java.time.LocalDate;
import java.util.ArrayList;
import person.Host;
import person.Performer;

/**
 *
 * @author Casper
 */
public class Concert extends Event{ //koncert
    private ArrayList<Performer> performers;
    private double duration; //trajanje koncerta u minutama
    
    public Concert(ArrayList<Performer> performers, double duration, String name, LocalDate startDate, LocalDate endDate, String description, Host host) {
        super(name, startDate, endDate, description, host);
        this.performers = performers;
        this.duration = duration;
    }

    public ArrayList<Performer> getPerformers() {
        return performers;
    }

    public void setPerformers(ArrayList<Performer> performers) {
        this.performers = performers;
    }
    


    public double getDuration() {
        return duration;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }
    public String toCSV(){
        return "Concert;"+super.getName()+";"+super.getStartDate()+";"+super.getEndDate()+";"+super.getDescription()+
                ";"+super.getHost()+";"+super.getListOfSubEvents()+";"+this.getPerformers()+";"+this.getDuration();
    }





}
