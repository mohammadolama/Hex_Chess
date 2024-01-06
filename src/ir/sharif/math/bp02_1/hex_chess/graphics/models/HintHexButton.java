package ir.sharif.math.bp02_1.hex_chess.graphics.models;

import java.awt.*;

public class HintHexButton extends HexagonButton {

    private String hintLabel="";

    public HintHexButton(int row, char col, int radius, int length, int width) {
        super(row, col, radius, length, width);
        setBackground(Color.RED);
        setVisible(true);
        this.removeMouseListener(this);
    }


    public String getHintLabel() {
        return hintLabel;
    }

    public void setHintLabel(String hintLabel) {
        this.hintLabel = hintLabel;
    }

    @Override
    public void paintComponent(Graphics g) {
        ((Graphics2D) g).setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        ((Graphics2D) g).setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        g.setColor(Color.BLACK);
        g.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 20));
        g.drawString(hintLabel, super.getLENGTH()/2, super.getWIDTH()/2+10);
    }
}
