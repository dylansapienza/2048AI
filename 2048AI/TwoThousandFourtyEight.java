class TwoThousandFourtyEight implements TwoThousandFourtyEightInt{
   //fields
	
	public int BoardID;
	private int[][] board;
	private static int currentFreeID = 0;

   TwoThousandFourtyEight(int x, int y) {
   // Constructor
	   this.board = new int[x][y];
	   TwoDimensional2048 T = new TwoDimensional2048();
	   T.addNewValue(board);
	   //BoardID = currentFreeID++;
   }

   TwoThousandFourtyEight(int[][] b) {
   // Constructor

   }

   public int[][] getBoard() {
	   
   	int[][] copy = this.board;
	
      return copy;
   }


   public int getHighestTile() {
	   
	   int currHigh = 0;
	   
	    for (int i = 0; i < this.board.length; i++) {
	        for (int j = 0; j < this.board[i].length; j++) {
	            if(this.board[i][j] > currHigh) {
	            	currHigh = this.board[i][j];
	            }
	        }
	    }
      return currHigh;
   }
      
    public int[] getHighestTileLoc() {
   	   
   	 int currHigh = 0;
   	 int x = 0;
   	 int y = 0;
   	 int [] location = new int[2];
   	   
   	  for (int i = 0; i < this.board.length; i++) {
   	      for (int j = 0; j < this.board[i].length; j++) {
   	          if(this.board[i][j] > currHigh) {
   	        	  currHigh = this.board[i][j];
   	        	  	x = i;
   	        	  	y = j;
   	           }
   	       }
   	  }
   	  	location[0] = x;
   	  	location[1] = y;
   	  	
   	  	return location;
      
   }

   public int getScore() {
	   
	   int score = 0;
	   int temptile = 0;
	    for (int i = 0; i < this.board.length; i++) {
	        for (int j = 0; j < this.board[i].length; j++) {
	            if(this.board[i][j] != 0) {
	            	temptile = this.board[i][j];
	            	
	            	while(temptile>1) {
	            		score =score + temptile;
	            		temptile = temptile/2;
	            		
	            	}
	        }
	    }
    	}
      return score;
   }

   public void printBoard() {
   }

    public TwoThousandFourtyEight copy() {
    	TwoDimensional2048 T = new TwoDimensional2048();	
    	TwoThousandFourtyEight copy = new TwoThousandFourtyEight(board);
    	copy.board = T.copyBoard(this.board);
    	
    	return copy;
   }


    //up action on board
    
    public boolean fullBoard() {
    	TwoDimensional2048 T = new TwoDimensional2048();
    	
    	if(T.numUnoccupied(this.board) == 0) {
    		return false;
    	}
    	
      return true;
   }
    
    public boolean up() {
    	TwoDimensional2048 T = new TwoDimensional2048();
    	
    	if(T.numUnoccupied(this.board) == 0) {
    		return false;
    	}
    	
    	this.board = T.up(this.board);
    	T.addNewValue(this.board);
    	
      return true;
   }

    //down action on board
    public boolean down() {
    	
    	TwoDimensional2048 T = new TwoDimensional2048();
    	
    	if(T.numUnoccupied(this.board) == 0) {
    		return false;
    	}
    	
    	this.board = T.down(this.board);
    	T.addNewValue(this.board);
    	
      return true;
   }

     //left action on board
    public boolean left() {
    	
    	TwoDimensional2048 T = new TwoDimensional2048();
    	
    	if(T.numUnoccupied(this.board) == 0) {
    		return false;
    	}    	
    	
    	this.board = T.left(this.board);
    	T.addNewValue(this.board);
    	
      return true;
   }

     //right action on board
    public boolean right() {
    	
    	TwoDimensional2048 T = new TwoDimensional2048();
    	
    	if(T.numUnoccupied(this.board) == 0) {
    		return false;
    	}
    	
    	this.board = T.right(this.board);
    	T.addNewValue(this.board);
    	
      return true;
   }
}
