import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class FadeOut here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class FadeOut extends Actor
{
    int fade = 255; 
    int i = 0;
    /**
     * Act - do whatever the FadeOut wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if (i < 85)
        {
           fadeOut();
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
    
    public void fadeOut() //JM
    {
        if(fade >= 15)
        {
           getImage().setTransparency(fade);
           fade -=10;
        }
        else 
        {
            if(fade == 5)
            fade = 0;
        }
    }
}
