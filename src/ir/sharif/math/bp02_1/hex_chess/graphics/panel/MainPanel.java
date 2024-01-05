package ir.sharif.math.bp02_1.hex_chess.graphics.panel;


import ir.sharif.math.bp02_1.hex_chess.graphics.util.Config;

import javax.swing.*;
import java.awt.*;

public class MainPanel extends JPanel {
    private final BoardPanel boardPanel;

    public MainPanel(BoardPanel boardPanel) {
        this.boardPanel = boardPanel;
        initialize();
    }

    private void initialize() {
        config();
        this.add(boardPanel);
    }

    private void config() {
        Config config = Config.getConfig("mainPanel");
        setLayout(null);
        setBounds(config.getProperty(Integer.class, "x"), config.getProperty(Integer.class, "y")
                , config.getProperty(Integer.class, "width"), config.getProperty(Integer.class, "height"));
        setPreferredSize(new Dimension(config.getProperty(Integer.class, "width")
                , config.getProperty(Integer.class, "height")));
    }


}