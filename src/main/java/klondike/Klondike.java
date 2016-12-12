package klondike;

import klondike.Logic;

import klondike.controllers.OperationController;
import klondike.controllers.Manual.ManualLogic;
import klondike.views.console.ConsoleView;


public class Klondike {
private Logic logic;
    
    private View view;
    
    public Klondike(View view, Logic logic) {
        this.view = view;
        this.logic = logic;
    }
    
    public void play() {
        OperationController controller;
        do {
            controller = logic.getOperationController();
            if (controller != null){
                view.interact(controller);
            }
        } while (controller != null);   
    }
    
    public static void main(String[] args) {
        new Klondike(new ConsoleView(), new ManualLogic()).play();
    }
}
