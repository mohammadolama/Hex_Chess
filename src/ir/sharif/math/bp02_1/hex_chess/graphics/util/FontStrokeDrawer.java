package ir.sharif.math.bp02_1.hex_chess.graphics.util;

import java.awt.*;

public class FontStrokeDrawer {
    public static void drawString(Graphics g, String s, int x, int y, Color fillColor, Color strokeColor) {
        g.setColor(strokeColor);
        int stroke = 2;
        for (int dx = -stroke; dx <= stroke; dx++) {
            for (int dy = -stroke; dy <= stroke; dy++) {
                if (dx * dx + dy * dy <= stroke * stroke) {
                    g.drawString(s, x + dx, y + dy);
                }
            }
        }

        g.setColor(fillColor);
        g.drawString(s, x, y);
    }

    public static void drawString(Graphics g, String s, int x, int y, Color fillColor) {
        Color strokeColor = new Color(255 - fillColor.getRed(), 255 - fillColor.getGreen(), 255 - fillColor.getBlue());
        drawString(g, s, x, y, fillColor, strokeColor);
    }
}
