package klondike.controllers;

public interface CommandMoveFromWasteToFundationController extends CommandController {

    public void move();

    public Error validateMove();
}
