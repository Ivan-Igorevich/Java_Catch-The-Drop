package ru.geekbrains.catch_the_drop;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;

/**
 * Created by IvanIgorevich on 11.10.2016.
 */
class Drop {
    private static Image drop;
    private float drop_left;
    private float drop_top;
    private static float drop_v;

    void updatePosition(float delta_time) {
        drop_top += drop_v * delta_time;
    }

    boolean isOutOfWindow(int wHeight){
        return drop_top >= wHeight - 10;
    }

    Drop(float left, float top, float speed) {
        drop_left = left;
        drop_top = top;
        drop_v = speed;
        try {
            drop = ImageIO.read(GameWindow.class.getResourceAsStream("drop.png"));
        } catch (IOException e){}
    }

    void drawSelf(Graphics g) {
        g.drawImage(drop, (int) drop_left, (int) drop_top, null);
    }

}
