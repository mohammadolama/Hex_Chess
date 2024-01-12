package ir.sharif.math.bp02_1.hex_chess.model.pieces;

import ir.sharif.math.bp02_1.hex_chess.model.Tile;
import ir.sharif.math.bp02_1.hex_chess.util.PieceName;
import ir.sharif.math.bp02_1.hex_chess.util.Pieces;

public class Pawn extends Piece{

    boolean black;

    public Pawn(Pieces piece , Tile currentTile){
        this(piece.getValue() , piece.getName() , piece.isWhite() , currentTile , false , false);
    }

    public Pawn(String value, String name, boolean black, Tile currentTile, boolean isSelected, boolean canBeAttacked) {
        super(value, name, black, currentTile, isSelected, canBeAttacked);
    }


    @Override
    public boolean isValidMove(Tile tile) {
        return false;
    }

    @Override
    public boolean MoveTo(Tile tile) {
        return false;
    }
}
