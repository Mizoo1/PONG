package pong.GUI;

import pong.Fachlogik.Konstante;
import pongl.GUI.Button.SlideButton;
import pongl.GUI.Button.TextFieldButton;
import pongl.GUI.Button.MenuButton;
import pong.Fachlogik.TischLogik;
import pong.Fachlogik.User;
import pongl.GUI.Button.RadioButtonsControler;
import pongl.GUI.Button.RadioButtonsLevel;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import javafx.animation.TranslateTransition;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Toggle;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;
/**
 * 
 * @author Muaaz Bdear
 */
public class GameMenu implements Konstante  
{
    private final Stage stage = new Stage();
    private final VBox mainMenu   = new VBox(10);
    private final VBox playLocal = new VBox(10);
    private final VBox multyPlay = new VBox(10);
    private final VBox option = new VBox(10);
    private final VBox music = new VBox(10);
    private final VBox controler = new VBox(10);
    private final VBox level = new VBox(10);
    private final Pane allPane;
    private  final Pane pane;
    private ImageView imgView;
    private User player1,player2;;
    private int speedController = BALL_SPEED_EASY;
    private boolean controll,on_p1,on_p2;
    /**
     * 
     * @throws Exception 
     */
    public GameMenu() throws Exception 
    {
        pane= new Pane();
        allPane = new Pane();
        image();
        allPane.getChildren().addAll(imgView,pane);
        Rectangle bg = new Rectangle(WIDTH, HEIGHT);
        bg.setFill(Color.AQUA);
        bg.setOpacity(0.4);
        mainMenu();
        pane.getChildren().addAll(bg, mainMenu);
    }
    /**
     * Diese Klasse repraesentiert das Hintergrundbild,
     * das im Menue erscheint.
     * @throws IOException 
     */
    private void image () throws IOException
    {
        Image img;
        try (InputStream inp = Files.newInputStream(Paths.get(PATH))) 
        {
            img = new Image(inp);
        }
        imgView = new ImageView(img);
        imgView.setFitHeight(500);
        imgView.setFitWidth(900);
    }
    /**
     * Diese Methode erstellt und gibt die gesamte Menueleiste
     * mit dem "PLAY LOCAL", MULTIPLAY","OPTION" und "EXIT" zurueck.
     * wird eines der Untemenues per Klick ausgewaehlt, leitet diese Methode
     * den Benutzer zu dem ausgewaehlte Untermenue.
     */
    private void mainMenu()
    {
        MenuButton PlayLocal = new MenuButton(LOCAL,true,250);
        playLocal();
        PlayLocal.setOnMouseClicked(event -> 
        {
            pane.getChildren().add(playLocal);
            TranslateTransition tt = new TranslateTransition(Duration.seconds(0.3), mainMenu);
            tt.setToX(mainMenu.getTranslateX() - OFFSET);
            TranslateTransition tt1 = new TranslateTransition(Duration.seconds(0.4), playLocal);
            tt1.setToX(mainMenu.getTranslateX());
            tt.play();
            tt1.play();
            tt.setOnFinished(even -> 
            {
                pane.getChildren().remove(mainMenu);
            });
        });
        MenuButton multiplay = new MenuButton(MULTI,true,250);
        multyPlay_();
        multiplay.setOnMouseClicked(event -> 
        {
            pane.getChildren().add(multyPlay);
            TranslateTransition tt = new TranslateTransition(Duration.seconds(0.3), mainMenu);
            tt.setToX(mainMenu.getTranslateX() - OFFSET);
            TranslateTransition tt1 = new TranslateTransition(Duration.seconds(0.4), multyPlay);
            tt1.setToX(mainMenu.getTranslateX());
            tt.play();
            tt1.play();
            tt.setOnFinished(even -> 
            {
                pane.getChildren().remove(mainMenu);
            });
        });
        MenuButton btnOption = new MenuButton(OPTION,true,250);
        option();
        btnOption.setOnMouseClicked(event -> 
        {   
            pane.getChildren().add(option);
            TranslateTransition tt = new TranslateTransition(Duration.seconds(0.3), mainMenu);
            tt.setToX(mainMenu.getTranslateX() - OFFSET);
            TranslateTransition tt1 = new TranslateTransition(Duration.seconds(0.4), option);
            tt1.setToX(mainMenu.getTranslateX());
            tt.play();
            tt1.play();
            tt.setOnFinished(even -> 
            {
                pane.getChildren().remove(mainMenu);
            });
        });
        MenuButton btnExit = new MenuButton(EXIT,true,250);
        btnExit.setOnMouseClicked(event -> 
        {
            System.exit(0);
        });
        mainMenu.getChildren().addAll( PlayLocal,multiplay, btnOption, btnExit);
        pos();
    }
    /**
     * Diese Methode erstellt das Menue ”PLAY LOCAL” samt seiner Untermenues
     * "PLAY","BACK" und dieNamefelder.
     * Wird "Play" per Klik ausgewaehlt, leitet die Methode den Benutzer zu 
     * andere Scene "Spieltisch" weiter.
     */
    private void playLocal()
    {
        MenuButton btnBack0_2 = new MenuButton(BACK,true,250);
        TextFieldButton p1= new TextFieldButton(SPIELER_RECHT,20); 
        TextFieldButton p2= new TextFieldButton(SPIELER_LINKS,20); 
        MenuButton play = new MenuButton(PLAY,true,250);
        setUser1(p1.getUser());
        setUser1(p2.getUser());
        play.setDisable(true);
        p1.setOnMouseClicked(event -> 
        {
            setUser1(p1.getUser());
            on_p1 = true;
        }); 
        p2.setOnMouseClicked(event -> 
        {
            setUser2(p2.getUser());
            System.out.println();
            on_p2 = true;
            if(on_p1 && on_p2)
            {
                play.setDisable(false);
            }
        }); 
        play.setOnMouseClicked(event -> 
        {   
            play.setDisable(false);
            player1 = p1.getUser();
            player2 = p2.getUser();
            TischLogik t = new TischLogik(new Tisch(),this.player1,this.player2,speedController,controll);
            Thread thread= new Thread(t);
            thread.start();
            stage.setScene(t.getTisch());
            stage.setTitle(PONG);
            stage.show();
            
        });
        btnBack0_2.setOnMouseClicked(event -> 
        {
            pane.getChildren().add(mainMenu);
            TranslateTransition tt = new TranslateTransition(Duration.seconds(0.3), playLocal);
            tt.setToX(playLocal.getTranslateX() + OFFSET);
            TranslateTransition tt1 = new TranslateTransition(Duration.seconds(0.4), mainMenu);
            tt1.setToX(playLocal.getTranslateX());
            tt.play();
            tt1.play();
            tt.setOnFinished(even -> 
            {
                pane.getChildren().remove(playLocal);
            });
        });
        playLocal.getChildren().addAll(p1,p2,play,btnBack0_2);
    }
    /**
     * Diese Methode erstellt das Menue ”MULTIPLAY” samt seiner Untermenues
     * "PLAY","BACK" und das Namefeld.
     * Wird "Play" per Klik ausgewaehlt, leitet die Methode den Benutzer zu 
     * andere Scene "Spieltisch" weiter.
     */
    private void multyPlay_()
    {
        MenuButton btnBack0_2 = new MenuButton(BACK,true,250);
        TextFieldButton p1= new TextFieldButton(SPIELER_NAME,20);
        MenuButton play_ = new MenuButton(PLAY,true,250);
        setUser1(p1.getUser());
        play_.setDisable(true);
        p1.setOnMouseClicked(event -> 
        {
            setUser1(p1.getUser());
            System.out.println();
            play_.setDisable(false);
        }); 
        play_.setOnMouseClicked(event -> 
        {   
            player1 = p1.getUser();
            TischLogik t = new TischLogik(new Tisch(),this.player1,this.player2,speedController,controll);
            Thread thread= new Thread(t);
            thread.start();
            stage.setScene(t.getTisch());
            stage.setTitle(PONG);
            stage.show();   
        });
        btnBack0_2.setOnMouseClicked(event -> 
        {
            pane.getChildren().add(mainMenu);
            TranslateTransition tt = new TranslateTransition(Duration.seconds(0.3), multyPlay);
            tt.setToX(multyPlay.getTranslateX() + OFFSET);
            TranslateTransition tt1 = new TranslateTransition(Duration.seconds(0.4), mainMenu);
            tt1.setToX(multyPlay.getTranslateX());
            tt.play();
            tt1.play();
            tt.setOnFinished(even -> 
            {
                pane.getChildren().remove(multyPlay);
            });
        });
            multyPlay.getChildren().addAll(p1,play_,btnBack0_2);
    }
    /**
     * Diese Methode erstellt das Menue ”OPTION” samt seiner Untermenues
     * "SOUND","LEVEL","CONTROLER" und "BACK".
     * Wird eines der Untermenues per Klik ausgewaehlt, leitet die Methode 
     * den Benutzer zu dem ausgewaehlte Untermenue weiter.
     */
    private void option()
    {
        MenuButton btnBack0_3 = new MenuButton(BACK,true,250);
        btnBack0_3.setOnMouseClicked(event -> 
        {
            pane.getChildren().add(mainMenu);
            TranslateTransition tt = new TranslateTransition(Duration.seconds(0.3), option);
            tt.setToX(option.getTranslateX() + OFFSET);
            TranslateTransition tt1 = new TranslateTransition(Duration.seconds(0.4), mainMenu);
            tt1.setToX(option.getTranslateX());
            tt.play();
            tt1.play();
            tt.setOnFinished(even -> 
            {
                pane.getChildren().remove(option);
            });
        });
        MenuButton btnSound = new MenuButton(SOUND,true,250);
        level();
        music();
        btnSound.setOnMouseClicked(event ->          
        {
            pane.getChildren().add(music);
            TranslateTransition tt = new TranslateTransition(Duration.seconds(0.3), option);
            tt.setToX(option.getTranslateX() - OFFSET);
            TranslateTransition tt1 = new TranslateTransition(Duration.seconds(0.4), music);
            tt1.setToX(option.getTranslateX());
            tt.play();
            tt1.play();
            tt.setOnFinished(even -> 
            {
               pane.getChildren().remove(option);
            });
        });
        MenuButton btnLevel = new MenuButton(LEVEL,true,250);
        btnLevel.setOnMouseClicked(event -> 
        {
            pane.getChildren().add(level);
            TranslateTransition tt = new TranslateTransition(Duration.seconds(0.3), option);
            tt.setToX(option.getTranslateX() - OFFSET);
            TranslateTransition tt1 = new TranslateTransition(Duration.seconds(0.4), level);
            tt1.setToX(option.getTranslateX());
            tt.play();
            tt1.play();
            tt.setOnFinished(even -> 
            {
               pane.getChildren().remove(option);
            });
        });
        MenuButton btnControler = new MenuButton(CONTROL,true,250);
        controler();
        btnControler.setOnMouseClicked(event -> 
        {
        pane.getChildren().add(controler);
            TranslateTransition tt = new TranslateTransition(Duration.seconds(0.3), option);
            tt.setToX(option.getTranslateX() - OFFSET);
            TranslateTransition tt1 = new TranslateTransition(Duration.seconds(0.4), controler);
            tt1.setToX(option.getTranslateX());
            tt.play();
            tt1.play();
            tt.setOnFinished(even -> 
            {
               pane.getChildren().remove(option);
            });
        });
        option.getChildren().addAll(btnSound,btnLevel,btnControler, btnBack0_3);
    }
    /**
     * Diese Methode erstellt das Untermenue "SOUND" und dint dazu, 
     * die Lautstaercke des Musiks mit einer Schiebetaste zu steuern.
     */
    private void music()
    {
        SlideButton slide=new SlideButton(MUSIK,98);
        MenuButton btnBackMusic = new MenuButton(BACK,true,250);
        btnBackMusic.setOnMouseClicked(event -> 
        { 
            pane.getChildren().add(option);
            TranslateTransition tt = new TranslateTransition(Duration.seconds(0.3), music);
            tt.setToX(music.getTranslateX() + OFFSET);
            TranslateTransition tt1 = new TranslateTransition(Duration.seconds(0.4), option);
            tt1.setToX(music.getTranslateX());
            tt.play();
            tt1.play();
            tt.setOnFinished(even -> 
            {
                pane.getChildren().remove(music);
            });
        });
        music.getChildren().addAll(slide,btnBackMusic);
    }
    /**
     * Diese Methode erstellt das Untermenue "LEVEL" und dint dazu, 
     * die Geschwindigkeit des Balls mit mehrere Radioknopfe zu steuern.
     */
    private void level()
    {
        RadioButtonsLevel rd = new RadioButtonsLevel(LEVEL,98);
        rd.getTg().selectedToggleProperty().addListener((ObservableValue<? extends Toggle> ov, Toggle old_toggle, Toggle new_toggle) -> 
        {
            if (rd.getTg().getSelectedToggle() != null) 
            {
                RadioButton button = (RadioButton) rd.getTg().getSelectedToggle();
                switch (button.getText()) 
                {
                    case HARD -> speedController = BALL_SPEED_HARD;
                    case MEDIUM -> speedController = BALL_SPEED_MEDIUM;
                    case EASY -> speedController = BALL_SPEED_EASY;
                }
            }
        });
        MenuButton btnBackLevel = new MenuButton(BACK,true,250);
        btnBackLevel.setOnMouseClicked(event -> 
        {   
            pane.getChildren().add(option);
            TranslateTransition tt = new TranslateTransition(Duration.seconds(0.3), level);
            tt.setToX(level.getTranslateX() + OFFSET);
            TranslateTransition tt1 = new TranslateTransition(Duration.seconds(0.4), option);
            tt1.setToX(level.getTranslateX());
            tt.play();
            tt1.play();
            tt.setOnFinished(even -> 
            {
                pane.getChildren().remove(level);
            });
        });
        level.getChildren().addAll(rd,btnBackLevel);
    }
    /**
     * Diese Methode erstellt das Untermenue "CONTROLLER" und dint zu
     * festlege der Steuerungsmethode mit dem Tastatur oder mit dem Maus.
     */
    private void controler()
    {
        RadioButtonsControler contrl = new RadioButtonsControler(CONTROL,500);
        contrl.getTg().selectedToggleProperty().addListener((ObservableValue<? extends Toggle> ov, Toggle old_toggle, Toggle new_toggle) -> 
        {
            // Has selection.
            if (contrl.getTg().getSelectedToggle() != null) 
            {
                RadioButton button = (RadioButton) contrl.getTg().getSelectedToggle();
                    switch (button.getText()) 
                    {
                        case MAUS -> controll = true;
                        case TASTATUR -> controll = false;
                        default -> {;}
                    }
            }
        });
        MenuButton btnBackControler = new MenuButton(BACK,true,250);
        btnBackControler.setOnMouseClicked(event -> 
        { 
            pane.getChildren().add(option);
            TranslateTransition tt = new TranslateTransition(Duration.seconds(0.3), controler);
            tt.setToX(controler.getTranslateX() + OFFSET);
            TranslateTransition tt1 = new TranslateTransition(Duration.seconds(0.4), option);
            tt1.setToX(controler.getTranslateX());
            tt.play();
            tt1.play();
            tt.setOnFinished(even -> 
            {
                pane.getChildren().remove(controler);
            });
        });
        controler.getChildren().addAll(contrl,btnBackControler);
    }
    /**
     * Diese Methode dient dazu, den notwendigen Abstand beim Verschieben des
     * Menues beim Auswaehlen einer andere Menue bzw. Untermenue.
     */
    private void pos()
    {
        mainMenu.setTranslateX(300); // verschieben
        mainMenu.setTranslateY(200);
        playLocal.setTranslateX(300); 
        playLocal.setTranslateY(200);
        multyPlay.setTranslateX(300); 
        multyPlay.setTranslateY(200);
        option.setTranslateX(300);
        option.setTranslateY(200);
        music.setTranslateX(300);
        music.setTranslateY(200);
        level.setTranslateX(300); 
        level.setTranslateY(200);
        controler.setTranslateX(300); 
        controler.setTranslateY(200);
        option.setTranslateX(OFFSET);
    }
    // getter und setter
    public Pane getAllPane() 
    {
        return allPane;
    }
    public void setUser1(User user) 
    {
        this.player1 = user;
    }
    public void setUser2(User user)
    {
        this.player2 = user;
    }       
}


