package klondike.controllers.Manual;

import klondike.controllers.OperationControllerVisitor;
import klondike.controllers.StartController;
import klondike.models.Game;
import klondike.models.State;

public class ManualStartController extends ManualOperationController implements StartController {

    protected ManualStartController(Game game) {
        super(game);
    }

    @Override
    public void start() {
        if (this.getState() == State.INITIAL)
            this.setState(State.IN_GAME);
    }

    @Override
    public void accept(OperationControllerVisitor operationControllerVisitor) {
        operationControllerVisitor.visit(this);
        
    }
}
