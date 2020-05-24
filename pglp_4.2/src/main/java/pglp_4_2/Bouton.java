package pglp_4_2;

public class Bouton {
	
	private boolean allumage;
	
	public Bouton()
	{
		this.allumage = true;
	}
	
	public boolean estallumer()
	{
		return this.allumage;
	}

	public void allumer()
	{
		allumage = true;
	}
	
	public void eteindre()
	{
		allumage = false;
	}
}
