package ir.sharif.math.bp02_1.hex_chess.graphics;


import ir.sharif.math.bp02_1.hex_chess.graphics.models.*;
import ir.sharif.math.bp02_1.hex_chess.model.Board;
import ir.sharif.math.bp02_1.hex_chess.model.GameState;
import ir.sharif.math.bp02_1.hex_chess.model.Tile;
import ir.sharif.math.bp02_1.hex_chess.model.pieces.Piece;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class GraphicalGameStateBuilder {
    private final GameState logicalGameState;


    public GraphicalGameStateBuilder(GameState gameState, GraphicalAgent agent) {
        this.logicalGameState = gameState;
    }

    public GraphicalGameState build() {
        GraphicalBoard b = createBoard(logicalGameState.getBoard());
        return new GraphicalGameState(b, null, null);
    }

    public void update(GraphicalGameState graphicalGameState) {
//        updateGPlayer(logicalGameState.getPlayer1(), graphicalGameState.getPlayer1());
//        updateGPlayer(logicalGameState.getPlayer2(), graphicalGameState.getPlayer2());
        updateBoard(logicalGameState.getBoard(), graphicalGameState.getBoard());
        graphicalGameState.setStarted(logicalGameState.isStarted());
    }


    private GraphicalBoard createBoard(Board board) {
        GraphicalBoard graphicalBoard = new GraphicalBoard(convertCells(board.getTiles()));
        setList(graphicalBoard.getTiles(), convertCells(board.getTiles()));
        return graphicalBoard;
    }

    private void updateBoard(Board board, GraphicalBoard graphicalBoard) {
        setList(graphicalBoard.getTiles(), convertCells(board.getTiles()));
    }

    private List<GraphicalTile> convertCells(List<Tile> tiles) {
        List<GraphicalTile> res = new ArrayList<>();

//        for (Tile tile : tiles) {
//            if (tile.getPiece() != null) {
//                res.add(new GraphicalTile(tile.getX(), tile.getY(), tile.getPiece().getName()));
//            } else {
//                res.add(new GraphicalTile(tile.getX(), tile.getY(), tile.getX() + "," + tile.getY()));
//            }
//        }

        return res;
    }

//    private GraphicalTile[][] convertCells(List<Tile> tiles) {
//        GraphicalTile[][] res = new GraphicalTile[13][13];
//
//        for (Tile tile : tiles) {
//            res[tile.getX()][tile.getY()] = new GraphicalTile(tile.getX() , tile.getY() , tile.getX()+","+ tile.getY());
//        }
//
//        return res;
//    }


    private GraphicalColor getColor(Color c) {
        if (c.equals(Color.BLACK)) return GraphicalColor.BLACK;
        else if (c.equals(Color.WHITE)) return GraphicalColor.WHITE;
        else if (c.equals(Color.RED)) return GraphicalColor.RED;
        else if (c.equals(Color.BLUE)) return GraphicalColor.BLUE;
        else if (c.equals(Color.GREEN)) return GraphicalColor.GREEN;
        else return GraphicalColor.YELLOW;
    }


    private <T> void setList(List<? super T> target, List<? extends T> values) {
        target.clear();
        target.addAll(values);
    }
}
