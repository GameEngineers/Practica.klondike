package klondike.controllers.Manual;

import klondike.controllers.Error;
import klondike.controllers.CommandControllerVisitor;
import klondike.controllers.CommandMoveFromWasteToFundationController;
import klondike.models.Card;
import klondike.models.Game;

public class ManualCommandMoveFromWasteToFundationController extends ManualCommandController implements CommandMoveFromWasteToFundationController {

    public ManualCommandMoveFromWasteToFundationController(Game game) {
        super(game);
    }

    public void move() {
        assert this.validateMove() == null;
        Card card = this.wastePop();
        this.fundationPush(card, card.getSuit());
    }

    public Error validateMove() {
        Error errorFromWaste = this.validateMoveFromWaste();
        if (errorFromWaste != null) {
            return errorFromWaste;
        } else {
            Card topWaste = this.wastePeek();
            return this.validateMoveToFundation(topWaste);
        }
    }
    
    @Override
    public void accept(CommandControllerVisitor moveControllerVisitor) {
        moveControllerVisitor.visit(this);
    }

}
