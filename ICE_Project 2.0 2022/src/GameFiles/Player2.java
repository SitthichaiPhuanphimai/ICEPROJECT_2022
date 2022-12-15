package GameFiles;

import javax.imageio.ImageIO;
import java.awt.*;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Player2 extends Entity
{
    GPanel gpanel;
    Player2Ctrl controller2;



    public Player2(GPanel Gpanel, Player2Ctrl controller2)
    {
        super(Gpanel);
        this.gpanel = Gpanel;
        this.controller2 = controller2;
        setDefValues();
        getPlayerImg();
        getHitBox();

    }

    public void setDefValues()
    {
        x= 900;
        y= 600;
        speed = 4;
        direction = "up";
        projectile = new Fireball(gPanel);


    }

    public void getPlayerImg()
    {

        try
        {


            up1 = ImageIO.read(new File("ressources/player/Warrior2_run_up1.png"));
            up2 = ImageIO.read(new File("ressources/player/Warrior2_run_up2.png"));
            down1 = ImageIO.read(new File("ressources/player/Warrior2_run_down1.png"));
            down2 = ImageIO.read(new File("ressources/player/Warrior2_run_down1.png"));
            left1 = ImageIO.read(new File("ressources/player/Warrior2_run_left1.png"));
            left2 = ImageIO.read(new File("ressources/player/Warrior2_run_left2.png"));
            right1 = ImageIO.read(new File("ressources/player/Warrior2_run_right1.png"));
            right2 = ImageIO.read(new File("ressources/player/Warrior2_run_right1.png"));




        }catch (IOException e)
        {
            System.out.println("Could not read file");
        }
    }
    public void update()
    {
        if (controller2.upPressed || controller2.downPressed || controller2.leftPressed || controller2.rightPressed)
        {
            if (controller2.upPressed) {
                y -= speed;
                direction = "up";

            } else if (controller2.downPressed) {
                y += speed;
                direction = "down";
            } else if (controller2.leftPressed) {
                x -= speed;
                direction = "left";

            } else if (controller2.rightPressed) {
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

        if(controller2.shootPressed)
        {
            projectile.set(x,y,direction, true,this);

            gpanel.fireballs2.add((Fireball) projectile);

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
