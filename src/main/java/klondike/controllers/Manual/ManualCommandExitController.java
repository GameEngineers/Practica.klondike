package klondike.controllers.Manual;

import klondike.controllers.CommandControllerVisitor;
import klondike.controllers.CommandExitController;
import klondike.models.Game;
import klondike.models.State;


public class ManualCommandExitController extends ManualCommandController implements CommandExitController {

    public ManualCommandExitController(Game game) {
        super(game);
    }
    
    public void exit(){
        this.setState(State.EXIT);
    }

    @Override
    public void accept(CommandControllerVisitor moveControllerVisitor) {
        moveControllerVisitor.visit(this);
        
    }

}
