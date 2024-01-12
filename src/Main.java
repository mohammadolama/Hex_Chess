import ir.sharif.math.bp02_1.hex_chess.graphics.Application;
import ir.sharif.math.bp02_1.hex_chess.graphics.listeners.SystemOutEventListener;
import ir.sharif.math.bp02_1.hex_chess.util.PieceName;

import java.awt.*;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Application application = new Application();
        application.registerEventListener(new SystemOutEventListener());
        application.setCellProperties(1,'a', PieceName.BLACK_BISHOP, Color.CYAN);

        Thread.sleep(2000);
        application.showMessage("shit");

        // app.setBottomMessage("نوبت سیاه!")
        // app.setRemovedMohreList(....) // optional
        // boolean app.showPopupMessage("")
        // string app.getPromoteMohreType()

        // TODO: promotion


    }
}