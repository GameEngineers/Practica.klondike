  package klondike.controllers;

public interface CommandController extends PresenterController {

    void accept(CommandControllerVisitor commandMoveControllerVisitor);
    
}
