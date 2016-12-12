package klondike.views.console;

import java.util.ArrayList;

import klondike.utils.IO;
import klondike.utils.LimitedIntDialog;

public class MenuView {

   
    private ArrayList<CommandView> commandViewArray;

    public MenuView() {
        commandViewArray = new ArrayList<>();
        commandViewArray.add(new MoveFromDeckToWasteView());
        commandViewArray.add(new MoveFromWasteToDeckView());
        commandViewArray.add(new MoveFromWasteToFundationView());
        commandViewArray.add(new MoveFromWasteToPileView());
        commandViewArray.add(new MoveFromPileToFundationView());
        commandViewArray.add(new MoveFromPileToPileView());
        commandViewArray.add(new MoveFromFundationToPileView());
        commandViewArray.add(new MoveFlipInPileView());
        commandViewArray.add(new ExitView());
    }

    public void write() {
        IO io = new IO();
        for (int i = 0; i < commandViewArray.size(); i++) {
            io.write(String.valueOf(i + 1) + ". ");
            commandViewArray.get(i).writeCommand();
        }
    }
    
    public int read() {
        return new LimitedIntDialog("Opción?", 1, commandViewArray.size()).read();
    }

}
