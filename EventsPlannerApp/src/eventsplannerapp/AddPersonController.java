/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eventsplannerapp;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import person.Author;
import person.Host;
import person.Lecturer;
import person.Performer;
import utility.Notes;

/**
 * FXML Controller class
 *
 * @author Casper
 */
public class AddPersonController implements Initializable {

    @FXML
    private ComboBox selectComboBox;
    @FXML
    private void selectComboBoxAction(ActionEvent event) {
        statusLabel.setText("");
        if(selectComboBox.getValue() == "Host"){
            hostAnchor.setVisible(true);
            participantsAnchor.setVisible(false);
        } 
        else {
            hostAnchor.setVisible(false);
            participantsAnchor.setVisible(true);
        }
    }
    @FXML
    private AnchorPane hostAnchor;
    @FXML
    private AnchorPane participantsAnchor;
    @FXML
    private Label statusLabel;
    ////// Hosts ////////
    @FXML
    private TextField nameHostTextField;
    @FXML
    private TextField lastNameHostTextField;
    @FXML
    private TextField telHostTextField;
    @FXML
    private TextField emailHostTextField;
    @FXML
    private TextArea noteHostTextArea;
    @FXML
    private void addHostButtonAction(ActionEvent event){
        MainPageController.allHosts.add(new Host(nameHostTextField.getText(),
                lastNameHostTextField.getText(),telHostTextField.getText(),emailHostTextField.getText(),new Notes(new java.util.Date(), noteHostTextArea.getText())));
        selectComboBox.getSelectionModel().clearSelection();
        nameHostTextField.clear();
        lastNameHostTextField.clear();
        telHostTextField.clear();
        emailHostTextField.clear();
        noteHostTextArea.clear();
        hostAnchor.setVisible(false);
        participantsAnchor.setVisible(false);
        statusLabel.setText("Success!");
    }
    @FXML
    private TextField namePartTextField;
    @FXML
    private TextField lastNamePartTextField;
    @FXML
    private TextField orgPartTextField;
    @FXML
    private void addParticipantButtonAction(ActionEvent event) {
        if(selectComboBox.getValue() == "Author"){
            MainPageController.allParticipants.add(
                    new Author(namePartTextField.getText(),lastNamePartTextField.getText(),orgPartTextField.getText()));
        }
        else if(selectComboBox.getValue() == "Lecturer"){
            MainPageController.allParticipants.add(
                    new Lecturer(namePartTextField.getText(),lastNamePartTextField.getText(),orgPartTextField.getText()));
        }
        else if(selectComboBox.getValue() == "Performer"){
            MainPageController.allParticipants.add(
                    new Performer(namePartTextField.getText(),lastNamePartTextField.getText(),orgPartTextField.getText()));
        }
        selectComboBox.getSelectionModel().clearSelection();
        namePartTextField.clear();
        lastNamePartTextField.clear();
        orgPartTextField.clear();
        hostAnchor.setVisible(false);
        participantsAnchor.setVisible(false);
        statusLabel.setText("Success!");
    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        selectComboBox.getItems().addAll("Host","Performer","Author","Lecturer");
        hostAnchor.setVisible(false);
        participantsAnchor.setVisible(false);
        // TODO
    }    
    
}
