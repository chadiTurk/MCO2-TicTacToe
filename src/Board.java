import java.util.*;

public class Board {
	
	private Human human;
	private Computer computer;
	private int row;
	private int col;
	private String[][] symbols;
	private Scanner scanner;
	
	
	public Board() {
		this.human = new Human("X");
		this.computer = new Computer("O");
		this.row = 4;
		this.col = 4;
		this.symbols = new String[4][4];
		this.scanner = new Scanner(System.in);
	}
	

	
	public void startGame() {
		
		String number;
		
		initializeBoard();
		
		drawBoard();
		
		while(boardIsNotFull()) {
			
			System.out.println("Enter number:");
			number = scanner.nextLine();
			playerMove(number);
			
			drawBoard();
			
			//checkWin Conditions Here
		}
		
		
		
	}
	
	public void initializeBoard() {
		for(int i=0;i<4;i++) {
			for(int j =0;j<4;j++) {
				this.symbols[i][j] ="-";
			}
		}
	}
	
	public void drawBoard() {
		System.out.println("-----------------");
		
		for(int i =0;i<row;i++) {
			System.out.print("| ");
			for( int j = 0;j<col;j++) {
				System.out.print(symbols[i][j] + " | ");
			}
			
			System.out.println();
			System.out.println("-----------------");
		}
		
	}
	
	public boolean playerMove(String move){
		
		String symbol = checkTurn();
		
		switch(move)
		{
			case "1":
				if(checkIfEmpty(0,0) == false){
					return false;
				}
				
				placeSymbol(0,0, symbol);
				
				break;
			case "2":
				if(checkIfEmpty(0,1) == false){
					return false;
				}
				
				placeSymbol(0,1,symbol);
				
				break;
			case "3":
				if(checkIfEmpty(0,2) == false){
					return false;
				}
				
				placeSymbol(0,2,symbol);
				
				break;
			case "4":
				if(checkIfEmpty(0,3) == false){
					return false;
				}
				
				placeSymbol(0,3,symbol);
				
				break;
			case "5":
				if(checkIfEmpty(1,0) == false){
					return false;
				}
				
				placeSymbol(1,0,symbol);
				
				break;
			case "6":
				if(checkIfEmpty(1,1) == false){
					return false;
				}
				
				placeSymbol(1,1,symbol);
				
				break;
			case "7":
				if(checkIfEmpty(1,2) == false){
					return false;
				}
				
				placeSymbol(1,2,symbol);
				
				break;
			case "8":
				if(checkIfEmpty(1,3) == false){
					return false;
				}
				
				placeSymbol(1,3,symbol);
				
				break;
			case "9":
				if(checkIfEmpty(2,0) == false){
					return false;
				}
				
				placeSymbol(2,0,symbol);
				
				break;
			case "10":
				if(checkIfEmpty(2,1) == false){
					return false;
				}
				
				placeSymbol(2,1,symbol);
				
				break;
			case "11":
				if(checkIfEmpty(2,2) == false){
					return false;
				}
				
				placeSymbol(2,2,symbol);
				
				break;
			case "12":
				if(checkIfEmpty(2,3) == false){
					return false;
				}
				
				placeSymbol(2,3,symbol);
				
				break;
			case "13":
				if(checkIfEmpty(3,0) == false){
					return false;
				}
				
				placeSymbol(3,0,symbol);
				
				break;
			case "14":
				if(checkIfEmpty(3,1) == false){
					return false;
				}
				
				placeSymbol(3,1,symbol);
				
				break;
			case "15":
				if(checkIfEmpty(3,2) == false){
					return false;
				}
				
				placeSymbol(3,2,symbol);
				
				break;
			case "16":
				if(checkIfEmpty(3,3) == false){
					return false;
				}
				
				placeSymbol(3,3,symbol);
				
				break;
		}
		
		return true;
		
	}
	
	public void placeSymbol(int row,int col,String symbol) {
		symbols[row][col] = symbol;
	}
	
	public boolean checkIfEmpty(int row, int col){
		
		if(symbols[row][col] =="-")
			return true;
		else
			return false;
	}
	
	public String checkTurn() {
		if(computer.isTurn == true) {
			computer.isTurn = false;
			return computer.getSymbol();
		}
			
		else {
			computer.isTurn = true;
			return human.getSymbol();
		}
			
	}
	
	public boolean boardIsNotFull() {
		for(int i = 0;i<row;i++) {
			for(int j = 0;j<col;j++) {
				if(symbols[i][j] == "-")
					return true;
					
			}
		}
		
		return false;
	}
	
	public boolean checkWin(String symbol) {
		
		if(checkRowWin(symbol) ||checkColWin(symbol) ||checkDiagonalWin(symbol)) {
			return true;
		}
		
		return false;
		
	}
	
	public boolean checkRowWin(String symbol) {
		
		//Don't do this one by one use a more efficient method
		
		
		
	}
	
	public boolean checkColWin(String symbol) {
		
	}
	
	public boolean checkDiagonalWin(String symbol) {
		
	}
	
	
	
	
	
	
	
}
