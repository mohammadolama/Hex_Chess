package ir.sharif.math.bp02_1.hex_chess.graphics;


import ir.sharif.math.bp02_1.hex_chess.graphics.models.GraphicalGameState;
import ir.sharif.math.bp02_1.hex_chess.graphics.panel.BoardPanel;
import ir.sharif.math.bp02_1.hex_chess.graphics.panel.MainPanel;
import ir.sharif.math.bp02_1.hex_chess.logic.LogicalAgent;
import ir.sharif.math.bp02_1.hex_chess.model.GameState;

import javax.swing.*;

/**
 * this class is a connection between the graphic and logics
 */
public class GraphicalAgent {
    private final LogicalAgent logicalAgent; // maybe deleted
    private final Object paintLock;
    private GraphicalGameState graphicalGameState;
    private Frame frame;

    public GraphicalAgent(LogicalAgent logicalAgent) {
        this.logicalAgent = logicalAgent;
        this.paintLock = new Object();
    }

    /**
     * this method get game state and build or update a graphical models
     * and save this models somewhere
     */
    public void update(GameState gameState) {
        synchronized (paintLock) {
            new GraphicalGameStateBuilder(gameState, this).update(this.graphicalGameState);
        }
    }

    public void initialize(GameState gameState) {
        this.graphicalGameState = new GraphicalGameStateBuilder(gameState, this).build();
        this.frame = initializePanels();
    }

    private Frame initializePanels() {
        BoardPanel boardPanel = new BoardPanel(graphicalGameState.getBoard(), this);
        MainPanel mainPanel = new MainPanel(boardPanel);
        Frame frame = Frame.getInstance();
        frame.setContentPane(mainPanel);
        return frame;
    }

    public void clickRequest(int row, char col) {
        logicalAgent.selectCell(row, col);
        /*
         *  TO DO
         *  WE SEND X , Y TO LOGIC, LOGIC SHOULD DECIDE WEATHER WE CHOOSE
         *  A PIECE , OR WE WANT TO MOVE A (ALREADY) CHOSEN PIECE TO A NEW CORDINATES.
         *
         *  I SUGGEST LOGIC SEND BACK A BOOLEAN (OR STRING ), SO WE UNDERSTAND IF
         *  OUR REQUEST IS DONE OR NOT .
         *
         *
         */
    }


    public Object getPaintLock() {
        return paintLock;
    }

    public String getPlayerNames(int number) {
        String[] s = new String[]{"first", "second"};
        String result;
        do {
            result = JOptionPane.showInputDialog(frame, "Enter " + s[number - 1] + " player name ");
        } while (result == null || result.length() == 0);
        return result;
    }

    public void playerWin(int playerNumber) {
        String[] s = new String[]{"one", "two"};
        String message;
        if (playerNumber == 3) message = "draw";
        else message = "player " + s[playerNumber - 1] + " wins";
        JOptionPane.showMessageDialog(frame, message);
    }



    public GraphicalGameState getGraphicalGameState() {
        return graphicalGameState;
    }
}
