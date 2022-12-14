package pong.Fachlogik;
/**
 * Diese Klasse ist fuer die Position 
 * des Balls auf der Koordinatenachse 
 * und fuer die Geschwindigkeit des Balls 
 * jeweils fuer die X-Achse und die Y-Achse 
 * verantwortlich.
 * @author Muaaz Bdear
 */
public class Ball implements Konstante
{
    private double x_pos;
    private double y_pos;
    private int ballYSpeed;
    private int ballXSpeed;
    /**
     * Konstruktur der Klasse Ball.
     * in der Konstruktur werden die Standardposition
     * und die Standardgeschwindigkeit des Balls definiert.
     */
    public Ball() 
    {
        x_pos = X_POSITION;
        y_pos = Y_POSITION;
        ballYSpeed = BALL_Y_SPEED;
        ballXSpeed = BALL_x_SPEED;
    }
    //getter und setter
    public double getX_pos() 
    {
        return x_pos;
    }
    public double getY_pos() 
    {
        return y_pos;
    }
    public int getBallYspeed() 
    {
        return ballYSpeed;
    }
    public int getBallXspeed() 
    {
        return ballXSpeed;
    }
    public void setX_pos(double x_pos)
    {
        this.x_pos = x_pos;
    }
    public void setY_pos(double y_pos)
    {
        this.y_pos = y_pos;
    }
    public void setBallYSpeed(int ballYSpeed) 
    {
        this.ballYSpeed = ballYSpeed;
    }
    public void setBallXspeed(int ballXSpeed) 
    {
        this.ballXSpeed = ballXSpeed;
    }
}
