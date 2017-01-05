/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eventsplannerapp;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javax.imageio.ImageIO;


/**
 *
 * @author Casper
 */
public class MainPageController implements Initializable {
    @FXML
    private AnchorPane eventsAnchorPane;
    @FXML 
    private AnchorPane usersAnchorPane;
    @FXML
    private AnchorPane optionsAnchorPane;
    
    @FXML
    private void allEventsButtonAction(ActionEvent event) {
        eventsAnchorPane.setVisible(true);
        usersAnchorPane.setVisible(false);
        optionsAnchorPane.setVisible(false);
    }
    @FXML
    private void usersButtonAction(ActionEvent event) {
        eventsAnchorPane.setVisible(false);
        usersAnchorPane.setVisible(true);
        optionsAnchorPane.setVisible(false);
    }
    @FXML
    private void optionsButtonAction(ActionEvent event) {
        eventsAnchorPane.setVisible(false);
        usersAnchorPane.setVisible(false);
        optionsAnchorPane.setVisible(true);    
    }
    @FXML
    private Button exitButton;
    @FXML
    private void exitButtonAction(ActionEvent event) {
        Stage stage = (Stage) exitButton.getScene().getWindow();
        stage.close();
    }
    
    @FXML
    private Button addEventButton;
    @FXML
    private void addEventButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
    }
    @FXML
    private Button deleteEventButton;
    @FXML
    private void deleteEventButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
    }
    @FXML
    private Button startMarketingButton;
    @FXML
    private void startMarketingButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
    }
    @FXML
    private Button exportEventsButton;
    @FXML
    private void exportEventsButton(ActionEvent event) {
        System.out.println("You clicked me!");
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        eventsAnchorPane.setVisible(true);
        usersAnchorPane.setVisible(false);
        optionsAnchorPane.setVisible(false);
    }  
    
}
