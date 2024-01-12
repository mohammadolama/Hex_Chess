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
        drawTextOnCenter(g2, p, "A");
    }
}
