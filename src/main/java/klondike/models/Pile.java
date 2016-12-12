package klondike.models;

import java.util.List;
import java.util.Stack;

public class Pile {
    private Stack<Card> downTurnedCards;

    private Stack<Card> upTurnedCards;

    public Pile(List<Card> cards) {
        this.downTurnedCards = new Stack<>();
        this.downTurnedCards.addAll(cards);
        this.upTurnedCards = new Stack<>();
        this.upTurnedCards.push(this.downTurnedCards.pop());
    }

    public void push(Card card) {
        assert card != null;
        this.upTurnedCards.push(card);
    }

    public void putPartialPile(Stack<Card> partialPile) {
        assert partialPile != null;
        while (!partialPile.empty()) {
            this.upTurnedCards.push(partialPile.pop());
        }
    }

    public Stack<Card> getPartialPile(int toIndex) {
        assert toIndex >= 0;
        assert toIndex < this.upTurnedCards.size();
        Stack<Card> partialPile = new Stack<>();
        for (int i = 0; i < toIndex + 1; i++) {
            partialPile.push(this.upTurnedCards.pop());
        }
        return partialPile;
    }

    public Card pop() {
        assert!this.upTurnedCardsIsEmpty();
        return this.upTurnedCards.pop();
    }

    public Card peekAt(int index) {
        assert index >= 0;
        assert index < this.upTurnedCardsSize();
        assert!this.upTurnedCardsIsEmpty();
        return this.upTurnedCards.get((this.upTurnedCardsSize() - 1) - index);
    }

    public int upTurnedCardsSize() {
        return this.upTurnedCards.size();
    }
    
    public int downTurnedCardsSize() {
        return this.downTurnedCards.size();
    }

    public void flip() {
        assert!this.downTurnedCardsIsEmpty();
        assert this.upTurnedCardsIsEmpty();
        this.upTurnedCards.push(this.downTurnedCards.pop());
    }

    public boolean downTurnedCardsIsEmpty() {
        return this.downTurnedCards.empty();
    }

    public boolean upTurnedCardsIsEmpty() {
        return this.upTurnedCards.empty();
    }

}
