package ir.sharif.math.bp02_1.hex_chess.graphics;

import ir.sharif.math.bp02_1.hex_chess.graphics.listeners.DummyEventListener;
import ir.sharif.math.bp02_1.hex_chess.graphics.listeners.EventListener;
import ir.sharif.math.bp02_1.hex_chess.graphics.panel.MainPanel;
import ir.sharif.math.bp02_1.hex_chess.graphics.util.Config;
import ir.sharif.math.bp02_1.hex_chess.graphics.util.Loop;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.lang.reflect.InvocationTargetException;

public class Frame extends JFrame {
    private EventListener eventListener;

    private File chooseFile() {
        JFileChooser chooser = new JFileChooser();
        int choice = chooser.showOpenDialog(this);
        if (choice != JFileChooser.APPROVE_OPTION) return null;
        return chooser.getSelectedFile();
    }

    public Frame() {
        this.eventListener = new DummyEventListener();
        setSize(new Dimension(Config.GAME_WIDTH, Config.GAME_HEIGHT));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setUndecorated(false);
        setTitle(Config.GAME_TITLE);
        this.setLayout(null);
        this.addMenuBar();
        setContentPane(new MainPanel());
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        new Loop(Config.FPS, this::update).start();
    }

    private void update() {
        try {
            SwingUtilities.invokeAndWait(() -> {
                this.revalidate();
                this.repaint();
            });
        } catch (InterruptedException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    private void addMenuBar() {
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        JMenuItem newMenuItem = new JMenuItem("New");
        fileMenu.add(newMenuItem);
        newMenuItem.addActionListener((actionEvent) -> eventListener.onNewGame());
        JMenuItem openMenuItem = new JMenuItem("Open");
        fileMenu.add(openMenuItem);
        openMenuItem.addActionListener((actionEvent) -> {
            File file = chooseFile();
            if (file != null) {
                eventListener.onLoad(file);
            }
        });
        JMenuItem saveMenuItem = new JMenuItem("Save");
        saveMenuItem.addActionListener((actionEvent) -> {
            File file = chooseFile();
            if (file != null) {
                eventListener.onSave(file);
            }
        });
        fileMenu.add(saveMenuItem);
        menuBar.add(fileMenu);
        this.setJMenuBar(menuBar);
    }

    public void setEventListener(EventListener eventListener) {
        this.eventListener = eventListener;
    }
}
