/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package event;

import companies.Company;
import java.time.LocalDate;
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

    public Promotion(Company company, String name, LocalDate startDate, LocalDate endDate, String description, Host host) {
        super(name, startDate, endDate, description, host);
        this.company = company;
    }
    public Promotion(Product product, String name, LocalDate startDate, LocalDate endDate, String description, Host host) {
        super(name, startDate, endDate, description, host);
        this.product = product;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
    public String toCSV(){
        return "Promotion;"+super.getName()+";"+super.getStartDate()+";"+super.getEndDate()+";"+super.getDescription()+
                ";"+super.getHost()+";"+super.getListOfSubEvents()+";"+this.getCompany()+";"+this.getProduct();
    }




    
}
