
public class Board {
	
	private Human human;
	private Computer computer;
	
	
	public Board() {
		this.human = new Human("X");
		this.computer = new Computer("O");
	}
	
	public void drawBoard() {
		System.out.println("-----------------");
		
		for(int i =0;i<4;i++) {
			System.out.print("| ");
			for( int j = 0;j<4;j++) {
				System.out.print("-" + " | ");
			}
			
			System.out.println();
			System.out.println("-----------------");
		}
		
		
		
	}
	
	
	
}
