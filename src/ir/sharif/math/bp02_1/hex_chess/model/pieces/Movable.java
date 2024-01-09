package ir.sharif.math.bp02_1.hex_chess.model.pieces;

import ir.sharif.math.bp02_1.hex_chess.model.Tile;

public interface Movable {

    boolean isValidMove(Tile tile);

    boolean MoveTo(Tile tile);


}
