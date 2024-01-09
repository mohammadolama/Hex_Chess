package ir.sharif.math.bp02_1.hex_chess.graphics.models;

import ir.sharif.math.bp02_1.hex_chess.graphics.GraphicalAgent;
import ir.sharif.math.bp02_1.hex_chess.graphics.util.HintUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public  class HexagonButton extends JButton implements MouseListener {

        private int startX;
        private int startY;
        private  final int WIDTH;
        private  final int HEIGHT;
        private final int radius;
        private char col;
        private int row;

        private GraphicalPiece piece;

        private GraphicalAgent graphicalAgent;

        public HexagonButton(int row, char col, int radius , int width , int height , int startX , int starY, GraphicalAgent graphicalAgent) {
            this.row = row;
            this.col = col;
            this.radius = radius;
            this.WIDTH = width;
            this.HEIGHT = height;
            this.startX = startX;
            this.startY = starY;
            this.graphicalAgent = graphicalAgent;
            setContentAreaFilled(false);
            setFocusPainted(true);
            setBorderPainted(false);
            setPreferredSize(new Dimension(HEIGHT, WIDTH));
            setBackground(HintUtil.getColor(row , col));

            int x = startX + (int)((3*radius/2) * (HintUtil.getCol(col)-1));
            this.startY = HintUtil.getCol(col) <= 6 ? startY + (height/2) * (HintUtil.getCol(col) -1) : startY + (height/2) * (11 - HintUtil.getCol(col));
            int y = HintUtil.getCol(col) <= 6 ? startY - height * (row-1) : startY - height * (5 - (HintUtil.getCol(col) - row));

            setBounds(x,y, WIDTH, HEIGHT);
            setVisible(true);
            this.addMouseListener(this);

        }

        public Polygon getPolygon(int radius) {
            Polygon hex = new Polygon();
            hex.addPoint((int) (radius / 2), 0);
            hex.addPoint((int) (3 * radius / 2), 0);
            hex.addPoint((int) (2 * radius), HEIGHT /2);
            hex.addPoint((int) (3 * radius / 2), HEIGHT);
            hex.addPoint((int) (radius / 2), HEIGHT);
            hex.addPoint(0, HEIGHT /2);
            return hex;
        }

        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            ((Graphics2D) g).setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            ((Graphics2D) g).setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
            if (piece.isCanBeAttacked()){
                g.setColor(Color.RED);
            } else if (piece.isSelected()) {
                g.setColor(Color.GREEN);
            }else {
                g.setColor(HintUtil.getColor(this.row , this.col));
            }
            g.fillPolygon(this.getPolygon(radius));
            if (piece != null && !piece.getValue().trim().isEmpty()){
                g.setColor(Color.BLACK);
                g.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 30));
                FontMetrics fm = g.getFontMetrics();
                int x = (getWidth() - fm.stringWidth(piece.getValue())) / 2;
                int y = ((getHeight() - fm.getHeight()) / 2) + fm.getAscent();
                g.drawString(piece.getValue(), x, y);
            }
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

    public int getWIDTH() {
        return WIDTH;
    }

    public int getHEIGHT() {
        return HEIGHT;
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

    public GraphicalPiece getPiece() {
        return piece;
    }

    public void setPiece(GraphicalPiece piece) {
        this.piece = piece;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        graphicalAgent.clickRequest(this.row , this.col);
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}