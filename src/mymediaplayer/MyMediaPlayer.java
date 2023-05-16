/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package mymediaplayer;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 *
 * @author Avria
 */
public class MyMediaPlayer extends Application{
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("My Media Players");
        
        scene.setOnMouseClicked((MouseEvent event)-> {
            if(event.getClickCount() == 2) {
                stage.setFullScreen(true);
            }
            });
        
        
        
        stage.show();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
    
}
