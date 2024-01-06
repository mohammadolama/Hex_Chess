package ir.sharif.math.bp02_1.hex_chess.graphics.models;

import ir.sharif.math.bp02_1.hex_chess.graphics.util.HintUtil;

import javax.swing.*;
import java.awt.*;

public  class HexagonButton extends JButton {

        private int startX = 250;
        private int startY = 450;

        private  final int LENGTH;
        private  final int WIDTH ;
        private final int radius;
        private char col;
        private int row;




        public HexagonButton(int row, char col, int radius , int length , int width) {
            this.row = row;
            this.col = col;
            this.radius = radius;
            this.LENGTH = length;
            this.WIDTH = width;
            setContentAreaFilled(false);
            setFocusPainted(true);
            setBorderPainted(false);
            setPreferredSize(new Dimension(WIDTH, LENGTH));
            setBackground(HintUtil.getColor(row , col));

            int x = startX + (int)((3*radius/2) * (HintUtil.getCol(col)-1));
            startY = HintUtil.getCol(col) <= 6 ? startY + (width/2) * (HintUtil.getCol(col) -1) : startY + (width/2) * (11 - HintUtil.getCol(col));
            int y = HintUtil.getCol(col) <= 6 ? startY - width * (row-1) : startY - width * (5 - (HintUtil.getCol(col) - row));

            setBounds(x,y,LENGTH , WIDTH);
            setVisible(true);

        }

        public Polygon getPolygon(int originX, int originY, int radius) {
            Polygon hex = new Polygon();
            hex.addPoint((int) (radius / 2), 0);
            hex.addPoint((int) (3 * radius / 2), 0);
            hex.addPoint((int) (2 * radius), WIDTH/2);
            hex.addPoint((int) (3 * radius / 2), WIDTH);
            hex.addPoint((int) (radius / 2), WIDTH);
            hex.addPoint(0, WIDTH/2);
//            for (int i = 0; i < 6; i++) {
//                double angle = (double) (2 * i + 1) / 6 * Math.PI;
//                int dx = (int) Math.ceil(radius * Math.cos(angle));
//                int dy = (int) Math.ceil(radius * Math.sin(angle));
//                hex.addPoint(xCenter + dx, yCenter + dy);
//            }
            return hex;
        }


        private static final int originX = -40;
        private static final int originY = -40;

        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            ((Graphics2D) g).setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            ((Graphics2D) g).setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
            g.setColor(HintUtil.getColor(this.row , this.col));
            g.fillPolygon(this.getPolygon(originX, originY, radius));
        }

    public int getStartX() {
        return startX;
    }

    public void setStartX(int startX) {
        this.startX = startX;
    }

    public int getStartY() {
        return startY;
    }

    public void setStartY(int startY) {
        this.startY = startY;
    }

    public int getLENGTH() {
        return LENGTH;
    }

    public int getWIDTH() {
        return WIDTH;
    }

    public int getRadius() {
        return radius;
    }

    public char getCol() {
        return col;
    }

    public void setCol(char col) {
        this.col = col;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }
}