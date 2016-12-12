package klondike.views.console;

import klondike.controllers.PresenterController;
import klondike.models.Card;
import klondike.utils.IO;

public class WasteView {

    private PresenterController presenterController;
    
    public WasteView(PresenterController presenterController){
        this.presenterController = presenterController;
    }
    
    public void write(){
        IO io = new IO();
        io.write("Descarte:");
        if (presenterController.wasteIsEmpty()){
            io.writeln("<vacio>");
        }else{
            for(Card card: presenterController.wasteGetVisibleCards()){
                new CardView(card).write();
            }
            io.writeln();
        }
    }
}
