package klondike.controllers.Manual;

import klondike.controllers.Error;
import klondike.controllers.MenuController;
import klondike.controllers.OperationControllerVisitor;
import klondike.models.Game;

public class ManualMenuController extends ManualOperationController implements MenuController {

    private ManualOperationControllerBuilder operationControllerBuilder;

    public ManualMenuController(Game game, ManualOperationControllerBuilder optionControllerBuilder) {
        super(game);
        this.operationControllerBuilder = optionControllerBuilder;
        this.operationControllerBuilder.build();
    }

    public ManualCommandController operate(int option) {
        assert validateOption(option - 1) != null;
        return this.operationControllerBuilder.getCommandController(option - 1);
    }

    public Error validateOption(int option){
        if (option < 0 || option >= this.operationControllerBuilder.getOperations())
            return Error.OPTION_NOT_VALID;
        else
            return null;
    }

    @Override
    public void accept(OperationControllerVisitor operationControllerVisitor) {
        operationControllerVisitor.visit(this);
        
    }
}
