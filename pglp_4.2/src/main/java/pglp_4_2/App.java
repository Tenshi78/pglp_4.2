package pglp_4_2;

public enum App {
Application;
	
	public void run( String[] args) {
		SaisieRPN saisie = new SaisieRPN();
		saisie.saisie();
	}
	
	public static void main( String[] args ) {
		Application.run(args);
	}

}
