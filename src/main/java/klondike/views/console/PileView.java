package klondike.views.console;

import klondike.controllers.PresenterController;
import klondike.utils.IO;

public class PileView {

    private PresenterController presenterController;

    public PileView(PresenterController presenterController) {
        this.presenterController = presenterController;
    }

    public void write() {
        IO io = new IO();
        for (int i = 0; i < presenterController.getNumberOfPiles(); i++) {
            io.write("Escalera " + (i + 1) + ":");
            for (int j = 0; j < presenterController.pileDownTurnedCardsSize(i); j++) {
                if (j < presenterController.pileDownTurnedCardsSize(i) - 1)
                    io.write("[");
                else {
                    if (presenterController.pileUpTurnedCardsIsEmpty(i)) {
                        io.write("[X,X]");
                    }
                }
            }
            for (int j = 0; j < presenterController.pileUpTurnedCardsSize(i); j++) {
                new CardView(presenterController.pilePeekAt(i, j)).write();
            }
            if (presenterController.pileDownTurnedCardsIsEmpty(i) && presenterController.pileUpTurnedCardsIsEmpty(i)) {
                io.write("<vacio>");
            }
            io.writeln();
        }
    }
}
