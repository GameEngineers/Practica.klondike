package klondike;

import klondike.controllers.OperationController;
import klondike.controllers.OperationControllerVisitor;

public interface View extends OperationControllerVisitor {

	public void interact(OperationController operationController);
}
