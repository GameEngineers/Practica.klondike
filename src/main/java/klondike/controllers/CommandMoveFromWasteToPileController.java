package klondike.controllers;

public interface CommandMoveFromWasteToPileController extends CommandController {

    public void move(int pileTarget);

    public Error validateMove(int pileTarget);
    
}
