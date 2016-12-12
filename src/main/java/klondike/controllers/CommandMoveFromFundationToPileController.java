package klondike.controllers;

import klondike.models.Suit;

public interface CommandMoveFromFundationToPileController extends CommandController {

    public void move(Suit suit, int pileTarget);

    public Error validateMove(Suit suit, int pileTarger);
}
