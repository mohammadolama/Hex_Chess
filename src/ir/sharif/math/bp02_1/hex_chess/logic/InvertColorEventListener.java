package ir.sharif.math.bp02_1.hex_chess.logic;

import ir.sharif.math.bp02_1.hex_chess.graphics.listeners.EventListener;
import ir.sharif.math.bp02_1.hex_chess.logic.GameManager;

import java.io.File;

public class InvertColorEventListener implements EventListener {

    private GameManager gameManager;

    public InvertColorEventListener(GameManager gameManager) {
        this.gameManager = gameManager;
    }

    @Override
    public void onClick(int row, char col) {
        gameManager.clicked(row , col);
    }

    @Override
    public void onLoad(File file) {

    }

    @Override
    public void onSave(File file) {

    }

    @Override
    public void onNewGame() {

    }
}
