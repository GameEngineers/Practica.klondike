package klondike.views.console;

import klondike.utils.IO;

public abstract class CommandView {
    
    protected IO io = new IO();
    
    public abstract void writeCommand();
}
