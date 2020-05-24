package pglp_4_2;

import java.util.Stack;

public class CommandeAnnuler implements Commande{
	
	private CommandeAnnulable dernierecommande;
	
	public CommandeAnnuler(Stack<CommandeAnnulable> historique)
	{
		this.dernierecommande = historique.pop();
	}
	
	@Override
	public void appliquer()
	{
		dernierecommande.annuler();
	}

}
