package ir.sharif.math.bp02_1.hex_chess.graphics;


import ir.sharif.math.bp02_1.hex_chess.graphics.models.*;
import ir.sharif.math.bp02_1.hex_chess.graphics.util.Config;
import ir.sharif.math.bp02_1.hex_chess.graphics.util.HintUtil;
import ir.sharif.math.bp02_1.hex_chess.model.Board;
import ir.sharif.math.bp02_1.hex_chess.model.GameState;
import ir.sharif.math.bp02_1.hex_chess.model.Tile;
import ir.sharif.math.bp02_1.hex_chess.model.pieces.Piece;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class GraphicalGameStateBuilder {
    private final GameState logicalGameState;

    private GraphicalAgent graphicalAgent;

    private int tileRadius;
    private int tileWidth;
    private int tileLength;
    private int startX;
    private int startY;

    Character[] chars = HintUtil.getChars();

    public GraphicalGameStateBuilder(GameState gameState, GraphicalAgent agent) {
        this.logicalGameState = gameState;
        this.graphicalAgent = agent;
        config();
    }

    public GraphicalGameState build() {
        GraphicalBoard b = createBoard(logicalGameState.getBoard());
        return new GraphicalGameState(b, null, null);
    }

    public void update(GraphicalGameState graphicalGameState) {
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

    private List<HexagonButton> convertCells(List<Tile> tiles) {
        List<HexagonButton> res = new ArrayList<>();

        for (int i = 1; i < 7; i++) {
            HintHexButton hintHex = new HintHexButton(i, 'z' , tileRadius , tileLength , tileWidth , startX , startY);
            hintHex.setHintLabel(i+"");
            res.add(hintHex);
        }

        for (Tile tile : tiles) {
            HexagonButton hexagonButton = new HexagonButton(tile.getRow(), tile.getCol() , tileRadius , tileLength , tileWidth , startX , startY , graphicalAgent);
            if (tile.getPiece()!=null){
                hexagonButton.setPiece(convertPiece(tile.getPiece()));
            }
            res.add(hexagonButton);
        }

        for (Character aChar : chars) {
            int col = HintUtil.getCol(aChar);
            if (col <= 6){
                HintHexButton hintHex = new HintHexButton(0, aChar , tileRadius , tileLength , tileWidth , startX , startY);
                hintHex.setHintLabel(aChar+"");
                res.add(hintHex);
                if (col<=5) {
                    HintHexButton hintHex2 = new HintHexButton(6 + col, aChar, tileRadius, tileLength, tileWidth , startX , startY);
                    hintHex2.setHintLabel(6 + col + "");
                    res.add(hintHex2);
                }
            }else {
                HintHexButton hintHex = new HintHexButton(col-6, aChar , tileRadius , tileLength , tileWidth , startX , startY);
                hintHex.setHintLabel(aChar+"");
                res.add(hintHex);
            }
        }

        return res;
    }

    private GraphicalPiece convertPiece(Piece piece){
        return new GraphicalPiece(piece.getName() , piece.getValue() , piece.isSelected() , piece.isCanBeAttacked());
    }


    private <T> void setList(List<? super T> target, List<? extends T> values) {
        target.clear();
        target.addAll(values);
    }

    private void config() {
        Config tileConfig = Config.getConfig("tile");
        tileRadius = tileConfig.getProperty(Integer.class , "radius");
        tileLength = tileConfig.getProperty(Integer.class , "length");
        tileWidth = tileConfig.getProperty(Integer.class , "width");
        startX = tileConfig.getProperty(Integer.class , "startX");
        startY = tileConfig.getProperty(Integer.class , "startY");
    }

}
