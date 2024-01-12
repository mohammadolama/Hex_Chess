import ir.sharif.math.bp02_1.hex_chess.graphics.Application;
import ir.sharif.math.bp02_1.hex_chess.graphics.listeners.SystemOutEventListener;

public class Main {
    public static void main(String[] args) {
        Application application = new Application();
        application.registerEventListener(new SystemOutEventListener());

        // app.setCellProperties('f', 11, SARBAZE_SIAH, RED);
        // app.setBottomMessage("نوبت سیاه!")
        // app.setRemovedMohreList(....) // optional
        // boolean app.showPopupMessage("")
        // string app.getPromoteMohreType()

        // eventListener.onCellClicked('f', 11)
        // eventListener.onClickOutside() // نظر سادات: بیخیال
        // eventListener.onGameLoad(File f)
        // eventListener.onGameSave(File f)
        // TODO: promotion


    }
}