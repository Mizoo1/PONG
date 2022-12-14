package pongl.GUI.Button;

import javafx.scene.effect.DropShadow;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.effect.Glow;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
/**
 * Diese Klasse ist für die Erstellung von Schaltflaechen
 * in den Menues zustaendig
 * @author mouaz
 */
public class MenuButton extends StackPane 
{
    protected String name;
    private Rectangle rAngle;
    private Text text;
    private final boolean check;
    private final int zahl;
    /**
     * Konstruktur der Klasse MenuButton.
     * In der Konstruktur werden die Methoden 'textDesgin()' und 
     * 'effekt()' aufgerufen.
     * @param name Der Name der Schaltflaeche
     * @param ok Die Effektbestaetigung
     * @param zahl Die Groesse der Schaltflaeche
     */
    public MenuButton(String name,boolean ok,int zahl)
    {
        this.check = ok;
        this.name = name;
        this.zahl=zahl;
        textDesgin();
        effekt ();
    }
    /**
     * Diese Methode repraesentiert Effekte,
     * wenn die Maus die Schaltflaeche beruehrt, verschiebt sich
     * die Schaltflaeche auf der x-Achse um 10 nach rechts.
     * Die Hintergrundfarbe wird Schwarz und der Text weiss.
     * Sobald die Maus die Schaltflaeche nicht mehr beruehert,
     * ist der oben gennante Effekt nicht mehr da.
     */
    public void effekt()
    {
        if(check)
        {
            // Bei Mausberuehrung
            setOnMouseEntered(event -> 
            {
                rAngle.setTranslateX(10); 
                text.setTranslateX(10);
                rAngle.setFill(Color.WHEAT);
                text.setFill(Color.BLACK);
            });
            // Bei nicht Beruehrung der Maus
            setOnMouseExited(event -> 
            {
                rAngle.setTranslateX(0);
                text.setTranslateX(0);
                rAngle.setFill(Color.BLACK);
                text.setFill(Color.WHEAT);
            });
            // Ein Instanz von der Klasse DropShadow initialisiert.
            DropShadow drop = new DropShadow(50, Color.WHEAT);
            drop.setInput(new Glow());
            /* Wenn man mit der Maus auf die Schaltflaeche klickt,
            leuchtet die Schaltfläche so lange auf bis nicht mehr
            geklickt ist*/
            setOnMousePressed(event -> setEffect(drop));
            setOnMouseReleased(event -> setEffect(null));
        }
    }
    /**
     * Diese Methode ist zustaendig, um das Textdesgin zu erstellen
     */
    public void textDesgin()
    {
        text = new Text(name);
        text.setFont(Font.font(20));
        rAngle = new Rectangle(zahl, 50);
        rAngle.setOpacity(0.3);
        rAngle.setFill(Color.WHITE);
        getChildren().addAll(rAngle, text);
    }
    // setter und getter
    public String getName()
    {
        return name;
    }
    public Rectangle getRAngle() 
    {
        return rAngle;
    }
}
