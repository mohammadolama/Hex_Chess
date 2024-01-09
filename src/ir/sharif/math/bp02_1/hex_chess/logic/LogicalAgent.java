package ir.sharif.math.bp02_1.hex_chess.logic;


import ir.sharif.math.bp02_1.hex_chess.graphics.GraphicalAgent;
import ir.sharif.math.bp02_1.hex_chess.model.Board;
import ir.sharif.math.bp02_1.hex_chess.model.GameState;
import ir.sharif.math.bp02_1.hex_chess.model.Player;
import ir.sharif.math.bp02_1.hex_chess.model.Tile;

/**
 * This class is an interface between logic and graphic.
 * some methods of this class, is called from graphic.
 * DO NOT CHANGE ANY PART WHICH WE MENTION.
 */
public class LogicalAgent {
    private final ModelLoader modelLoader;
    private final GraphicalAgent graphicalAgent;
    private final GameState gameState;

    /**
     * DO NOT CHANGE CONSTRUCTOR.
     */
    public LogicalAgent() {
        this.graphicalAgent = new GraphicalAgent(this);
        this.modelLoader = new ModelLoader();
        this.gameState = loadGameState();
    }


    /**
     * NO CHANGES NEEDED.
     */
    private GameState loadGameState() {
        Board board = modelLoader.loadBord();
        return new GameState(board, null, null);
    }

    /**
     * NO CHANGES NEEDED.
     */
    public void initialize() {
        graphicalAgent.initialize(gameState);
    }

    /**
     * Give a number from graphic,( which is the playerNumber of a player
     * who clicks "ReadyButton".) you should somehow change that player state.
     * if both players are ready. then start the game.
     */
    public void readyPlayer(int playerNumber) {


        // dont touch this line
        graphicalAgent.update(gameState);
    }

    /**
     * give x,y (coordinates of a cell) :
     * you should handle if user want to select a piece
     * or already selected a piece and now want to move it to a new cell
     */
    // ***
    public void selectCell(int row, char col) {

        Tile cell = gameState.getBoard().getCell(row, col);
        if (cell.getPiece() != null){
            cell.getPiece().setSelected(!cell.getPiece().isSelected());
        }

        // dont touch this line
        graphicalAgent.update(gameState);
        checkForEndGame();
    }


    public String getCellDetails(int row, char col) {
        return "cell at " + col + " " + row;
    }

    /**
     * check for endgame and specify winner
     * if player one in winner set winner variable to 1
     * if player two in winner set winner variable to 2
     * If the game is a draw set winner variable to 3
     */
    private void checkForEndGame() {
        if (false) {
            // game ends
            int winner = 1;


            // your code


            // dont touch it
            graphicalAgent.playerWin(winner);
            /* save players*/
            modelLoader.savePlayer(gameState.getPlayer1());
            modelLoader.savePlayer(gameState.getPlayer2());
            LogicalAgent logicalAgent = new LogicalAgent();
            logicalAgent.initialize();
        }
    }

}
