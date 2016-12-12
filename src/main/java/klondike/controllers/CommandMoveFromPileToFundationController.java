package klondike.controllers;


public interface CommandMoveFromPileToFundationController extends CommandController {

    public void move(int pileOrigin);

    public Error validateMove(int pileOrigin);
}
