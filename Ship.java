import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

/**
 * Write a description of class Ship here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Ship extends Actor
{
    public int number = -1;
    private int speed = 0;
    private int prob = 0;
    public Ship(){
        GreenfootImage myImage = getImage();
        int height = (int)myImage.getHeight()*1/9;
        int width = (int)myImage.getWidth()*1/9;
        myImage.scale(height, width);
    }
    /**
     * Act - do whatever the Ship wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act(){
        if (Greenfoot.isKeyDown("left") && getX() > 18){
            setLocation(getX()-speed, getY());
        }
        if (Greenfoot.isKeyDown("right") && getX() < getWorld().getWidth()-18){
            setLocation(getX()+speed, getY());
        }
        number=Greenfoot.getRandomNumber(prob);
        if (number==0){
            ((MyWorld)getWorld()).enemy();
        }
        List enemy = getWorld().getObjects(Enemy.class);
        for (int i = 0; i < enemy.size(); i++){
            Actor en = getWorld().getObjects(Enemy.class).get(i);
            int enemyX = en.getX();
            int enemyY = en.getY();
            if ((enemyX+10 >= getX()-10 && enemyX-10 <= getX()+10 && (enemyY+8 >= getY()-10 && enemyY-8 <= getY()+10))){
                ((MyWorld)getWorld()).lose();
                break;
            }
        }
    }
    public void easy(){
        speed = 3;
        prob = 40;
    }
    public void medium(){
        speed = 5;
        prob = 10;
    }
    public void hard(){
        speed = 7;
        prob = 5;
    }
}