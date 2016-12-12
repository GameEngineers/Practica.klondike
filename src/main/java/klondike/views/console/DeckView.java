package klondike.views.console;

import klondike.controllers.PresenterController;
import klondike.utils.IO;

public class DeckView {

    private PresenterController presenterController;
    
    public DeckView(PresenterController presenterController){
        this.presenterController = presenterController;
    }
    
    public void write(){
        IO io = new IO();
        io.write("Baraja:");
        if (presenterController.deckIsEmpty()){
            io.writeln("<vacio>");
        }else{
            io.writeln("[X,X]");
        }
    }
}
