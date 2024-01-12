package ir.sharif.math.bp02_1.hex_chess.util;

public enum Pieces {

    WHITE_PAWN("pawn" , "\u2659" , true),
    BLACK_PAWN("pawn" , "\u265F" , false);

    private final String name;
    private final boolean isWhite;
    private final String value;

    Pieces(String name , String value , boolean isWhite){
        this.name = name;
        this.value = value;
        this.isWhite = isWhite;
    }

    public String getName() {
        return name;
    }

    public boolean isWhite() {
        return isWhite;
    }

    public String getValue() {
        return value;
    }
}
