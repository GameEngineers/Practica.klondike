package klondike.controllers.Manual;

import klondike.controllers.Error;
import klondike.controllers.CommandControllerVisitor;
import klondike.controllers.CommandMoveFromWasteToPileController;
import klondike.models.Card;
import klondike.models.Game;

public class ManualCommandMoveFromWasteToPileController extends ManualCommandController implements CommandMoveFromWasteToPileController {
    
    public ManualCommandMoveFromWasteToPileController(Game game) {
        super(game);
    }

    public void move(int pileTarget) {
        assert this.validateMove(pileTarget) == null;
        this.pilePush(pileTarget, this.wastePop());
    }

    public Error validateMove(int pileTarget) {
        Error errorFromWaste = this.validateMoveFromWaste();
        if (errorFromWaste != null){
            return errorFromWaste;
        } else {
            Card topWaste = this.wastePeek();
            return this.validateMoveToPile(topWaste, pileTarget);
        }
    }

    @Override
    public void accept(CommandControllerVisitor moveControllerVisitor) {
        moveControllerVisitor.visit(this);
    }

}
