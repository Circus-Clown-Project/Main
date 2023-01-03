/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import interfaces.Shapes;
import controller.ImageController;
import java.util.Random;

/**
 *
 * @author Kimo Store
 */
public class GiftsFactory {
    private int screenWidth, screenHeight;
    private ImageObject[] gifts ;
    private ImageController imageController = new ImageController();

    
     public GiftsFactory(int screenWidth, int screenHeight) {
        this.screenWidth = screenWidth;
        this.screenHeight = screenHeight;
        gifts = imageController.getGifts(screenWidth, screenHeight);
     }
    
    public Shapes getGift(String giftName) {
        if (giftName == "gift") {
            return gifts[0];
        } else if (giftName == "special") {
            return gifts[1];
        }
        return null; 
        
    }
}
