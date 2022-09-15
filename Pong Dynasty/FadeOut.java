import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Gets rid of the black screen in order to show the new screen
 * 
 * John
 * 11/30/19
 */
public class FadeOut extends Actor
{
    private int fade = 255; 
    private int i = 0;
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
