import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Makes the screen black in order to transition to the next world
 * 
 * Kenny 
 * 11/29/19
 */
public class FadeIn extends Actor
{
    private int fade = 0; 
    private int i = 0;
    /**
     * Act - do whatever the FadeIn wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if (i < 85)
        {
           fadeIn();
           i++;
        }
    }    
    public void fadeIn() //KH
    {
        if(fade <= 240)
        {
           getImage().setTransparency(fade);
           fade +=10;
        }
        else 
        {
            if(fade >= 250)
            fade = 255;
        }
    }
    
    
}
