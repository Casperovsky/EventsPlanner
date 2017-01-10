/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eventsplannerapp;

import event.Event;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Rectangle2D;
import javafx.scene.control.Alert;
import javafx.stage.Screen;
import javafx.stage.Stage;
import person.Host;
import person.Participant;

/**
 *
 * @author MK9
 */
public class RootController {
    private static final int mainPageWidth = 1300;
    private static final int mainPageHeight = 700;
    private static Stage activeStage;
    private Stage ownerStage;
    
    
    public void setStageToCenter(){
        Rectangle2D screenBounds = Screen.getPrimary().getVisualBounds();
        activeStage.setX((screenBounds.getWidth() - mainPageWidth) / 2);
        activeStage.setY((screenBounds.getHeight() - mainPageHeight) / 2);
    }

    
    public static Stage getActiveStage() {
        return activeStage;
    }

    public static void setActiveStage(Stage activeStage) {
        RootController.activeStage = activeStage;
    }

    public Stage getOwnerStage() {
        return ownerStage;
    }

    public void setOwnerStage(Stage ownerStage) {
        this.ownerStage = ownerStage;
    }
    
    public void serialisationAllEvents(){
        ArrayList<Event> events = new ArrayList<>();
        for(Event e : MainPageController.allEvents){
            events.add(e);
        }
        try{
            File file = new File("src/save/allEvents.dat");
            file.createNewFile();
            FileOutputStream fos = new FileOutputStream("src/save/allEvents.dat");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(events);
            oos.close();
            fos.close();
        } catch(Exception e){
            System.out.println("[Error] serialisation allEvents: " + e);
        }
    }
    public void serialisationAllHosts(){
        ArrayList<Host> hosts = new ArrayList<>();
        for(Host h : MainPageController.allHosts){
            hosts.add(h);
        }
        try{
            File file = new File("src/save/allHosts.dat");
            file.createNewFile();
            FileOutputStream fos = new FileOutputStream("src/save/allHosts.dat");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(hosts);
            oos.close();
            fos.close();
        } catch(Exception e){
            System.out.println("[Error] serialisation allHosts: " + e);
        }
    }
    public void serialisationAllParticipants(){
        ArrayList<Participant> participants = new ArrayList<>();
        for(Participant p : MainPageController.allParticipants){
            participants.add(p);
        }
        try{
            File file = new File("src/save/allParticipants.dat");
            file.createNewFile();
            FileOutputStream fos = new FileOutputStream("src/save/allParticipants.dat");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(participants);
            oos.close();
            fos.close();
        } catch(Exception e){
            System.out.println("[Error] serialisation allParticipants: " + e);
        }
    }
    public void startUp(){
        try{
            FileInputStream fis = new FileInputStream("src/save/allEvents.dat");
            ObjectInputStream ois = new ObjectInputStream(fis);
            MainPageController.allEvents.addAll((ArrayList<Event>) ois.readObject());
            fis = new FileInputStream("src/save/allHosts.dat");
            ois = new ObjectInputStream(fis);
            MainPageController.allHosts.addAll((ArrayList<Host>) ois.readObject());
            fis = new FileInputStream("src/save/allParticipants.dat");
            ois = new ObjectInputStream(fis);
            MainPageController.allParticipants.addAll((ArrayList<Participant>) ois.readObject());
        } catch(Exception e){
            System.out.println("[uvoz] " + e);
        }   
        
    }
    public static void infoPopUp(String mssg){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information");
            alert.setHeaderText(null);
            alert.setContentText(mssg);
            alert.showAndWait();
    }
    
    
}
