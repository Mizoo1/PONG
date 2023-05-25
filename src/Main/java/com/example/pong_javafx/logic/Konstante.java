package com.example.pong_javafx.logic;


/**
 *
 * @author Muaaz Bdear
 */
public interface Konstante
{
    // Die Standardszenewerte
    int HEIGHT = 500;
    int WIDTH = 900;
    // Die Schlaege
    int SCHLAAEGE_LAENGE = 100;
    int SCHLAEGE_BREITE = 15;
    // Die Ball
    int BALL = 15;
    // Konstanten bezüglich Punktzahl und Runden
    int MAX_SCORE = 21;
    int MIN_SCORE = 15;
    int MAX_RUNDEN = 3;
    // die Spieler
    int SPIELER_1 = 1;
    int SPIELER_2 = 0;
    // die Schlaegebewegungsabstand
    int YPOSITION = 30;
    int YPOSITION_UNTEN = 400;
    int YPOSITION_OBEN = 10;
    // Konstante Erhöhung der Ballgeschwindigkeit auf der x- und y-Achse
    int BALL_STD_SPEED_X = 12;
    int BALL_STD_SPEED_Y = 5;
    // Die Standardgeschwindigkeit
    int BALL_Y_SPEED = 1;
    int BALL_x_SPEED = 1;
    // Ballgeschwindigkeit
    int BALL_SPEED_EASY = 3;
    int BALL_SPEED_MEDIUM = 6;
    int BALL_SPEED_HARD = 9;
    // Ball-Achtionspeed
    int BALL_ACTION_SPEED = 10;
    //
    // x-Achse verschieben
    int SET_X = 300;
    int SET_Y = 200;

    int OFFSET = 400;
    // Die Standardballposition
    double X_POSITION = WIDTH/2;
    double Y_POSITION = HEIGHT/2;
    double X_NULL_POSITION = 0;
    // Strings
    String WEITER_SPIELEN = "Klick oder Enter um zu spielen";
    String START = "Klick oder Enter";
    String SCHLISSEN = "Klick oder Enter um zu schliessen";
    String PAUSE =  "Pause";
    String MAUS =  "MOUSE";
    String HARD ="Hard";
    String MEDIUM ="Medium";
    String EASY ="Easy";
    String TASTATUR = "KEYBOARD";
    String VERBUNDEN = "ist verbunen ";
    String PATH = "D:\\Muaaz\\Studim\\Semester 4\\Softwaretechnik II\\Neuer Ordner\\Pong_JavaFx\\src\\main\\java\\com\\example\\pong_javafx\\model\\ss.jpg";
    String LOCAL = "PLAY LOCAL";
    String MULTI = "MULTIPLAY";
    String OPTION = "OPTION";
    String EXIT = "EXIT";
    String BACK = "BACK";
    String SPIELER_RECHT = "User Name right";
    String SPIELER_LINKS = "User Name Links";
    String SPIELER_NAME = "User Name";
    String PLAY = "PLAY";
    String PONG = "PONGSPIEL";
    String SOUND ="SOUND";
    String LEVEL = "LEVEL";
    String CONTROL = "CONTROL";
    String MUSIK ="Music";
    String GEWINNER = "Gewinner ist: ";
}