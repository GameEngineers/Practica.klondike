package klondike.controllers;

public interface CommandControllerVisitor {

    void visit(CommandMoveFromDeckToWasteController commandMoveDeckToWasteController);
    
    void visit(CommandMoveFromWasteToFundationController commandMoveWasteToFundationController);
    
    void visit(CommandMoveFromWasteToPileController commandMoveWasteToPileController);
    
    void visit(CommandMoveFromWasteToDeckController commandMoveWasteToDeckController);
    
    void visit(CommandMoveFromPileToFundationController commandMovePileToFundationController);
    
    void visit(CommandMoveFromPileToPileController commandMovePileToPileController);
    
    void visit(CommandMoveFromFundationToPileController commandMoveFundationToPileController);

    void visit(CommandMoveFlipInPileController commandMoveFlipPileController);
    
    void visit(CommandExitController commandExitController);
}
