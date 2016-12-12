package klondike.controllers;

public interface CommandMoveFromPileToPileController extends CommandController {

    public void move(int pileOrigin, int pileTarget, int toIndex);

    public Error validateMove(int pileOrigin, int pileTarget, int index);
}
