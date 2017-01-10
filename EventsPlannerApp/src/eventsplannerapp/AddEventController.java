/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eventsplannerapp;

import companies.Company;
import event.Concert;
import event.Event;
import event.Exhibition;
import event.Lecture;
import event.OtherEvent;
import event.Promotion;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import person.Author;
import person.Host;
import person.Lecturer;
import person.Participant;
import person.Performer;
import person.Person;
import products.Product;

/**
 * FXML Controller class
 *
 * @author Casper
 */
public class AddEventController implements Initializable {
    
    public ObservableList<Participant> allLecturers = FXCollections.observableArrayList();
    public ObservableList<Participant> allAuthors = FXCollections.observableArrayList();
    public ObservableList<Participant> allPerformers = FXCollections.observableArrayList();
    
    @FXML
    private ComboBox selectComboBox;
    @FXML
    private void selectComboBoxAction(ActionEvent event){
        eventDetailsAnchorPane.setVisible(true);
        if(selectComboBox.getValue() == "Concert"){
            promotionAnchorPane.setVisible(false);
            lectureAnchorPane.setVisible(false);
            concertAnchorPane.setVisible(true);
            exhibitionAnchorPane.setVisible(false);
            otherEventAnchorPane.setVisible(false);
        }
        else if(selectComboBox.getValue() == "Exhibition"){
            promotionAnchorPane.setVisible(false);
            lectureAnchorPane.setVisible(false);
            concertAnchorPane.setVisible(false);
            exhibitionAnchorPane.setVisible(true);
            otherEventAnchorPane.setVisible(false);
            
        }
        else if(selectComboBox.getValue() == "Lecture"){
            promotionAnchorPane.setVisible(false);
            lectureAnchorPane.setVisible(true);
            concertAnchorPane.setVisible(false);
            exhibitionAnchorPane.setVisible(false);
            otherEventAnchorPane.setVisible(false);
        }
        else if(selectComboBox.getValue() == "Promotion"){
            promotionAnchorPane.setVisible(true);
            lectureAnchorPane.setVisible(false);
            concertAnchorPane.setVisible(false);
            exhibitionAnchorPane.setVisible(false);
            otherEventAnchorPane.setVisible(false);
        }
        else if(selectComboBox.getValue() == "Other Event"){
            promotionAnchorPane.setVisible(false);
            lectureAnchorPane.setVisible(false);
            concertAnchorPane.setVisible(false);
            exhibitionAnchorPane.setVisible(false);
            otherEventAnchorPane.setVisible(true);
        }
    }
    @FXML
    private AnchorPane eventDetailsAnchorPane;
    @FXML
    private AnchorPane promotionAnchorPane;
    @FXML
    private AnchorPane lectureAnchorPane;
    @FXML
    private AnchorPane concertAnchorPane;
    @FXML
    private AnchorPane exhibitionAnchorPane;
    @FXML
    private AnchorPane otherEventAnchorPane;
    @FXML
    private TextField eventNameTextField;
    @FXML
    private DatePicker eventStartDatePicker;
    @FXML
    private DatePicker eventEndDatePicker;
    @FXML
    private TextArea eventDescriptionTextArea;
    @FXML
    private ComboBox eventOrgComboBox;
    @FXML
    private ComboBox<Event> mainEventComboBox;
    //Lecture
    @FXML
    private TextField lectureSubjectTextField;
    @FXML
    private ComboBox lectureComboBox;
    @FXML
    private TextArea lectureContentTextArea;
    @FXML
    private Button lectureAddButton;

    @FXML
    private void cancelButtonAction(ActionEvent event){
        Stage stage = (Stage) selectComboBox.getScene().getWindow();
        stage.close();
    }
    @FXML
    private void lectureAddButtonAction(ActionEvent event) {
        Lecture lect = new Lecture(lectureSubjectTextField.getText(), (Lecturer) lectureComboBox.getValue(), 
                lectureContentTextArea.getText(), eventNameTextField.getText(), (LocalDate) eventStartDatePicker.getValue(), (LocalDate) eventEndDatePicker.getValue(), 
                eventDescriptionTextArea.getText(),(Host) eventOrgComboBox.getValue());
        MainPageController.allEvents.add(lect);
        if(mainEventComboBox.getValue() != null){
            mainEventComboBox.getValue().getListOfSubEvents().add(lect);
        }
        succAdded("Added new event - " + lect.getName() + "!");
    }
    //Concert
    @FXML
    private ComboBox concertPerformersComboBox;
    @FXML
    private TextField concertDurationTextField;
    @FXML
    private Button concertButtonAdd;
    @FXML
    private Label listOfPerformersLabel;
    
    private ArrayList<Performer> performers = new ArrayList<>();
            
    @FXML
    private void addPerformerButtonAction(ActionEvent event) {
        if(concertPerformersComboBox.getValue() != null){
            listOfPerformersLabel.setText(listOfPerformersLabel.getText() + ", " + concertPerformersComboBox.getValue());
            performers.add((Performer) concertPerformersComboBox.getValue());
        }  
    }
    @FXML
    private void concertButtonAddAction(ActionEvent event) {
       Concert con = new Concert(performers, Double.parseDouble(concertDurationTextField.getText()), 
       eventNameTextField.getText(), (LocalDate) eventStartDatePicker.getValue(), (LocalDate) eventEndDatePicker.getValue(), 
                eventDescriptionTextArea.getText(),(Host) eventOrgComboBox.getValue());
       MainPageController.allEvents.add(con);
       if(mainEventComboBox.getValue() != null){
        mainEventComboBox.getValue().getListOfSubEvents().add(con);
       }
       succAdded("Added new event - " + con.getName() + "!");
        
    }
    //Exhibition
    @FXML
    private TextField exhibitionSubjectTextField;
    @FXML 
    private ComboBox exhibitionAuthorsComboBox;
    @FXML
    private Button exhibitionAddButton;
    @FXML
    private Label listOfAuthorsLabel;
    
    private ArrayList<Author> authors = new ArrayList<>();
     
    @FXML
    private void authorAddButtonAction(ActionEvent event) {
        if(exhibitionAuthorsComboBox.getValue() != null){
            listOfAuthorsLabel.setText(listOfAuthorsLabel.getText() + ", " + exhibitionAuthorsComboBox.getValue());
            authors.add((Author) exhibitionAuthorsComboBox.getValue());
        }
    }
    @FXML
    private void exhibitionAddButtonAction(ActionEvent event) {
        Exhibition ex = new Exhibition(exhibitionSubjectTextField.getText(), authors, 
        eventNameTextField.getText(), (LocalDate) eventStartDatePicker.getValue(), (LocalDate) eventEndDatePicker.getValue(), 
                eventDescriptionTextArea.getText(),(Host) eventOrgComboBox.getValue());
        MainPageController.allEvents.add(ex);
        if(mainEventComboBox.getValue() != null){
            mainEventComboBox.getValue().getListOfSubEvents().add(ex);
        }
        succAdded("Added new event - " + ex.getName() + "!");
    }
    //Promotion
    @FXML
    private TextField promotionTextField;
    @FXML
    private ToggleButton companyToggleButton;
    @FXML
    private ToggleButton productToggleButton;
    @FXML
    private Label errorPromotionLabel;
    @FXML
    private void addPromotionButtonAction(ActionEvent event){
        if(companyToggleButton.isSelected()){
            Promotion prom = new Promotion(new Company(promotionTextField.getText()), 
            eventNameTextField.getText(), (LocalDate) eventStartDatePicker.getValue(), (LocalDate) eventEndDatePicker.getValue(), 
            eventDescriptionTextArea.getText(),(Host) eventOrgComboBox.getValue());
            MainPageController.allEvents.add(prom);
            if(mainEventComboBox.getValue() != null){
                mainEventComboBox.getValue().getListOfSubEvents().add(prom);
            }
            succAdded("Added new event - " + prom.getName() + "!");
        }
        else if(productToggleButton.isSelected()){
            Promotion prom = new Promotion(new Product(promotionTextField.getText()), 
            eventNameTextField.getText(), (LocalDate) eventStartDatePicker.getValue(), (LocalDate) eventEndDatePicker.getValue(), 
            eventDescriptionTextArea.getText(),(Host) eventOrgComboBox.getValue());
            MainPageController.allEvents.add(prom);
            if(mainEventComboBox.getValue() != null){
                mainEventComboBox.getValue().getListOfSubEvents().add(prom);
            }
            succAdded("Added new event - " + prom.getName() + "!");
        }
        else{
            errorPromotionLabel.setText("Choose company or product!");
        }
    }
    @FXML
    private void addOtherEventButtonAction(ActionEvent event){
        OtherEvent other = new OtherEvent(
            eventNameTextField.getText(), (LocalDate) eventStartDatePicker.getValue(), (LocalDate) eventEndDatePicker.getValue(), 
            eventDescriptionTextArea.getText(),(Host) eventOrgComboBox.getValue());
        MainPageController.allEvents.add(other);
        if(mainEventComboBox.getValue() != null){
                mainEventComboBox.getValue().getListOfSubEvents().add(other);
            }
        succAdded("Added new event - " + other.getName() + "!");
    }
    @FXML
    private ToggleGroup companyToggleGroup;
    /**
     * Initializes the controller class.
     */
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        eventDetailsAnchorPane.setVisible(false);
        selectComboBox.getItems().addAll("Concert","Exhibition","Lecture","Promotion","Other Event");
        mainEventComboBox.getItems().add(null);
        mainEventComboBox.getItems().addAll(MainPageController.allEvents);
        promotionAnchorPane.setVisible(false);
        lectureAnchorPane.setVisible(false);
        concertAnchorPane.setVisible(false);
        exhibitionAnchorPane.setVisible(false);
        eventOrgComboBox.getItems().addAll(MainPageController.allHosts);
        populateLecturers();
        populatePerformers();
        populateAuthors();    
    }    
    public void populateLecturers(){
        for(Participant p : MainPageController.allParticipants){
            if(p instanceof Lecturer){
                allLecturers.add(p);
            }
        }
        lectureComboBox.getItems().addAll(allLecturers);
    }
    public void populatePerformers(){
        for(Participant p : MainPageController.allParticipants){
            if(p instanceof Performer){
                allPerformers.add(p);
            }
        }
        concertPerformersComboBox.getItems().addAll(allPerformers);
    }
    public void populateAuthors(){
        for(Participant p : MainPageController.allParticipants){
            if(p instanceof Author){
                allAuthors.add(p);
            }
        }
        exhibitionAuthorsComboBox.getItems().addAll(allAuthors);
    }
    public void succAdded(String mssg){
        cancelButtonAction(null);
        RootController.infoPopUp(mssg);
    }

    
}
