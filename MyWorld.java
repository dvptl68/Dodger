import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{
    private int number = -1;
    private int score = 0;
    private int difficulty = 0;
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1);
        prepare();
    }
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {

        Start start = new Start();
        addObject(start,getWidth()/2,getHeight()/2);
    }
    public void start1(){
        List objects = getObjects(null);
        removeObjects(objects);
        difficulty = 1;
        Ship ship = new Ship();
        addObject(ship,292,290);
        ship.setLocation(291,340);
        showText("Score: 0", getWidth()/2, 20);
        ((Ship)getObjects(Ship.class).get(0)).easy();
    }
    public void start2(){
        List objects = getObjects(null);
        removeObjects(objects);
        difficulty = 2;
        Ship ship = new Ship();
        addObject(ship,292,290);
        ship.setLocation(291,340);
        showText("Score: 0", getWidth()/2, 20);
        ((Ship)getObjects(Ship.class).get(0)).medium();
    }
    public void start3(){
        List objects = getObjects(null);
        removeObjects(objects);
        difficulty = 3;
        Ship ship = new Ship();
        addObject(ship,292,290);
        ship.setLocation(291,340);
        showText("Score: 0", getWidth()/2, 20);
        ((Ship)getObjects(Ship.class).get(0)).hard();
    }
    public void enemy(){
        Enemy enemy = new Enemy();
        number = Greenfoot.getRandomNumber(getWidth());
        if (number <= 15){
            number = 16;
        }
        if (number >= getWidth()-15){
            number = getWidth()-16;
        }
        addObject(enemy,number,10);
        List enemyNum = getObjects(Enemy.class);
        for (int i = 0; i < enemyNum.size(); i++){
            if (difficulty == 1){
                ((Enemy)getObjects(Enemy.class).get(i)).easy();
            }else if(difficulty == 2){
                ((Enemy)getObjects(Enemy.class).get(i)).medium();
            }else if(difficulty == 3){
                ((Enemy)getObjects(Enemy.class).get(i)).hard();
            }
        }
    }
    public void score(){
        score++;
        showText("Score: " + score, getWidth()/2, 20);
    }
    public void lose (){
        List objects = getObjects(null);
        removeObjects(objects);
        showText("", getWidth()/2, 20);
        showText("Score: " + score, getWidth()/2, getHeight()/2);
        Greenfoot.delay(250);
        Greenfoot.setWorld(new MyWorld());
    }
}
