package ir.sharif.math.bp02_1.hex_chess.graphics.models;

import java.awt.*;
import java.util.List;

public class GraphicalBoard{

    public List<HexagonButton> tiles;

    public GraphicalBoard(List<HexagonButton> map) {
        this.tiles = map;
    }

    public List<HexagonButton> getTiles() {
        return tiles;
    }

    public void setTiles(List<HexagonButton> tiles) {
        this.tiles = tiles;
    }
}
