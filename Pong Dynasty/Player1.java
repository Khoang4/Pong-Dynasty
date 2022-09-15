import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * One of the players that will hit the ball and can move around
 * Drawn by John  
 * Code by both Kenny and John
 * 12/9/19
 */
public class Player1 extends Actor
{
    private boolean Swing1 = false;
    private int l = 0;
    private int swingLength1 = 0;
    private int cooldown1 = 0;
    private  int velocity = 0;
    private int g = 1;
    private GreenfootImage imageLeft = new GreenfootImage("Player1_Left.png");
    private GreenfootImage imageRight = new GreenfootImage("Player1_Right.png");
    private GreenfootImage imageRightSwing = new GreenfootImage("Player1_Right_Swing.png");
    private GreenfootImage imageLeftSwing = new GreenfootImage("Player1_Left_Swing.png");
    private boolean left = false;
    
    public void act() 
    {
        swing();
        move();
        orientation();
    } 
    /**determines if the player is swinging/trying to hit the ball
     * Kenny
     */
    private void swing()
    {
        if ((Greenfoot.isKeyDown("g") || Greenfoot.isKeyDown("space")) && cooldown1 >= 15)
        {
            Swing1 = true;
        }
        if ((Greenfoot.isKeyDown("g") || Greenfoot.isKeyDown("space")))
        {
            l++;
        }
        else
        {
            l = 0;
        }
        if (l > 25 || swingLength1 > 15)
        {
            Swing1 = false;
        }
        if (Swing1 == true)
        {
            swingLength1++;
            cooldown1=0;
        }
        else
        {
            swingLength1 = 0;
        }
        cooldown1++;
    }
    /**
     * Getting the player to move 
     * Kenny
     */
    private void move()
    {
        setLocation(getX(), getY()+velocity);
        if(Greenfoot.isKeyDown("d"))
        {
            move(10);
            left = false;
        }
        if(Greenfoot.isKeyDown("a"))
        {
            move(-10);
            left = true;
        }
        if(Greenfoot.isKeyDown("w") && (getY() >= 500))
        {
            velocity = -22;
        }    
        if(Greenfoot.isKeyDown("s"))
        {
            setLocation(getX(), getY()+5);
        }
        velocity += g;
        
        if(getY() > 519)    //stops player from clipping through floor (John)
        {
            setLocation (getX(), 519);
        }
    }
    /**orients which way the image faces
     * John
     */
    public void orientation()
    {
        if (left == true)
        {
            if (Swing1)
            {
                setImage(imageLeftSwing);
            }
            else
            {
                setImage(imageLeft);
            }
        }
        else
        {
            if (Swing1)
            {
                setImage(imageRightSwing);
            }
            else
            {
                setImage(imageRight);
            }
        }
    }
    /**
     * Determines how the player is oriented
     * John
     */
    public boolean getOrientation()
    {
        return left;
    }
}
