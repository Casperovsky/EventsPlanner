/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package person;

/**
 *
 * @author Casper
 */
public class Visitor extends Person{
    private String adress;
    private String telNumber;
    private String email;

    public Visitor(String adress, String telNumber, String email, String name, String lastName) {
        super(name, lastName);
        this.adress = adress;
        this.telNumber = telNumber;
        this.email = email;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
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
    
}
