package ir.sharif.math.bp02_1.hex_chess.graphics.panel;


import ir.sharif.math.bp02_1.hex_chess.graphics.util.Config;

import javax.swing.*;
import java.awt.*;

public class MainPanel extends JPanel {
    private final BoardPanel boardPanel;

    private int x;
    private int y;
    private int width;
    private int height;

    public MainPanel(BoardPanel boardPanel) {
        this.boardPanel = boardPanel;
        initialize();
    }

    private void initialize() {
        config();
        this.add(boardPanel);
    }

    public void update(){
        this.boardPanel.update();
        this.repaint();
        this.revalidate();
    }

    private void config() {
        Config config = Config.getConfig("mainPanel");
        setLayout(null);
        this.x = config.getProperty(Integer.class, "x");
        this.y = config.getProperty(Integer.class, "y");
        this.width = config.getProperty(Integer.class, "width");
        this.height = config.getProperty(Integer.class, "height");
        setBounds(x,y,width,height);
        setPreferredSize(new Dimension(width,height));
    }


}