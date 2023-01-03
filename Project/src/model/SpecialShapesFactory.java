/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import interfaces.Shapes;
import controller.ImageController;
import eg.edu.alexu.csd.oop.game.GameObject;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Kimo Store
 */
public class SpecialShapesFactory {

private int screenWidth, screenHeight,specialShapesNum;
private String theme;
private BombsFactory bombsFactory;
private GiftsFactory giftsFactory; 
private ArrayList<Shapes> specialShapes;
    public SpecialShapesFactory(int screenWidth, int screenHeight, int specialShapesNum,String theme) {
        this.screenWidth = screenWidth;
        this.screenHeight = screenHeight;
        this.specialShapesNum = specialShapesNum;
        this.theme=theme;
        specialShapes = new ArrayList<Shapes>();
        bombsFactory = new BombsFactory(screenWidth,screenHeight);
        giftsFactory = new GiftsFactory(screenWidth,screenHeight);
    }
   
public ArrayList<Shapes> getSpecialShapes() {
        if (theme == "./images/Normal.png") 
        {
            specialShapes.add(giftsFactory.getGift("gift"));
            specialShapesNum--;
        } else if (theme == "./images/Hard.png") 
        {
            specialShapes.add(giftsFactory.getGift("gift"));
            specialShapesNum--;
            specialShapes.add(giftsFactory.getGift("special"));
            specialShapesNum--;
        }
        ArrayList<Shapes> bombs=bombsFactory.getBombs(theme, specialShapesNum);
        for(int i=0;i<specialShapesNum;i++)
        {
            specialShapes.add(bombs.get(i));
        }
        return specialShapes;
    }   
}
