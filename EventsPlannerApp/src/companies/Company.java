/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package companies;

/**
 *
 * @author Casper
 */
public class Company { //kompanija
    String name;
    
    public Company(String name){
        this.name = name;
    }
    @Override
    public String toString() {
        return "Company{" + "name=" + name + '}';
    }
        
}

    
