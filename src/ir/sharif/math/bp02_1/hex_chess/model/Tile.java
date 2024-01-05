package ir.sharif.math.bp02_1.hex_chess.model;

import ir.sharif.math.bp02_1.hex_chess.model.pieces.Piece;

import java.awt.*;

public class Tile {
    private final int x, y;
    private Piece piece;

    public Tile( int x, int y) {
        this.x = x;
        this.y = y;
        this.piece = null;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Piece getPiece() {
        return piece;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }
}
