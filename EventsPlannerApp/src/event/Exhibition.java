/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package event;

import java.util.ArrayList;
import java.util.Date;
import person.Author;
import person.Host;
import person.Participant;

/**
 *
 * @author Casper
 */
public class Exhibition extends Event{ //izlozba
    private String subject;
    private ArrayList<Author> authors; //autori na izlozbi

    public Exhibition(String name, Date startDate, Date endDate, String description, Host host, ArrayList<Participant> participants) {
        super(name, startDate, endDate, description, host, participants);
    }
    
}
