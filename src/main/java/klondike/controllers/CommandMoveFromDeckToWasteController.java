package klondike.controllers;

public interface CommandMoveFromDeckToWasteController extends CommandController {

    public void move();

    public Error validateMove();
}
