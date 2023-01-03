package model;

import interfaces.Difficulty;


public class HardWorld implements Difficulty {

    private final int speedH = 1, movingH = 35, specialShapesH = 12,colorsH=7;
    private final int gameSpeed, movingNum, specialShapesNum,colorsNum;
    private final String theme;

    public HardWorld() {
        this.gameSpeed = speedH;
        this.movingNum = movingH;
        this.specialShapesNum = specialShapesH;
        this.colorsNum = colorsH;
        this.theme = "./images/Hard.png";
    }

    @Override
    public int getGameSpeed() {
        return gameSpeed;
    }

    @Override
    public int getMovingNum() {
        return movingNum;
    }

    @Override
    public int getSpecialShapesNum() {
        return specialShapesNum;
    }

    @Override
    public int getColorsNum() {
        return colorsNum;
    }
    
    @Override
    public String getTheme() {
        return this.theme;
    }
}
