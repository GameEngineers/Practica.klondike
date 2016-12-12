package klondike.controllers.Manual;

import java.util.ArrayList;

import klondike.models.Game;

public class ManualOperationControllerBuilder {
    
    private ArrayList<ManualCommandController> commandControllerArray;
    
    private Game game;
    
    public ManualOperationControllerBuilder(Game game) {
        this.game = game;
        commandControllerArray = new ArrayList<>();
    }
    
    public void build(){
        commandControllerArray.add(new ManualCommandMoveFromDeckToWasteController(game));
        commandControllerArray.add(new ManualCommandMoveFromWasteToDeckController(game));
        commandControllerArray.add(new ManualCommandMoveFromWasteToFundationController(game));
        commandControllerArray.add(new ManualCommandMoveFromWasteToPileController(game));
        commandControllerArray.add(new ManualCommandMoveFromPileToFundationController(game));
        commandControllerArray.add(new ManualCommandMoveFromPileToPileController(game));
        commandControllerArray.add(new ManualCommandMoveFromFundationToPileController(game));
        commandControllerArray.add(new ManualCommandMoveFlipInPileController(game));
        commandControllerArray.add(new ManualCommandExitController(game));
    }
    
    public ManualCommandController getCommandController(int option){
        assert option >= 0;
        assert option < this.commandControllerArray.size();
        return this.commandControllerArray.get(option);
    }
    
    public int getOperations(){
        return commandControllerArray.size();
    }
    

}
