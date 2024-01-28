package ir.sharif.math.bp02_1.hex_chess.logic;

import java.util.HashMap;
import java.util.Map;

public class BoardHelper {

    private static final HashMap<Integer, Character> itc = new HashMap<>();
    private static final HashMap<Character, Integer> cti = new HashMap<>();

    static {
        itc.put(0, 'a');
        itc.put(1, 'b');
        itc.put(2, 'c');
        itc.put(3, 'd');
        itc.put(4, 'e');
        itc.put(5, 'f');
        itc.put(6, 'g');
        itc.put(7, 'h');
        itc.put(8, 'i');
        itc.put(9, 'k');
        itc.put(10, 'l');
        for (Map.Entry<Integer, Character> e : itc.entrySet()) {
            cti.put(e.getValue(), e.getKey());
        }
    }

    public static char getChar(Integer i) {
        if (i < 0 || i > 10)
            throw new RuntimeException("invalid number!" + i);
        return itc.get(i);
    }

    public static int getInt(char c) {
        if (cti.containsKey(c)) return cti.get(c);
        else
            throw new RuntimeException("invalid character!");
    }
}
