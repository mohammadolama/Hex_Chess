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
    private int tileRadius;
    private int tileWidth;
    private int tileLength;
    Character[] chars = HintUtil.getChars();

    public BoardPanel(GraphicalBoard board, GraphicalAgent graphicalAgent) {
        this.board = board;
        this.agent = graphicalAgent;
        config();
        requestFocus();
        setBackground(new Color(134, 248, 83));

        for (int i = 1; i < 7; i++) {
            HintHexButton hintHex = new HintHexButton(i, 'z' , tileRadius , tileLength , tileWidth);
            hintHex.setHintLabel(i+"");
            this.add(hintHex);
        }

        for (Character aChar : chars) {
            int col = HintUtil.getCol(aChar);
            if (col <= 6){
                HintHexButton hintHex = new HintHexButton(0, aChar , tileRadius , tileLength , tileWidth);
                hintHex.setHintLabel(aChar+"");
                this.add(hintHex);

                for (int i = 1; i < 6+col; i++) {
                    HexagonButton hexagonButton = new HexagonButton(i, aChar , tileRadius , tileLength , tileWidth);
                    this.add(hexagonButton);
                }
                if (col<=5) {
                    HintHexButton hintHex2 = new HintHexButton(6 + col, aChar, tileRadius, tileLength, tileWidth);
                    hintHex2.setHintLabel(6 + col + "");
                    this.add(hintHex2);
                }
            }else {
                HintHexButton hintHex = new HintHexButton(col-6, aChar , tileRadius , tileLength , tileWidth);
                hintHex.setHintLabel(aChar+"");
                this.add(hintHex);
                for (int i = col-5; i < 12; i++) {
                    HexagonButton hexagonButton = new HexagonButton(i, aChar , tileRadius , tileLength , tileWidth);
                    this.add(hexagonButton);
                }
            }
        }
//        for (int i = 1; i < 7; i++) {
//            HexagonButton hexagonButton = new HexagonButton(i, 'a' , tileRadius , tileLength , tileWidth);
//            this.add(hexagonButton);
//        }
//        for (int i = 1; i < 8; i++) {
//            HexagonButton hexagonButton = new HexagonButton(i, 'b' , tileRadius , tileLength , tileWidth);
//            this.add(hexagonButton);
//        }
    }

    public Dimension getPreferredSize() {
        return new Dimension(1000, 700);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        ((Graphics2D) g).setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        ((Graphics2D) g).setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
//        ((Graphics2D) g).rotate(Math.toRadians(30), 500, 350);
//        synchronized (agent.getPaintLock()){
//            board.paint((Graphics2D) g);
//        }
//        ((Graphics2D) g).rotate(Math.toRadians(-30), 500, 350);
    }

    private void config() {
        Config config = Config.getConfig("boardPanel");
        setLayout(null);
        setBounds(config.getProperty(Integer.class, "x"), config.getProperty(Integer.class, "y")
                , config.getProperty(Integer.class, "width"), config.getProperty(Integer.class, "height"));

        Config tileConfig = Config.getConfig("tile");
        tileRadius = tileConfig.getProperty(Integer.class , "radius");
        tileLength = tileConfig.getProperty(Integer.class , "length");
        tileWidth = tileConfig.getProperty(Integer.class , "width");
    }



}
