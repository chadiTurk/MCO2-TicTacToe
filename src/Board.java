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
	private ArrayList<Integer> numbersLeft;
	private Integer level;
	
	public Board() {
		this.human = new Human("X");
		this.computer = new Computer("O");
		this.row = 4;
		this.col = 4;
		this.board = new String[4][4];
		this.locations = new int[4][4];
		this.scanner = new Scanner(System.in);
		this.hasWinner = false;
		this.currSymbol = "X";
		this.numbersLeft = new ArrayList<>();
	}
	

	
	public void startGame() {
		
		
		Scanner numberScan = new Scanner(System.in);
		String number;
		
		initializeBoard();
	
		initializeLocations();
	
		initializeNumbersNotTaken();
	
		computer.setnumbersLeft(numbersLeft);
	
		do {
			System.out.println("Enter level for computer (0-2):");
			level = numberScan.nextInt();
			
			if(level < 0 || level >2) {
				System.out.println("Please enter a valid level");
			}
			else {
				computer.initializeLevel(level);
			}
			
		}while(level < 0 || level > 2);
		
		
		drawLocations();
		drawBoard();
		
		
		
		
		while(boardIsNotFull() && hasWinner == false) {
			
			
			
			if(this.human.getIsTurn() == true) {
				System.out.println(human.getName() + "s Turn (" + currSymbol + ")");
				
				//CHECK IF MOVE IS SCANNER MOVE IS LEGAL IF THE LOCATION IS EMPTY1
				number = getHumanInput();
				playerMove(number);
//				computer.setnumbersLeft(numbersLeft);
			}
			else if(this.computer.getIsTurn() == true) {
				System.out.println(computer.getName() + "s Turn (" + currSymbol + ")");
				String num = computer.generateBehavior(board);
				playerMove(num);
			}
			System.out.println(System.lineSeparator().repeat(150));
			drawLocations();
			drawBoard();
			
			if(currSymbol == "X")
				currSymbol = "O";
			else if(currSymbol == "O")
				currSymbol = "X";
			//checkWin Conditions Here
		}
		
		if(boardIsNotFull() == false) {
			System.out.println("It's a tie!");
		}
		
		hasWinner = false;
		
		if(human.getSymbol() == "X") {
			human.setSymbol("O");
			computer.setSymbol("X");
		}else {
			human.setSymbol("X");
			computer.setSymbol("O");
		}
		
		
		this.currSymbol = "X";
		
	}
	
	public String getHumanInput() {
		
		String number;
		Integer temp;
		boolean validLocation;
		
		do {
			System.out.println("Enter number:");
			number = scanner.nextLine();
			temp = Integer.valueOf(number);
			
			validLocation = searchForNum(temp);
			
			if(!validLocation && temp > 0 && temp < 17){
				System.out.println("INVALID: That location is already occupied.");
			}
			
			else if(temp < 1 || temp > 16){
				System.out.println("INVALID: That location is invalid.");
			}
			
		}while(temp <1 || temp > 16 || validLocation == false);
		
		
		return number;
		
	}
	
	
	public boolean searchForNum(Integer number){
		
		boolean numberAvail = false;
		
		if(number > 0 && number < 17) {
			for(int i=0;i<this.numbersLeft.size();i++) {
				if(numbersLeft.get(i) == number) {
					numberAvail = true;
					break;
				}
					
			}
		}
	
		return numberAvail;
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
		
		//todo add numbersLeft.add(num) to all cases	
		String symbol = checkTurn();
		currSymbol = symbol;
		
		
		switch(move)
		{
			case "1":
				if(checkIfEmpty(0,0) == false){
					return false;
				}
				
				placeSymbol(0,0, symbol);
				numbersLeft.remove(Integer.valueOf(1));
				break;
			case "2":
				if(checkIfEmpty(0,1) == false){
					return false;
				}
				
				placeSymbol(0,1,symbol);
				numbersLeft.remove(Integer.valueOf(2));
				break;
			case "3":
				if(checkIfEmpty(0,2) == false){
					return false;
				}
				
				placeSymbol(0,2,symbol);
				numbersLeft.remove(Integer.valueOf(3));
				break;
			case "4":
				if(checkIfEmpty(0,3) == false){
					return false;
				}
				
				placeSymbol(0,3,symbol);
				numbersLeft.remove(Integer.valueOf(4));
				break;
			case "5":
				if(checkIfEmpty(1,0) == false){
					return false;
				}
				
				placeSymbol(1,0,symbol);
				numbersLeft.remove(Integer.valueOf(5));
				break;
			case "6":
				if(checkIfEmpty(1,1) == false){
					return false;
				}
				
				placeSymbol(1,1,symbol);
				numbersLeft.remove(Integer.valueOf(6));
				break;
			case "7":
				if(checkIfEmpty(1,2) == false){
					return false;
				}
				
				placeSymbol(1,2,symbol);
				numbersLeft.remove(Integer.valueOf(7));
				break;
			case "8":
				if(checkIfEmpty(1,3) == false){
					return false;
				}
				
				placeSymbol(1,3,symbol);
				numbersLeft.remove(Integer.valueOf(8));
				break;
			case "9":
				if(checkIfEmpty(2,0) == false){
					return false;
				}
				
				placeSymbol(2,0,symbol);
				numbersLeft.remove(Integer.valueOf(9));
				break;
			case "10":
				if(checkIfEmpty(2,1) == false){
					return false;
				}
				
				placeSymbol(2,1,symbol);
				numbersLeft.remove(Integer.valueOf(10));
				break;
			case "11":
				if(checkIfEmpty(2,2) == false){
					return false;
				}
				
				placeSymbol(2,2,symbol);
				numbersLeft.remove(Integer.valueOf(11)); 
				break;
			case "12":
				if(checkIfEmpty(2,3) == false){
					return false;
				}
				
				placeSymbol(2,3,symbol);
				numbersLeft.remove(Integer.valueOf(12));
				break;
			case "13":
				if(checkIfEmpty(3,0) == false){
					return false;
				}
				
				placeSymbol(3,0,symbol);
				numbersLeft.remove(Integer.valueOf(13));
				break;
			case "14":
				if(checkIfEmpty(3,1) == false){
					return false;
				}
				
				placeSymbol(3,1,symbol);
				numbersLeft.remove(Integer.valueOf(14)); 
				break;
			case "15":
				if(checkIfEmpty(3,2) == false){
					return false;
				}
				
				placeSymbol(3,2,symbol);
				numbersLeft.remove(Integer.valueOf(15)); 
				break;
			case "16":
				if(checkIfEmpty(3,3) == false){
					return false;
				}
				
				placeSymbol(3,3,symbol);
				numbersLeft.remove(Integer.valueOf(16));
				break;
		}
		
		return true;
		
	}
	
	public void placeSymbol(int row,int col,String symbol) {
		board[row][col] = symbol;
		
		this.hasWinner = checkWin(symbol);
		
		
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
			human.isTurn = true;
			return computer.getSymbol();
		}
			
		else if(human.isTurn == true){
			human.isTurn = false;
			computer.isTurn = true;
			return human.getSymbol();
		}
		
		return "";
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
	
	public boolean checkWin(String symbol) {
		
		//first row
		if(board[0][0] == symbol && board[0][1] == symbol && board[0][2] == symbol)
			return true;
		if(board[1][0] == symbol && board[1][1] == symbol && board[1][2] == symbol)
			return true;
		if(board[2][0] == symbol && board[2][1] == symbol && board[2][2] == symbol)
			return true;
		if(board[3][0] == symbol && board[3][1] == symbol && board[3][2] == symbol)
			return true;
		
		//second row
		if(board[0][1] == symbol && board[0][2] == symbol && board[0][3] == symbol)
			return true;
		if(board[1][1] == symbol && board[1][2] == symbol && board[1][3] == symbol)
			return true;
		if(board[2][1] == symbol && board[2][2] == symbol && board[2][3] == symbol)
			return true;
		if(board[3][1] == symbol && board[3][2] == symbol && board[3][3] == symbol)
			return true;
		
		
		//first col
		if(board[0][0] == symbol && board[1][0] == symbol && board[2][0] == symbol)
			return true;
		if(board[0][1] == symbol && board[1][1] == symbol && board[2][1] == symbol)
			return true;
		if(board[0][2] == symbol && board[1][2] == symbol && board[2][2] == symbol)
			return true;
		if(board[0][3] == symbol && board[1][3] == symbol && board[2][3] == symbol)
			return true;
		
		//second col
		if(board[1][0] == symbol && board[2][0] == symbol && board[3][0] == symbol)
			return true;
		if(board[1][1] == symbol && board[2][1] == symbol && board[3][1] == symbol)
			return true;
		if(board[1][2] == symbol && board[2][2] == symbol && board[3][2] == symbol)
			return true;
		if(board[1][3] == symbol && board[2][3] == symbol && board[3][3] == symbol)
			return true;
		
		//first diag 
		if(board[0][1] == symbol && board[1][2] == symbol && board[2][3] == symbol)
			return true;
		if(board[0][0] == symbol && board[1][1] == symbol && board[2][2] == symbol)
			return true;
		if(board[1][0] == symbol && board[2][1] == symbol && board[3][2] == symbol)
			return true;
		if(board[1][1] == symbol && board[2][2] == symbol && board[3][3] == symbol)
			return true;
		
		
		//second diag
		if(board[2][0] == symbol && board[1][1] == symbol && board[0][2] == symbol)
			return true;
		if(board[0][3] == symbol && board[1][2] == symbol && board[2][1] == symbol)
			return true;
		if(board[1][2] == symbol && board[2][1] == symbol && board[3][0] == symbol)
			return true;
		if(board[1][3] == symbol && board[2][2] == symbol && board[3][1] == symbol)
			return true;
		
	
		return false;
	
		
	}
		
	
	public String[][] getBoard(){	
		return this.board;
	}
	
	public void initializeNumbersNotTaken() {
		
		this.numbersLeft.clear();
		
		for(int i = 1;i<=16;i++) {
			this.numbersLeft.add(i);
		}
	}
	public ArrayList<Integer> getnumbersLeft(){
		return this.numbersLeft;
	}
	
}
