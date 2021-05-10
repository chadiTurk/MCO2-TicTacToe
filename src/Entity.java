
public abstract class Entity {
	
	protected String symbol;
	protected Boolean isTurn;
	private String name;
	
	public Entity(String symbol,String name) {
		
		initialize(symbol);
		this.name = name;
	}
	
	private void initialize(String symbol){
		this.symbol = symbol;
		
		if(this.symbol == "X") {
			this.isTurn = true;
		}

		else if(this.symbol == "O") {
			this.isTurn = false;
		}
			
	}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
		
		if(this.symbol == "X") {
			this.isTurn = true;
		}
		else
			this.isTurn = false;
	}

	public Boolean getIsTurn() {
		return isTurn;
	}

	public void setIsTurn(Boolean isTurn) {
		this.isTurn = isTurn;
	}
	
	public String getName() {
		return this.name;
	}
	
}
