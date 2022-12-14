package pongl.GUI.Button;

import pong.Fachlogik.Konstante;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

/**
 * Diese Klasse ist fuer die Erstellung der optionalen Schaltflaechen 
 * der Steuerungsmethode(Maus und Tastatur)des Spiels verantwortlich.
 * @author Muaaz Bdear
 */
public class RadioButtonsControler extends MenuButton implements Konstante
{
    private ToggleGroup tg;
    /**
     * Konstruktur der Klasse RadioButtonsControler
     * @param name Der Name des Knopfs
     * @param i -
     */
    public RadioButtonsControler(String name,int i)
    {  
        super(name,false,i);    
    }
    /**
     * Diese Methode ist verantwortlich fuer die Erstellung 
     * spezieller Optionsfelder zur Auswahl der Art der Spielsteuerung,
     * entweder ueber die Tastatur oder ueber die Maus.
     */
    @Override
    public void textDesgin()
    { 
        RadioButton maus = new RadioButton(MAUS);
        RadioButton tastatur= new RadioButton(TASTATUR);
        
        // Um nur eine der Optionen auswaehlen zu koennen
        tg = new ToggleGroup();
        maus.setToggleGroup(tg);
        tastatur.setToggleGroup(tg);
        
        // Die Standardsteuerung erfolgt ueber die Tastatur
        tastatur.setSelected(true);
        tastatur.setVisible(true);
        
        // Die Auswahlen werden horizontal platziert
        HBox hBox = new HBox(10);
        hBox.getChildren().addAll(maus, tastatur);
        VBox vBox= new VBox(10);
        
        //Beschriftung und Schriftgroesse
        Label lName= new Label(name);
        lName.setFont(new Font("Arial", 24));
        vBox.getChildren().addAll(lName,hBox);
        getChildren().add(vBox);
    }
    // getter
    public ToggleGroup getTg() 
    {
        return tg;
    }
}


