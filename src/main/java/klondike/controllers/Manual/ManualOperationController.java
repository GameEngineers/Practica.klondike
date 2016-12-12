package klondike.controllers.Manual;

import klondike.controllers.OperationControllerVisitor;
import klondike.controllers.OperationController;
import klondike.models.Game;

public abstract class ManualOperationController extends ManualController implements OperationController {

    protected ManualOperationController(Game game) {
        super(game);
    }

    public abstract void accept(OperationControllerVisitor operationControllerVisitor);

}
