package ir.sharif.math.bp02_1.hex_chess.graphics;

import ir.sharif.math.bp02_1.hex_chess.graphics.listeners.EventListener;
import ir.sharif.math.bp02_1.hex_chess.graphics.panel.BoardPanel;

import java.awt.*;

public class Application {
    private final Frame mainFrame;
    private final BoardPanel boardPanel;

    public Application() {
        this.mainFrame = Frame.getInstance();
        this.boardPanel = new BoardPanel();
        this.mainFrame.getContentPane().setLayout(new BorderLayout());
        this.mainFrame.getContentPane().add(boardPanel, BorderLayout.CENTER);
    }

    public void registerEventListener(EventListener eventListener) {
        boardPanel.setEventListener(eventListener);
        mainFrame.setEventListener(eventListener);
    }

}
