package klondike.views.console;

import klondike.controllers.StartController;

public class StartView {

    void interact(StartController startController){
        startController.start();
        new TableauView(startController).write();
    }
}
