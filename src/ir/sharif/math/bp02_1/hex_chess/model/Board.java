package ir.sharif.math.bp02_1.hex_chess.model;


import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Board {
    private final List<Tile> tiles;

    public Board(List<Tile> tiles) {
        this.tiles = tiles;
    }


    public List<Tile> getTiles() {
        return tiles;
    }

    /**
     * give x,y , return a cell with that coordinates
     * return null if not exist.
     */
    public Tile getCell(int x, int y) {
        return null;
    }
}
