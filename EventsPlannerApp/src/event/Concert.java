/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package event;

import person.Performer;
import person.Person;

/**
 *
 * @author Casper
 */
public class Concert extends Person{ //koncert
    private Performer performer;
    private double duration; //trajanje koncerta u minutama

    public Concert(String name, String lastName) {
        super(name, lastName);
    }
}
