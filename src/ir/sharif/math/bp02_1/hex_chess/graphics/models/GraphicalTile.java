package ir.sharif.math.bp02_1.hex_chess.graphics.models;

import java.awt.*;

public class GraphicalTile extends GraphicalModel {
    private int q, r;

    public boolean marked;
    private String k;

    private static final int originX = 60;
    private static final int originY = 80;
    private static final int radius = 30;

    private static final Color[] colors = {new Color(1.0F, 1.0F, 1.0F), new Color(0.9F, 0.9F, 0.9F), new Color(0.8F, 0.8F, 0.8F)};

    public GraphicalTile(int q, int r, String k) {
        this.q = q;
        this.r = r;
        this.k = k;
        marked = false;
    }

    public Polygon getPolygon(int originX, int originY, int radius) {
        int xCenter = (int) (originX + 1.65 * this.q * radius + 1.7 * 0.5 * this.r * radius);
        int yCenter = (int) (originY + 1.5 * this.r * radius);
        Polygon hex = new Polygon();
        for (int i = 0; i < 6; i++) {
            double angle = (double) (2 * i + 1) / 6 * Math.PI;
            int dx = (int) Math.ceil(radius * Math.cos(angle));
            int dy = (int) Math.ceil(radius * Math.sin(angle));
            hex.addPoint(xCenter + dx, yCenter + dy);
        }
        return hex;
    }
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
            g.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 40));
            g.drawString(k, centerX - 32, centerY+8);
        }
        ((Graphics2D) g).rotate(Math.toRadians(30), centerX, centerY);
    }
}
