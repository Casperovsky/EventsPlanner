/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package products;

/**
 *
 * @author Casper
 */
public class Product { //proizvod
    String name;
    
    public Product(String name){
        this.name = name;
    }

    @Override
    public String toString() {
        return "Product{" + "name=" + name + '}';
    }
    
}
