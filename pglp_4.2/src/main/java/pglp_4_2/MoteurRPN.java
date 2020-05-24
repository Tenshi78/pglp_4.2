package pglp_4_2;

import java.util.Stack;

public class MoteurRPN extends Interpreteur {

	private Stack<Double> pile;


	public MoteurRPN() {
		this.pile = new Stack<Double>();
	}


	public void enregistrerNb(double nb) {
		this.appliquercommandestocker(new CommandeStockerNombre(pile, nb));
	}


	public void appliquerOperation(Operation op) {
		this.appliquercommandestocker(new CommandeOperation(pile, op));
	}


	public String afficherPile() {
		String s = "{";
		for (Double d : this.pile) {
			s += (d + " ");
		}	
		return s.trim() + "}";
	}

	public int getSizePile(){
		return this.pile.size();
	}
}
