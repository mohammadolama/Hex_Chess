package ir.sharif.math.bp02_1.hex_chess.graphics.models;


import ir.sharif.math.bp02_1.hex_chess.graphics.ImageLoader;

import java.awt.*;
import java.awt.image.BufferedImage;

public class GraphicalPiece extends GraphicalModel {
    private final GraphicalColor color;
    private final BufferedImage image;
    private final int id;
    private final boolean isSelected;

//    public GraphicalPiece(GraphicalColor color, boolean isSelected) {
//        this.color = color;
//        image = ImageLoader.getImage(color.toString().toLowerCase());
//        this.isSelected = isSelected;
//
//  }


    public GraphicalPiece(GraphicalColor color, int id, boolean isSelected) {
        this.color = color;
        this.id = id;
        this.isSelected = isSelected;
        image = ImageLoader.getImage(color.toString().toLowerCase() + id);
    }

    public GraphicalColor getColor() {
        return color;
    }

    public BufferedImage getImage() {
        return image;
    }

    @Override
    public void paint(Graphics2D graphics2D) {

    }
}
