public class Ai2048 {
	static void playLeft(TwoThousandFourtyEight board) {
		while (board.left()) {
			// loop until the board is full!
		}
	}

	static void playRandom(TwoThousandFourtyEight board) {
		while(board.fullBoard()) {
			int choice = 0;
			choice = Rnd2048.randNum(3);
			switch(choice) {
		
			case 0:
				board.left();
				break;
			case 1:
				board.right();
				break;
			case 2:
				board.up();
				break;
			case 3:
				board.down();
				break;
		}
		
		}
	}

	static void playAI(TwoThousandFourtyEight board) {

		int [] highestTile = {};
		int [] topLeft = {0,0};
		int [] topRight = {3,0};
		int [] botLeft = {0,3};
		int [] botRight = {3,3};
		
		while(board.fullBoard()) {
			
			highestTile = board.getHighestTileLoc();
			
		
		while(highestTile[0] == topLeft[0] && highestTile[1] == topLeft[1] && board.fullBoard()) {
				
			board.up();
			board.right();
			board.up();
			board.left();
				

		}
			
		while(highestTile[0] == topRight[0] && highestTile[1] == topRight[1] && board.fullBoard()) {
					
			board.up();
			board.left();
			board.up();
			board.right();

			}
		
		while(highestTile[0] == botLeft[0] && highestTile[1] == botLeft[1] && board.fullBoard()) {
					
			board.down();
			board.left();
			board.down();
			board.right();

		}
		
		while(highestTile[0] == botRight[0] && highestTile[1] == botRight[1] && board.fullBoard()) {
					
			board.down();
			board.right();
			board.down();
			board.left();
		}	
		
		while(board.fullBoard()) {
			
			board.up();
			board.right();
			board.up();
			board.left();
			

			
			}
		}
	}
	
}