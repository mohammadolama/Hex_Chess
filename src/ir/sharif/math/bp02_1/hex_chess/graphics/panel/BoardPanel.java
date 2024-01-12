package ir.sharif.math.bp02_1.hex_chess.graphics.panel;


import ir.sharif.math.bp02_1.hex_chess.graphics.GraphicalAgent;
import ir.sharif.math.bp02_1.hex_chess.graphics.models.GraphicalBoard;
import ir.sharif.math.bp02_1.hex_chess.graphics.models.HexagonButton;
import ir.sharif.math.bp02_1.hex_chess.graphics.models.HintHexButton;
import ir.sharif.math.bp02_1.hex_chess.graphics.util.HintUtil;
import ir.sharif.math.bp02_1.hex_chess.graphics.util.Config;

import javax.swing.*;
import java.awt.*;

public class BoardPanel extends JPanel {

    protected final GraphicalBoard board;
    protected final GraphicalAgent agent;
    private int x;
    private int y;
    private int width;
    private int height;

    public BoardPanel(GraphicalBoard board, GraphicalAgent graphicalAgent) {
        this.board = board;
        this.agent = graphicalAgent;
        config();
        requestFocus();
        setBackground(new Color(134, 248, 83));
        for (HexagonButton tile : this.board.tiles) {
            this.add(tile);
        }
    }

    public Dimension getPreferredSize() {
        return new Dimension(width, height);
    }


    private void config() {
        Config config = Config.getConfig("boardPanel");
        setLayout(null);
        this.x = config.getProperty(Integer.class, "x");
        this.y = config.getProperty(Integer.class, "y");
        this.width = config.getProperty(Integer.class, "width");
        this.height = config.getProperty(Integer.class, "height");
        setBounds(x,y,width,height);
        setPreferredSize(new Dimension(width,height));
    }

    public void update(){
        this.removeAll();
        for (HexagonButton tile : this.board.tiles) {
            this.add(tile);
        }
        repaint();
        revalidate();
    }



}
