package klondike.views.console;

import klondike.controllers.MenuController;
import klondike.models.Suit;

import org.junit.runners.Suite;

import klondike.controllers.CommandController;
import klondike.controllers.CommandControllerVisitor;
import klondike.controllers.CommandExitController;
import klondike.controllers.CommandMoveFlipInPileController;
import klondike.controllers.CommandMoveFromDeckToWasteController;
import klondike.controllers.CommandMoveFromFundationToPileController;
import klondike.controllers.CommandMoveFromPileToFundationController;
import klondike.controllers.CommandMoveFromPileToPileController;
import klondike.controllers.CommandMoveFromWasteToDeckController;
import klondike.controllers.CommandMoveFromWasteToFundationController;
import klondike.controllers.CommandMoveFromWasteToPileController;
import klondike.utils.IO;
import klondike.utils.LimitedIntDialog;
import klondike.controllers.Error;

class GameView implements CommandControllerVisitor {

    private IO io = new IO();

    private MenuView menuView;

    public GameView() {
        menuView = new MenuView();
    }

    public void interact(MenuController menuController) {
        menuView.write();
        menuController.operate(menuView.read()).accept(this);
    }

    private void showGame(CommandController commandController) {
        new TableauView(commandController).write();
        if (commandController.isFinished()) {
            io.writeln("Has completado Klondike!!!");
        }
    }

    @Override
    public void visit(CommandMoveFromDeckToWasteController moveDeckToWasteController) {
        Error error = moveDeckToWasteController.validateMove();
        if (error != null) {
            io.writeln(error.toString());
        } else {
            moveDeckToWasteController.move();
        }
        this.showGame(moveDeckToWasteController);
    }

    @Override
    public void visit(CommandMoveFromWasteToFundationController moveWasteToFundationController) {
        Error error = moveWasteToFundationController.validateMove();
        if (error != null) {
            io.writeln(error.toString());
        } else {
            moveWasteToFundationController.move();
        }
        this.showGame(moveWasteToFundationController);
    }

    @Override
    public void visit(CommandMoveFromWasteToPileController moveWasteToPileController) {
        int pileTarget = new LimitedIntDialog("A que escalera?", moveWasteToPileController.getNumberOfPiles()).read() - 1;
        Error error = moveWasteToPileController.validateMove(pileTarget);
        if (error != null) {
            io.writeln(error.toString());
        } else {
            moveWasteToPileController.move(pileTarget);
        }
        this.showGame(moveWasteToPileController);
    }

    @Override
    public void visit(CommandMoveFromWasteToDeckController moveWasteToDeckController) {
        Error error = moveWasteToDeckController.validateMove();
        if (error != null) {
            io.writeln(error.toString());
        } else {
            moveWasteToDeckController.move();
        }
        this.showGame(moveWasteToDeckController);
    }

    @Override
    public void visit(CommandMoveFromPileToFundationController movePileToFundationController) {
        int pileOrigin = new LimitedIntDialog("De que escalera?", movePileToFundationController.getNumberOfPiles()).read() - 1;
        Error error = movePileToFundationController.validateMove(pileOrigin);
        if (error != null) {
            io.writeln(error.toString());
        } else {
            movePileToFundationController.move(pileOrigin);
        }
        this.showGame(movePileToFundationController);
    }

    @Override
    public void visit(CommandMoveFromPileToPileController movePileToPileController) {
        int pileOrigin = new LimitedIntDialog("De que escalera?", movePileToPileController.getNumberOfPiles()).read() - 1;
        int toIndex = new LimitedIntDialog("Cuantas cartas?", movePileToPileController.pileUpTurnedCardsSize(pileOrigin)).read() - 1;
        int pileTarget = new LimitedIntDialog("A que escalera?", movePileToPileController.getNumberOfPiles()).read() - 1;
        Error error = movePileToPileController.validateMove(pileOrigin, pileTarget, toIndex);
        if (error != null) {
            io.writeln(error.toString());
        } else {
            movePileToPileController.move(pileOrigin, pileTarget, toIndex);
        }
        this.showGame(movePileToPileController);
    }

    @Override
    public void visit(CommandMoveFromFundationToPileController moveFundationToPileController) {
        int ordinalSuit = new LimitedIntDialog("De que palo?", Suit.values().length).read() - 1;
        Suit suit = Suit.values()[ordinalSuit];
        int pileTarget = new LimitedIntDialog("A que escalera?", moveFundationToPileController.getNumberOfPiles()).read() - 1;
        Error error = moveFundationToPileController.validateMove(suit, pileTarget);
        if (error != null) {
            io.writeln(error.toString());
        } else {
            moveFundationToPileController.move(suit, pileTarget);
        }
    }

    @Override
    public void visit(CommandMoveFlipInPileController flipPileController) {
        int pileTarget = new LimitedIntDialog("De que escalera?", flipPileController.getNumberOfPiles()).read() - 1;
        Error error = flipPileController.validateMove(pileTarget);
        if (error != null) {
            io.writeln(error.toString());
        } else {
            flipPileController.move(pileTarget);
        }
        this.showGame(flipPileController);
    }

    @Override
    public void visit(CommandExitController commandExitController) {
        io.write("Adios!!!");
        commandExitController.exit();
    }

}
