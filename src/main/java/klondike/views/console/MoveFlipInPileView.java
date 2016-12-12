package klondike.views.console;

import klondike.utils.IO;

public class MoveFlipInPileView extends CommandView {

    
    public void writeCommand(){
        IO io = new IO();
        io.writeln("Voltear en escalera");
    }
}
