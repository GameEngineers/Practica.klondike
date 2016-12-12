package klondike.controllers.Manual;

import klondike.controllers.Error;
import klondike.controllers.CommandControllerVisitor;
import klondike.controllers.CommandMoveFromPileToFundationController;
import klondike.models.Card;
import klondike.models.Game;

public class ManualCommandMoveFromPileToFundationController extends ManualCommandController implements CommandMoveFromPileToFundationController {

    public ManualCommandMoveFromPileToFundationController(Game game) {
        super(game);
    }

    public void move(int pileOrigin) {
        assert this.validateMove(pileOrigin) == null;
        Card card = this.pilePop(pileOrigin);
        this.fundationPush(card, card.getSuit());
    }

    public Error validateMove(int pileOrigin) {
        if(this.pileUpTurnedCardsIsEmpty(pileOrigin)){
            return Error.EMPTY_UPTURNED;
        } else {
            Card topPileOrigin = this.pilePeekAt(pileOrigin, 0);
            return this.validateMoveToFundation(topPileOrigin);
        }
    }

    @Override
    public void accept(CommandControllerVisitor moveControllerVisitor) {
        moveControllerVisitor.visit(this);
    }
}
