package com.example.pong_javafx.main;

import com.example.pong_javafx.GUI.GameMenu;
import com.example.pong_javafx.logic.Konstante;
import java.io.IOException;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
/**
 * Die Klasse Main mit der Main-Methode
 * @author Muaaz Bdear
 */
public class Main extends Application implements Konstante
{

    private boolean ok = false;
    private Stage stage;
    public static void main(String [] args) throws IOException
    {
        launch();
    }
    @Override
    public void start(Stage stage) throws Exception
    {
        GameMenu gm= new GameMenu();
        this.stage = stage;
        stage.setTitle("PONG");
        Scene scene = new Scene(gm.getAllPane(),WIDTH,HEIGHT);
        stage.setScene(scene);
        stage.show();
    }
}