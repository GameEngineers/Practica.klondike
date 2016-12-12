package klondike.controllers.Manual;

import klondike.Logic;
import klondike.controllers.Manual.ManualOperationControllerBuilder;
import klondike.controllers.Manual.ManualStartController;
import klondike.models.CardBuilder;
import klondike.models.Game;

public class ManualLogic implements Logic {

	private Game game;

	private ManualOperationControllerBuilder operationControllerBuilder;
	
	private ManualStartController startController;

	private ManualMenuController menuController;

	public ManualLogic() {
		game = new Game(new CardBuilder());
		operationControllerBuilder = new ManualOperationControllerBuilder(game);
		startController = new ManualStartController(game);
		menuController = new ManualMenuController(game, operationControllerBuilder);
	}

	@Override
	public ManualOperationController getOperationController() {
		switch (game.getState()){
		case INITIAL:
			return startController;
		case IN_GAME:
			return menuController;
		case EXIT:
		default:
			return null;
		}
	}
}
