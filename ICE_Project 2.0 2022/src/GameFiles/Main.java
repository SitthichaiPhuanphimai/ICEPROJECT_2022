package GameFiles;

import javax.swing.*;

public class Main

{
    public static void main(String[] args)
    {

        JFrame window = new JFrame();
        //Exit when X is pressed
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Can't resize window
        window.setResizable(false);

        window.setTitle("ICE GAME");

        GPanel gPanel = new GPanel();
        window.add(gPanel);
        window.pack();

        window.setLocationRelativeTo(null);
        window.setVisible(true);

        gPanel.startGameThread();

    }


}
