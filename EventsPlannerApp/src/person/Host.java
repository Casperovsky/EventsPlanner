/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package person;

import utility.Notes;
import java.util.ArrayList;
/**
 *
 * @author Casper
 */
public class Host extends Person{
    private String telNumber;
    private String email;
    private ArrayList<Notes> notes;
    
    public Host(String name, String lastName, String telNumber, String email, Notes note){
        super(name,lastName);
        this.telNumber = telNumber;
        this.email = email;
        notes = new ArrayList<>();
        notes.add(note);
    }
    public Host(String name, String lastName, String telNumber, String email){
        super(name,lastName);
        this.telNumber = telNumber;
        this.email = email;
        notes = new ArrayList<>();
    }
    public String getTelNumber() {
        return telNumber;
    }

    public void setTelNumber(String telNumber) {
        this.telNumber = telNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public ArrayList<Notes> getNotes() {
        return notes;
    }

    public void setNotes(ArrayList<Notes> notes) {
        this.notes = notes;
    }

    @Override
    public String toString() {
        return super.getName() +" " + super.getLastName();
    }

    
    

    
}
