/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utility;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Casper
 */
public class Notes implements Serializable{
    private Date date;
    private String content;
    
    public Notes(Date date, String content){
        this.date = date;
        this.content = content;
    }

    @Override
    public String toString() {
        return "(" + date + ") " + content;
    }
    
    
}
