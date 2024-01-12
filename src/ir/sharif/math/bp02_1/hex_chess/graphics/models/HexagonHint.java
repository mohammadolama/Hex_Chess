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
        g2.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 20));
        drawTextOnCenter(g2, p, hintLabel);
    }


}
