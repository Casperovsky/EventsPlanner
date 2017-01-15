/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import java.util.Hashtable;

/**
 *
 * @author Casper
 */
public class ClientUtils {
    private static Hashtable clients = new Hashtable();
    
    public static synchronized ActiveClient addClient(String id,String address){
        ActiveClient test = (ActiveClient) clients.get(id);
        if(test==null){
            ActiveClient client = new ActiveClient(id, address);
            clients.put(id,client);
            return client;
        }else
         return null;
    }
    public static synchronized boolean removeClient(String id){
        ActiveClient test = (ActiveClient)clients.get(id);
        if(test==null)
            return false;
        else
            clients.remove(id);
        return true;
    }
}
