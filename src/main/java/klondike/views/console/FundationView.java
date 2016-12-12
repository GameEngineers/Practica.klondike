package klondike.views.console;

import klondike.controllers.PresenterController;
import klondike.models.Suit;
import klondike.utils.IO;

public class FundationView {

    private PresenterController presenterController;
    
    public FundationView(PresenterController presenterController){
        this.presenterController = presenterController;
    }
    
    public void write(){
        IO io = new IO();
        for(Suit suit: Suit.values()){
            io.write("Palo " + suit.name() + ":");
            if (presenterController.fundationIsEmpty(suit)){
                io.write("<vacio>");
            }else{
                new CardView(presenterController.fundationPeek(suit)).write();
            }
            io.writeln();
        }
    }
}
