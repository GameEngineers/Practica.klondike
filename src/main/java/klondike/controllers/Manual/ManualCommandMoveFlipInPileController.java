package klondike.controllers.Manual;

import klondike.controllers.Error;
import klondike.controllers.CommandMoveFlipInPileController;
import klondike.controllers.CommandControllerVisitor;
import klondike.models.Game;

public class ManualCommandMoveFlipInPileController extends ManualCommandController implements CommandMoveFlipInPileController {

    public ManualCommandMoveFlipInPileController(Game game) {
        super(game);
    }

    public void move(int pileTarget) {
        assert this.validateMove(pileTarget) == null;
        this.flipInPile(pileTarget);
    }

    public Error validateMove(int pileOrigin) {
        if (this.pileUpTurnedCardsIsEmpty(pileOrigin)) {
            if (this.pileDownTurnedCardsIsEmpty(pileOrigin)) {
                return Error.EMPTY_DOWNTURNED;
            }
        } else {
            return Error.CAN_NOT_FLIP_CARD;
        }
        return null;
    }

    @Override
    public void accept(CommandControllerVisitor moveControllerVisitor) {
        moveControllerVisitor.visit(this);
    }

}
