
public abstract class Entity {
	
	protected String symbol;
	protected Boolean isTurn;
	protected Boolean isFirst;
	
	public Entity(String symbol) {
		this.symbol = symbol;
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

	public Boolean getIsFirst() {
		return isFirst;
	}

	public void setIsFirst(Boolean isFirst) {
		this.isFirst = isFirst;
	}
	
	
}
