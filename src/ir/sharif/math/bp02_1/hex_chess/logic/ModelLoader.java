package ir.sharif.math.bp02_1.hex_chess.logic;

import ir.sharif.math.bp02_1.hex_chess.graphics.util.Config;
import ir.sharif.math.bp02_1.hex_chess.graphics.util.HintUtil;
import ir.sharif.math.bp02_1.hex_chess.model.Board;
import ir.sharif.math.bp02_1.hex_chess.model.Player;
import ir.sharif.math.bp02_1.hex_chess.model.Tile;
import ir.sharif.math.bp02_1.hex_chess.model.pieces.Pawn;
import ir.sharif.math.bp02_1.hex_chess.util.Pieces;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ModelLoader {
    private final File boardFile;


    /**
     * DO NOT CHANGE ANYTHING IN CONSTRUCTOR.
     */
    public ModelLoader() {
        boardFile = Config.getConfig("mainConfig").getProperty(File.class, "board");
    }


    /**
     * read file "boardFile" and craete a Board
     * <p>
     * you can use "BoardBuilder" class for this purpose.
     * <p>
     * pay attention add your codes in "try".
     */
    public Board loadBord() {

        List<Tile> map = new ArrayList<>();
        Character[] chars = HintUtil.getChars();


        for (Character aChar : chars) {
            int col = HintUtil.getCol(aChar);
            if (col <= 6){
                for (int i = 1; i < 6+col; i++) {
                    Tile tile=new Tile(i,aChar);
                    tile.setPiece(new Pawn(Pieces.WHITE_PAWN , tile));
                    map.add(tile);
                }
            }else {
                for (int i = col-5; i < 12; i++) {
                    Tile tile = new Tile(i,aChar);
                    tile.setPiece(new Pawn(Pieces.BLACK_PAWN , tile));
                    map.add(tile);
                }
            }
        }

        return new Board(map);
    }


    /**
     * load player.
     * if no such a player exist, create an account(file) for him/her.
     * <p>
     * you can use "savePlayer" method of this class for that purpose.
     * <p>
     * add your codes in "try" block .
     */
    public Player loadPlayer(String name, int playerNumber) {
        try {
            File playerFile = getPlayerFile(name);
            Scanner scanner = new Scanner(playerFile);


            // Code in this part

            return null;

        } catch (FileNotFoundException | IllegalArgumentException e) {
            e.printStackTrace();
            System.err.println("could not find player file");
            System.exit(-2);
        }
        return null;
    }

    /**
     * if player does not have a file, create one.
     * <p>
     * else update his/her file.
     * <p>
     * add your codes in "try" block .
     */
    public void savePlayer(Player player) {
        try {
            // add your codes in this part
            File file = getPlayerFile(player.getName());
            PrintStream printStream = new PrintStream(new FileOutputStream(file));


        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.err.println("could not find player file");
            System.exit(-2);
        }
    }

    /**
     * give you a name (player name), search for its file.
     * return the file if exist.
     * return null if not.
     */
    private File getPlayerFile(String name) {

        return null;
    }

}
