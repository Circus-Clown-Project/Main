package controller;

import model.ImageObject;

public class ImageController {

    public ImageObject[] getPlates(int width, int height, String color, int id) {

        ImageObject plate1 = new ImageObject((int) (Math.random() * (width / 2)), -1 * (int) (Math.random() * height), "./images/" + color + "platewithoutbase.png", id);
        ImageObject plate2 = new ImageObject((int) (Math.random() * (width / 2)), -1 * (int) (Math.random() * height), "./images/" + color + "platewithbase.png", id);
        ImageObject plate3 = new ImageObject((int) (Math.random() * (width / 2)), -1 * (int) (Math.random() * height), "./images/" + color + "platewithdeepbase.png", id);
        ImageObject plate4 = new ImageObject((int) (Math.random() * (width / 2)), -1 * (int) (Math.random() * height), "./images/" + color + "pot.png", id);
        ImageObject[] Plates = {plate1, plate2, plate3, plate4};
        return Plates;

    }

    public ImageObject[] getBombs(int width, int height) {

        ImageObject bomb1 = new ImageObject((int) (Math.random() * (width / 2)), -1 * (int) (Math.random() * height), "./images/Bomb.png", 100);
        ImageObject bomb2 = new ImageObject((int) (Math.random() * (width / 2)), -1 * (int) (Math.random() * height), "./images/tnt.png", 200);
        ImageObject[] bombs = {bomb1, bomb2};
        return bombs;

    }

    public ImageObject[] getGifts(int width, int height) {

        ImageObject gift = new ImageObject((int) (Math.random() * (width / 2)), -1 * (int) (Math.random() * height), "./images/gift.png", 300);
        ImageObject special = new ImageObject((int) (Math.random() * (width / 2)), -1 * (int) (Math.random() * height), "./images/special.png", 400);
        ImageObject[] gifts = {gift, special};
        return gifts;

    }

}
