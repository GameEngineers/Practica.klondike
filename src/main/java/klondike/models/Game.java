package klondike.models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class Game {

    private State state;

    private Stack<Card> deck;

    private Waste waste;

    private List<Pile> piles;

    private Map<Suit, Stack<Card>> fundations;

    private static final int NUM_PILES = 7;

    private static final int SUIT_MAXIMUM_VALUE = 13;

    private static final int DECK_TURNOVER_CARDS = 3;

    public Game(CardBuilder cardBuilder) {
        this.state = State.INITIAL;
        this.waste = new Waste();
        this.fundations = new HashMap<Suit, Stack<Card>>();
        for (Suit suit : Suit.values()) {
            fundations.put(suit, new Stack<Card>());
        }
        this.deck = cardBuilder.buildDeck(SUIT_MAXIMUM_VALUE);
        this.piles = cardBuilder.buildPiles(NUM_PILES, deck);
    }
    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public boolean isFinished() {
        int NumCards = 0;
        for (Suit suit : this.fundations.keySet()) {
            NumCards += this.fundations.get(suit).size();
        }
        return NumCards == SUIT_MAXIMUM_VALUE * this.fundations.keySet().size();
    }

    public int getNumPiles() {
        return piles.size();
    }

    public int getSuitMaxiumValue() {
        return SUIT_MAXIMUM_VALUE;
    }

    public void turnOverCards(){
        int i = 0;
        List<Card> turnedCards = new ArrayList<>();
        while(!this.deckIsEmpty() && i < DECK_TURNOVER_CARDS){
            turnedCards.add(this.deck.pop());
            i++;
        }
        this.waste.putTurnedCards(turnedCards);
    }
    
    public void resetDeck(){
        while(!this.wasteIsEmpty()){
            this.deck.push(this.waste.pop());
        }
    }

    public Card wastePeek() {
        return this.waste.peek();
    }

    public Card wastePop() {
        return this.waste.pop();
    }

    public List<Card> wasteGetVisibleCards() {
        return this.waste.getVisibleCards();
    }

    public boolean deckIsEmpty() {
        return this.deck.isEmpty();
    }

    public boolean wasteIsEmpty() {
        return this.waste.isEmpty();
    }

    public Card fundationPeek(Suit suit) {
        assert suit != null;
        return this.fundations.get(suit).peek();
    }

    public boolean fundationIsEmpty(Suit suit) {
        assert suit != null;
        return this.fundations.get(suit).isEmpty();
    }

    public void fundationPush(Suit suit, Card card) {
        assert suit != null;
        assert card != null;
        this.fundations.get(suit).push(card);
    }

    public Card fundationPop(Suit suit) {
        assert suit != null;
        return this.fundations.get(suit).pop();
    }

    public void pilePush(int pile, Card card) {
        assert card != null;
        assert pile > 0;
        assert pile <= piles.size();
        this.piles.get(pile).push(card);
    }

    public void putPartialPile(int pile, Stack<Card> partialPile) {
        assert partialPile != null;
        assert pile > 0;
        assert pile <= piles.size();
        this.piles.get(pile).putPartialPile(partialPile);
    }

    public Stack<Card> getPartialPile(int pile, int toIndex) {
        assert pile > 0;
        assert pile <= piles.size();
        return this.piles.get(pile).getPartialPile(toIndex);
    }

    public Card pilePop(int pile) {
        assert pile > 0;
        assert pile <= piles.size();
        return this.piles.get(pile).pop();
    }

    public Card pilePeekAt(int pile, int index) {
        assert pile > 0;
        assert pile <= piles.size();
        return this.piles.get(pile).peekAt(index);
    }

    public int pileUpTurnedCardsSize(int pile) {
        assert pile > 0;
        assert pile <= piles.size();
        return this.piles.get(pile).upTurnedCardsSize();
    }
    
    public int pileDownTurnedCardsSize(int pile) {
        assert pile > 0;
        assert pile <= piles.size();
        return this.piles.get(pile).downTurnedCardsSize();
    }

    public void flipInPile(int pile) {
        assert pile > 0;
        assert pile <= piles.size();
        this.piles.get(pile).flip();
    }

    public boolean pileDownTurnedCardsIsEmpty(int pile) {
        assert pile > 0;
        assert pile <= piles.size();
        return this.piles.get(pile).downTurnedCardsIsEmpty();
    }

    public boolean pileUpTurnedCardsIsEmpty(int pile) {
        assert pile > 0;
        assert pile <= piles.size();
        return this.piles.get(pile).upTurnedCardsIsEmpty();
    }
}
