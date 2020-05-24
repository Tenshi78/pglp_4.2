package pglp_4_2;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Interpreteur {
	
	private Stack<CommandeAnnulable> pile;
	private Bouton bouton;
	private List<String> log;
	
	public Interpreteur() {
		this.pile = new Stack<CommandeAnnulable>();
		this.bouton = new Bouton();
		this.log = new ArrayList<String>();
	}
	

	private void appliquercommande(Commande commande) {
		commande.appliquer();
	}	
	

	public void appliquercommandestocker(CommandeAnnulable commande) {
		try {
			commande.appliquer();
			this.pile.add(commande);	
		} catch (Exception e) {
			throw e;
		}
	}
	
	public void undoCommand() {
		this.appliquercommande(new CommandeAnnuler(pile));
	}
	
	public void log(String str) {
		this.appliquercommande(() -> log.add(str));
	}
	
	public String getLastLog() {
		return log.get(log.size() - 1);
	}
	
	public void shutdown() {
		this.appliquercommande(new CommandeQuitter(bouton));
	}
	
	public boolean estallumer() {
		return bouton.estallumer();
	}
	
}