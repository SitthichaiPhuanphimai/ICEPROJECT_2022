package GameFiles;

import java.awt.*;
import java.awt.image.BufferedImage;

public  class Entity
{
    GPanel gPanel;
    public Projectile projectile;
    public int x,y;
    public int speed;
    String name;

    boolean alive;

    int life;


    public BufferedImage up1,up2,down1,down2,left1,left2,right1,right2;
    public String direction;

    public boolean collision = false;
    public Rectangle hitbox;

    public int spriteCounter = 0;
    public int spriteNumber = 1;


    public void update()
    {

        switch (direction)
        {
            case "up":
               y-=speed;

                break;
            case "down":
              y+=speed;

                break;

            case "left":
               x-= speed;
                break;
            case "right":
              x+= speed;
                break;
        }

    }



    public Entity(GPanel gPanel)
    {

    }

    public void draw(Graphics2D g2)
    {

    }




}
