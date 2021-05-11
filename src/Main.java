import java.util.*;
public class Main {
	
	private static Board board;
	
	public static void main(String[] args) {
		
		int option;
		
		Scanner scanner = new Scanner(System.in);
		
		board = new Board();
		
	
		
		do {
			board.startGame();
			System.out.println("Play again?");
			System.out.println("[1] Yes");
			System.out.println("[2] No");
			System.out.print("Option: ");
			option = scanner.nextInt();
			System.out.println(option);
		}while(option == 1);
	}
}
