package GameFiles;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;


public class TileManager
{
    GPanel gpanel;
    Tile [] tile;

    int[][] tileMapNum;

    public TileManager(GPanel gpanel)
    {
        this.gpanel = gpanel;
        tile = new Tile [10];
        tileMapNum = new int [gpanel.maxScreenCol][gpanel.maxScreenRow];
        getTileImage();
        loadMap();
    }

    public void getTileImage()
    {
        try{
            tile[0] = new Tile();
            tile[0].image = ImageIO.read(new File("ressources/tiles/land_6.png"));


            tile[1] = new Tile();
            tile[1].image = ImageIO.read(new File("ressources/tiles/tree_6.png"));
            tile[1].walkable = false;


            tile[2] = new Tile();
            tile[2].image = ImageIO.read(new File("ressources/tiles/tree_1.png"));
            tile[2].walkable = false;



            tile[3] = new Tile();
            tile[3].image = ImageIO.read(new File("ressources/tiles/stones_10.png"));
            tile[3].walkable = false;



            tile[4] = new Tile();
            tile[4].image = ImageIO.read(new File("ressources/tiles/lake.png"));
            tile[4].walkable = false;



            tile[5] = new Tile();
            tile[5].image = ImageIO.read(new File("ressources/tiles/decor_1.png"));
            tile[5].walkable = false;




        }catch (IOException e)
        {
            System.out.println("Error");
        }



    }


    public void loadMap()
    {

        try
        {
            File mapFile = new File("ressources/maps/TileMap.txt");
            BufferedReader reader = new BufferedReader(new FileReader(mapFile));

            int collum = 0;
            int row = 0;

            while(collum < gpanel.maxScreenCol && row < gpanel.maxScreenRow)
            {
                String line = reader.readLine();

                while(collum < gpanel.maxScreenCol)
                {
                    String[] numbers = line.split(",");
                    int num = Integer.parseInt(numbers[collum]);

                    tileMapNum [collum][row] = num;
                    collum++;
                }
                if(collum == gpanel.maxScreenCol)
                {
                    collum = 0;
                    row++;
                }
            }
            reader.close();
        } catch (Exception e) {
            System.out.println("Error loading the map");
        }

    }


    public void draw (Graphics2D g2)
    {
        int collum = 0;
        int row = 0;
        int x = 0;
        int y = 0;


        while (collum < gpanel.maxScreenCol && row < gpanel.maxScreenRow)
        {
            int tileNum = tileMapNum[collum][row];
            g2.drawImage(tile[0].image,x,y, gpanel.tileSize,gpanel.tileSize,null);
            g2.drawImage(tile[tileNum].image,x,y, gpanel.tileSize,gpanel.tileSize,null);

            collum++;
            x += gpanel.tileSize;

            if (collum == gpanel.maxScreenCol)
            {
                collum = 0;
                x = 0;
                row++;
                y += gpanel.tileSize;
            }
        }


        g2.drawImage(tile[4].image, 550,350,150,150,null);


        g2.drawImage(tile[5].image, 480,170,134,134,null);


    }

    //hitbox for lake
    Rectangle test = new Rectangle(550,350,150,150);

    //hitbox for lake
    Rectangle test1 = new Rectangle(480,170,134,134);


}
