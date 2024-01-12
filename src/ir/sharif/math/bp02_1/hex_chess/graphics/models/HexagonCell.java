package ir.sharif.math.bp02_1.hex_chess.graphics.models;

import ir.sharif.math.bp02_1.hex_chess.graphics.util.HintUtil;

import java.awt.*;


public class HexagonCell extends Hexagon implements Paintable {
    private String text;
    private Color backGroundColor;
    private Color textColor;

    public HexagonCell(int row, char col, int startX, int startY) {
        super(row, col, startX, startY);
        this.text = "A";
        this.backGroundColor = HintUtil.getColor(this.getRow(), this.getCol());
        this.textColor = Color.WHITE;
    }

    public void setBackGroundColor(Color backGroundColor) {
        this.backGroundColor = backGroundColor;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setTextColor(Color textColor) {
        this.textColor = textColor;
    }

    @Override
    public void paint(Graphics2D g2) {
        g2.setColor(backGroundColor);
        Polygon p = this.getPolygon();
        g2.fillPolygon(p);

        g2.setColor(Color.BLACK);
        g2.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 30));
        drawTextOnCenter(g2, p, text, textColor);
    }
}
