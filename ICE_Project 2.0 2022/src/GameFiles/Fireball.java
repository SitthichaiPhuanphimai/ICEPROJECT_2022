package GameFiles;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Fireball extends Projectile
{

    GPanel gPanel;

    public Fireball(GPanel gPanel)
    {
        super(gPanel);
        this.gPanel=gPanel;

        name = "Arrow";
        life = 100;
        speed = 2;
        getImage();

    }

    public void getImage()

    {
        try {
            up1 = ImageIO.read(new File("ressources/projectiles/fireball_up_1.png"));
            down1 = ImageIO.read(new File("ressources/projectiles/fireball_down_1.png"));
            left1 = ImageIO.read(new File("ressources/projectiles/fireball_left_1.png"));
            right1 = ImageIO.read(new File("ressources/projectiles/fireball_right_1.png"));

        } catch (IOException e)
        {
            System.out.println("Error loading the image");
        }
    }

    public void draw(Graphics2D g2)
    {


        BufferedImage image = null;
        switch(direction)

        {
            case "up":

                {
                    image = up1;
                }


                break;
            case "down":

                {
                    image = down1;
                }

                break;
            case "left":

                {
                    image = left1;
                }

                break;
            case "right":

                {
                    image = right1;
                }

                break;
        }
        g2.drawImage(image,x+30,y+30,30,30,null);

    }

    public Rectangle getHitBox()
    {
        return new Rectangle(x+30,y+30,20,20);
    }

}
