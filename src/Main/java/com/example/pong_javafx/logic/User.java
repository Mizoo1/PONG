package com.example.pong_javafx.logic;

/**
 *
 * @author Muaaz Bdear
 */
public class User implements Konstante
{
    private final String name;
    private int score;
    private double x_pos;
    private double y_pos;

    public User(String name)
    {
        this.name = name;
        x_pos = X_NULL_POSITION;
        y_pos= (double) HEIGHT /2- (double) SCHLAAEGE_LAENGE /2;
        boolean isRight = false;
    }
    // setter und getter

    public void setX_pos(double x_pos)
    {
        this.x_pos = x_pos;
    }
    public void setY_pos(double y_pos)
    {
        this.y_pos = y_pos;
    }
    public void setScore(int score)
    {
        this.score = score;
    }
    public double getX_pos()
    {
        return x_pos;
    }
    public double getY_pos()
    {
        return y_pos;
    }
    public String getName()
    {
        return name;
    }
    public int getScore()
    {
        return score;
    }


    @Override
    public String toString()
    {
        return "High Rank : " + "name=" + name + ", score=" + score ;
    }
}