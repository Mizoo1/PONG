package com.example.pong_javafx.logic;

/**
 * Diese Klasse ist für den Aufprall verantwortlich.
 */
public class Collision implements Konstante {
    private final TischLogik tLogik;

    public Collision(TischLogik tLogik) {
        this.tLogik = tLogik;
    }

    /**
     * Diese Methode ist dafür verantwortlich, die Geschwindigkeit des Balls umzukehren,
     * wenn der Ball die Unterseite, die Oberseite oder die Schläger der beiden Spieler berührt.
     */
    public void colis() {
        // Überprüfung, ob der Ball das Spielfeld nach unten, oben oder die Schläger berührt.
        if (tLogik.getBall().getY_pos() > HEIGHT || tLogik.getBall().getY_pos() < 0 || tLogik.getBall().getY_pos() < 50) {
            // Umkehrung der Ballgeschwindigkeit auf der Y-Achse.
            tLogik.getBall().setBallYSpeed(tLogik.getBall().getBallYspeed() * -1);
        }

        // Überprüfung, ob der Ball den Schläger des ersten Spielers berührt.
        if (((tLogik.getBall().getX_pos() + SCHLAEGE_BREITE > tLogik.getList().get(SPIELER_1).getX_pos()) &&
                tLogik.getBall().getY_pos() >= tLogik.getList().get(SPIELER_1).getY_pos() &&
                tLogik.getBall().getY_pos() <= tLogik.getList().get(SPIELER_1).getY_pos() + SCHLAAEGE_LAENGE) ||
                ((tLogik.getBall().getX_pos() < tLogik.getList().get(SPIELER_2).getX_pos() + SCHLAEGE_BREITE) &&
                        tLogik.getBall().getY_pos() >= tLogik.getList().get(SPIELER_2).getY_pos() &&
                        tLogik.getBall().getY_pos() <= tLogik.getList().get(SPIELER_2).getY_pos() + SCHLAAEGE_LAENGE)) {

            /*
             * Wenn die Ballgeschwindigkeit größer als Null ist, wird sie als 1 bezeichnet,
             * andernfalls als -1.
             */
            tLogik.getBall().setBallXspeed((int) (tLogik.getBall().getBallXspeed() + 1 * Math.signum(tLogik.getBall().getBallXspeed())));
            // Umkehrung der Ballgeschwindigkeit auf der X-Achse.
            tLogik.getBall().setBallXspeed(tLogik.getBall().getBallXspeed() * -1);
            // Umkehrung der Ballgeschwindigkeit auf der Y-Achse.
            tLogik.getBall().setBallYSpeed(tLogik.getBall().getBallYspeed() * -1);
        }

        tLogik.getScore().score();
        tLogik.pause();
    }
}
