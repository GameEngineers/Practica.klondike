package klondike.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Stack;

public class CardBuilder {

    public CardBuilder(){}

    public Stack<Card> buildDeck(int suitMaxValue){
        Random rnd = new Random();
        rnd.setSeed(System.currentTimeMillis());
        Stack<Card> deck = new Stack<>();
        int numCards = 0;
        while (numCards < (suitMaxValue * Suit.values().length)){
            int value = rnd.nextInt(suitMaxValue) + 1;
            Suit suit = Suit.values()[rnd.nextInt(Suit.values().length)];
            Card card = new Card(suit, value);
            if (!deck.contains(card)){
                deck.push(card);
                numCards ++;
            }
        }
        return deck;
    }
    
    public List<Pile> buildPiles(int piles, Stack<Card> deck){
        ArrayList<Pile> listPiles = new ArrayList<>();
        
        for(int i = 0; i < piles; i ++){
            List<Card> cards = new ArrayList<>();
            for(int j = 0; j <= i; j++)
            {
                cards.add(deck.pop());
            }
            listPiles.add(new Pile(cards));
        }
        return listPiles;
    }
}
