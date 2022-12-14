package pong.Fachlogik;

import pong.GUI.Tisch;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javafx.scene.paint.Color;
/**
 * 
 * @author Muaaz Bdear
 */
public class TischLogik implements Runnable, Konstante
{ 
   private final Score score;
   private final Collision colision ;
   private final Controller contrl;
   private final List <User>list; 
   private final Ball ball;
   private final Tisch tisch;
   private int isStart =3; 
   private int rundenZähler, iSpeed;
   private final boolean wahl;
   /**
    * Konstruktur der Klasse Tischlogik.
    * Aus jeder dieser Klassen (Collision,Controller,Score,
    * Ball und ArrayList<User>) wird ein Instanz initialisiert
    * und die Methode movement wird in dem Konstruktur aufgerufen
    * @param tisch Instanz der Klasse Tisch
    * @param player1 Der Spieler 1
    * @param player2 Der Spieler 2
    * @param iSpeed Der Faktor zur Verdoppelung der Ballgeschwindigkeit
    * @param wahl Die Auswahl der Kontrolle
    */
   public TischLogik(Tisch tisch,User player1, User player2,int iSpeed,boolean wahl)
   {
       rundenZähler=1;
       ball=new Ball();
       list=new ArrayList<User>();
       list.add(player1);
       list.add(player2);
       list.get(0).setX_pos(0);
       list.get(0).setY_pos(200);
       list.get(1).setX_pos(900);
       list.get(1).setY_pos(250);
       this.tisch=tisch;
       this.colision = new Collision(this);
       this.contrl = new Controller(this);
       this.score = new Score(this);
       this.iSpeed = iSpeed;
       contrl.movements();
       this.wahl = wahl;
   }
   /**
    * Bei dieser Methode gibt es eine Endlosschleife. 
    * Die Methode movement() wird aufgerufen, um die Art der Ansteuerung 
    * der Schläger zu ermitteln, wird dann die Methode graphicColor() aufgerufen,
    * legt die Hintergrundfarbe und die Ballfarbe fest.
    * Ist das Spiel im Gange, werden die Ballgeschwindigkeit
    * ermittelt und Schläger aufgestellt und die Methode colis()
    * wird aufgerufen, dann wird Thread aktiviert.
    */
   @Override
   public void run()
   { 
       //Endlose Schleife
       while(true)
       {
            try{
                contrl.movements();
                tisch.graphicColor();
                if(isStart ==1)
                {
                    ballSpeed(iSpeed);
                    //Spielschläger entstehen
                    tisch.drawPaddle(list);
                    colision.colis();
                }
                else 
                {
                    start();
                }
                Thread.sleep(20);
            }catch(InterruptedException e)
            {
                //Aktuellen Thread deaktivieren
                Thread.currentThread().interrupt();
            }
        } 
    }
   /**
    * Diese Methode ist dafür verantwortlich,
    * den Ball zu erzeugen und seine Geschwindigkeit 
    * zu kontrollieren
    * @param i Der Faktor zur Verdoppelung der
    * Ballgeschwindigkeit nach Wahl des Spielers
    */
    public void ballSpeed(int i)
    {
        this.iSpeed=i;
        ball.setX_pos(ball.getX_pos()+ball.getBallXspeed()* i);
        ball.setY_pos(ball.getY_pos()+ball.getBallYspeed()* i);
        tisch.getGc().setFill(Color.HOTPINK);
        tisch.getGc().fillOval(ball.getX_pos(), ball.getY_pos(), 15, 15);
        tisch.getGc().strokeOval(ball.getX_pos(), ball.getY_pos(), 15, 15);
   }
    /**
    * Diese Methode ist dafür verantwortlich, 
    * den Spielverlauf von Anfang bis Ende 
    * durch die isStart-variable zu bestimmen
    */
    public void start() 
    {
       switch (isStart) 
       {
           case 1 -> run();
           case 2 -> tisch.drawRunde(rundenZähler);
           case 3 -> tisch.drawStart();
           case 4 -> tisch.drawWin(GEWINNER+gewinner(), list,score);
           case 5 -> tisch.drawPause();
       }
    }
    /**
    * Diese Methode wird verwendet, um die Runde zu führen.
    * Wenn ein Spieler einen Punkt erzielt, kehrt der Ball 
    * zum Ausgangspunkt zurück, wobei der Ball jedes Mal in
    * eine zufällige Richtung gelenkt wird
    */
    public void runde ()
    { 
        if(isStart ==1)
        {  
            if(rundenZähler>3) 
            {
                System.exit(0);
            }
        restBallPos();
        ball.setBallXspeed(new Random().nextInt(2) == 0 ? 1: -1);
        ball.setBallYSpeed(new Random().nextInt(2) == 0 ? 1: -1);
        }else if(isStart == 2)
        {
            tisch.drawRunde(rundenZähler);
        }
    ende();
   }
    /**
     * Diese Methode ist für das Beenden des Spiels verantwortlich
     */
    public void ende()
    {
        if(rundenZähler > 3)
        {
            isStart = 4;
        }
    }
    /**
    * Diese Methode ist dafür verantwortlich,
    * die Punkte für die Spieler in den drei Runden
    * zu berechnen und das Ergebnis des Gewinners zurückzugeben
    * @return Der Gewinner
    */
    public String gewinner()
    {
        //Die Ergebnisse der drei Runden werden zusammengezählt
        if(score.getRp1_1()+score.getRp1_2()+score.getRp1_3()>
           score.getRp2_1()+score.getRp2_2()+score.getRp2_3())
        {
            return list.get(SPIELER_1).getName();
        }else 
        {
            return list.get(SPIELER_2).getName();
        }
   }
    /**
     * Diese Methode wird verwendet, um eine Spielpause einzulegen
     */
    public void pause()
    {
        tisch.setOnScroll(e -> isStart = 5);
    }
    /**
     * Diese Methode wird verwendet, um den Geschwindigkeitseffekt
     * eines Spielers zu aktivieren, der die drei Bedingungen erfuellt:
     * 1-Der Spieler befindet sich in der zweiten Runde
     * 2-Die Punkte des Spielers sind um zwei Punkte hoeher als die des Gegners
     * 3-Die Punktzahl des Gegners darf nicht weniger als fünf sein
     * @param i Der Index der Spieler
     */
    public void action(int i)
    {
        if(i ==2)
        {
            if (rundenZähler == 2&& list.get(SPIELER_2)
                .getScore()-2>list.get(SPIELER_1)
                .getScore()&&list.get(SPIELER_1).getScore()>=5)
            { 
                /* Hier muss die Geschwindigkeit umgekehrt werden,
                damit der Ball in Richtung des Gegners gelenkt wird*/
                ball.setBallXspeed(-BALL_ACTION_SPEED);
            }                               
        }else if (i == 1) 
        {
            if (rundenZähler == 2&& list.get(SPIELER_1)
                .getScore()-2>list.get(SPIELER_2)
                .getScore()&&list.get(SPIELER_2).getScore()>=5)
            {
                ball.setBallXspeed(BALL_ACTION_SPEED);
            }
        }
    }
    /**
     * Diese Methode wird verwendet, um den Ball in 
     * die Mitte des Tisches zurückzubringen
     */
    public void restBallPos()
    {
       ball.setX_pos(WIDTH/2);
       ball.setY_pos(HEIGHT/2);
    }
    /**
     * Diese Methode wird verwendet,
     * um die Punkte der Spieler auf Null zu bringen
     */
    public void restScore()
    {
        list.get(SPIELER_2).setScore(0);
        list.get(SPIELER_1).setScore(0);   
    }
    // getter und setter
    public void setIsStart(int isStart) 
    {
        this.isStart = isStart;
    }

    public void setRundenZaehler(int rundenZaehler)
    {
        this.rundenZähler = rundenZaehler;
    }
    public int getRundenZaehler()
    {
        return rundenZähler;
    }
    public Score getScore()
    {
        return score;
    }
    public boolean isWahl()
    {
        return wahl;
    }
        public Tisch getTisch()
    {
        return tisch;
    }
            public List<User> getList()
    {
        return list;
    }
    public Ball getBall()
    {
        return ball;
    }
}


