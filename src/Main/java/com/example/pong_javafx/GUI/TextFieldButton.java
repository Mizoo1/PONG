package com.example.pong_javafx.GUI;

import com.example.pong_javafx.logic.User;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

/**
 * Dieser Klasse ist dafuer verantwortlich, ein Textfeld
 * zu erstellen.
 * @author mouaz
 */
public class TextFieldButton extends MenuButton
{
    private User user;
    /**
     * Konstruktur der Klasse TextFieldButton
     * @param name Der Name des Knopfs
     * @param zahl Die groesse des Knopfs
     */
    public TextFieldButton(String name,int zahl)
    {
        super(name,false,zahl);
    }

    @Override
    public void textDesgin()
    {
        HBox box = new HBox(5);
        // Das Textfeld
        TextField tf= new TextField(super.name);
        MenuButton b = new MenuButton("Accept",true,98);
        // Beim Knopfdruck wird ein 'user' initialisiert.
        b.setOnMouseClicked((e)->
        {
            user= new User(tf.getText());
            System.out.print(getUser().toString());
            b.setDisable(true);
            tf.setDisable(true);
        });
        // HBox objekte
        box.getChildren().addAll(tf,b);
        getChildren().addAll(box);
    }
    // getter
    public User getUser()
    {
        return user;
    }
}
