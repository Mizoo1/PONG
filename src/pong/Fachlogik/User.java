package pong.Fachlogik;

import java.net.InetAddress;
/**
 * 
 * @author Muaaz Bdear
 */
public class User implements Konstante
{
    private String name;
    private int score;
    private double x_pos;
    private double y_pos;
    private boolean isRight;
    private InetAddress ipAdress;
    private int port;

    public User(String name)
    {
        this.name = name;
        x_pos = X_NULL_POSITION;
        y_pos=HEIGHT/2-SCHLAAEGE_LAENGE/2;
        this.isRight=false;
    }
    // setter und getter
    public boolean isIsRight() 
    {
        return isRight;
    }
    public void setName(String name) 
    {
        this.name = name;
    }
    public void setIsRight(boolean i) 
    {
        isRight=i;
    }
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
    public InetAddress getIpAdress() 
    {
        return ipAdress;
    }

    public int getPort() 
    {
        return port;
    }
    @Override
    public String toString() 
    {
        return "High Rank : " + "name=" + name + ", score=" + score ;
    }
}
