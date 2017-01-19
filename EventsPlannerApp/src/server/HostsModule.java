/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import java.util.ArrayList;
import person.Host;

/**
 *
 * @author MK9
 */
public class HostsModule {
    public static ArrayList<Host> hosts = new ArrayList<>();
    
    public void addAll(ArrayList<Host> hst){
        hosts.addAll(hst);
    }
    
    public void add(Host h){
        hosts.add(h);
    }
    public void remove(Host h){
        hosts.remove(h);
    }
    
    public ArrayList<Host> getAll(){
        return hosts;
    }
}
