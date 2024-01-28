package ir.sharif.math.bp02_1.hex_chess.logic;

import ir.sharif.math.bp02_1.hex_chess.graphics.Application;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GameManager {

    private Application application;

    private final Random random;

    private final double treshhold = 0.2;

    private InvertColorEventListener listener;


    private List<Tile> tiles = new ArrayList<>();

    private Tile[][] tiless = new Tile[11][11];


    public GameManager(Application application) {
        this.application = application;
        listener = new InvertColorEventListener(this);
        this.application.registerEventListener(listener);
        this.random = new Random();
        init();
    }

    private void init() {

        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 11; j++) {
                tiless[i][j] = new Tile(i + 1, BoardHelper.getChar(j), true);
                double v = random.nextDouble();
                if (v <= treshhold)
                    tiless[i][j].setSelected(true);
            }
        }
        for (int i = 6; i < 11; i++) {
            for (int j = 1 + (i - 6); j < 10 + (6 - i); j++) {
                tiless[i][j] = new Tile(i + 1, BoardHelper.getChar(j), true);
                double v = random.nextDouble();
                if (v <= treshhold)
                    tiless[i][j].setSelected(true);
            }
        }

        draw();
    }


    public void clicked(int row, char col) {
        row = row-1;            // we are saving the board in an array, which is 0-based. Thus we need to decrement it first.
        System.out.println("Clicked on " + col + row);
        int c = BoardHelper.getInt(col);
        toggleCell(row , c);

        toggleCell(row-1 , c);
        toggleCell(row+1 , c);
        toggleCell(row , c+1);
        toggleCell(row , c-1);

        if (col <= 'f') {
            toggleCell(row - 1, c - 1);
            if (col < 'f')
                toggleCell(row+1 , c+1);
        }
        if (col >= 'f') {
            toggleCell(row - 1, c + 1);
            if (col > 'f'){
                toggleCell(row+1 , c-1);
            }
        }

        draw();
    }


    private void draw(){
        for (int i = 0; i < tiless.length; i++) {
            for (int j = 0; j < tiless[0].length; j++) {
                if (tiless[i][j] != null){
                    if (tiless[i][j].isSelected()){
                        application.setCellProperties(tiless[i][j].getRow(), tiless[i][j].getCol(), null, Color.RED, Color.BLACK);
                    }else {
                        application.setCellProperties(tiless[i][j].getRow(), tiless[i][j].getCol(), null, null, Color.BLACK);
                    }
                }
            }
        }
    }

    private void toggleCell(int row , int col){
        if (row>=0 && row<tiless.length && col>=0 && col<tiless[0].length){
            if (tiless[row][col] != null){
                tiless[row][col].setSelected(!tiless[row][col].isSelected());
            }
        }
    }

}
