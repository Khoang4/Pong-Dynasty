import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

/**
 * Background image for the character to be infront of. Gives aesthetic art for users to play against each other.
 * sounds from sounds-resource.com and 
 * music from soundcloud
 * John and Kenny 
 * 12/6/19
 */

public class Battlefield extends World
{
    
       private int l = 0;
       private int t = 0;
       private double musicChoice;
       private int reimainingTime = 300;
       private int score1;
       private int score2;
       private int time;
       private int numberOfActs;
       private GreenfootSound battleMusic1 = new GreenfootSound("Bit Rush.mp3");
       private GreenfootSound battleMusic2 = 
            new GreenfootSound("VVVVVV Soundtrack 1016 Potential For Anything.mp3");
    /**
     * Constructor for objects of class MyWorld.
     * 
     * John and Kenny
     */
    public Battlefield()
    {    
        // Create a new world with 1000x600 cells with a cell size of 1x1 pixels. (Kenny)
        super(1000, 600, 1, true); 
        FadeOut fadeOut = new FadeOut();
        Player1 play1 = new Player1();
        Player2 play2 = new Player2();
        Ball ball = new Ball();
        addObject(play1,250,100);
        addObject(play2,750,100);
        addObject(ball,500,525);
        battleMusic1.setVolume(30);
        battleMusic2.setVolume(20);
        
        //randomly choose one of two songs (John)
        musicChoice = Math.random();
        if(musicChoice > .5)   
        {
         battleMusic1.play();
        }
        else
        {
         battleMusic2.play();
        }
        time = 0;
        score1 = 0;
        score2 = 0;
        showTime();
        showScore1();
        showScore2();
    }
    
    /**
     * John and Kenny
     */
    public void act()
    {
        Greenfoot.setSpeed(50);
        reset();
        countTime();
        endGame();
    }
    
    /**
     * Returns the player hit by the ball to its original position. Also resets the ball back onto the 
     * origin position
     * John
     */
    public void reset()
    {
        if (getObjects(Player1.class).size() == 0 || getObjects(Player2.class).size() == 0)
        {
            l++;
            removeObjects(getObjects(Ball.class));
        }
        if(l == 80 && getObjects(Player1.class).size() == 0 && t == 0)
        {
            Player1 play1 = new Player1();
            Ball ball = new Ball();
            addObject(play1,250,100);
            addObject(ball,500,525);
            l = 0;
        }
        if(l == 80 && getObjects(Player2.class).size() == 0 && t == 0)
        {
            Player2 play2 = new Player2();
            Ball ball = new Ball();
            addObject(play2,750,100);
            addObject(ball,500,525);
            l = 0;
        }
        //loop initially chosen song 
        if(!battleMusic1.isPlaying() && !battleMusic2.isPlaying())
        {
            if (musicChoice > 0.5)
            {
               battleMusic1.play();
            }
            else
            {
               battleMusic2.play();
            }
        }
    }
    
    /**
     * Calculates the real time of the game
     * John
     */
    private void countTime()
        {
        numberOfActs++;
        time = numberOfActs / 60;
        showTime();
    }
    
    /**
     * Displays the current time of the match
     * Kenny
     */
    private void showTime()
    {
        showText("Time: " + time, 850, 25);
    }
    
    /**
     * Collects the amount of points for the players and displays it on the screen
     * Kenny
     */
    public void addScore(int points1, int points2)
    {
        score1 = score1 + points1;
        showScore1();
        score2 = score2 + points2;
        showScore2();
    }
    
    /**
     * Code for displaying the scores of the players
     * Kenny
     */
    private void showScore1()
    {
        showText("Red Score: " + score1 + " / 3", 150, 25);
    }
    
    private void showScore2()
    {
        showText("Blue Score: " + score2 + " / 3", 150, 60);
    }
    
    /**
     * Displays the winner of the match and returns to the Main Menu or restarts the game
     * John
     */
    public void endGame()
    {
        if(score1 == 3 && t < 100)
        {
            showText("Congratulations!!! Player 1 wins!!!", 500, 300);
            t++;
        }
        if(score2 == 3 && t < 100)
        {
            showText("Congratulations!!! Player 2 wins!!!", 500, 300);
            t++;
        }
        if (t == 100)
        {
            showText("", 500, 300);
            showText("If you would like to play again, press \"enter\".", 500, 275);
            showText("Will return to the menu in " + reimainingTime/60 + " seconds.", 500, 325);
        }
        if (t >= 100)
        {
            reimainingTime--;
        }
        if(Greenfoot.isKeyDown("enter") && (score1 == 3 || score2 == 3))
        {
            battleMusic1.stop();
            battleMusic2.stop();
            Greenfoot.setWorld(new Battlefield());
        }
        if(reimainingTime == 0)
        {
            battleMusic1.stop();
            battleMusic2.stop();
            Greenfoot.setWorld(new MainMenu());
        }
    }
}
