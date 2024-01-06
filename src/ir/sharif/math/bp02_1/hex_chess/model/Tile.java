package ir.sharif.math.bp02_1.hex_chess.model;

import ir.sharif.math.bp02_1.hex_chess.model.pieces.Piece;

import java.awt.*;

public class Tile {
    private final int row;
    private final char col;
    private Piece piece;

    public Tile( int row, char col) {
        this.row = row;
        this.col = col;
        this.piece = null;
    }

    public Tile(int row, char col, Piece piece) {
        this.row = row;
        this.col = col;
        this.piece = piece;
    }

    public int getRow() {
        return row;
    }

    public char getCol() {
        return col;
    }

    public Piece getPiece() {
        return piece;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }
}
