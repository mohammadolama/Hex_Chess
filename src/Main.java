import ir.sharif.math.bp02_1.hex_chess.graphics.Application;
import ir.sharif.math.bp02_1.hex_chess.graphics.listeners.SystemOutEventListener;
import ir.sharif.math.bp02_1.hex_chess.graphics.models.StringColor;
import ir.sharif.math.bp02_1.hex_chess.util.PieceName;

public class Main {
    public static void main(String[] args) {
        Application application = new Application();
        application.registerEventListener(new SystemOutEventListener());
        application.setRemovedPieces(new StringColor[]{
                new StringColor(PieceName.BLACK_BISHOP, StringColor.WHITE),
                new StringColor(PieceName.WHITE_BISHOP, StringColor.WHITE)
        });

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