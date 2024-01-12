package ir.sharif.math.bp02_1.hex_chess.graphics.models;

import ir.sharif.math.bp02_1.hex_chess.graphics.util.HintUtil;
import ir.sharif.math.bp02_1.hex_chess.graphics.util.PaintUtils;

import java.awt.*;


public class HexagonCell extends Hexagon implements Paintable {
    private String text;
    private Color color;

    public HexagonCell(int row, char col, int startX, int startY) {
        super(row, col, startX, startY);
        this.text = "A";
        this.color = HintUtil.getColor(this.getRow(), this.getCol());
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public void paint(Graphics2D g2) {
        g2.setColor(color);
        Polygon p = this.getPolygon();
        g2.fillPolygon(p);

        g2.setColor(Color.BLACK);
        g2.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 30));
        PaintUtils.drawTextOnCenter(g2, p.getBounds(), text);
    }
}
