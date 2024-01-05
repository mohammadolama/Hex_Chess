package ir.sharif.math.bp02_1.hex_chess.graphics.models;

import java.awt.*;
import java.util.List;

public class GraphicalBoard extends GraphicalModel {

    public List<GraphicalTile> tiles;

    public GraphicalBoard(List<GraphicalTile> map) {
        this.tiles = map;
    }


    public List<GraphicalTile> getTiles() {
        return tiles;
    }

    public void setTiles(List<GraphicalTile> tiles) {
        this.tiles = tiles;
    }

    @Override
    public void paint(Graphics2D graphics2D) {
        for (GraphicalTile tile : tiles) {
            if (tile != null){
                tile.paint(graphics2D);
            }
        }
    }
}
