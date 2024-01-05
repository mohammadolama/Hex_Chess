package ir.sharif.math.bp02_1.hex_chess.graphics.models;

import java.awt.*;

public class GraphicalTile extends GraphicalModel {
    private int q, r;

    public boolean marked;
    private String k;

    private static final int originX = 100;
    private static final int originY = 100;
    private static final int radius = 20;

    private static final Color[] colors = {new Color(1.0F, 1.0F, 1.0F), new Color(0.9F, 0.9F, 0.9F), new Color(0.8F, 0.8F, 0.8F)};

    public GraphicalTile(int q, int r, String k) {
        this.q = q;
        this.r = r;
        this.k = k;
        marked = false;
    }

    public Polygon getPolygon(int originX, int originY, int radius) {
        int xCenter = (int) (originX + 1.73 * this.q * radius + 1.73 * 0.5 * this.r * radius);
        int yCenter = (int) (originY + 1.5 * this.r * radius);
        Polygon hex = new Polygon();
        for (int i = 0; i < 6; i++) {
            double angle = (double) (2 * i + 1) / 6 * Math.PI;
            double dx = radius * Math.cos(angle);
            double dy = radius * Math.sin(angle);
            hex.addPoint(xCenter + (int) dx, yCenter + (int) dy);
        }
        return hex;
    }

    // private Tile sum(Tile other) {
    //     return new Tile(this.q + other.q, this.r + other.r);
    // }

    private Color getColor() {
        return marked ? Color.CYAN : colors[((this.q - this.r) % 3 + 3) % 3];
    }

    public String getK() {
        return k;
    }

    public void setK(String k) {
        this.k = k;
    }

    @Override
    public void paint(Graphics2D g) {
        g.setColor(this.getColor());
        g.fillPolygon(this.getPolygon(originX, originY, radius));
        int centerX = (int) (originX + 1.73 * this.q * radius + 1.73 * 0.5 * this.r * radius);
        int centerY = (int) (originY + 1.5 * this.r * radius);
        g.setColor(Color.BLACK);
        ((Graphics2D) g).rotate(Math.toRadians(-30), centerX, centerY);
        if (k!= null && !k.contains(",")){
            g.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 20));
            g.drawString(k, centerX - 10, centerY+8);
        }
        ((Graphics2D) g).rotate(Math.toRadians(30), centerX, centerY);
        if (marked) {
            g.setColor(Color.RED);
            StringBuilder coords = new StringBuilder();
            coords.append((char) ('a' + (q + 4)));
            coords.append((char) ('9' - (r + 4)));
            g.drawString(coords.toString(), centerX, centerY);
        }
    }
}
