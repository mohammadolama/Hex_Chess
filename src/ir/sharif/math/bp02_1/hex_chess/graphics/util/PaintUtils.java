package ir.sharif.math.bp02_1.hex_chess.graphics.util;

import java.awt.*;

public class PaintUtils {
    public static void drawTextOnCenter(Graphics2D g2, Rectangle rectangle, String text) {
        FontMetrics fm = g2.getFontMetrics();
        double x = rectangle.getX() + (rectangle.getWidth() - fm.stringWidth(text)) / 2;
        double y = rectangle.getY() + ((rectangle.getHeight() - fm.getHeight()) / 2) + fm.getAscent();
        g2.drawString(text, (int)Math.round(x), (int)Math.round(y));
    }
}
