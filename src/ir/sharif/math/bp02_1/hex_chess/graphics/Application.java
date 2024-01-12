package ir.sharif.math.bp02_1.hex_chess.graphics;

import ir.sharif.math.bp02_1.hex_chess.graphics.listeners.EventListener;
import ir.sharif.math.bp02_1.hex_chess.graphics.panel.BoardPanel;
import ir.sharif.math.bp02_1.hex_chess.graphics.panel.RemovedPiecesPanel;

import javax.swing.*;
import java.awt.*;

public class Application {
    private final Frame mainFrame;
    private final BoardPanel boardPanel;

    public Application() {
        this.mainFrame = Frame.getInstance();
        this.boardPanel = new BoardPanel();
        this.mainFrame.getContentPane().setLayout(new BorderLayout());
        this.mainFrame.getContentPane().add(boardPanel, BorderLayout.CENTER);

        RemovedPiecesPanel removedPiecesPanel = new RemovedPiecesPanel();
        this.mainFrame.getContentPane().add(removedPiecesPanel, BorderLayout.LINE_END);

        this.mainFrame.setVisible(true);
        boardPanel.initialize();
    }

    public void registerEventListener(EventListener eventListener) {
        boardPanel.setEventListener(eventListener);
        mainFrame.setEventListener(eventListener);
    }

    public void setCellProperties(int row, char col, String text, Color color) {
        boardPanel.setCellProperties(row, col, text, color);
    }

    public void showMessage(String text) {
        JOptionPane.showMessageDialog(mainFrame, text);
    }

}
