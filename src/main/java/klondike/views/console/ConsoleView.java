package klondike.views.console;

import klondike.View;
import klondike.controllers.CommandExitController;
import klondike.controllers.MenuController;
import klondike.controllers.CommandController;
import klondike.controllers.OperationController;
import klondike.controllers.StartController;

public class ConsoleView implements View {

    private StartView startView;

    private GameView gameView;

    private MenuView menuView;

    public ConsoleView() {
        startView = new StartView();
        gameView = new GameView();
    }

    public void interact(OperationController operationController) {
        assert operationController != null;
        operationController.accept(this);
    }

    @Override
    public void visit(StartController startController) {
        startView.interact(startController);
    }

    @Override
    public void visit(MenuController menuController) {
        gameView.interact(menuController);
    }
}
