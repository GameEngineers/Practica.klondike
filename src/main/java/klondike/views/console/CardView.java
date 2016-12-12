package klondike.views.console;

import klondike.models.Card;
import klondike.utils.IO;

public class CardView {

    private final String[] CARD_VALUES = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
    
    private Card card;
    
    public CardView(Card card){
        assert card != null;
        this.card = card;
    }
    
    public void write(){
        IO io = new IO();
        io.write("[" + CARD_VALUES[card.getValue() - 1] + "," + card.getSuit().toString() + "]");
    }
}
