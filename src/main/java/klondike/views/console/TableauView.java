package klondike.views.console;

import klondike.controllers.PresenterController;
import klondike.utils.IO;

public class TableauView {

    PresenterController presenterController;
    
    public TableauView(PresenterController presenterController){
        this.presenterController = presenterController;
    }
    
    public void write(){
        IO io = new IO();
        io.writeln("==================================");
        new DeckView(presenterController).write();
        new WasteView(presenterController).write();
        new FundationView(presenterController).write();
        new PileView(presenterController).write();
        io.writeln("----------------------------------");
    }
    
}
