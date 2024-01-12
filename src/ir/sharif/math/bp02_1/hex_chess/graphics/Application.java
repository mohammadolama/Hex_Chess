package ir.sharif.math.bp02_1.hex_chess.graphics;

import ir.sharif.math.bp02_1.hex_chess.graphics.panel.BoardPanel;

import javax.swing.*;
import java.awt.*;

public class Application {
    Frame mainFrame;

    public Application() {
        this.mainFrame = Frame.getInstance();
        BoardPanel boardPanel = new BoardPanel();
        this.mainFrame.getContentPane().setLayout(new BorderLayout());
        this.mainFrame.getContentPane().add(boardPanel, BorderLayout.CENTER);
    }

}
