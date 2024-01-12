package ir.sharif.math.bp02_1.hex_chess.graphics.models;


import ir.sharif.math.bp02_1.hex_chess.graphics.ImageLoader;

import java.awt.*;
import java.awt.image.BufferedImage;

public class GraphicalPiece {
    private BufferedImage image;

    private final String name;
    private final String value;
    private boolean isSelected;
    private boolean canBeAttacked;

    public GraphicalPiece(String name, String value , boolean isSelected, boolean canBeAttacked) {
        this.name = name;
        this.value = value;
        this.isSelected = isSelected;
        this.canBeAttacked = canBeAttacked;
    }

    public String getName() {
        return name;
    }

    public String getValue() {
        return value;
    }

    public BufferedImage getImage() {
        return image;
    }

    public void setImage(BufferedImage image) {
        this.image = image;
    }


    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }

    public boolean isCanBeAttacked() {
        return canBeAttacked;
    }

    public void setCanBeAttacked(boolean canBeAttacked) {
        this.canBeAttacked = canBeAttacked;
    }
}
