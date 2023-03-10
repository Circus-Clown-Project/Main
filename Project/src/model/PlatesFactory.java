/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import interfaces.Shapes;
import controller.ImageController;
import java.util.Random;

public class PlatesFactory {
    private int screenWidth, screenHeight;
    private ImageObject[] greenPlates = new ImageObject[4];
    private ImageObject[] bluePlates = new ImageObject[4];
    private ImageObject[] orangePlates = new ImageObject[4];
    private ImageObject[] pinkPlates = new ImageObject[4];
    private ImageObject[] redPlates = new ImageObject[4];
    private ImageObject[] yellowPlates = new ImageObject[4];
    private ImageController imageController = new ImageController();

    public PlatesFactory(int screenWidth, int screenHeight) {
        this.screenWidth = screenWidth;
        this.screenHeight = screenHeight;
        greenPlates = imageController.getPlates(screenWidth, screenHeight, "green", 1);
        bluePlates = imageController.getPlates(screenWidth, screenHeight, "blue", 3);
        orangePlates = imageController.getPlates(screenWidth, screenHeight, "orange", 4);
        pinkPlates = imageController.getPlates(screenWidth, screenHeight, "pink", 5);
        redPlates = imageController.getPlates(screenWidth, screenHeight, "red", 6);
        yellowPlates = imageController.getPlates(screenWidth, screenHeight, "yellow", 7);

    }
    
    public Shapes getShape(String shapeName) {
        Random r = new Random();

        if (shapeName == "GreenPlate") {
            return greenPlates[r.nextInt(4)];
        } else if (shapeName == "RedPlate") {
            return redPlates[r.nextInt(4)];
        } else if (shapeName == "BluePlate") {
            return bluePlates[r.nextInt(4)];
        } else if (shapeName == "PinkPlate") {
            return pinkPlates[r.nextInt(4)];
        } else if (shapeName == "OrangePlate") {
            return orangePlates[r.nextInt(4)];
        } else if (shapeName == "YellowPlate") {
            return yellowPlates[r.nextInt(4)];
        }
        else
            return null;
    }
}
