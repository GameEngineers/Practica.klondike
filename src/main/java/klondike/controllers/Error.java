package klondike.controllers;

public enum Error {
	
	EMPTY_DECK("El mazo está vacio."),
	EMPTY_WASTE("El desgaste está vacio."),
	EMPTY_FUNDATION("El palo está vacio."),
	NOT_EMPTY_DECK("El mazo no está vacio."),
	NOT_EMPTY_DOWNTURNED("La pila tiene cartas sin escubiertas."),
	NOT_EMPTY_UPTURNED("La pila tiene cartas descubiertas."),
	EMPTY_UPTURNED("No quedan cartas descubiertas."),
	EMPTY_DOWNTURNED("No quedan cartas por descubrir."),
	CARD_NOT_PROPERTY("No puedes poner la carta {1} sobre la carta {2}."),	
    OPTION_NOT_VALID("La opción debe ser {1} y {2} inclusives."),
    CAN_NOT_FLIP_CARD("No se puede voltear una carta descubierta.");
    
	private String message;
	
	private Error(String message){
		this.message = message;
	}
	
	@Override
	public String toString(){
		return message;
	}
}
