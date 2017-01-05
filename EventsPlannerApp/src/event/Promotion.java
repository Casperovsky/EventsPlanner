/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package event;

import companies.Company;
import java.util.ArrayList;
import java.util.Date;
import person.Host;
import person.Participant;
import products.Product;

/**
 *
 * @author Casper
 */
public class Promotion extends Event{ //promocija
    private Company company;
    private Product product;

    public Promotion(String name, Date startDate, Date endDate, String description, Host host, ArrayList<Participant> participants) {
        super(name, startDate, endDate, description, host, participants);
    }


    
}
