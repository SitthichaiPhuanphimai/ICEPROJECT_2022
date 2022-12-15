package GameFiles;

public class Projectile extends Entity
{
    Entity user;
    public Projectile(GPanel gPanel)
    {
        super(gPanel);
    }

    public void set(int x, int y, String direction, boolean alive, Entity user)
    {
        this.x = x;
        this.y = y;
        this.direction = direction;
        this.alive = alive;
        this.user = user;
        this.life = 100;


    }

    public void update()
    {
        switch (direction)
        {
            case "up":
                y -= speed;
                break;

            case "down":
                y += speed;
                break;

            case "left":
                x -= speed;
                break;

            case "right":
                x += speed;
                break;
        }

        life--;
            if(life <= 0)
            {
                alive = false;
            }

    }



}

