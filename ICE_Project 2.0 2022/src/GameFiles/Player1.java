package GameFiles;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;



public class Player1 extends Entity
{
    GPanel gpanel;
    Player1Ctrl controller;



    public Player1(GPanel Gpanel, Player1Ctrl controller)
    {
        super(Gpanel);
        this.gpanel = Gpanel;
        this.controller = controller;
        setDefValues();
        getPlayerImg();
        hitbox = getHitBox();



    }

    public void setDefValues()
    {
        x= 100;
        y= 100;
        speed = 4;
        direction = "down";
        projectile = new Fireball(gPanel);


    }


    //load the images for the player for each direction. Two images of each direction to animate movement
    public void getPlayerImg()
    {

        try
        {


            up1 = ImageIO.read(new File("ressources/player/Warrior1_run_up1.png"));
            up2 = ImageIO.read(new File("ressources/player/Warrior1_run_up2.png"));
            down1 = ImageIO.read(new File("ressources/player/Warrior1_run_down1.png"));
            down2 = ImageIO.read(new File("ressources/player/Warrior1_run_down2.png"));
            left1 = ImageIO.read(new File("ressources/player/Warrior1_run_left1.png"));
            left2 = ImageIO.read(new File("ressources/player/Warrior1_run_left2.png"));
            right1 = ImageIO.read(new File("ressources/player/Warrior1_run_right1.png"));
            right2 = ImageIO.read(new File("ressources/player/Warrior1_run_right2.png"));



        }catch (IOException e)
        {
            System.out.println("Could not read file");
        }
    }
    public void update()
    {
        if (controller.upPressed || controller.downPressed || controller.leftPressed || controller.rightPressed)
        {
            if (controller.upPressed)
            {


                    y -= speed;
                    direction = "up";


            } else if (controller.downPressed)
            {

                        y += speed;

                        direction = "down";

            } else if (controller.leftPressed)
            {

                    x -= speed;
                    direction = "left";




            } else if (controller.rightPressed)
            {


                    x += speed;

                    direction = "right";

            }


            spriteCounter++;

            if(spriteCounter > 10 )
            {
                if(spriteNumber == 1)
                {
                    spriteNumber = 2;
                } else if (spriteNumber == 2)
                {
                    spriteNumber = 1;
                }
                spriteCounter = 0;
            }
        }

        if(controller.shootPressed)
        {
            projectile.set(x,y,direction, true,this);

            gpanel.fireballs.add((Fireball) projectile);

        }

        this.collision = false;
    }



    public void draw(Graphics2D g2)
    {


        BufferedImage image = null;
        switch(direction)
        {
            case "up":
                if(spriteNumber==1)
                {
                    image = up1;
                }
                if(spriteNumber==2)
                {
                    image = up2;
                }

                break;
            case "down":
                if (spriteNumber==1)
                {
                    image = down1;
                }
                if(spriteNumber == 2)
                {
                    image = down2;
                }
                break;
            case "left":
                if(spriteNumber ==1)
                {
                    image = left1;
                }
                if (spriteNumber == 2)
                {
                    image = left2;
                }
                break;
            case "right":
                if(spriteNumber == 1)
                {
                    image = right1;
                }
                if(spriteNumber ==2) {
                    image = right2;
                }
                break;
        }
        g2.drawImage(image,x,y,96,96,null);

    }


    public Rectangle getHitBox()
    {
        return new Rectangle(x+30,y+30,34,34);
    }








}
