package klondike.controllers.Manual;

import klondike.controllers.Error;
import klondike.controllers.CommandControllerVisitor;
import klondike.controllers.CommandMoveFromWasteToDeckController;
import klondike.models.Game;

public class ManualCommandMoveFromWasteToDeckController extends ManualCommandController implements CommandMoveFromWasteToDeckController {

    public ManualCommandMoveFromWasteToDeckController(Game game) {
        super(game);
    }

    public void move() {
        assert this.validateMove() == null;
        this.resetDeck();
    }

    public Error validateMove() {
        Error errorFromWaste = this.validateMoveFromWaste();
        if (errorFromWaste != null) {
            return errorFromWaste;
        } else if (!this.deckIsEmpty()) {
            return Error.NOT_EMPTY_DECK;
        } else {
            return null;
        }
    }

    @Override
    public void accept(CommandControllerVisitor moveControllerVisitor) {
        moveControllerVisitor.visit(this);
    }

}
