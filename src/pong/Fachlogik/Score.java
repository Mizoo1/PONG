package pong.Fachlogik;
/**
 * Diese Klasse ist fuer die Berechnung der Punkte 
 * fuer die Spieler verantwortlich
 * @author Muaaz Bdear
 */
public class Score implements Konstante
{
    private final TischLogik tLogik;
    private int  rp1_1,rp1_2,rp1_3,rp2_1,rp2_2,rp2_3;
    /**
     * Konstruktor der Klasse Score
     * @param t 
     */
    public Score(TischLogik t) 
    {
        this.tLogik = t;
    }
    /**
     * Diese Methode dient dazu, die Punktzahl der beiden 
     * Spieler zu berechnen.
     * Die Methoden maxScore() und minScore() und tur() werden
     * aufgerufen.
     */
    public void score()
   {
        maxScore();
        minScore();
        tur();
        /*Die Punktzahlen und das Action-Sympol 
        werden auf dem Bildschirm angezeigt*/
        tLogik.getTisch().scoreColor(tLogik.getList());
        tLogik.getTisch().drawRang(tLogik.getRundenZaehler());
        tLogik.getTisch().drawActionP(tLogik.getRundenZaehler(),tLogik.getList());
        tLogik.getTisch().drawActionP(tLogik.getRundenZaehler(), tLogik.getList());
    }  
    /**
     * Diese Methode wird verwendet,
     * um das Min_Score (15) zu kontrollieren.
     * Wenn die Punktzahl eines Spielers min. 15 Punkte erreicht und
     * der Spieler übertrifft den Gegner um zwei Punkte, endet die Runde
     */
    public void minScore()
    {
        if(tLogik.getList().get(SPIELER_1).getScore()>=MIN_SCORE&&
           tLogik.getList().get(SPIELER_1).getScore()>tLogik.getList()
           .get(SPIELER_2).getScore()+2||tLogik.getList().get(SPIELER_2)
           .getScore()>=MIN_SCORE&&tLogik.getList().get(SPIELER_2)
           .getScore()>tLogik.getList().get(SPIELER_1).getScore()+2)
        {
            switch (tLogik.getRundenZaehler())
            {
                // In der ersten Runde
                case 1 -> 
                {
                    //Die Ergebnisse der ersten Runde werden gespeichert
                    rp1_1= tLogik.getList().get(SPIELER_1).getScore();
                    rp2_1= tLogik.getList().get(SPIELER_2).getScore();
                    //Der Zähler wird auf Null zurückgesetzt
                    tLogik.getList().get(SPIELER_1).setScore(0);
                    tLogik.getList().get(SPIELER_2).setScore(0);
                }
                // In der zweiten Runde
                case 2 -> 
                {
                    //Die Ergebnisse der zweiten Runde werden gespeichert
                    rp1_2= tLogik.getList().get(SPIELER_1).getScore();
                    rp2_2= tLogik.getList().get(SPIELER_2).getScore();
                    //Der Zähler wird auf Null zurückgesetzt
                    tLogik.getList().get(SPIELER_1).setScore(0);
                    tLogik.getList().get(SPIELER_2).setScore(0);
                }
                // In der dritten Runde
                case 3 -> 
                {
                    //Die Ergebnisse der dritten Runde werden gespeichert
                    rp1_3= tLogik.getList().get(SPIELER_1).getScore();
                    rp2_3= tLogik.getList().get(SPIELER_2).getScore();
                    //Der Zähler wird auf Null zurückgesetzt
                    tLogik.getList().get(SPIELER_1).setScore(0);
                    tLogik.getList().get(SPIELER_2).setScore(0);
                }
            }
            tLogik.setRundenZaehler(tLogik.getRundenZaehler()+1);
            tLogik.setIsStart(2);
            tLogik.runde();  
        }
    }
    /**
     * Diese Methode wird verwendet,
     * um das Max_Score (21) zu kontrollieren.
     * Wenn die Punktzahl eines Spielers 21 erreicht, endet die Runde
     */
    public void maxScore()
    {
        /* Wenn die Punktzahl eines Spielers 21 erreicht*/
        if(tLogik.getList().get(SPIELER_1).getScore() == MAX_SCORE 
           || tLogik.getList().get(SPIELER_2).getScore() == MAX_SCORE)
        {
            // Ergebnisse nach Anzahl der Runden sortieren
            switch (tLogik.getRundenZaehler()) 
            {
                case 1 -> 
                {
                    //Die Ergebnisse der ersten Runde werden gespeichert
                    rp1_1= tLogik.getList().get(SPIELER_1).getScore();
                    rp2_1= tLogik.getList().get(SPIELER_2).getScore();
                    //Der Zähler wird auf Null zurückgesetzt
                    tLogik.getList().get(SPIELER_1).setScore(0);
                    tLogik.getList().get(SPIELER_2).setScore(0);
                }
                case 2 -> 
                {
                    ////Die Ergebnisse der zweiten Runde werden gespeichert
                    rp1_2= tLogik.getList().get(SPIELER_1).getScore();
                    rp2_2= tLogik.getList().get(SPIELER_2).getScore();
                    //Der Zähler wird auf Null zurückgesetzt
                    tLogik.getList().get(SPIELER_1).setScore(0);
                    tLogik.getList().get(SPIELER_2).setScore(0);
                }
                case 3 -> 
                {
                    ////Die Ergebnisse der dritten Runde werden gespeichert
                    rp1_3= tLogik.getList().get(SPIELER_1).getScore();
                    rp2_3= tLogik.getList().get(SPIELER_2).getScore();
                    //Der Zähler wird auf Null zurückgesetzt
                    tLogik.getList().get(SPIELER_1).setScore(0);
                    tLogik.getList().get(SPIELER_2).setScore(0);
                }
            }
            //Die Erhoehung der Rundenzahl um 1
            tLogik.setRundenZaehler(tLogik.getRundenZaehler()+1);
            tLogik.setIsStart(2);
            tLogik.runde();
        }
    }
    /**
     * Diese Kategorie ist dafür verantwortlich,
     * Punkte für jeden einzelnen Spieler zu sammeln 
     * und die Geschwindigkeit des Balls nach jeder 
     * Aufprell zu erhöhen
     */
    public void tur()
    {
        //Wenn Spieler 1 den Ball verfehlt, bekommt Spieler 2 einen Punkt
        if(tLogik.getBall().getX_pos() < tLogik.getList().get(SPIELER_2).getX_pos() - SCHLAEGE_BREITE) 
        {  
            tLogik.getList().get(SPIELER_2).setScore(tLogik.getList().get(SPIELER_2).getScore()+1);
            /*Erhoehung der Ballgeschwindigkeit nach
            jedem Aufprall auf der x- und y-Achse*/
            tLogik.getBall().setBallXspeed(BALL_STD_SPEED_X);
            tLogik.getBall().setBallYSpeed(BALL_STD_SPEED_Y);
            tLogik.runde(); 
        }
        //Wenn Spieler 2 den Ball verfehlt, bekommt Spieler 1 einen Punkt
        if(tLogik.getBall().getX_pos() > tLogik.getList().get(SPIELER_1).getX_pos() + SCHLAEGE_BREITE) 
        {  
            // Die Punktzahl wird um 1 erhoeht
            tLogik.getList().get(SPIELER_1).setScore(tLogik.getList().get(SPIELER_1).getScore()+1);
            /*Erhoehung der Ballgeschwindigkeit nach 
            jedem Aufprall auf der x- und y-Achse*/
            tLogik.getBall().setBallYSpeed(BALL_STD_SPEED_X);
            tLogik.getBall().setBallYSpeed(BALL_STD_SPEED_Y);
            tLogik.runde();  
        }
    }
    //setter und getter
    public int getRp1_1() 
    {
        return rp1_1;
    }
    public int getRp1_2() 
    {
        return rp1_2;
    }
    public int getRp1_3() 
    {
        return rp1_3;
    }
    public int getRp2_1() 
    {
        return rp2_1;
    }
    public int getRp2_2() 
    {
        return rp2_2;
    }
    public int getRp2_3() 
    {
        return rp2_3;
    }
}
