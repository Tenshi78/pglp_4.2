package pglp_4_2;

import java.util.Stack;

public class CommandeStockerNombre implements CommandeAnnulable {
	private double nombre;
	private Stack<Double> pile;
	
	public CommandeStockerNombre(Stack<Double>pile,double nombre)
	{
		this.pile = pile;
		this.nombre = nombre;
	}
	
	@Override
	public void appliquer()
	{
		this.pile.push(nombre);
	}
	
	@Override
	public void annuler()
	{
		this.pile.pop();
	}

}
