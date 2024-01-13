import ir.sharif.math.bp02_1.hex_chess.graphics.Application;
import ir.sharif.math.bp02_1.hex_chess.graphics.listeners.SystemOutEventListener;
import ir.sharif.math.bp02_1.hex_chess.util.PieceName;

import java.awt.*;
import ir.sharif.math.bp02_1.hex_chess.graphics.models.StringColor;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Application application = new Application();
        application.registerEventListener(new SystemOutEventListener());
        application.setCellProperties(1,'a', PieceName.BLACK_BISHOP, null, Color.BLACK);
        application.setRemovedPieces(new StringColor[]{
                new StringColor(PieceName.BLACK_BISHOP, StringColor.BLACK),
                new StringColor(PieceName.WHITE_BISHOP, StringColor.WHITE)
        });
        Thread.sleep(2000);
        application.setMessage("Hii");
        // add examples
    }
}