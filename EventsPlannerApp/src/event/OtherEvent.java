/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package event;

import java.time.LocalDate;
import person.Host;

/**
 *
 * @author Casper
 */
public class OtherEvent extends Event{ //ostali dogadjaji

    public OtherEvent(String name, LocalDate startDate, LocalDate endDate, String description, Host host) {
        super(name, startDate, endDate, description, host);
    }
    public String toCSV(){
        return "Other Event;"+super.getName()+";"+super.getStartDate()+";"+super.getEndDate()+";"+super.getDescription()+
                ";"+super.getHost()+";"+super.getListOfSubEvents();
    }
    
}
