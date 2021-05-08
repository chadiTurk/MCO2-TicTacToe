
public abstract class Entity {
	
	protected String symbol;
	protected Boolean isTurn;

	
	public Entity(String symbol) {
		
		initialize(symbol);
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
	}

	public Boolean getIsTurn() {
		return isTurn;
	}

	public void setIsTurn(Boolean isTurn) {
		this.isTurn = isTurn;
	}

	
}
