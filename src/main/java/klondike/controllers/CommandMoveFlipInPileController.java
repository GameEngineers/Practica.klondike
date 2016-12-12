package klondike.controllers;

public interface CommandMoveFlipInPileController extends CommandController {
    
    public void move(int pileTarget);

    public Error validateMove(int pileOrigin);
}
