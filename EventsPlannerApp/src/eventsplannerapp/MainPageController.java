/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eventsplannerapp;

import event.Event;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Callback;
import person.Host;
import person.Participant;
import person.Visitor;


/**
 *
 * @author Casper
 */
public class MainPageController implements Initializable {
    
    public static ObservableList<Host> allHosts = FXCollections.observableArrayList();
    public static ObservableList<Participant> allParticipants = FXCollections.observableArrayList();
    public static ObservableList<Event> allEvents = FXCollections.observableArrayList();
    public static ObservableList<Visitor> allVisitors = FXCollections.observableArrayList();
    
    @FXML
    private AnchorPane eventsAnchorPane;
    @FXML 
    private AnchorPane usersAnchorPane;
    @FXML
    private AnchorPane downloadsAnchorPane;
    @FXML
    private AnchorPane visitorsAnchorPane;
    
    @FXML
    private void allEventsButtonAction(ActionEvent event) {
        eventsAnchorPane.setVisible(true);
        usersAnchorPane.setVisible(false);
        downloadsAnchorPane.setVisible(false);
        visitorsAnchorPane.setVisible(false);
    }
    @FXML
    private void usersButtonAction(ActionEvent event) {
        eventsAnchorPane.setVisible(false);
        usersAnchorPane.setVisible(true);
        downloadsAnchorPane.setVisible(false);
        visitorsAnchorPane.setVisible(false);
    }
    @FXML
    private void optionsButtonAction(ActionEvent event) {
        eventsAnchorPane.setVisible(false);
        usersAnchorPane.setVisible(false);
        downloadsAnchorPane.setVisible(true); 
        visitorsAnchorPane.setVisible(false);
        
    }
    @FXML
    private void visitorsButtonAction(ActionEvent event) {
        eventsAnchorPane.setVisible(false);
        usersAnchorPane.setVisible(false);
        downloadsAnchorPane.setVisible(false);
        visitorsAnchorPane.setVisible(true);
    }
    @FXML
    private Button exitButton;
    @FXML
    private void exitButtonAction(ActionEvent event) {
        Stage stage = (Stage) exitButton.getScene().getWindow();
        stage.close();
    }
    

    @FXML
    private Button deleteEventButton;
    @FXML
    private void deleteEventButtonAction(ActionEvent event) {
        if(eventsTableView.getSelectionModel().getSelectedItem() != null){
            allEvents.remove((Event) eventsTableView.getSelectionModel().getSelectedItem());
        }
        else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information");
            alert.setHeaderText(null);
            alert.setContentText("First select some event from table!");
            alert.showAndWait();
        }
    }
    @FXML
    private Button startMarketingButton;
    @FXML
    private void startMarketingButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
    }

    
    //
    @FXML
    private void addUserAction(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("AddPerson.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle("Add Person");
        stage.showAndWait();
    }
    @FXML
    private void addEventButtonAction(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("AddEvent.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle("Add Event");
        stage.showAndWait();
    }
    @FXML
    private void viewEventButtonAction(ActionEvent e) throws IOException {
        try{
        event = (Event) eventsTableView.getSelectionModel().getSelectedItem();
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("ViewEvent.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle("View Event");
        stage.showAndWait();
        }
        catch(Exception ex){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Information");
                    alert.setHeaderText(null);
                    alert.setContentText("First select some event from table!");
                    alert.showAndWait();
        }
        
        
    }
    @FXML
    private void downloadHostsButtonAction(ActionEvent event){
        try{
        downloadHosts();
        }
        catch(Exception e){
            System.out.println("errorrr");
        }
    }
    @FXML
    private void downloadParticipantsButtonAction(ActionEvent event){
        try{
            downloadParticipants();
        }
        catch(Exception e){
            System.out.println("errorrr");
        }
    }
    @FXML
    private void downloadEventsButtonAction(ActionEvent event){
        try{
            downloadEvents();
        }
        catch(Exception e){
            System.out.println("errorrr");
        }
    }
    @FXML
    private void saveAllButonAction(ActionEvent event){
        RootController rc = new RootController();
        rc.serialisationAllEvents();
        rc.serialisationAllHosts();
        rc.serialisationAllParticipants();
        System.out.println("success!");
    }
    
    @FXML
    private TableView hostTableView;
    
    @FXML
    private TableView participantTableView;
    
    @FXML
    private TableView eventsTableView;
    
    @FXML
    private TableView visitorsTableView;

    /**
     *
     */
    public static Event event;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        eventsAnchorPane.setVisible(true);
        usersAnchorPane.setVisible(false);
        downloadsAnchorPane.setVisible(false);
        visitorsAnchorPane.setVisible(false);
        RootController rc = new RootController();
        rc.startUp();
        /////////////////// Host (Organizators) TableView ///////////////////
        hostTableView.setEditable(true);
        hostTableView.setPlaceholder(new Label(""));
        TableColumn hostNameCol = new TableColumn("Name");
        TableColumn hostLastNameCol = new TableColumn("Lastname");
        TableColumn hostTelephoneCol = new TableColumn("Telephone");
        TableColumn hostEmailCol = new TableColumn("E-mail");
        TableColumn hostNoteCol = new TableColumn("Note");
        hostNameCol.setCellValueFactory(
                    new PropertyValueFactory<>("name")
            );
        hostLastNameCol.setCellValueFactory(
                    new PropertyValueFactory<>("lastName")
            );
        hostTelephoneCol.setCellValueFactory(
                    new PropertyValueFactory<>("telNumber")
            );
        hostEmailCol.setCellValueFactory(
                    new PropertyValueFactory<>("email")
            );
        hostNoteCol.setCellValueFactory(
                    new PropertyValueFactory<>("notes")
            );
        hostTableView.setItems(allHosts);
        hostTableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        hostTableView.getColumns().addAll(hostNameCol,hostLastNameCol,hostTelephoneCol,hostEmailCol,hostNoteCol);
        
        
        /////////////////// Participants TableView ///////////////////
        participantTableView.setEditable(true);
        participantTableView.setPlaceholder(new Label(""));
        TableColumn partNameCol = new TableColumn("Name");
        TableColumn partLastNameCol = new TableColumn("Lastname");
        TableColumn partOrganizationCol = new TableColumn("Organisation");
        partNameCol.setCellValueFactory(
                    new PropertyValueFactory<>("name")
            );
        partLastNameCol.setCellValueFactory(
                    new PropertyValueFactory<>("lastName")
            );
        partOrganizationCol.setCellValueFactory(
                    new PropertyValueFactory<>("orgName")
            );
        participantTableView.setItems(allParticipants);
        participantTableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        participantTableView.getColumns().addAll(partNameCol,partLastNameCol,partOrganizationCol);
        
        /////////////////// Events TableView ///////////////////
        eventsTableView.setEditable(true);
        eventsTableView.setPlaceholder(new Label(""));
        TableColumn eventNameCol = new TableColumn("Name");
        TableColumn eventStartCol = new TableColumn("Start Date");
        TableColumn eventEndCol = new TableColumn("End Date");
        TableColumn eventDescCol = new TableColumn("Description");
        TableColumn eventHostCol = new TableColumn("Organizator");
        eventNameCol.setCellValueFactory(
                    new PropertyValueFactory<>("name")
            );
        eventStartCol.setCellValueFactory(
                    new PropertyValueFactory<>("startDate")
            );
        eventEndCol.setCellValueFactory(
                    new PropertyValueFactory<>("endDate")
            );
        eventDescCol.setCellValueFactory(
                    new PropertyValueFactory<>("description")
            );
        eventHostCol.setCellValueFactory(
                    new PropertyValueFactory<>("host")
            );
        eventStartCol.setSortType(TableColumn.SortType.ASCENDING);
        eventsTableView.setItems(allEvents);
        eventsTableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        eventsTableView.getColumns().addAll(eventStartCol,eventEndCol,eventNameCol,eventDescCol,eventHostCol);
        
        //allVisitors
        populateAllVisitors();
        /////////////////// Visitors TableView ///////////////////
        visitorsTableView.setEditable(true);
        visitorsTableView.setPlaceholder(new Label(""));
        TableColumn visitorNameCol = new TableColumn("Name");
        TableColumn visitorLastNameCol = new TableColumn("Lastname");
        TableColumn visitorAddressCol = new TableColumn("Address");
        TableColumn visitorTelNumCol = new TableColumn("Tel. number");
        TableColumn visitorEmailCol = new TableColumn("E-mail");
        visitorNameCol.setCellValueFactory(
                    new PropertyValueFactory<>("name")
            );
        visitorLastNameCol.setCellValueFactory(
                    new PropertyValueFactory<>("lastName")
            );
        visitorAddressCol.setCellValueFactory(
                    new PropertyValueFactory<>("address")
            );
        visitorTelNumCol.setCellValueFactory(
                    new PropertyValueFactory<>("telNumber")
            );
        visitorEmailCol.setCellValueFactory(
                    new PropertyValueFactory<>("email")
            );
        visitorsTableView.setItems(allVisitors);
        visitorsTableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        visitorsTableView.getColumns().addAll(visitorNameCol,visitorLastNameCol,visitorAddressCol,visitorTelNumCol,visitorEmailCol);
        
        
    }
    
    public void populateAllVisitors(){
        String csvFile = "src/files/visitors.csv";
        String line = "";
        String cvsSplitBy = ";";
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

            while ((line = br.readLine()) != null) {

                // use comma as separator
                String[] visitor = line.split(cvsSplitBy);
                allVisitors.add(new Visitor(visitor[0],visitor[1],visitor[2],visitor[3],visitor[4]));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void downloadHosts() throws IOException{
        File file = new File("src/files/hosts.csv");
        file.createNewFile();
        FileWriter fileWriter = null;
        try{
            fileWriter = new FileWriter(file);
            for(Host h : allHosts){
                fileWriter.write(h.getName()+";"+h.getLastName()+";"+h.getTelNumber()+";"+h.getEmail()+"\n");
            }
            fileWriter.close();
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Obavjestenje");
            alert.setHeaderText(null);
            alert.setContentText("Uspjesno ste preuzeli organizatore.");
            alert.showAndWait();
        }
        catch(Exception e){
            
        }
    }
    public void downloadParticipants() throws IOException{
        File file = new File("src/files/participants.csv");
        file.createNewFile();
        FileWriter fileWriter = null;
        try{
            fileWriter = new FileWriter(file);
            for(Participant p : allParticipants){
                fileWriter.write(p.getName()+";"+p.getLastName()+";"+p.getOrgName()+"\n");
            }
            fileWriter.close();
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Obavjestenje");
            alert.setHeaderText(null);
            alert.setContentText("Uspjesno ste preuzeli ucesnike.");
            alert.showAndWait();
        }
        catch(Exception e){
            
        }
    }
    public void downloadEvents() throws IOException{
        File file = new File("src/files/events.csv");
        file.createNewFile();
        FileWriter fileWriter = null;
        try{
            fileWriter = new FileWriter(file);
            for(Event e : allEvents){
                fileWriter.write(e.toCSV()+"\n");
            }
            fileWriter.close();
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Obavjestenje");
            alert.setHeaderText(null);
            alert.setContentText("Uspjesno ste preuzeli dogadjaje.");
            alert.showAndWait();
        }
        catch(Exception e){
            
        }
    }
    
}
