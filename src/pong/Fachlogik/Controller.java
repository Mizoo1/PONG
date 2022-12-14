package pong.Fachlogik;

import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

/**
 * Diese Klasse dient zur benutzung der Tastaur,
 * die Maus, und die Optionkonntrolle
 * @author Muaaz Bdear
 */
public class Controller implements Konstante
{
    private final TischLogik tLogik
;    /**
     * Konstruktor der Klasse 
     * @param t 
     */
    public Controller(TischLogik t) 
    {
        this.tLogik = t;
    }
    /**
     * Diese Methode ist fuer alle Steuerbewegungen im Spiel mit Maus und Tastatur zustaendig.
     */
    public void movements()
   {
    tLogik.getList().add(new User("p1"));
    tLogik.getList().add(new User("p2"));
    /*Die Maus funktioniert, wenn die Auswahl des Spielers aus der Kontrollliste mit der Maus erfolgt*/
    if (tLogik.isWahl())
    {
        // Mauskontrolle
        tLogik.getTisch().getCanvas().setOnMouseMoved(e ->  tLogik.getList().get(SPIELER_2).setY_pos(e.getY()));
        tLogik.getTisch().setOnMouseClicked(e ->  tLogik.setIsStart(1) );
    }
        // Tastaturkontrolle
        tLogik.getTisch().setOnKeyPressed((KeyEvent e) ->
        {
            if(e.getCode() == KeyCode.ENTER)
            {
             
                tLogik.setIsStart(1); 
            }
            if(e.getCode() == KeyCode.UP)
            {
                /* Bestimmen der Entfernung von oben,
                ueber die ein Spieler den Schlaeger bewegen kann*/
                if (tLogik.getList().get(SPIELER_1).getY_pos()==-YPOSITION_OBEN)
                {
                    tLogik.getList().get(SPIELER_1).setY_pos(-YPOSITION_OBEN);
                }
                else
                /*Die spezifische Entfernung, die sich der Schlaeger bei jedem Tastendruck bewegt*/
                {
                tLogik.getList().get(SPIELER_1).setY_pos(tLogik.getList().get(SPIELER_1).getY_pos()-YPOSITION);
                }
            }
            else if(e.getCode() == KeyCode.DOWN)
            {   /* Bestimmen der Entfernung von unten,
                ueber die ein Spieler den Schlaeger bewegen kann*/
                if (tLogik.getList().get(SPIELER_1).getY_pos()==YPOSITION_UNTEN)
                {
                    tLogik.getList().get(SPIELER_1).setY_pos(YPOSITION_UNTEN);
                }else
                {  
                /*Die spezifische Entfernung, die sich der Schlaeger bei jedem Tastendruck bewegt*/
                tLogik.getList().get(SPIELER_1).setY_pos(tLogik.getList().get(SPIELER_1).getY_pos()+YPOSITION);
                }
                /*Die Tastatur funktioniert, wenn die Auswahl des Spielers aus der Kontrollliste mit der Tastatur erfolgt*/
            } else if (e.getCode() == KeyCode.W&&!tLogik.isWahl())
            {
                if (tLogik.getList().get(SPIELER_2).getY_pos()==-YPOSITION_OBEN)
                {
                    tLogik.getList().get(SPIELER_2).setY_pos(-YPOSITION_OBEN);
                }
                else
                {                    
                tLogik.getList().get(SPIELER_2).setY_pos(tLogik.getList().get(SPIELER_2).getY_pos()-YPOSITION);
                }
            }else if(e.getCode() == KeyCode.S&&!tLogik.isWahl())
            {   
                if (tLogik.getList().get(SPIELER_2).getY_pos()==YPOSITION_UNTEN)
                {
                    tLogik.getList().get(SPIELER_2).setY_pos(YPOSITION_UNTEN);
                }
                else
                {  
                tLogik.getList().get(SPIELER_2).setY_pos(tLogik.getList().get(SPIELER_2).getY_pos()+YPOSITION);
                } 
            }else if(e.getCode() == KeyCode.P)
            {
                tLogik.setIsStart(5);
             //Die Action-Taste des ersten Spielers
            }else if (e.getCode() == KeyCode.Q)
            {
                tLogik.action(1);
             //Die Action-Taste des zweiten Spielers   
            }else if (e.getCode() == KeyCode.SHIFT)
            {
                tLogik.action(2);
            }
        });
        /*Die spezifische Entfernung, die sich der Schlaeger nach jedem Tastendruck bewegt*/
        tLogik.getTisch().getCanvas().setOnKeyReleased((KeyEvent e) ->
        {
            if(e.getCode() == KeyCode.UP)
            {
                if (tLogik.getList().get(SPIELER_1).getY_pos()==-YPOSITION_OBEN)
                {
                     tLogik.getList().get(SPIELER_1).setY_pos(-YPOSITION_OBEN);
                }else {
                    tLogik.getList().get(SPIELER_1).setY_pos(tLogik.getList().get(SPIELER_1).getY_pos()-YPOSITION);
                }
            }
            else if(e.getCode() == KeyCode.DOWN)
            {
                if (tLogik.getList().get(SPIELER_1).getY_pos()==YPOSITION_UNTEN)
                {
                     tLogik.getList().get(SPIELER_1).setY_pos(YPOSITION_UNTEN);
                }else {
                    tLogik.getList().get(SPIELER_1).setY_pos(tLogik.getList().get(SPIELER_1).getY_pos()+YPOSITION);
                }
            }else if(e.getCode() == KeyCode.W&&!tLogik.isWahl())
            {
                if (tLogik.getList().get(SPIELER_2).getY_pos()==-YPOSITION_OBEN)
                {
                     tLogik.getList().get(SPIELER_2).setY_pos(-YPOSITION_OBEN);
                }else {
                    tLogik.getList().get(SPIELER_2).setY_pos(tLogik.getList().get(SPIELER_2).getY_pos()-YPOSITION);
                }
            }else if(e.getCode() == KeyCode.S&&!tLogik.isWahl())
            {
                if (tLogik.getList().get(SPIELER_2).getY_pos()==YPOSITION_UNTEN)
                {
                     tLogik.getList().get(SPIELER_2).setY_pos(YPOSITION_UNTEN);
                }else {
                    tLogik.getList().get(SPIELER_2).setY_pos(tLogik.getList().get(SPIELER_2).getY_pos()+YPOSITION);
                }
            }
        });
    }
}
