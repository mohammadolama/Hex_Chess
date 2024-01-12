package ir.sharif.math.bp02_1.hex_chess.graphics.models;

import ir.sharif.math.bp02_1.hex_chess.graphics.util.Config;
import ir.sharif.math.bp02_1.hex_chess.graphics.util.HintUtil;

import java.awt.*;

public class HexagonCell extends Hexagon implements Paintable {
    public HexagonCell(int row, char col, int startX, int startY) {
        super(row, col, startX, startY);
    }

    @Override
    public void paint(Graphics2D g2) {
        g2.setColor(HintUtil.getColor(this.getRow() , this.getCol()));
        Polygon p = this.getPolygon();
        g2.fillPolygon(p);

        g2.setColor(Color.BLACK);
        g2.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 30));
        FontMetrics fm = g2.getFontMetrics();
        double x = p.getBounds().getX() + (p.getBounds().getWidth() - fm.stringWidth("A")) / 2;
        double y = p.getBounds().getY() + ((p.getBounds().getHeight() - fm.getHeight()) / 2) + fm.getAscent();
        g2.drawString("A", (int)Math.round(x), (int)Math.round(y));
    }
}
