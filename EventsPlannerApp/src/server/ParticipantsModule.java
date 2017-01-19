/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import java.util.ArrayList;
import person.Participant;

/**
 *
 * @author MK9
 */
public class ParticipantsModule {
    public static ArrayList<Participant> participants = new ArrayList<>();
    
    public void addAll(ArrayList<Participant> part){
        participants.addAll(part);
    }
    
    public void add(Participant p){
        participants.add(p);
    }
    public void remove(Participant p){
        participants.remove(p);
    }
    
    public ArrayList<Participant> getAll(){
        return participants;
    }
    
    
}
