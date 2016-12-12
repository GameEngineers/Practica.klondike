package klondike.controllers.Manual;

import java.util.List;
import java.util.Stack;

import klondike.models.Card;
import klondike.models.Game;
import klondike.models.State;
import klondike.models.Suit;

public abstract class ManualController {

    private Game game;

    protected ManualController(Game game) {
        assert game != null;
        this.game = game;
    }

    protected void setState(State state) {
        this.game.setState(state);
    }

    protected State getState() {
        return game.getState();
    }

    public boolean isFinished() {
        return game.isFinished();
    }

    protected void resetDeck(){
        this.game.resetDeck();
    }
    
    protected void fundationPush(Card card, Suit suit) {
        assert suit != null;
        assert card != null;
        this.game.fundationPush(suit, card);
        if (this.game.isFinished()) {
            this.setState(State.EXIT);
        }
    }

    protected Card fundationPop(Suit suit) {
        assert suit != null;
        return this.game.fundationPop(suit);
    }

    protected Card wastePop() {
        return this.game.wastePop();
    }

    public Card wastePeek(){
        return this.game.wastePeek();
    }
    
    protected void turnOverCards(){
        this.game.turnOverCards();
    }

    protected Card pilePop(int pileOrigin) {
        assert pileOrigin > 0;
        assert pileOrigin < this.getNumberOfPiles();
        return this.game.pilePop(pileOrigin);
    }

    protected void pilePush(int pileTarget, Card card) {
        assert pileTarget > 0;
        assert pileTarget < this.getNumberOfPiles();
        assert card != null;
        this.game.pilePush(pileTarget, card);
    }

    public Card fundationPeek(Suit suit){
        assert suit != null;
        return this.game.fundationPeek(suit);
    }

    protected Stack<Card> pileGetPartial(int pileOrigin, int toIndex) {
        assert pileOrigin > 0;
        assert pileOrigin < this.getNumberOfPiles();
        return this.game.getPartialPile(pileOrigin, toIndex);
    }

    protected void pilePutPartial(int pileTarget, Stack<Card> partialPile) {
        assert pileTarget > 0;
        assert pileTarget < this.getNumberOfPiles();
        assert partialPile != null;
        this.game.putPartialPile(pileTarget, partialPile);
    }

    protected void flipInPile(int pileTarget) {
        assert pileTarget > 0;
        assert pileTarget < this.getNumberOfPiles();
        this.game.flipInPile(pileTarget);
    }

    public int pileUpTurnedCardsSize(int pileOrigin) {
        assert pileOrigin > 0;
        assert pileOrigin < this.getNumberOfPiles();
        return this.game.pileUpTurnedCardsSize(pileOrigin);
    }

    public boolean pileUpTurnedCardsIsEmpty(int pileOrigin) {
        assert pileOrigin > 0;
        assert pileOrigin < this.getNumberOfPiles();
        return this.game.pileUpTurnedCardsIsEmpty(pileOrigin);
    }

    public boolean pileDownTurnedCardsIsEmpty(int pileOrigin) {
        assert pileOrigin > 0;
        assert pileOrigin < this.getNumberOfPiles();
        return this.game.pileDownTurnedCardsIsEmpty(pileOrigin);
    }
    
    public int pileDownTurnedCardsSize(int pileOrigin){
        assert pileOrigin > 0;
        assert pileOrigin < this.getNumberOfPiles();
        return this.game.pileDownTurnedCardsSize(pileOrigin);
    }

    public int getNumberOfPiles() {
        return this.game.getNumPiles();
    }

    public int getSuitMaxiumValue() {
        return this.game.getSuitMaxiumValue();
    }

    public Card pilePeekAt(int pileOrigin, int index) {
        assert pileOrigin > 0;
        assert pileOrigin < this.getNumberOfPiles();
        return this.game.pilePeekAt(pileOrigin, index);
    }

    public boolean fundationIsEmpty(Suit suit) {
        assert suit != null;
        return this.game.fundationIsEmpty(suit);
    }

    public boolean deckIsEmpty() {
        return this.game.deckIsEmpty();
    }

    public boolean wasteIsEmpty() {
        return this.game.wasteIsEmpty();
    }
    
    public List<Card> wasteGetVisibleCards(){
        return this.game.wasteGetVisibleCards();
    }

}
