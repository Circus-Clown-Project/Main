/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import interfaces.Shapes;
import controller.ImageController;
import java.util.ArrayList;
import java.util.Random;

public class BombsFactory {
   
    private int screenWidth, screenHeight;
    private ImageObject[] bombs = new ImageObject[2];
    private ImageController imageController = new ImageController();
    private ArrayList<Shapes> BOMBS;

    
     public BombsFactory(int screenWidth, int screenHeight) {
        this.screenWidth = screenWidth;
        this.screenHeight = screenHeight;
        bombs = imageController.getBombs(screenWidth, screenHeight);
        BOMBS = new ArrayList<Shapes>();
     }
    
    public ArrayList<Shapes> getBombs(String theme ,int bombsNum) {
        if (theme == "./images/Easy.png") 
        {
            BOMBS.add(bombs[1]);
            bombsNum--;
        }else if (theme == "./images/Normal.png") 
        {
            for(int i=0;i<2;i++)
            {
                BOMBS.add(bombs[1]);
                bombsNum--;
            }
        }
        else if (theme == "./images/Hard.png") 
        {
            for(int i=0;i<3;i++)
            {
                BOMBS.add(bombs[1]);
                bombsNum--;
            }
        }
        for(int i=0;i<bombsNum;i++)
        {
            BOMBS.add(bombs[0]);
        }
        
        return BOMBS;
    }
}
