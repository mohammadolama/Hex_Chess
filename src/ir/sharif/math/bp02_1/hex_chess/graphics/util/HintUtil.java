package ir.sharif.math.bp02_1.hex_chess.graphics.util;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class HintUtil {

    private static HashMap<Character , Integer> map=new HashMap<>();

    static {
        for (int i = (int)'a'; i < (int)'j'; i++) {
            map.put((char)i , i-((int)'a')+1);
        }
        map.put('k' , 10);
        map.put('l' , 11);
        map.put('z' , 0);
        map.put('x' , 12);
    }

    private static final Color[] colors = {  new Color(0.9F, 0.9F, 0.9F), new Color(1.0F, 1.0F, 1.0F),  new Color(0.8F, 0.8F, 0.8F)};

    public static Color getColor(int i , char c){
        return colors[((i + map.get(c)) % 3 + 3) % 3];
    }

    public static int getCol(char c){
        return map.get(c);
    }

    public static Character[] getChars(){
        ArrayList<Character> l = new ArrayList<>(map.keySet());
        l.remove(Character.valueOf('z'));
        l.remove(Character.valueOf('x'));
        Collections.sort(l);
        Character[] chars = new Character[l.size()];
        chars = l.toArray(chars);
        return chars;
    }
}