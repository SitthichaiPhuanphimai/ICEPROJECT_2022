package GameFiles;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


public class Player1Ctrl extends KeyAdapter {

    public boolean upPressed, downPressed,leftPressed, rightPressed, shootPressed;


    @Override
    public void keyTyped(KeyEvent e) {

    }

    public void keyPressed(KeyEvent e)
    {


        if (e.getKeyCode() == KeyEvent.VK_W)
        {
            upPressed = true;
        }

        if (e.getKeyCode() == KeyEvent.VK_S )
        {
            downPressed = true;
        }

        if (e.getKeyCode() == KeyEvent.VK_A )
        {
            leftPressed = true;
        }

        if (e.getKeyCode() == KeyEvent.VK_D)
        {
            rightPressed = true;
        }

        if (e.getKeyCode() == KeyEvent.VK_SPACE)
        {
            shootPressed = true;
        }

    }




    public void keyReleased(KeyEvent e)
    {

        if(e.getKeyCode() == KeyEvent.VK_W)
        {
            upPressed = false;
        }

        if(e.getKeyCode() == KeyEvent.VK_S)
        {
            downPressed = false;
        }

        if(e.getKeyCode() == KeyEvent.VK_A)
        {
            leftPressed = false;
        }

        if(e.getKeyCode() == KeyEvent.VK_D)
        {
            rightPressed = false;
        }

        if(e.getKeyCode() == KeyEvent.VK_SPACE)
        {
            shootPressed = false;
        }


    }
}
