package ir.sharif.math.bp02_1.hex_chess.graphics.panel;

import ir.sharif.math.bp02_1.hex_chess.graphics.listeners.DummyEventListener;
import ir.sharif.math.bp02_1.hex_chess.graphics.listeners.EventListener;
import ir.sharif.math.bp02_1.hex_chess.graphics.models.HexagonCell;
import ir.sharif.math.bp02_1.hex_chess.graphics.models.HexagonHint;
import ir.sharif.math.bp02_1.hex_chess.graphics.models.Paintable;
import ir.sharif.math.bp02_1.hex_chess.graphics.util.Config;
import ir.sharif.math.bp02_1.hex_chess.graphics.util.HintUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

public class BoardPanel extends JPanel {
    private int boardLeftShift = 150;
    final int boardTopShift = 48;
    final int boardBorderWidth = 3;

    private final List<HexagonCell> cells;
    private final List<HexagonHint> hints;
    private String message;
    private EventListener eventListener;

    public BoardPanel() {
        setLayout(null);
        setBackground(Color.decode("#f7f7f7"));
        this.addMouseListener(new BoardMouseListener());
        this.eventListener = new DummyEventListener();
        cells = new ArrayList<>();
        hints = new ArrayList<>();
        message = "";
    }

    public void initialize() {
        boardLeftShift = (getWidth() - (15 * Config.CELL_SIZE)) / 2;
        System.out.println(getWidth());
        System.out.println(boardBorderWidth);
        initialBaseBoard();
        initializeHints();
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

    private void initializeHints() {
        int moreShift = 5;
        for (int i = 1; i < 7; i++) {
            hints.add(new HexagonHint(i, 'z', boardLeftShift + moreShift, boardTopShift, "" + i));
        }

        Character[] chars = HintUtil.getChars();
        for (Character aChar : chars) {
            int col = HintUtil.getCol(aChar);
            if (col <= 6) {
                hints.add(new HexagonHint(0, aChar, boardLeftShift, boardTopShift - moreShift, "" + aChar));
                if (col <= 5) {
                    hints.add(new HexagonHint(6 + col, aChar, boardLeftShift + moreShift, boardTopShift + moreShift, "" + (6 + col)));
                }
            } else {
                hints.add(new HexagonHint(col - 6, aChar, boardLeftShift - moreShift, boardTopShift - moreShift, "" + aChar));
            }
        }

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

        // draw black board as board and background
        for (HexagonCell cell : cells) {
            g.setColor(Color.decode("#080808"));
            for (int dx = -boardBorderWidth; dx <= boardBorderWidth; dx += 1) {
                for (int dy = -boardBorderWidth; dy <= boardBorderWidth; dy += 1) {
                    if (dx * dx + dy * dy <= boardBorderWidth * boardBorderWidth) {
                        Polygon p = cell.getPolygon();
                        p.translate(dx, dy);
                        g.fillPolygon(p);
                    }
                }
            }
        }

        // foreground board
        for (Paintable cell : cells) {
            cell.paint(g2);
        }
        for (Paintable cell : hints) {
            cell.paint(g2);
        }

        FontMetrics fm = g2.getFontMetrics();
        int x = getX() + (getWidth() - fm.stringWidth(message)) / 2;
        int y = getHeight() - 50 - ((fm.getHeight()) / 2) + fm.getAscent();
        g2.drawString(message, x, y);
    }

    public void setEventListener(EventListener eventListener) {
        this.eventListener = eventListener;
    }

    public void setCellProperties(int row, char col, String text, Color backGroundColor, Color textColor) {
        HexagonCell targetCell = findCell(row, col);
        if (targetCell != null) {
            if (text != null)
                targetCell.setText(text);
            if (backGroundColor != null)
                targetCell.setBackGroundColor(backGroundColor);
            if (textColor != null)
                targetCell.setTextColor(textColor);
        } else {
            System.err.printf("cant find cel with row=%d, col=%c", row, col);
        }
    }

    private HexagonCell findCell(int row, char col) {
        for (HexagonCell cell : cells) {
            if (cell.getRow() == row && cell.getCol() == col) {
                return cell;
            }
        }
        return null;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    private class BoardMouseListener implements MouseListener {
        @Override
        public void mouseClicked(MouseEvent mouseEvent) {
            HexagonCell targetCell = null;
            for (HexagonCell cell : cells) {
                if (cell.getPolygon().contains(mouseEvent.getPoint())) {
                    targetCell = cell;
                    break;
                }
            }
            if (targetCell != null) {
                eventListener.onClick(targetCell.getRow(), targetCell.getCol());
            }
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
}
