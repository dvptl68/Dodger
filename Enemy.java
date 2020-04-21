import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Enemy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Enemy extends Actor
{
    private int speed = 0;
    public Enemy(){
        GreenfootImage myImage = getImage();
        int height = (int)myImage.getHeight()*1/4;
        int width = (int)myImage.getWidth()*1/4;
        myImage.scale(height, width);
    }
    /**
     * Act - do whatever the Enemy wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        setLocation(getX(), getY()+speed);
        Actor ship = getWorld().getObjects(Ship.class).get(0);
        if(getY() >= ship.getY()+10){
            ((MyWorld)getWorld()).score();
            getWorld().removeObject(this);
        }
    }
    public void easy(){
        speed = 1;
    }
    public void medium(){
        speed = 3;
    }
    public void hard(){
        speed = 5;
    }
}