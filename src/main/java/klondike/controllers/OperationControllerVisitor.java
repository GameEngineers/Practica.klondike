package klondike.controllers;

public interface OperationControllerVisitor {

    void visit(MenuController menuController);
    
    void visit(StartController startController);
}

