package klondike.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Waste {
    private Stack<Card> cards;

    private int lastVisibleCardIndex;

    public Waste() {
        this.cards = new Stack<>();
        this.lastVisibleCardIndex = -1;
    }

    public Card pop() {
        Card card = this.cards.pop();
        if (lastVisibleCardIndex > this.cards.size() - 1) {
            lastVisibleCardIndex = this.cards.size() - 1;
        }
        return card;
    }
    
    public Card peek(){
        return this.cards.peek();
    }

    // public void push(Card card){
    // assert card != null;
    // this.cards.push(card);
    // }

    public void putTurnedCards(List<Card> cards) {
        assert cards != null;
        assert cards.size() > 0;
        for (Card card : cards) {
            this.cards.push(card);
        }
        this.lastVisibleCardIndex = this.cards.size() - cards.size();
    }

    public List<Card> getVisibleCards() {
        if (this.lastVisibleCardIndex > -1) {
            return this.cards.subList(lastVisibleCardIndex, this.cards.size());
        } else {
            return new ArrayList<Card>();
        }
    }
    
    public boolean isEmpty(){
        return this.cards.isEmpty();
    }

}
