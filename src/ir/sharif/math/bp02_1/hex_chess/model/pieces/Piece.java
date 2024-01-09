package ir.sharif.math.bp02_1.hex_chess.model.pieces;

import ir.sharif.math.bp02_1.hex_chess.model.Tile;

public abstract class Piece implements Movable {
    private String value;
    private String name;
    boolean white;
    private Tile currentTile;
    private boolean isSelected;
    private boolean canBeAttacked;

    protected Piece(String value, String name, boolean white, Tile currentTile, boolean isSelected, boolean canBeAttacked) {
        this.value = value;
        this.name = name;
        this.white = white;
        this.currentTile = currentTile;
        this.isSelected = isSelected;
        this.canBeAttacked = canBeAttacked;
    }

    public Tile getCurrentCell() {
        return currentTile;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }

    public void setCurrentCell(Tile currentTile) {
        this.currentTile = currentTile;
    }

    public Tile getCurrentTile() {
        return currentTile;
    }

    public void setCurrentTile(Tile currentTile) {
        this.currentTile = currentTile;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isCanBeAttacked() {
        return canBeAttacked;
    }

    public void setCanBeAttacked(boolean canBeAttacked) {
        this.canBeAttacked = canBeAttacked;
    }

}
