package ir.sharif.math.bp02_1.hex_chess.graphics.panel;

import ir.sharif.math.bp02_1.hex_chess.graphics.util.Config;
import ir.sharif.math.bp02_1.hex_chess.util.PieceName;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;


public class RemovedPiecesPanel extends JPanel {
    private List<String> pieces;

    final int size = Config.CELL_SIZE * 2;
    final int countPerRow = 4;

    public RemovedPiecesPanel() {
        setLayout(null);
        setBackground(Color.decode("#eeeeee"));
        pieces = new ArrayList<>();

        repaint();
        setPreferredSize(new Dimension(size * countPerRow, 0));
    }

    public void setPieces(List<String> pieces) {
        this.pieces = pieces;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(Color.BLACK);
        g.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 30));
        FontMetrics fm = g.getFontMetrics();
        List<String> paintPieces = pieces;
        for (int i = 0; i < paintPieces.size(); i++) {
            String p = paintPieces.get(i);
            int x = size * (i % countPerRow) + (size - fm.stringWidth(p))/2;
            int y = size * (1 + i / countPerRow) + (size - fm.getHeight())/2;
            g.drawString(p, x, y);
        }
    }
}
