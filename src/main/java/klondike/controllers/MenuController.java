package klondike.controllers;

public interface MenuController extends OperationController {

    public CommandController operate(int option);
    
    public Error validateOption(int option);
}
