import ir.sharif.math.bp02_1.hex_chess.graphics.Application;
import ir.sharif.math.bp02_1.hex_chess.graphics.listeners.SystemOutEventListener;
import ir.sharif.math.bp02_1.hex_chess.util.PieceName;

import java.awt.*;
import ir.sharif.math.bp02_1.hex_chess.graphics.models.StringColor;
import ir.sharif.math.bp02_1.hex_chess.util.PieceName;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Application application = new Application();
        application.registerEventListener(new SystemOutEventListener());
        application.setCellProperties(1,'a', PieceName.BLACK_BISHOP, Color.CYAN);
        application.setRemovedPieces(new StringColor[]{
                new StringColor(PieceName.BLACK_BISHOP, StringColor.WHITE),
                new StringColor(PieceName.WHITE_BISHOP, StringColor.WHITE)
        });

        Thread.sleep(2000);
        application.showMessage("shit");

        // app.setBottomMessage("نوبت سیاه!")
        // app.setRemovedMohreList(....) // optional
        // boolean app.showPopupMessage("")
        // string app.getPromoteMohreType()

        // TODO: promotion


    }
}