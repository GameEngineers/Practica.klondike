package klondike.controllers.Manual;

import klondike.controllers.Error;
import klondike.controllers.CommandControllerVisitor;
import klondike.controllers.CommandMoveFromPileToPileController;
import klondike.models.Card;
import klondike.models.Game;

public class ManualCommandMoveFromPileToPileController extends ManualCommandController implements CommandMoveFromPileToPileController {

    public ManualCommandMoveFromPileToPileController(Game game) {
        super(game);
    }

    public void move(int pileOrigin, int pileTarget, int toIndex) {
        assert toIndex > 0;
        assert toIndex < this.pileUpTurnedCardsSize(pileOrigin);
        assert this.validateMove(pileOrigin, pileTarget, toIndex) == null;
        this.pilePutPartial(pileTarget, this.pileGetPartial(pileOrigin, toIndex));
    }

    public Error validateMove(int pileOrigin, int pileTarget, int index) {
        Error error = this.validateMoveFromPile(pileOrigin);
        if (error != null) {
            return error;
        } else {
            Card card = this.pilePeekAt(pileOrigin, index);
            return validateMoveToPile(card, pileTarget);
        }
    }

    @Override
    public void accept(CommandControllerVisitor moveControllerVisitor) {
        moveControllerVisitor.visit(this);
    }

}
