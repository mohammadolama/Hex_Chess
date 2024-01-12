package ir.sharif.math.bp02_1.hex_chess.graphics.panel;

import ir.sharif.math.bp02_1.hex_chess.graphics.models.StringColor;
import ir.sharif.math.bp02_1.hex_chess.graphics.util.Config;
import ir.sharif.math.bp02_1.hex_chess.graphics.util.FontStrokeDrawer;

import javax.swing.*;
import java.awt.*;


public class RemovedPiecesPanel extends JPanel {
    private StringColor[] pieces = new StringColor[0];

    final int size = Config.CELL_SIZE * 2;
    final int countPerRow = 4;

    public RemovedPiecesPanel() {
        setLayout(null);
        setBackground(Color.decode("#eeeeee"));

        repaint();
        setPreferredSize(new Dimension(size * countPerRow, 0));
    }

    public void setPieces(StringColor[] pieces) {
        this.pieces = pieces;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 48));
        FontMetrics fm = g.getFontMetrics();
        StringColor[] paintPieces = pieces;
        for (int i = 0; i < paintPieces.length; i++) {
            StringColor p = paintPieces[i];
            g.setColor(p.getColor());
            int x = size * (i % countPerRow) + (size - fm.stringWidth(p.getText())) / 2;
            int y = size * (1 + i / countPerRow) + (size - fm.getHeight()) / 2;
            FontStrokeDrawer.drawString(g, p.getText(), x, y, p.getColor());
        }
    }
}
