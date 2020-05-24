package pglp_4_2;

import java.util.Scanner;

public class SaisieRPN 
{
	private MoteurRPN moteur;
	private Scanner sc;

	public SaisieRPN()
	{
		moteur = new MoteurRPN();
	}

	public void setScanner(Scanner sc) 
	{
		this.sc = sc;		
	}

	public void closeScanner() 
	{
		sc.close();
	}

	public void saisie() {
		this.setScanner(new Scanner(System.in));

		String input = ""; 
		String str = "";

		while(moteur.estallumer()) 
		{
			System.out.println("Saisissez un nombre, une opération ou quitter pour sortir, puis taper sur entrée");
			try 
			{
				input = scanneLigne();
				str += input + " ";
				System.out.println(str);
			}
			catch (Exception e) {
				System.err.println(e.getMessage());
			}
			System.out.println(moteur.afficherPile());
		}

		System.out.println("Fin du programme");
		this.closeScanner();    
	}

	public String scanneLigne()
	{
		String input;
		if (sc.hasNextDouble()) 
		{
			Double d = sc.nextDouble();
			moteur.enregistrerNb(d);
			sc.nextLine();
			input = d.toString();
		} 
		else 
		{
			input = sc.nextLine();
			if (input.equals("quitter")) 
			{
				moteur.shutdown();
			}
			else if (input.equals("annuler")) 
			{
				moteur.undoCommand();
			}
			else if (isOperation(input)) 
			{
				moteur.appliquerOperation(renvoieOperation(input));	
			}
			
		}
		return input;
	}

	private boolean isOperation(String str) 
	{
		return this.renvoieOperation(str) != null;
	}

	private Operation renvoieOperation(String str) 
	{
		for (Operation op : Operation.values())
			if (str.equals(op.getSymbole()))
				return op;
		return null;
	}

}
