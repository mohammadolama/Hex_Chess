package ir.sharif.math.bp02_1.hex_chess.logic;

public class Tile {

    private int row;

    private char col;

    private boolean isSelected;

    private final boolean available;

    public Tile(int row, char col, boolean available) {
        this.row = row;
        this.col = col;
        this.available = available;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public char getCol() {
        return col;
    }

    public void setCol(char col) {
        this.col = col;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }

    public boolean isAvailable() {
        return available;
    }
}
