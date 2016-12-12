package klondike.views.console;

import klondike.View;
import klondike.controllers.MenuController;
import klondike.controllers.OperationController;
import klondike.controllers.StartController;

public class ConsoleView implements View {

    private StartView startView;

    private GameView gameView;

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
