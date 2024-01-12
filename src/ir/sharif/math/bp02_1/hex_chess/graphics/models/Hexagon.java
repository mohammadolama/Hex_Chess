package ir.sharif.math.bp02_1.hex_chess.graphics.models;

import ir.sharif.math.bp02_1.hex_chess.graphics.util.Config;
import ir.sharif.math.bp02_1.hex_chess.graphics.util.FontStrokeDrawer;
import ir.sharif.math.bp02_1.hex_chess.graphics.util.HintUtil;

import java.awt.*;

public abstract class Hexagon implements Paintable {
    protected final int row;
    protected char col;
    protected final int startX;
    protected final int startY;

    public Hexagon(int row, char col, int startX, int startY) {
        this.row = row;
        this.col = col;

        this.startX = startX;
        this.startY = startY;
    }


    public Polygon getPolygon() {
        double height = (Math.sin(Math.PI / 3) * Config.CELL_SIZE * 2);
        int iCol = HintUtil.getCol(col);
        double x = startX + ((3 * Config.CELL_SIZE / 2.0) * (HintUtil.getCol(col) - 1));
        double y = startY + height * 8;
        y += (height / 2) * (HintUtil.getCol(col) <= 6 ? (HintUtil.getCol(col) - 1) : (11 - HintUtil.getCol(col)));
        y -= height * (HintUtil.getCol(col) <= 6 ? (row - 1) : (5 - (HintUtil.getCol(col) - row)));

        Polygon hex = new Polygon();
        for (int i = 0, deg = 90; i < 6; i++, deg += 60) {
            hex.addPoint(
                    (int) Math.round(Config.CELL_SIZE * Math.sin(deg / 180.0 * Math.PI)),
                    (int) Math.round(Config.CELL_SIZE * Math.cos(deg / 180.0 * Math.PI)));
        }

        hex.translate((int) Math.round(x), (int) Math.round(y));
        return hex;
    }

    public int getRow() {
        return row;
    }

    public char getCol() {
        return col;
    }

    @Override
    public String toString() {
        return "Hexagon{" +
                "row=" + row +
                ", col=" + col +
                '}';
    }

    protected void drawTextOnCenter(Graphics2D g2, Polygon p, String text, Color color) {
        FontMetrics fm = g2.getFontMetrics();
        double x = p.getBounds().getX() + (p.getBounds().getWidth() - fm.stringWidth(text)) / 2;
        double y = p.getBounds().getY() + ((p.getBounds().getHeight() - fm.getHeight()) / 2) + fm.getAscent();
        FontStrokeDrawer.drawString(g2, text, (int)Math.round(x), (int)Math.round(y), color);

    }

    @Override
    public abstract void paint(Graphics2D g2);
}