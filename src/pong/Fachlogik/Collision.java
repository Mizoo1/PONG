package pong.Fachlogik;
/**
 * Diese Klasse ist fuer den Aufprall verantwortlich 
 * @author Muaaz Bdear
 */
public class Collision implements Konstante
{
    private final TischLogik tLogik;
    public Collision(TischLogik tLogik)
    {
        this.tLogik = tLogik; 
    }
    /**
     * Diese Methode ist dafuer verantwortlich, 
     * die Geschwindigkeit des Balls umzukehren,
     * wenn der Ball die Unterseite oder die Oberseite 
     * oder die Schlaege der beiden Spieler aufprallt
     */
    public void colis()
   {
        // Es ueberprueft, ob der Ball im Rechteck ist.
	if(tLogik.getBall().getY_pos() > HEIGHT || tLogik.getBall().getY_pos() < 0||tLogik.getBall().getY_pos() < 50)
        {
            // Umkehrung der Ballgeschwindugkeit auf der Y-Achse.
            tLogik.getBall().setBallYSpeed(tLogik.getBall().getBallYspeed()*-1);
        }
        // Es ueberprueft, ob der X-Achse der Ball groesser als die X-Achse des ersten Spielers
        if(((tLogik.getBall().getX_pos() + SCHLAEGE_BREITE > tLogik.getList().get(SPIELER_1).getX_pos())
                                                && 
           // und ob der Y-Achse der Ball groesser oder gleich der Y-Achse des ersten Spielers         
           tLogik.getBall().getY_pos() >= tLogik.getList().get(SPIELER_1).getY_pos()
                                                && 
           // und ob der Y-Achse der Ball kleiner  oder gleich der Y-Achse des ersten Spielers + 100
           tLogik.getBall().getY_pos() <= tLogik.getList().get(SPIELER_1).getY_pos() + SCHLAAEGE_LAENGE) 
                                                || 
           ((tLogik.getBall().getX_pos() < tLogik.getList().get(SPIELER_2).getX_pos() + SCHLAEGE_BREITE) 
                                                && 
           tLogik.getBall().getY_pos() >= tLogik.getList().get(SPIELER_2).getY_pos()
                                                && 
           tLogik.getBall().getY_pos() <= tLogik.getList().get(SPIELER_2).getY_pos() + SCHLAAEGE_LAENGE))
        {
            /* wenn die Zahl der Ballgeschwindigkeit groesser als Null ist,
            wird sie als  1 bezeichnet und wenn sie kleiner ist,wird sie als -1 bezeichnet.
            */ 
            tLogik.getBall().setBallXspeed((int) (tLogik.getBall().getBallXspeed()
            +1*Math.signum(tLogik.getBall().getBallXspeed())));
            // Umkehrung der Ballgeschwindugkeit auf der X-Achse.
            tLogik.getBall().setBallXspeed(tLogik.getBall().getBallXspeed()*-1);
            // Umkehrung der Ballgeschwindugkeit auf der Y-Achse.
            tLogik.getBall().setBallYSpeed(tLogik.getBall().getBallYspeed()*-1);
        }
        tLogik.getScore().score();
        tLogik.pause();
   }
}
