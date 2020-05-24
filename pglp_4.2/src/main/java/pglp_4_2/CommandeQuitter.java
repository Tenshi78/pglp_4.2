package pglp_4_2;

public class CommandeQuitter implements Commande{
	private Bouton bouton;
	
	public CommandeQuitter(Bouton bouton)
	{
		this.bouton = bouton;
	}

	@Override
	public void appliquer()
	{
		bouton.eteindre();
	}
}
