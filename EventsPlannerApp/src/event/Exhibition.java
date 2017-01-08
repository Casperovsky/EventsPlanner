/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package event;

import java.time.LocalDate;
import java.util.ArrayList;
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

    public Exhibition(String subject, ArrayList<Author> authors, String name, LocalDate startDate, LocalDate endDate, String description, Host host) {
        super(name, startDate, endDate, description, host);
        this.subject = subject;
        this.authors = authors;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public ArrayList<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(ArrayList<Author> authors) {
        this.authors = authors;
    }
    
    public String toCSV(){
        return "Exhibition;"+super.getName()+";"+super.getStartDate()+";"+super.getEndDate()+";"+super.getDescription()+
                ";"+super.getHost()+";"+super.getListOfSubEvents()+";"+this.getSubject()+";"+this.getAuthors();
    }
    
}
