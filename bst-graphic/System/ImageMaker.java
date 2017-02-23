package System;
/*
 * ImageMaker.java
 *
 * Created on April 21, 2008, 11:16 AM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 *
 * @author Josiah Hester, September 11, 2007
 *   http://www.javalobby.org/articles/ultimate-image/
 */
public class ImageMaker {

    private final static Color backColor = new Color(188, 230, 176);

    public static void drawDetails(Graphics g) {
        g.setColor(backColor);            // Create Background
        g.fillRect(0, 0, 1198, 898);
    }

    public static BufferedImage createImage() {
        BufferedImage img =
                new BufferedImage(1198, 898, BufferedImage.TYPE_INT_RGB);
        img.createGraphics();
        Graphics2D g = (Graphics2D) img.getGraphics();
        drawDetails(g);
        return img;
    }
}
