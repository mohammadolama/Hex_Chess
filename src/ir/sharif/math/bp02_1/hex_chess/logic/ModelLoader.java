package ir.sharif.math.bp02_1.hex_chess.logic;

import ir.sharif.math.bp02_1.hex_chess.graphics.panel.BoardPanel;
import ir.sharif.math.bp02_1.hex_chess.graphics.util.Config;
import ir.sharif.math.bp02_1.hex_chess.model.Board;
import ir.sharif.math.bp02_1.hex_chess.model.Player;
import ir.sharif.math.bp02_1.hex_chess.model.Tile;
import ir.sharif.math.bp02_1.hex_chess.model.pieces.Name;
import ir.sharif.math.bp02_1.hex_chess.model.pieces.Piece;

import java.awt.*;
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
        for (int i = 0; i < 13; i++) {
            for (int j = 0; j < 13; j++) {
                map.add(createTile(i,j));
            }
        }
        Board board = new Board(map);

        return board;

    }

    private Tile createTile(int i , int j){
        Tile tile = new Tile(i , j);
        if ((i == 6 && (j>=0 && j <=2))){
            tile.setPiece(new Piece(Name.BLACK_BISHOP));
        }
        return tile;
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
