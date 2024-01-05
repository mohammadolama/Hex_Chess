package ir.sharif.math.bp02_1.hex_chess.graphics.panel;


import ir.sharif.math.bp02_1.hex_chess.graphics.GraphicalAgent;
import ir.sharif.math.bp02_1.hex_chess.graphics.models.GraphicalBoard;
import ir.sharif.math.bp02_1.hex_chess.graphics.models.GraphicalTile;
import ir.sharif.math.bp02_1.hex_chess.graphics.util.Config;

import javax.swing.*;
import java.awt.*;

public class BoardPanel extends JPanel {

    protected final GraphicalBoard board;
    protected final GraphicalAgent agent;

    public BoardPanel(GraphicalBoard board, GraphicalAgent graphicalAgent) {
        this.board = board;
        this.agent = graphicalAgent;
        config();
        requestFocus();
        setBackground(new Color(134, 248, 83));
    }

    public Dimension getPreferredSize() {
        return new Dimension(1000, 700);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        ((Graphics2D) g).rotate(Math.toRadians(30), 400, 400);
        synchronized (agent.getPaintLock()){
            board.paint((Graphics2D) g);
        }
    }

    private void config() {
        Config config = Config.getConfig("boardPanel");
        setLayout(null);
        setBounds(config.getProperty(Integer.class, "x"), config.getProperty(Integer.class, "y")
                , config.getProperty(Integer.class, "width"), config.getProperty(Integer.class, "height"));
    }

}
