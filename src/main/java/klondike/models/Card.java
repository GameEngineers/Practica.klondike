package klondike.models;

import klondike.models.Suit;

public class Card {

    private Suit suit;

    private int value;

    public Card(Suit suit, int value) {
        this.suit = suit;
        this.value = value;
    }

    public Suit getSuit() {
        return suit;
    }

    public int getValue() {
        return value;
    }
    
    public boolean inSameSuitAscendSequence(Card card){
        assert card != null;
        if (this.getValue() == card.getValue() + 1 
                && this.getSuit() == card.getSuit()){
            return true;
        }else
            return false;
    }
    
    public boolean inDistinctSuitDescendSequence(Card card){
        assert card != null;
        if (this.getValue() + 1 == card.getValue()
                && this.getSuit() != card.getSuit()){
            return true;
        }else
            return false;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Card other = (Card) obj;
        if (this.value != other.value)
            return false;
        if (this.suit != other.suit){
            return false;
        }
        return true;
    }
    
    public Card clone() {
        return new Card(this.suit, this.value);
    }
}
