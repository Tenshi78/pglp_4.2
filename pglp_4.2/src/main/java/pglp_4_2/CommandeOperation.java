package pglp_4_2;

import java.util.Stack;

public class CommandeOperation implements CommandeAnnulable{
	
	private double derniernombre;
	private double avantderniernombre;
	private Operation operation;
	private Stack<Double> pile;	
	
	public CommandeOperation(Stack<Double> pile, Operation operation)
	{
		this.pile = pile;
		this.operation = operation;
	}
	@Override
	public void appliquer()
	{
		double resultat;
		this.derniernombre = this.pile.pop();
		this.avantderniernombre = this.pile.pop();
		resultat = operation.evaluer(avantderniernombre,derniernombre);
		this.pile.push(resultat);
	}
	
	@Override
	public void annuler()
	{
		this.pile.pop();
		this.pile.push(avantderniernombre);
		this.pile.push(derniernombre);
	}

}
