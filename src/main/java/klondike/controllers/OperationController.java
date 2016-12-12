package klondike.controllers;

public interface OperationController {

	void accept(OperationControllerVisitor operationControllerVisitor);
	
}

