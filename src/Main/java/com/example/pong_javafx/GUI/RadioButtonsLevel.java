package com.example.pong_javafx.GUI;

import com.example.pong_javafx.logic.Konstante;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

/**
 *Diese Klasse ist fuer die Kunfigurierung der optionalen Schaltflaechen
 * der Ballgeschwindigkeit(Easy,Medium,Hard)des Spiels verantwortlich.
 * @author Muaaz Bdear
 */
public class RadioButtonsLevel extends MenuButton implements Konstante
{

    private ToggleGroup tg;
    /**
     * Konstruktur der Klasse RadioButtonsLevel
     * @param name Der Name der Schaltflaeche
     * @param i -
     */
    public RadioButtonsLevel(String name,int i)
    {
        super(name,false,i);
    }
    /**
     * Diese Methode ist verantwortlich fuer die Erstellung
     * spezieller Optionsfelder zur Auswahl der Ballgeschwindigkeit
     */
    @Override
    public void textDesgin()
    {
        RadioButton easy = new RadioButton(EASY);
        RadioButton medium= new RadioButton(MEDIUM);
        RadioButton hard= new RadioButton(HARD);

        // Um nur eine der Optionen auswaehlen zu koennen
        tg = new ToggleGroup();
        easy.setToggleGroup(tg);
        medium.setToggleGroup(tg);
        hard.setToggleGroup(tg);

        // Die Standardgeschwindigkeit der Ball ist Easy
        easy.setSelected(true);

        // Die Auswahlen werden horizontal platziert
        HBox horizonal = new HBox(10);
        horizonal.getChildren().addAll(easy, medium, hard);
        VBox vertickal= new VBox(10);

        // Beschriftung und Schri ftgroesse
        Label lName= new Label(name);
        lName.setFont(new Font("Arial", 24));
        vertickal.getChildren().addAll(lName,horizonal);
        getChildren().add(vertickal);
    }
    //getter
    public ToggleGroup getTg()
    {
        return tg;
    }
}
