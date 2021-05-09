import java.util.*;

public class Board {
	
	private Human human;
	private Computer computer;
	private int row;
	private int col;
	private String[][] board;
	private int[][] locations;
	private Scanner scanner;
	private boolean hasWinner;
	private String currSymbol;
	private ArrayList<Symbols> symbols;
	
	
	public Board() {
		this.human = new Human("X");
		this.computer = new Computer("O");
		this.row = 4;
		this.col = 4;
		this.board = new String[4][4];
		this.locations = new int[4][4];
		this.scanner = new Scanner(System.in);
		this.hasWinner = false;
		this.currSymbol = "";
		this.symbols = new ArrayList<>();
	}
	

	
	public void startGame() {
		
		String number;
		
		
		
		
		initializeBoard();
		initializeLocations();
		
		drawLocations();
		drawBoard();
		
		while(boardIsNotFull() && hasWinner == false) {
			
			System.out.println("Enter number:");
			number = scanner.nextLine();
			playerMove(number);
			
			System.out.println(System.lineSeparator().repeat(150));
			drawLocations();
			drawBoard();
			
			//checkWin Conditions Here
		}
		
		
		
	}
	
	public void initializeBoard() {
		for(int i=0;i<4;i++) {
			for(int j =0;j<4;j++) {
				this.board[i][j] ="-";
			}
		}
	}
	
	public void drawBoard() {
		
		drawSpace();
		System.out.println("-----------------");
		
		for(int i =0;i<row;i++) {
			drawSpace();
			System.out.print("| ");
			for( int j = 0;j<col;j++) {
				System.out.print(board[i][j] + " | ");
			}
			
			System.out.println();
			drawSpace();
			System.out.println("-----------------");
		}
		
		if(this.hasWinner == true){
			if(currSymbol == computer.getSymbol()) {
				System.out.println("The computer (" + currSymbol + ")" + " has won the game!" );
			}
			else if(currSymbol == human.getSymbol()) {
				System.out.println("The human (" + currSymbol + ")" + " has won the game!" );
			}
		}
		
	}
	
	public void initializeLocations() {
		int location = 1;
		
		for(int i=0;i<4;i++) {
			for(int j =0;j<4;j++) {
				this.locations[i][j] = location++;
			}
		}
	}
	
	public void drawLocations() {
		
		drawSpace();
		System.out.println("-----------------");
		
		for(int i =0;i<row;i++) {
			drawSpace();
			System.out.print("| ");
			for( int j = 0;j<col;j++) {
				if(locations[i][j] < 10) {
						System.out.print(locations[i][j] + " | ");
				}
					
				else {
					System.out.print(locations[i][j] + "| ");
				}
					
			}
			
			System.out.println();
			drawSpace();
			System.out.println("-----------------");
		}
		
		
		
	
		
	}
	
	
	private void drawSpace() {
		System.out.print("                            ");
	}
	
	public boolean playerMove(String move){
		
		String symbol = checkTurn();
		currSymbol = symbol;
		
		
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
		board[row][col] = symbol;
		
		this.hasWinner = checkWin(row,col,symbol);

		
	}
	
	public boolean checkIfEmpty(int row, int col){
		
		if(board[row][col] =="-")
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
				if(board[i][j] == "-")
					return true;
					
			}
		}
		
		return false;
	}
	
	public boolean checkWin(int x, int y, String symbol) {
		

		int row = 0, col = 0, diag = 0, rdiag = 0;
		
		boolean winner = false;
		
		for(int i = 0;i<4;i++) {
			if(board[x][i] == symbol) {
				col++;
//				
			}
				
			if(board[i][y] == symbol) {
				row++;
			}
				
			if(board[i][i] == symbol) {
				diag++;
			}
				
			if(board[i][(4-1)-i] == symbol) {
				rdiag++;
			}
				
			
			
			if(row == 3) {
				//check if the symbols are next to each other
				
//				if([i][y])
			}
			
			if(row == 3 || col == 3 || diag == 3 || rdiag == 3 ) {
				winner = true;
				break;
			}
				
		}
		
		return winner;

	}
		
	
	public String[][] getBoard(){	
		return this.board;
	}
}
