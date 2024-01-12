package ir.sharif.math.bp02_1.hex_chess.graphics.models;

import java.awt.*;

public class HexagonHint extends Hexagon implements Paintable {
    final private String hintLabel;
    public HexagonHint(int row, char col, int startX, int startY, String hintLabel) {
        super(row, col, startX, startY);
        this.hintLabel = hintLabel;
    }

    @Override
    public void paint(Graphics2D g2) {
        Polygon p = this.getPolygon();

        g2.setColor(Color.BLACK);
        g2.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 20));
        FontMetrics fm = g2.getFontMetrics();
        double x = p.getBounds().getX() + (p.getBounds().getWidth() - fm.stringWidth(hintLabel)) / 2;
        double y = p.getBounds().getY() + ((p.getBounds().getHeight() - fm.getHeight()) / 2) + fm.getAscent();
        g2.drawString(hintLabel, (int)Math.round(x), (int)Math.round(y));
    }


}
