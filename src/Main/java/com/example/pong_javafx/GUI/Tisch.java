package com.example.pong_javafx.GUI;

import com.example.pong_javafx.logic.Konstante;
import com.example.pong_javafx.logic.Score;
import com.example.pong_javafx.logic.User;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;

import java.util.List;

/**
 * Klasse Tisch
 * @author Muaaz Bdear
 */
public final  class Tisch extends Scene implements Konstante
{
    private Canvas canvas;
    private StackPane stackPane;
    private final GraphicsContext gc;
    private boolean ok= false;
    private Score score;
    /**
     * Konstruktor der Klasse Tisch
     */
    public Tisch()
    {
        super(new StackPane());
        // Der Tisch
        canvas = new Canvas(WIDTH,HEIGHT);
        gc = canvas.getGraphicsContext2D();
        stackPane = new StackPane();
        this.setRoot(stackPane);
        stackPane.getChildren().addAll(canvas);
    }
    /**
     * Diese Methode dient dazu, der Hintergrundfarbe festzustellen
     * und die Schriftart - groesse einzustellen.
     */
    public void graphicColor()
    {
        //Grafik setzen
        //Hintergrundfarbe feststellen
        gc.setFill(Color.rgb(46, 8, 8));
        gc.fillRect(0, 0, WIDTH, HEIGHT);
        //Schriftart und -groesse einstellen
        gc.setFill(Color.WHITE);
        gc.setFont(Font.font("MONOSPACED",18));
    }
    /**
     * Diese Methode ist dafuer verantwortlich,
     * die Farbe der Punkte entsprechend dem Ergebnis
     * anzugeben. Bei einem Unentschieden erhalten beide
     * Spieler die gelbe Farbe. Wenn einer der beiden Spieler
     * mehr Punkte erzielt, wird die Farbe gruen, und wenn der Spieler
     * weniger Punkte erzielt, hat Punkte die Farbe rot.
     * @param list Die beiden Spieler
     */
    public void scoreColor(List <User>list)
    {
        /*Wenn die Punkte des ersten Spielers hoeher
        sind als die Punkte des zweiten Spielers*/
        if(list.get(SPIELER_1).getScore() > list.get(SPIELER_2).getScore())
        {
            /* Die Punktfarbe des ersten Spielers ist gruen
            und die des zweiten Spielers rot */
            getGc().setStroke(Color.GREEN);
            getGc().strokeText(list.get(SPIELER_1).getName(), 100, 50);
            getGc().strokeText(list.get(SPIELER_1).getScore()+"", 300, 100);
            getGc().setStroke(Color.rgb(219, 71, 71));
            getGc().strokeText(list.get(SPIELER_2).getName(), 800, 50);
            getGc().strokeText(list.get(SPIELER_2).getScore()+"", 600, 100);
         /*Wenn die Punkte des ersten Spielers nidriger
        sind als die Punkte des zweiten Spielers*/
        }else if(list.get(SPIELER_1).getScore() < list.get(SPIELER_2).getScore())
        {
            /*Die Punktfarbe des ersten Spielers ist rot
            und die des zweiten Spielers gruen*/
            getGc().setStroke(Color.rgb(219, 71, 71));
            getGc().strokeText(list.get(SPIELER_1).getName(), 100, 50);
            getGc().strokeText(list.get(SPIELER_1).getScore()+"", 300, 100);
            getGc().setStroke(Color.GREEN);
            getGc().strokeText(list.get(SPIELER_2).getName(), 800, 50);
            getGc().strokeText(list.get(SPIELER_2).getScore()+"", 600, 100);
         /*Bei Punktgleichheit zwischen den beiden Spielern
            wird die Farbe der Punkte fuer jeden der Spieler gelb*/
        }else{
            getGc().setStroke(Color.rgb(159, 171, 83));
            getGc().strokeText(list.get(SPIELER_1).getName(), 100, 50);
            getGc().strokeText(list.get(SPIELER_1).getScore()+"", 300, 100);
            getGc().strokeText(list.get(SPIELER_2).getName(), 800, 50);
            getGc().strokeText(list.get(SPIELER_2).getScore()+"", 600, 100);
        }
        // Das Punkt-Symbol
        getGc().setFill(Color.GREEN);
        /*Mit jedem steigenden Punkt wird neben dem Namen des Spielers
        ein kleiner gruener Punkt auf dem Bildschirm angezeigt*/
        for (int i = 0; i < list.get(SPIELER_1).getScore() ; i++)
        {
            getGc().fillOval(150 +i*10, 50, 5, 5);
        }
        for (int i = 0; i < list.get(SPIELER_2).getScore() ; i++)
        {
            getGc().fillOval(750 -i*10, 50, 5, 5);
        }
    }
    /**
     * Diese Methode ist fuer die Anzeige
     * des Starttextes des Spiels zustaendig.
     */
    public void drawStart()
    {
        getGc().setStroke(Color.rgb(159, 171, 83));
        getGc().setTextAlign(TextAlignment.CENTER);
        getGc().strokeText(START, WIDTH / 2, HEIGHT / 2);
    }
    /**
     * Diese Methode ist fuer die Anzeige der Punkte
     * und die Bekanntgabe des Gewinners verantwortlich.
     * @param s Der Text
     * @param list Die beiden Spieler
     */
    public void drawWin(String s, List <User>list,Score score)
    {
        getGc().setStroke(Color.rgb(46, 149, 70));
        getGc().setTextAlign(TextAlignment.CENTER);
        getGc().strokeText(s, WIDTH / 2, HEIGHT / 3);
        getGc().strokeText(SCHLISSEN, WIDTH / 2, 300);
        getGc().setStroke(Color.WHEAT);
        getGc().strokeText(list.get(SPIELER_1).getName()
                , 180, 200);
        getGc().strokeText(list.get(SPIELER_2).getName()
                , 720, 200);
        getGc().strokeText("Runde 3 :"+score.getRp1_3(), 208, 215);
        getGc().strokeText("Runde 2 :"+score.getRp1_2(), 208, 230);
        getGc().strokeText("Runde 1 :"+score.getRp1_1(), 208, 245);
        getGc().strokeText("Runde 3 :"+score.getRp2_3(), 748, 215);
        getGc().strokeText("Runde 2 :"+score.getRp2_2(), 748, 230);
        getGc().strokeText("Runde 1 :"+score.getRp2_1(), 748, 245);
    }
    /**
     * Diese Methode ist fuer die Anzeige des Endes
     * der Runden zustaendig.
     * @param i Die Anzahl der Runden
     */
    public void drawRunde(int i)
    {
        getGc().setStroke(Color.rgb(65, 159, 125));
        getGc().setTextAlign(TextAlignment.CENTER);
        getGc().strokeText("Runde: "+i+"", WIDTH / 2, HEIGHT / 2);
        getGc().setStroke(Color.YELLOW);
        getGc().strokeText(START, WIDTH / 2, 200);
    }
    /**
     * Diese Methode wird verwendet, um den Pausetext
     * auf dem Bildschirm anzuzeigen
     */
    public void drawPause()
    {
        gc.setStroke(Color.rgb(219, 71, 71));
        gc.setTextAlign(TextAlignment.CENTER);
        gc.strokeText(PAUSE, WIDTH/2, 80);
        getGc().strokeText(WEITER_SPIELEN, WIDTH / 2, 300);
    }
    /**
     * Diese Methode ist fuer das Erstellen von Schlaegern
     * fuer die Spieler verantwortlich und legt die Schlaegerfarbe
     * fuer den ersten Spieler auf Blau und den zweiten Spieler auf
     * Gelb fest.
     * @param list Die beiden Spieler
     */
    public void drawPaddle(List <User>list)
    {
        gc.setFill(Color.rgb(156, 208, 122));
        gc.fillRoundRect(list.get(SPIELER_2).getX_pos(),
                list.get(SPIELER_2).getY_pos(), SCHLAEGE_BREITE, SCHLAAEGE_LAENGE,10,10);
        gc.setFill(Color.rgb(84, 149, 213));
        list.get(SPIELER_1).setX_pos(WIDTH-15);
        gc.fillRoundRect(list.get(SPIELER_1).getX_pos(),
                list.get(SPIELER_1).getY_pos(), SCHLAEGE_BREITE, SCHLAAEGE_LAENGE,10,10);
    }
    /**
     * Diese Methode ist dafuer verantwortlich,
     * um den Geschwindigkeitseffekt eines Spielers zu aktivieren,
     * der die drei Bedingungen erfuellt:
     * 1-Der Spieler befindet sich in der zweiten Runde
     * 2-Die Punkte des Spielers sind um zwei Punkte hoeher als die des Gegners
     * 3-Die Punktzahl des Gegners darf nicht weniger als fünf sein.
     * Danachwird ein gruener Punkt unter dem Schlaeger angezeigt wird.
     * @param i Die Rundenanzahl
     * @param list Die beiden Spieler
     */
    public void drawActionP(int i,List <User>list)
    {
        if (i == 2&& list.get(SPIELER_1)
                .getScore()-2>list.get(SPIELER_2)
                .getScore()&&list.get(SPIELER_2)
                .getScore()>=5)
        {
            getGc().setFill(Color.GREEN);
            getGc().fillOval(80, 420, 5, 5);
        }
        else if (i == 2&& list.get(SPIELER_2)
                .getScore()-2>list.get(SPIELER_1)
                .getScore()&&list.get(SPIELER_1)
                .getScore()>=5)
        {
            getGc().setFill(Color.GREEN);
            getGc().fillOval(820, 420, 5, 5);
        }
    }
    /**
     * Diese Methode ist fuer die Anzeige aller Punkte
     * in jeder Runde zusaetzlich der Anzeige der Nummer
     * fuer die aktuelle Runde verantwortlich.
     * @param i Die Rundenanzahl
     */
    public void drawRang(int i)
    {
        getGc().setStroke(Color.rgb(159, 171, 83));
        getGc().strokeText("Runde: "+i+"/3", 450 , 50);
    }
    // getter und setter
    public boolean isOk()
    {
        return ok;
    }
    public Canvas getCanvas()
    {
        return canvas;
    }
    public StackPane getStackPane()
    {
        return stackPane;
    }
    public GraphicsContext getGc()
    {
        return gc;
    }
    public void setCanvas(Canvas canvas)
    {
        this.canvas = canvas;
    }
    public void setStackPane(StackPane stackPane)
    {
        this.stackPane = stackPane;
    }
    public void setOk(boolean ok)
    {
        this.ok = ok;
    }
}