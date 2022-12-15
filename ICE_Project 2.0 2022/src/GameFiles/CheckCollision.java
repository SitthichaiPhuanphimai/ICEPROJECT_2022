package GameFiles;


import javax.swing.*;
import java.awt.*;

public class CheckCollision {
    GPanel gpanel;

    public CheckCollision(GPanel gpanel) {
        this.gpanel = gpanel;
    }

    public void checkCollisions()
    {
        checkFireballCollison();

    }


    public void checkWalkable()
    {


    }

    public void checkFireballCollison() {
        Rectangle r1;
        Rectangle r2;
        Rectangle p1 = gpanel.player1.getHitBox();
        Rectangle p2 = gpanel.player2.getHitBox();

        for (Fireball f : gpanel.fireballs) {
            r1 = f.getHitBox();
            if (r1.intersects(p2)) {
                f.alive = false;
                JOptionPane.showMessageDialog(null, "Player 1 wins");


            }
        }

        for (Fireball f : gpanel.fireballs2)
        {
            r2 = f.getHitBox();
            if (r2.intersects(p1)) {
                f.alive = false;
                JOptionPane.showMessageDialog(null, "Player 2 wins");
            }

        }
    }
}
