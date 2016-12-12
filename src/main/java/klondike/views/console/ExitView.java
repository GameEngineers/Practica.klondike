package klondike.views.console;

import klondike.controllers.CommandExitController;
import klondike.utils.IO;

public class ExitView extends CommandView {

    void interact(CommandExitController exitController){
        exitController.exit();
    }
    
    public void writeCommand(){
        io.writeln("Salir");
    }
}
