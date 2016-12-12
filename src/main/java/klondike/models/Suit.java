package klondike.models;

public enum Suit {
    OROS('o'),
    COPAS('c'),
    ESPADAS('e'),
    BASTOS('b');
    
    private char fundation;
    
    private Suit(char fundation){
       this.fundation = fundation;
    }
    
    @Override
    public String toString(){
        return "" + this.fundation;
    }
}
