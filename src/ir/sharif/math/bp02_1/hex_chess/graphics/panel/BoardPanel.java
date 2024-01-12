package ir.sharif.math.bp02_1.hex_chess.graphics.panel;

import ir.sharif.math.bp02_1.hex_chess.graphics.models.HexagonCell;
import ir.sharif.math.bp02_1.hex_chess.graphics.models.HexagonHint;
import ir.sharif.math.bp02_1.hex_chess.graphics.util.HintUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

public class BoardPanel extends JPanel implements MouseListener {
    final int boardLeftShift = 200;
    final int boardTopShift = 20;
    final int boardBorderWidth = 2;

    private final List<HexagonCell> cells;
    private final List<HexagonHint> hints;

    public BoardPanel() {
        setLayout(null);
        setBackground(Color.decode("#f7f7f7"));

        cells = new ArrayList<>();
        initialBaseBoard();
        this.addMouseListener(this);

        hints = new ArrayList<>();
        // TODO: hint ha ro por konim!
    }

    private void initialBaseBoard() {
        Character[] chars = HintUtil.getChars();

        for (Character aChar : chars) {
            int col = HintUtil.getCol(aChar);
            if (col <= 6) {
                for (int i = 1; i < 6 + col; i++) {
                    HexagonCell tile = new HexagonCell(i, aChar, boardLeftShift, boardTopShift);
                    cells.add(tile);
                }
            } else {
                for (int i = col - 5; i < 12; i++) {
                    HexagonCell tile = new HexagonCell(i, aChar, boardLeftShift, boardTopShift);
                    cells.add(tile);
                }
            }
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 =(Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

        // draw black board as board and background
        for(HexagonCell cell: cells) {
            g.setColor(Color.decode("#080808"));
            for(int dx = -boardBorderWidth; dx <= boardBorderWidth; dx += 1){
                for(int dy = -boardBorderWidth; dy <= boardBorderWidth; dy += 1) {
                    if (dx * dx + dy * dy <= boardBorderWidth*boardBorderWidth) {
                        Polygon p = cell.getPolygon();
                        p.translate(dx, dy);
                        g.fillPolygon(p);
                    }
                }
            }
        }

        // foreground board
        for(HexagonCell cell: cells) {
            cell.paint(g2);
        }
    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
        HexagonCell targetCell = null;
        for(HexagonCell cell: cells) {
            if (cell.getPolygon().contains(mouseEvent.getPoint())) {
                targetCell = cell;
                break;
            }
        }
        System.out.println("clicked -> " + targetCell);
    }

    @Override
    public void mousePressed(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseReleased(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseEntered(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseExited(MouseEvent mouseEvent) {

    }
}
