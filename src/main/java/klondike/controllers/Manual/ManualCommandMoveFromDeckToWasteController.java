package klondike.controllers.Manual;

import klondike.controllers.Error;
import klondike.controllers.CommandControllerVisitor;
import klondike.controllers.CommandMoveFromDeckToWasteController;
import klondike.models.Game;

public class ManualCommandMoveFromDeckToWasteController extends ManualCommandController implements CommandMoveFromDeckToWasteController {
    
    public ManualCommandMoveFromDeckToWasteController(Game game) {
        super(game);
    }
    

    public void move(){
        assert this.validateMove() == null;
        this.turnOverCards();
    }
    

    public Error validateMove() {
        if (this.deckIsEmpty()) {
            return Error.EMPTY_DECK;
        } else {
            return null;
        }
    }


    @Override
    public void accept(CommandControllerVisitor moveControllerVisitor) {
        moveControllerVisitor.visit(this);
    }
}
