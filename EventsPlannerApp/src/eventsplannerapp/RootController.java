/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eventsplannerapp;

import javafx.geometry.Rectangle2D;
import javafx.stage.Screen;
import javafx.stage.Stage;

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


    
    
}
