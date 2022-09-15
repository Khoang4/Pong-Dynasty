import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class SingleCharacterSelect here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SingleCharacterSelect extends World
{
    int i = 0;
    int p = 0;
    FadeOut fadeOut = new FadeOut();
    FadeIn fadeIn = new FadeIn();
    Character1Tile c1 = new Character1Tile();
    Character2Tile c2 = new Character2Tile();
    Character3Tile c3 = new Character3Tile();
    Character4Tile c4 = new Character4Tile();
    
    /**
     * Constructor for objects of class SingleCharacterSelect.
     * 
     */
    public SingleCharacterSelect()
    {    
        super(1000, 600, 1);   
        addObject(fadeOut, 500, 300);
        addObject(c1, 350, 150);
        addObject(c2, 650, 150);
        addObject(c3, 350, 450);
        addObject(c4, 650, 450);
    }
    
    public void act()
    {
        if (Greenfoot.isKeyDown("enter") && i < 1) 
        {
            addObject(fadeIn, 500, 300);
            i++;
        }
        if (i >= 1 && i <= 100)
        {
            i++;
        }
        if (i == 100)
        {
            Greenfoot.setWorld(new WorldSelect());
        }
        
        //to main menu
        if (Greenfoot.isKeyDown("backspace") && p < 1) 
        {
            addObject(fadeIn, 500, 300);
            p++;
            Greenfoot.playSound("BBS Back.wav");
        }
        if (p >= 1 && p <= 100)
        {
            p++;
        }
        if (p == 100)
        {
            Greenfoot.setWorld(new MainMenu());
        }
    }
}