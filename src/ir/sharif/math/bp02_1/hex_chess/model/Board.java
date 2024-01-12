package ir.sharif.math.bp02_1.hex_chess.model;


import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Board {
    private final List<Tile> tiles;

    private Tile selectedTile;

    public Board(List<Tile> tiles) {
        this.tiles = tiles;
        selectedTile = null;
    }
    public List<Tile> getTiles() {
        return tiles;
    }

    public Tile getCell(int row, char col) {
        for (Tile tile : tiles) {
            if (tile.getRow() == row && tile.getCol() == col){
                return tile;
            }
        }
        return null;
    }

    public Tile getSelectedTile() {
        return selectedTile;
    }

    public void setSelectedTile(Tile selectedTile) {
        this.selectedTile = selectedTile;
    }
}
