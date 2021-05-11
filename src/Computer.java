
import java.util.*;

public class Computer extends Entity{
	
	private int level;
	private String[][] currentBoard;
	private ArrayList<Integer> numbersLeft;
	private String number;
	
	
	public Computer(String symbol) {
		super(symbol,"Computer");
		this.level = 0;
		this.numbersLeft = new ArrayList<>();
	}
	
	// add levels here
	
	public void initializeLevel(int level){
		this.level = level;
	}
	
	public void setCurrentBoard(String[][] board) {
		this.currentBoard = board;
	}
	
	
	public void setnumbersLeft(ArrayList<Integer> numbersLeftBoard) {
		
		
		this.numbersLeft = numbersLeftBoard;
		
	}
	
	public String generateBehavior(String[][] board) {
		
		String decision;
		
		setCurrentBoard(board);
		
		//possible to return an  objec that contains x and y coordinate that the cpu would make 
		
		if(this.level == 0) {
			decision = levelZero();
			
			return decision;
		}
		else if(this.level == 1) {
			//hard coded table
		}
		else if(this.level == 2) {
			//search strategy
		}
		
		return "";
	}
	
	public String levelZero() {
		//return row col coordinates of move chosen by cpu
		
		
		
		
		/*
		 * 1. Check first if the cpu already has a win on the next move
		 * 2. If none, check if enemy has a possible winning move then block that
		 * 2. If none, just do a random move
		 */
		
		// check if there's a possible winning move here for the cpu
		
		if(checkComputerWin()) {
			return this.number;
		}
		
		else if(checkHumanWin()) {
			return this.number;
		}
		
		else {
			
			for(int i = 0;i<this.numbersLeft.size();i++) {
				System.out.println(numbersLeft.get(i));
			}
			
			Integer temp = numbersLeft.get(new Random().nextInt(numbersLeft.size()));
			
			System.out.println(temp);
			
			String num = String.valueOf(temp);
			
			return num;
			
		}
				
		
	}
	
	public boolean checkComputerWin() {
		
		//row1
		
		
		
		if(currentBoard[0][0] == symbol && currentBoard[0][1] == symbol && currentBoard[0][2] == "-") {
			this.number = "3";
			return true;
		}
		
		if(currentBoard[1][0] == symbol && currentBoard[1][1] == symbol && currentBoard[1][2] == "-") {
			this.number = "7";
			return true;
		}
		
		if(currentBoard[2][0] == symbol && currentBoard[2][1] == symbol && currentBoard[2][2] == "-") {
			this.number = "11";
			return true;
		}
		
		if(currentBoard[3][0] == symbol && currentBoard[3][1] == symbol && currentBoard[3][2] == "-") {
			this.number = "15";
			return true;
		}
		
		//row2
		
		if(currentBoard[0][1] == symbol && currentBoard[0][2] == symbol && currentBoard[0][0] == "-") {
			this.number = "1";
			return true;
		}
		
		if(currentBoard[0][1] == symbol && currentBoard[0][2] == symbol && currentBoard[0][3] == "-") {
			this.number = "4";
			return true;
		}
		
		if(currentBoard[1][1] == symbol && currentBoard[1][2] == symbol && currentBoard[1][0] == "-") {
			this.number = "5";
			return true;
		}
		
		if(currentBoard[1][1] == symbol && currentBoard[1][2] == symbol && currentBoard[1][3] == "-") {
			this.number = "8";
			return true;
		}
		
		if(currentBoard[2][1] == symbol && currentBoard[2][2] == symbol && currentBoard[2][0] == "-") {
			this.number = "9";
			return true;
		}
		
		if(currentBoard[2][1] == symbol && currentBoard[2][2] == symbol && currentBoard[2][3] == "-") {
			this.number = "12";
			return true;
		}
		
		if(currentBoard[3][1] == symbol && currentBoard[3][2] == symbol && currentBoard[3][0] == "-") {
			this.number = "13";
			return true;
		}
		
		if(currentBoard[3][1] == symbol && currentBoard[3][2] == symbol && currentBoard[3][3] == "-") {
			this.number = "16";
			return true;
		}
		
		//row3
		
		if(currentBoard[0][2] == symbol && currentBoard[0][3] == symbol && currentBoard[0][1] == "-") {
			this.number = "2";
			return true;
		}
		
		if(currentBoard[1][2] == symbol && currentBoard[1][3] == symbol && currentBoard[1][1] == "-") {
			this.number = "6";
			return true;
		}
		
		if(currentBoard[2][2] == symbol && currentBoard[2][3] == symbol && currentBoard[2][1] == "-") {
			this.number = "10";
			return true;
		}
		
		if(currentBoard[3][2] == symbol && currentBoard[3][3] == symbol && currentBoard[3][1] == "-") {
			this.number = "14";
			return true;
		}
		
		
		//col1
		
		if(currentBoard[0][0] == symbol && currentBoard[1][0] == symbol && currentBoard[2][0] == "-") {
			this.number = "9";
			return true;
		}
		
		if(currentBoard[0][1] == symbol && currentBoard[1][1] == symbol && currentBoard[2][1] == "-") {
			this.number = "10";
			return true;
		}
		
		if(currentBoard[0][2] == symbol && currentBoard[1][2] == symbol && currentBoard[2][2] == "-") {
			this.number = "11";
			return true;
		}
		
		if(currentBoard[0][3] == symbol && currentBoard[1][3] == symbol && currentBoard[2][3] == "-") {
			this.number = "12";
			return true;
		}
		
		//col 2
		
		if(currentBoard[1][0] == symbol && currentBoard[2][0] == symbol && currentBoard[0][0] == "-") {
			this.number = "1";
			return true;
		}
		
		if(currentBoard[1][0] == symbol && currentBoard[2][0] == symbol && currentBoard[3][0] == "-") {
			this.number = "13";
			return true;
		}
		
		if(currentBoard[1][1] == symbol && currentBoard[2][1] == symbol && currentBoard[0][1] == "-") {
			this.number = "2";
			return true;
		}
		
		if(currentBoard[1][1] == symbol && currentBoard[2][1] == symbol && currentBoard[3][1] == "-") {
			this.number = "14";
			return true;
		}
		
		if(currentBoard[1][2] == symbol && currentBoard[2][2] == symbol && currentBoard[0][2] == "-") {
			this.number = "3";
			return true;
		}
		
		if(currentBoard[1][2] == symbol && currentBoard[2][2] == symbol && currentBoard[3][2] == "-") {
			this.number = "15";
			return true;
		}
		
		if(currentBoard[1][3] == symbol && currentBoard[2][3] == symbol && currentBoard[0][3] == "-") {
			this.number = "4";
			return true;
		}
		
		if(currentBoard[1][3] == symbol && currentBoard[2][3] == symbol && currentBoard[3][3] == "-") {
			this.number = "16";
			return true;
		}
		
		//col 3
		
		if(currentBoard[2][0] == symbol && currentBoard[3][0] == symbol && currentBoard[1][0] == "-") {
			this.number = "5";
			return true;
		}
		
		if(currentBoard[2][1] == symbol && currentBoard[3][1] == symbol && currentBoard[1][1] == "-") {
			this.number = "6";
			return true;
		}
		
		if(currentBoard[2][2] == symbol && currentBoard[3][2] == symbol && currentBoard[1][2] == "-") {
			this.number = "7";
			return true;
		}
		
		if(currentBoard[2][3] == symbol && currentBoard[3][3] == symbol && currentBoard[1][3] == "-") {
			this.number = "8";
			return true;
		}
		
		//diag 1
		
		if(currentBoard[0][1] == symbol && currentBoard[3][0] == symbol && currentBoard[2][3] == "-") {
			this.number = "12";
			return true;
		}
		
		if(currentBoard[0][0] == symbol && currentBoard[1][1] == symbol && currentBoard[2][2] == "-") {
			this.number = "11";
			return true;
		}
		
		if(currentBoard[1][0] == symbol && currentBoard[2][1] == symbol && currentBoard[3][2] == "-") {
			this.number = "15";
			return true;
		}
		
		if(currentBoard[1][2] == symbol && currentBoard[2][3] == symbol && currentBoard[0][1] == "-") {
			this.number = "2";
			return true;
		}
		
		if(currentBoard[1][1] == symbol && currentBoard[2][2] == symbol && currentBoard[0][0] == "-") {
			this.number = "1";
			return true;
		}
		
		if(currentBoard[1][1] == symbol && currentBoard[2][2] == symbol && currentBoard[3][3] == "-") {
			this.number = "16";
			return true;
		}
		
		if(currentBoard[2][1] == symbol && currentBoard[3][2] == symbol && currentBoard[1][0] == "-") {
			this.number = "5";
			return true;
		}
		
		if(currentBoard[2][2] == symbol && currentBoard[3][3] == symbol && currentBoard[1][1] == "-") {
			this.number = "6";
			return true;
		}
		
		//diag2
		
		if(currentBoard[0][2] == symbol && currentBoard[1][1] == symbol && currentBoard[2][0] == "-") {
			this.number = "9";
			return true;
		}
		
		if(currentBoard[0][3] == symbol && currentBoard[1][2] == symbol && currentBoard[2][1] == "-") {
			this.number = "10";
			return true;
		}
		
		if(currentBoard[1][3] == symbol && currentBoard[2][2] == symbol && currentBoard[3][1] == "-") {
			this.number = "14";
			return true;
		}
		
		if(currentBoard[1][1] == symbol && currentBoard[2][0] == symbol && currentBoard[0][2] == "-") {
			this.number = "3";
			return true;
		}
		
		if(currentBoard[1][2] == symbol && currentBoard[2][1] == symbol && currentBoard[0][3] == "-") {
			this.number = "4";
			return true;
		}
		
		if(currentBoard[1][2] == symbol && currentBoard[2][1] == symbol && currentBoard[3][0] == "-") {
			this.number = "13";
			return true;
		}
		
		if(currentBoard[3][1] == symbol && currentBoard[2][2] == symbol && currentBoard[1][3] == "-") {
			this.number = "8";
			return true;
		}
		
		if(currentBoard[2][1] == symbol && currentBoard[3][0] == symbol && currentBoard[1][2] == "-") {
			this.number = "7";
			return true;
		}
		
		// IN between::
		
		if(currentBoard[0][0] == symbol && currentBoard[2][0] == symbol && currentBoard[1][0] == "-") {
			this.number = "5";
			return true;
		}
		
		if(currentBoard[0][1] == symbol && currentBoard[2][1] == symbol && currentBoard[1][1] == "-") {
			this.number = "6";
			return true;
		}
		
		if(currentBoard[0][2] == symbol && currentBoard[2][2] == symbol && currentBoard[1][2] == "-") {
			this.number = "7";
			return true;
		}
		
		if(currentBoard[0][3] == symbol && currentBoard[2][3] == symbol && currentBoard[1][3] == "-") {
			this.number = "8";
			return true;
		}
		
		if(currentBoard[0][0] == symbol && currentBoard[2][2] == symbol && currentBoard[1][1] == "-") {
			this.number = "6";
			return true;
		}
		
		if(currentBoard[0][2] == symbol && currentBoard[2][0] == symbol && currentBoard[1][1] == "-") {
			this.number = "6";
			return true;
		}
		
		if(currentBoard[0][1] == symbol && currentBoard[2][3] == symbol && currentBoard[1][2] == "-") {
			this.number = "7";
			return true;
		}
		
		if(currentBoard[0][3] == symbol && currentBoard[2][1] == symbol && currentBoard[1][2] == "-") {
			this.number = "7";
			return true;
		}
		
		if(currentBoard[1][0] == symbol && currentBoard[3][0] == symbol && currentBoard[2][0] == "-") {
			this.number = "9";
			return true;
		}
		
		if(currentBoard[1][1] == symbol && currentBoard[3][1] == symbol && currentBoard[2][1] == "-") {
			this.number = "10";
			return true;
		}
		
		if(currentBoard[1][2] == symbol && currentBoard[3][2] == symbol && currentBoard[2][2] == "-") {
			this.number = "11";
			return true;
		}
		
		if(currentBoard[1][3] == symbol && currentBoard[3][3] == symbol && currentBoard[2][3] == "-") {
			this.number = "12";
			return true;
		}
		
		if(currentBoard[1][0] == symbol && currentBoard[3][2] == symbol && currentBoard[2][1] == "-") {
			this.number = "10";
			return true;
		}
		
		if(currentBoard[1][2] == symbol && currentBoard[3][0] == symbol && currentBoard[2][1] == "-") {
			this.number = "10";
			return true;
		}
		
		if(currentBoard[1][1] == symbol && currentBoard[3][3] == symbol && currentBoard[2][2] == "-") {
			this.number = "11";
			return true;
		}
		
		if(currentBoard[1][3] == symbol && currentBoard[3][1] == symbol && currentBoard[2][2] == "-") {
			this.number = "11";
			return true;
		}
		
		if(currentBoard[0][0] == symbol && currentBoard[0][2] == symbol && currentBoard[0][1] == "-") {
			this.number = "2";
			return true;
		}
		
		if(currentBoard[1][0] == symbol && currentBoard[1][2] == symbol && currentBoard[1][1] == "-") {
			this.number = "6";
			return true;
		}
		
		if(currentBoard[2][0] == symbol && currentBoard[2][2] == symbol && currentBoard[2][1] == "-") {
			this.number = "10";
			return true;
		}
		
		if(currentBoard[3][0] == symbol && currentBoard[3][2] == symbol && currentBoard[3][1] == "-") {
			this.number = "14";
			return true;
		}
		
		if(currentBoard[0][1] == symbol && currentBoard[0][3] == symbol && currentBoard[0][2] == "-") {
			this.number = "3";
			return true;
		}
		
		if(currentBoard[1][1] == symbol && currentBoard[1][3] == symbol && currentBoard[1][2] == "-") {
			this.number = "7";
			return true;
		}
		
		if(currentBoard[2][1] == symbol && currentBoard[2][3] == symbol && currentBoard[2][2] == "-") {
			this.number = "11";
			return true;
		}
		
		if(currentBoard[3][1] == symbol && currentBoard[3][3] == symbol && currentBoard[3][2] == "-") {
			this.number = "15";
			return true;
		}
		
		return false;
	}
	
	public boolean checkHumanWin() {
		
		
		String humanSymbol;
		
		if(this.symbol == "X")
			humanSymbol = "O";
		else {
			humanSymbol = "X";
		}
		
		//make this return boolean
		if(currentBoard[0][0] == humanSymbol && currentBoard[0][1] == humanSymbol && currentBoard[0][2] == "-") {
			this.number = "3";
			return true;
		}
		
		if(currentBoard[1][0] == humanSymbol && currentBoard[1][1] == humanSymbol && currentBoard[1][2] == "-") {
			this.number = "7";
			return true;
		}
		
		if(currentBoard[2][0] == humanSymbol && currentBoard[2][1] == humanSymbol && currentBoard[2][2] == "-") {
			this.number = "11";
			return true;
		}
		
		if(currentBoard[3][0] == humanSymbol && currentBoard[3][1] == humanSymbol && currentBoard[3][2] == "-") {
			this.number = "15";
			return true;
		}
		
		//row2
		
		if(currentBoard[0][1] == humanSymbol && currentBoard[0][2] == humanSymbol && currentBoard[0][0] == "-") {
			this.number = "1";
			return true;
		}
		
		if(currentBoard[0][1] == humanSymbol && currentBoard[0][2] == humanSymbol && currentBoard[0][3] == "-") {
			this.number = "4";
			return true;
		}
		
		if(currentBoard[1][1] == humanSymbol && currentBoard[1][2] == humanSymbol && currentBoard[1][0] == "-") {
			this.number = "5";
			return true;
		}
		
		if(currentBoard[1][1] == humanSymbol && currentBoard[1][2] == humanSymbol && currentBoard[1][3] == "-") {
			this.number = "8";
			return true;
		}
		
		if(currentBoard[2][1] == humanSymbol && currentBoard[2][2] == humanSymbol && currentBoard[2][0] == "-") {
			this.number = "9";
			return true;
		}
		
		if(currentBoard[2][1] == humanSymbol && currentBoard[2][2] == humanSymbol && currentBoard[2][3] == "-") {
			this.number = "12";
			return true;
		}
		
		if(currentBoard[3][1] == humanSymbol && currentBoard[3][2] == humanSymbol && currentBoard[3][0] == "-") {
			this.number = "13";
			return true;
		}
		
		if(currentBoard[3][1] == humanSymbol && currentBoard[3][2] == humanSymbol && currentBoard[3][3] == "-") {
			this.number = "16";
			return true;
		}
		
		//row3
		
		if(currentBoard[0][2] == humanSymbol && currentBoard[0][3] == humanSymbol && currentBoard[0][1] == "-") {
			this.number = "2";
			return true;
		}
		
		if(currentBoard[1][2] == humanSymbol && currentBoard[1][3] == humanSymbol && currentBoard[1][1] == "-") {
			this.number = "6";
			return true;
		}
		
		if(currentBoard[2][2] == humanSymbol && currentBoard[2][3] == humanSymbol && currentBoard[2][1] == "-") {
			this.number = "10";
			return true;
		}
		
		if(currentBoard[3][2] == humanSymbol && currentBoard[3][3] == humanSymbol && currentBoard[3][1] == "-") {
			this.number = "14";
			return true;
		}
		
		
		//col1
		
		if(currentBoard[0][0] == humanSymbol && currentBoard[1][0] == humanSymbol && currentBoard[2][0] == "-") {
			this.number = "9";
			return true;
		}
		
		if(currentBoard[0][1] == humanSymbol && currentBoard[1][1] == humanSymbol && currentBoard[2][1] == "-") {
			this.number = "10";
			return true;
		}
		
		if(currentBoard[0][2] == humanSymbol && currentBoard[1][2] == humanSymbol && currentBoard[2][2] == "-") {
			this.number = "11";
			return true;
		}
		
		if(currentBoard[0][3] == humanSymbol && currentBoard[1][3] == humanSymbol && currentBoard[2][3] == "-") {
			this.number = "12";
			return true;
		}
		
		//col 2
		
		if(currentBoard[1][0] == humanSymbol && currentBoard[2][0] == humanSymbol && currentBoard[0][0] == "-") {
			this.number = "1";
			return true;
		}
		
		if(currentBoard[1][0] == humanSymbol && currentBoard[2][0] == humanSymbol && currentBoard[3][0] == "-") {
			this.number = "13";
			return true;
		}
		
		if(currentBoard[1][1] == humanSymbol && currentBoard[2][1] == humanSymbol && currentBoard[0][1] == "-") {
			this.number = "2";
			return true;
		}
		
		if(currentBoard[1][1] == humanSymbol && currentBoard[2][1] == humanSymbol && currentBoard[3][1] == "-") {
			this.number = "14";
			return true;
		}
		
		if(currentBoard[1][2] == humanSymbol && currentBoard[2][2] == humanSymbol && currentBoard[0][2] == "-") {
			this.number = "3";
			return true;
		}
		
		if(currentBoard[1][2] == humanSymbol && currentBoard[2][2] == humanSymbol && currentBoard[3][2] == "-") {
			this.number = "15";
			return true;
		}
		
		if(currentBoard[1][3] == humanSymbol && currentBoard[2][3] == humanSymbol && currentBoard[0][3] == "-") {
			this.number = "4";
			return true;
		}
		
		if(currentBoard[1][3] == humanSymbol && currentBoard[2][3] == humanSymbol && currentBoard[3][3] == "-") {
			this.number = "16";
			return true;
		}
		
		//col 3
		
		if(currentBoard[2][0] == humanSymbol && currentBoard[3][0] == humanSymbol && currentBoard[1][0] == "-") {
			this.number = "5";
			return true;
		}
		
		if(currentBoard[2][1] == humanSymbol && currentBoard[3][1] == humanSymbol && currentBoard[1][1] == "-") {
			this.number = "6";
			return true;
		}
		
		if(currentBoard[2][2] == humanSymbol && currentBoard[3][2] == humanSymbol && currentBoard[1][2] == "-") {
			this.number = "7";
			return true;
		}
		
		if(currentBoard[2][3] == humanSymbol && currentBoard[3][3] == humanSymbol && currentBoard[1][3] == "-") {
			this.number = "8";
			return true;
		}
		
		//diag 1
		
		if(currentBoard[0][1] == humanSymbol && currentBoard[3][0] == humanSymbol && currentBoard[2][3] == "-") {
			this.number = "12";
			return true;
		}
		
		if(currentBoard[0][0] == humanSymbol && currentBoard[1][1] == humanSymbol && currentBoard[2][2] == "-") {
			this.number = "11";
			return true;
		}
		
		if(currentBoard[1][0] == humanSymbol && currentBoard[2][1] == humanSymbol && currentBoard[3][2] == "-") {
			this.number = "15";
			return true;
		}
		
		if(currentBoard[1][2] == humanSymbol && currentBoard[2][3] == humanSymbol && currentBoard[0][1] == "-") {
			this.number = "2";
			return true;
		}
		
		if(currentBoard[1][1] == humanSymbol && currentBoard[2][2] == humanSymbol && currentBoard[0][0] == "-") {
			this.number = "1";
			return true;
		}
		
		if(currentBoard[1][1] == humanSymbol && currentBoard[2][2] == humanSymbol && currentBoard[3][3] == "-") {
			this.number = "16";
			return true;
		}
		
		if(currentBoard[2][1] == humanSymbol && currentBoard[3][2] == humanSymbol && currentBoard[1][0] == "-") {
			this.number = "5";
			return true;
		}
		
		if(currentBoard[2][2] == humanSymbol && currentBoard[3][3] == humanSymbol && currentBoard[1][1] == "-") {
			this.number = "6";
			return true;
		}
		
		//diag2
		
		if(currentBoard[0][2] == humanSymbol && currentBoard[1][1] == humanSymbol && currentBoard[2][0] == "-") {
			this.number = "9";
			return true;
		}
		
		if(currentBoard[0][3] == humanSymbol && currentBoard[1][2] == humanSymbol && currentBoard[2][1] == "-") {
			this.number = "10";
			return true;
		}
		
		if(currentBoard[1][3] == humanSymbol && currentBoard[2][2] == humanSymbol && currentBoard[3][1] == "-") {
			this.number = "14";
			return true;
		}
		
		if(currentBoard[1][1] == humanSymbol && currentBoard[2][0] == humanSymbol && currentBoard[0][2] == "-") {
			this.number = "3";
			return true;
		}
		
		if(currentBoard[1][2] == humanSymbol && currentBoard[2][1] == humanSymbol && currentBoard[0][3] == "-") {
			this.number = "4";
			return true;
		}
		
		if(currentBoard[1][2] == humanSymbol && currentBoard[2][1] == humanSymbol && currentBoard[3][0] == "-") {
			this.number = "13";
			return true;
		}
		
		if(currentBoard[3][1] == humanSymbol && currentBoard[2][2] == humanSymbol && currentBoard[1][3] == "-") {
			this.number = "8";
			return true;
		}
		
		if(currentBoard[2][1] == humanSymbol && currentBoard[3][0] == humanSymbol && currentBoard[1][2] == "-") {
			this.number = "7";
			return true;
		}
		
		// IN between::
		
		if(currentBoard[0][0] == humanSymbol && currentBoard[2][0] == humanSymbol && currentBoard[1][0] == "-") {
			this.number = "5";
			return true;
		}
		
		if(currentBoard[0][1] == humanSymbol && currentBoard[2][1] == humanSymbol && currentBoard[1][1] == "-") {
			this.number = "6";
			return true;
		}
		
		if(currentBoard[0][2] == humanSymbol && currentBoard[2][2] == humanSymbol && currentBoard[1][2] == "-") {
			this.number = "7";
			return true;
		}
		
		if(currentBoard[0][3] == humanSymbol && currentBoard[2][3] == humanSymbol && currentBoard[1][3] == "-") {
			this.number = "8";
			return true;
		}
		
		if(currentBoard[0][0] == humanSymbol && currentBoard[2][2] == humanSymbol && currentBoard[1][1] == "-") {
			this.number = "6";
			return true;
		}
		
		if(currentBoard[0][2] == humanSymbol && currentBoard[2][0] == humanSymbol && currentBoard[1][1] == "-") {
			this.number = "6";
			return true;
		}
		
		if(currentBoard[0][1] == humanSymbol && currentBoard[2][3] == humanSymbol && currentBoard[1][2] == "-") {
			this.number = "7";
			return true;
		}
		
		if(currentBoard[0][3] == humanSymbol && currentBoard[2][1] == humanSymbol && currentBoard[1][2] == "-") {
			this.number = "7";
			return true;
		}
		
		if(currentBoard[1][0] == humanSymbol && currentBoard[3][0] == humanSymbol && currentBoard[2][0] == "-") {
			this.number = "9";
			return true;
		}
		
		if(currentBoard[1][1] == humanSymbol && currentBoard[3][1] == humanSymbol && currentBoard[2][1] == "-") {
			this.number = "10";
			return true;
		}
		
		if(currentBoard[1][2] == humanSymbol && currentBoard[3][2] == humanSymbol && currentBoard[2][2] == "-") {
			this.number = "11";
			return true;
		}
		
		if(currentBoard[1][3] == humanSymbol && currentBoard[3][3] == humanSymbol && currentBoard[2][3] == "-") {
			this.number = "12";
			return true;
		}
		
		if(currentBoard[1][0] == humanSymbol && currentBoard[3][2] == humanSymbol && currentBoard[2][1] == "-") {
			this.number = "10";
			return true;
		}
		
		if(currentBoard[1][2] == humanSymbol && currentBoard[3][0] == humanSymbol && currentBoard[2][1] == "-") {
			this.number = "10";
			return true;
		}
		
		if(currentBoard[1][1] == humanSymbol && currentBoard[3][3] == humanSymbol && currentBoard[2][2] == "-") {
			this.number = "11";
			return true;
		}
		
		if(currentBoard[1][3] == humanSymbol && currentBoard[3][1] == humanSymbol && currentBoard[2][2] == "-") {
			this.number = "11";
			return true;
		}
		
		if(currentBoard[0][0] == humanSymbol && currentBoard[0][2] == humanSymbol && currentBoard[0][1] == "-") {
			this.number = "2";
			return true;
		}
		
		if(currentBoard[1][0] == humanSymbol && currentBoard[1][2] == humanSymbol && currentBoard[1][1] == "-") {
			this.number = "6";
			return true;
		}
		
		if(currentBoard[2][0] == humanSymbol && currentBoard[2][2] == humanSymbol && currentBoard[2][1] == "-") {
			this.number = "10";
			return true;
		}
		
		if(currentBoard[3][0] == humanSymbol && currentBoard[3][2] == humanSymbol && currentBoard[3][1] == "-") {
			this.number = "14";
			return true;
		}
		
		if(currentBoard[0][1] == humanSymbol && currentBoard[0][3] == humanSymbol && currentBoard[0][2] == "-") {
			this.number = "3";
			return true;
		}
		
		if(currentBoard[1][1] == humanSymbol && currentBoard[1][3] == humanSymbol && currentBoard[1][2] == "-") {
			this.number = "7";
			return true;
		}
		
		if(currentBoard[2][1] == humanSymbol && currentBoard[2][3] == humanSymbol && currentBoard[2][2] == "-") {
			this.number = "11";
			return true;
		}
		
		if(currentBoard[3][1] == humanSymbol && currentBoard[3][3] == humanSymbol && currentBoard[3][2] == "-") {
			this.number = "15";
			return true;
		}
		
		return false;
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

	public String getNum() {
		return this.number;
	}
	
	
}
