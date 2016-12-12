package klondike.controllers;

public interface CommandMoveFromWasteToDeckController extends CommandController {

    public void move();

    public Error validateMove();
}
