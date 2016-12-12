package klondike.controllers.Manual;

import klondike.models.Card;
import klondike.models.Game;
import klondike.models.Suit;
import klondike.controllers.Error;
import klondike.controllers.CommandControllerVisitor;
import klondike.controllers.CommandMoveFromFundationToPileController;

public class ManualCommandMoveFromFundationToPileController extends ManualCommandController implements CommandMoveFromFundationToPileController {

    public ManualCommandMoveFromFundationToPileController(Game game) {
        super(game);
    }

    public void move(Suit suit, int pileTarget) {
        assert this.validateMove(suit, pileTarget) == null;
        this.pilePush(pileTarget, this.fundationPop(suit));
    }

    public Error validateMove(Suit suit, int pileTarger) {
        if (this.fundationIsEmpty(suit)) {
            return Error.EMPTY_FUNDATION;
        } else {
            Card topFundation = this.fundationPeek(suit);
            return this.validateMoveToPile(topFundation, pileTarger);
        }
    }

    @Override
    public void accept(CommandControllerVisitor moveControllerVisitor) {
        moveControllerVisitor.visit(this);
    }

}
