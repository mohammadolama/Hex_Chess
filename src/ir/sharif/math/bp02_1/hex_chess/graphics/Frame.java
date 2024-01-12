package ir.sharif.math.bp02_1.hex_chess.graphics;

import ir.sharif.math.bp02_1.hex_chess.graphics.panel.MainPanel;
import ir.sharif.math.bp02_1.hex_chess.graphics.util.Config;

import javax.swing.*;
import java.awt.*;

import java.io.File;

public class Frame extends JFrame {
    private static Frame instance;

    public static Frame getInstance() {
        if (instance == null) instance = new Frame();
        return instance;
    }

    private File chooseFile() {
        JFileChooser chooser = new JFileChooser();

        int choice = chooser.showOpenDialog(this);

        if (choice != JFileChooser.APPROVE_OPTION) return null;

        return chooser.getSelectedFile();

    }

    private Frame() {
        setSize(new Dimension(Config.GAME_WIDTH, Config.GAME_HEIGHT));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setUndecorated(false);
        setTitle(Config.GAME_TITLE);


        // Create a menubar
        JMenuBar mb = new JMenuBar();

        // Create amenu for menu
        JMenu m1 = new JMenu("File");

        // Create menu items
        JMenuItem mi1 = new JMenuItem("New");
        JMenuItem mi2 = new JMenuItem("Open");
        mi2.addActionListener((actionEvent) -> {
            File f = chooseFile();
            if (f != null) {
                // TODO: load file
                // listener.onGameLoad(f);
            }
        });
        JMenuItem mi3 = new JMenuItem("Save");
        JMenuItem mi9 = new JMenuItem("Print");

        m1.add(mi1);
        m1.add(mi2);
        m1.add(mi3);
        m1.add(mi9);

        // Create amenu for menu
        JMenu m2 = new JMenu("Edit");

        // Create menu items
        JMenuItem mi4 = new JMenuItem("cut");
        JMenuItem mi5 = new JMenuItem("copy");
        JMenuItem mi6 = new JMenuItem("paste");


        m2.add(mi4);
        m2.add(mi5);
        m2.add(mi6);

        JMenuItem mc = new JMenuItem("close");


        mb.add(m1);
        mb.add(m2);
        mb.add(mc);

        this.setJMenuBar(mb);


        this.setLayout(null);
        this.setVisible(true);
        this.setLocationRelativeTo(null);

        setContentPane(new MainPanel());
    }

}
