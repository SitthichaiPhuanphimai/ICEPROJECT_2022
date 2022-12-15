package GameFiles;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class GPanel extends JPanel implements Runnable
{
    int defTileSize = 16; // tilesize
    int scale = 3; // scale
    public  int tileSize = defTileSize * scale; //48x48 px
    public   int maxScreenCol = 28; // max collum of scrren
    public   int maxScreenRow = 16; // max row of screen
    int screenWidth = tileSize * maxScreenCol; //448 px X
    int screenHeight = tileSize * maxScreenRow; //256 px Y

    Thread gameThread;


    Player1Ctrl controller = new Player1Ctrl();
    Player2Ctrl controller2 = new Player2Ctrl();


    Player1 player1 = new Player1(this,controller);

    Player2 player2 = new Player2(this,controller2);

    TileManager tileManager = new TileManager(this);

    CheckCollision checker = new CheckCollision(this);



    int fps = 60;

    //fireball for player 1
    ArrayList<Fireball> fireballs = new ArrayList<>();

    // fireball for player 2
    ArrayList<Fireball> fireballs2 = new ArrayList<>();



    public GPanel()
    {
        this.setPreferredSize(new Dimension(screenWidth,screenHeight ));
        this.setBackground(Color.BLACK);
        this.setDoubleBuffered(true);
        this.addKeyListener(controller);
        this.addKeyListener(controller2);
        this.setFocusable(true);
    }


    public void startGameThread()
    {
        gameThread = new Thread(this);
        gameThread.start();
    }
    @Override
    public void run()
    {

        double drawInterval = 1000000000/fps; //0.16666 sec

        double nextDrawTime = System.nanoTime() + drawInterval;


        while(gameThread != null)
        {

            update();
            checker.checkCollisions();

            repaint();



            try {
                double remainingTime = nextDrawTime - System.nanoTime();
                remainingTime = remainingTime/1000000;

                if(remainingTime < 0)
                {
                    remainingTime = 0;
                }

                Thread.sleep((long) remainingTime);

                nextDrawTime += drawInterval;

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }

    public void update()
    {

        //updates player movements

        player1.update();
        player2.update();



        //update fireballs p1
        for(int i = 0; i<fireballs.size();i++)
        {
            if(fireballs.get(i) != null)
            {
                if(fireballs.get(i).alive)
                {
                    fireballs.get(i).update();
                }
                if(!fireballs.get(i).alive)
                {
                    fireballs.remove(i);
                }
            }
        }

        //update fireballs p2
        for(int i = 0; i<fireballs2.size();i++)
        {
            if(fireballs2.get(i) != null)
            {
                if(fireballs2.get(i).alive)
                {
                    fireballs2.get(i).update();
                }
                if(!fireballs2.get(i).alive)
                {
                    fireballs2.remove(i);
                }
            }
        }


    }


    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;

        tileManager.draw(g2);
        player1.draw(g2);
        player2.draw(g2);

        // Hitboxes for debugging

    /*    g2.drawRect(player1.x+30,player1.y+30,34,34);
          g2.drawRect(player2.x+30,player2.y+30,34,34);
*/


        for(Fireball fireball : fireballs)
        {
            if(fireball.alive)
            {
                fireball.draw(g2);

            }

        }

        for(Fireball fireball : fireballs2)
        {
            if(fireball.alive)
            {
                fireball.draw(g2);
            }

        }

        g2.dispose();

    }

}
