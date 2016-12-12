package klondike.controllers;

import java.util.List;

import klondike.models.Card;
import klondike.models.Suit;

public interface PresenterController {

    public Card pilePeekAt(int pileOrigin, int index);

    public int pileDownTurnedCardsSize(int pileOrigin);

    public int pileUpTurnedCardsSize(int pileOrigin);
    
    public Card fundationPeek(Suit suit);

    public boolean fundationIsEmpty(Suit suit);

    public boolean deckIsEmpty();

    public boolean wasteIsEmpty();

    public List<Card> wasteGetVisibleCards();

    public boolean pileDownTurnedCardsIsEmpty(int pileOrigin);

    public boolean pileUpTurnedCardsIsEmpty(int pileOrigin);

    public int getNumberOfPiles();
    
    public boolean isFinished();
}
