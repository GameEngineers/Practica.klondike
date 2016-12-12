package klondike.controllers.Manual;

import klondike.controllers.Error;
import klondike.controllers.CommandController;
import klondike.models.Card;
import klondike.models.Game;

public abstract class ManualCommandController extends ManualController implements CommandController {

    public ManualCommandController(Game game) {
        super(game);
    }

    protected Error validateMoveToPile(Card card, int pileTarget){
        if (this.pileUpTurnedCardsIsEmpty(pileTarget)) {
            if (!this.pileDownTurnedCardsIsEmpty(pileTarget))
                return Error.NOT_EMPTY_DOWNTURNED;
            if (card.getValue() != this.getSuitMaxiumValue())
                return Error.CARD_NOT_PROPERTY;
        } else {
            Card topPileTarget = this.pilePeekAt(pileTarget, 0);
            if (!card.inDistinctSuitDescendSequence(topPileTarget)) {
                return Error.CARD_NOT_PROPERTY;
            }
        }
        return null;
    }
    
    protected Error validateMoveToFundation(Card card){
        if (!this.fundationIsEmpty(card.getSuit())){
            Card topFundation = this.fundationPeek(card.getSuit());
            if (!card.inSameSuitAscendSequence(topFundation)) {
                return Error.CARD_NOT_PROPERTY;
            }
        }else{
            if (card.getValue() != 1){
                return Error.CARD_NOT_PROPERTY;
            }
        }
        return null;
    }
    
    protected Error validateMoveFromWaste(){
        if (this.wasteIsEmpty()){
            return Error.EMPTY_WASTE;
        }else{
            return null;
        }
    }
    
    protected Error validateMoveFromPile(int pileOrigin){
        if (this.pileUpTurnedCardsIsEmpty(pileOrigin)) {
            return Error.EMPTY_UPTURNED;
        }else{
            return null;
        }
    }
    
}
