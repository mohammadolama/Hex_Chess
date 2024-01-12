package ir.sharif.math.bp02_1.hex_chess.graphics;

import ir.sharif.math.bp02_1.hex_chess.graphics.listeners.EventListener;
import ir.sharif.math.bp02_1.hex_chess.graphics.models.StringColor;
import ir.sharif.math.bp02_1.hex_chess.graphics.panel.BoardPanel;
import ir.sharif.math.bp02_1.hex_chess.graphics.panel.RemovedPiecesPanel;

import java.awt.*;

public class Application {
    private final Frame mainFrame;
    private final BoardPanel boardPanel;
    private final RemovedPiecesPanel removedPiecesPanel;

    public Application() {
        this.mainFrame = Frame.getInstance();
        this.boardPanel = new BoardPanel();
        this.mainFrame.getContentPane().setLayout(new BorderLayout());
        this.mainFrame.getContentPane().add(boardPanel, BorderLayout.CENTER);

        removedPiecesPanel = new RemovedPiecesPanel();
        this.mainFrame.getContentPane().add(removedPiecesPanel, BorderLayout.LINE_END);

        this.mainFrame.setVisible(true);
    }

    public void registerEventListener(EventListener eventListener) {
        boardPanel.setEventListener(eventListener);
        mainFrame.setEventListener(eventListener);
    }

    public void setRemovedPieces(StringColor[] pieces) {
        this.removedPiecesPanel.setPieces(pieces);
    }

}
