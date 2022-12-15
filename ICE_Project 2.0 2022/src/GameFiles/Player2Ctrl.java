package GameFiles;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


public class Player2Ctrl extends KeyAdapter {
    public boolean upPressed, downPressed, leftPressed, rightPressed, shootPressed;



    public void keyPressed(KeyEvent e)
    {


        if(e.getKeyCode() == KeyEvent.VK_UP)
        {
            upPressed = true;
        }

        if(e.getKeyCode() == KeyEvent.VK_DOWN)
        {
            downPressed = true;
        }

        if(e.getKeyCode()== KeyEvent.VK_LEFT)
        {
            leftPressed = true;
        }

        if(e.getKeyCode()== KeyEvent.VK_RIGHT)
        {
            rightPressed = true;
        }

        if(e.getKeyCode()== KeyEvent.VK_K)
        {
            shootPressed = true;
        }
    }


    public void keyReleased(KeyEvent e)
    {


        if(e.getKeyCode()== KeyEvent.VK_UP)
        {
            upPressed = false;
        }

        if(e.getKeyCode() == KeyEvent.VK_DOWN)
        {
            downPressed = false;
        }

        if(e.getKeyCode() == KeyEvent.VK_LEFT)
        {
            leftPressed = false;
        }

        if(e.getKeyCode() == KeyEvent.VK_RIGHT)
        {
            rightPressed = false;
        }

        if(e.getKeyCode() == KeyEvent.VK_K)
        {
            shootPressed = false;
        }
    }


}

