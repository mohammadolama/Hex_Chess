package ir.sharif.math.bp02_1.hex_chess.model;

public class GameState {
    private final Board board;
    private final Player player1;
    private final Player player2;

    private final Player currentPlayer;

    private final boolean hasStarted;

    public GameState(Board board, Player player1, Player player2) {
        this.board = board;
        this.player1 = player1;
        this.player2 = player2;
        this.currentPlayer = player1;
        this.hasStarted = false;
    }

    public Board getBoard() {
        return board;
    }

    public Player getPlayer1() {
        return player1;
    }

    public Player getPlayer2() {
        return player2;
    }

    public Player getPlayer(int i) {
        if (i == 1) return player1;
        else if (i == 2) return player2;
        else return null;
    }

    public boolean isStarted() {
        return hasStarted;
    }

    /**
     * return null if game is not started.
     * else return a player whose turn is now.
     */
    public Player getCurrentPlayer() {
        return currentPlayer;
    }


    /**
     * finish current player's turn and update some fields of this class;
     * you can use method "endTurn" in class "Player" (not necessary, but recommended)
     */
    public void nextTurn() {

    }


    @Override
    public String toString() {
        return "GameState{" +
                "board=" + board +
                ", playerOne=" + player1 +
                ", playerTwo=" + player2 +
                '}';
    }
}
