package pglp_4_2;

public enum Operation {
	
	PLUS("+")
	{
		@Override
		public double evaluer(double x, double y)
		{
			return x + y;
		}
	}, 

	MOINS("-")
	{
		@Override
		public double evaluer(double x, double y)
		{
			return x - y;
		}
	},

	MULT("*")
	{
		@Override
		public double evaluer(double x, double y)
		{
			return x * y;
		}
	},

	DIV("/")
	{
		@Override
		public double evaluer(double x, double y)
		{
			return x / y;
		}
	};
	
	private String symbole;
	
	private Operation(String symbole)
	{
		this.symbole = symbole;
	}
		
	public abstract double evaluer(double x , double y);
	
	public String getSymbole() {
		return symbole;
	}
}