/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eventsplannerapp;

import event.Concert;
import event.Exhibition;
import event.Lecture;
import event.Promotion;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author Casper
 */
public class ViewEventController implements Initializable {
    @FXML
    private Label eventNameLabel;
    @FXML
    private Label dateLabel;
    @FXML
    private Label descriptionLabel;
    @FXML
    private Label otherLabel;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        eventNameLabel.setText(MainPageController.event.getName());
        dateLabel.setText(MainPageController.event.getStartDate() + " - " + MainPageController.event.getEndDate());
        descriptionLabel.setText("Description: " + MainPageController.event.getDescription() +"\n"+
                                "Organizator: "+ MainPageController.event.getHost() +"\n"+
                                 "Subevents: "  +MainPageController.event.getListOfSubEvents());
        
        if(MainPageController.event instanceof Concert){
         otherLabel.setText("Duration: " +String.valueOf(((Concert) MainPageController.event).getDuration())+ "\n"+
                            "Performers: "+((Concert) MainPageController.event).getPerformers());
        }
        else if(MainPageController.event instanceof Exhibition){
         otherLabel.setText("Subject: " +((Exhibition) MainPageController.event).getSubject()+ "\n"+
                            "Authors: "+((Exhibition) MainPageController.event).getAuthors());
        }
        else if(MainPageController.event instanceof Lecture){
         otherLabel.setText("Subject: " +((Lecture) MainPageController.event).getSubject()+ "\n"+
                            "Lecturer: "+((Lecture) MainPageController.event).getLecturer()+ "\n"+
                            "Content: "+((Lecture) MainPageController.event).getContent());
        }else if(MainPageController.event instanceof Promotion){
           if(((Promotion) MainPageController.event).getCompany() != null){
            otherLabel.setText("Company: " +((Promotion) MainPageController.event).getCompany());
           }
           else if(((Promotion) MainPageController.event).getProduct()!= null){
            otherLabel.setText("Product: " +((Promotion) MainPageController.event).getProduct());
           }
        }
        
    }    
    
}
