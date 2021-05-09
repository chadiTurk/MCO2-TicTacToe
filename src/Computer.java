
import java.util.ArrayList;

public class Computer extends Entity{
	
	private int level;
	private String[][] currentBoard;
	private int row;
	private int col;
	
	public Computer(String symbol) {
		super(symbol);
	}
	
	// add levels here
	
	public void initializeLevel(int level){
		this.level = level;
	}
	
	public void setCurrentBoard(String[][] board) {
		this.currentBoard = board;
	}
	
	
	public void generateBehavior() {
		if(this.level == 0) {
			levelZero();
		}
		else if(this.level == 1) {
			//hard coded table
		}
		else if(this.level == 2) {
			//search strategy
		}
	}
	
	public void levelZero() {
		//return row col coordinates of move chosen by cpu
		
		/*
		 * 1. Check first if the cpu already has a win on the next move
		 * 2. If none, check if enemy has a possible winning move then block that
		 * 2. If none, just do a random move
		 */
		
		// check if there's a possible winning move here for the cpu
		
		
		
		//check if there's a possible wnning move here for the human
		
		//else just do a random move
		
		
		
	}
	
	public void levelOne() {
		//return row col coordinates of move chosen by cpu
	}
	
	public void levelTwo() {
		//return row col coordinates of move chosen by cpu
	}

	public int getLevel() {
		return level;
	}

	public int getRow() {
		return row;
	}

	public int getCol() {
		return col;
	}
	
	
	
}
