import java.util.Scanner;

public class TwoDimensional2048 implements TwoDimensional{
    public static void main(String[] args) {
        int[][] b, br, brc;
        int[][] b2;
        int tmp;

        int[][] initb = {
                {0,2,0,0,2},
                {0,2,0,0,0},
                {0,2,0,2,0},
                {0,2,0,2,2},
                {2,0,2,0,0}};
        int[][] lb = {
                {4,0,0,0,0},
                {2,0,0,0,0},
                {4,0,0,0,0},
                {4,2,0,0,0},
                {4,0,0,0,0}};
        int[][] ub = {
                {2,4,2,4,4},
                {0,4,0,0,0},
                {0,0,0,0,0},
                {0,0,0,0,0},
                {0,0,0,0,0}};
        int[][] rb = {
                {0,0,0,0,4},
                {0,0,0,0,2},
                {0,0,0,0,4},
                {0,0,0,2,4},
                {0,0,0,0,4}};
        int[][] db = {
                {0,0,0,0,0},
                {0,0,0,0,0},
                {0,0,0,0,0},
                {0,4,0,0,0},
                {2,4,2,4,4}};
        int[][] multb = {
                {0,0,0,0,0},
                {0,0,0,0,0},
                {0,0,0,0,0},
                {0,0,0,0,4},
                {0,0,0,0,16}};
        int[][] bprerot = {
                {0,0,2,2},
                {0,2,2,0},
                {0,2,0,2},
                {2,0,0,0},
                {0,2,0,2},
                {0,0,0,2},
                {0,0,0,0}};
        int[][] brot1 = {
                {2,0,2,0,2,2,0},
                {2,2,0,0,0,0,0},
                {0,2,2,0,2,0,0},
                {0,0,0,2,0,0,0}};
        int[][] brot3 = {
                {0,0,0,2,0,0,0},
                {0,0,2,0,2,2,0},
                {0,0,0,0,0,2,2},
                {0,2,2,0,2,0,2}};

        // Check the creation of boards, and adding new values
        // to the board.
        
        TwoDimensional2048 T = new TwoDimensional2048();
        b = T.blankBoard(5, 5);
        assert(T.validateBoard(b));

        for (int i = 0 ; i < 10 ; i++) {
        	  T.addNewValue(b);
        	
        }
        
        	assert(T.validateBoard(b));
        	tmp = b[1][4];
        	b[1][4] = 33;
        	assert(!T.validateBoard(b));
        	b[1][4] = tmp;
        	//System.out.println("initb:");
        	//T.printBoard(initb);
        	//System.out.println("b:");
        	//T.printBoard(b);
        	assert(T.identicalBoard(initb, b));

        // Check if the randCoord method works
        brc = T.blankBoard(5, 6);
        // add in some random values
        brc[0][0] = 2;
        brc[1][1] = 2;
        brc[2][2] = 2;
        brc[3][3] = 2;
        brc[4][4] = 2;
        brc[4][5] = 2;
        int[][] coordAnswers = {
                {0, 1},
                {3, 2},
                {2, 0},
                {0, 4}};
        for (int i = 0 ; i < 4 ; i++) {
            int[] coord = T.randCoord(brc, (i * 41)%T.numUnoccupied(brc));
            assert(coord[0] == coordAnswers[i][0] &&
                    coord[1] == coordAnswers[i][1]);
        }

        // Check rotation.
        br = T.blankBoard(7, 4);
        for (int i = 0 ; i < 10 ; i++) {
            T.addNewValue(br);
        }
        assert(T.validateBoard(br));
        assert(T.identicalBoard(br, bprerot));
        br = T.rotateLeft(br);
        assert(T.identicalBoard(br, brot1));
        br = T.rotateLeft(T.rotateLeft(br));
        assert(T.identicalBoard(br, brot3));

        // Check the movement operations.
        b2 = b;
        b = T.left(b2);
        assert(T.identicalBoard(lb, b));
        b = T.up(b2);
        assert(T.identicalBoard(ub, b));
        b = T.right(b2);
        assert(T.identicalBoard(rb, b));
        b = T.down(b2);
        assert(T.identicalBoard(db, b));

        b = b2;
        b = T.left(b);
        b = T.up(b);
        b = T.right(b);
        b = T.down(b);
        b = T.right(b);
        b = T.down(b);
        assert(T.identicalBoard(multb, b));


        // Please add your checks below
        
        System.out.println("Victory!");

    }



///All the return values are set to default. You need to replace it with the correct format.

    public boolean validateBoard(int[][] b){
    	
    	for(int i = 0; i<b.length; i++) {
    	if(OneDimensional2048.validateRow(b[i]) == false) {
    		return false;
    	}
    	
    	}
    	
        return true;
    }
    public int[][] blankBoard(int x, int y) {
    	
    	int [][] blankBoard = new int[x][y];
    	
        return blankBoard;
    }
    public boolean identicalBoard(int[][] a, int[][] b) {
    	
    	if(a.length != b.length) {
    		return false;
    	}
    	if(a[0].length != b[0].length) {
    		return false;
    	}
    	
	    for (int i = 0; i < a.length; i++) {
	        for (int j = 0; j < a[i].length; j++) {
	            if(a[i][j] != b[i][j]) {
	            	return false;
	        }
	    }
    	}
        return true;
    }
    public int numUnoccupied(int[][] b) {
    	
    	int numof0 = 0;
	    for (int i = 0; i < b.length; i++) {
	        for (int j = 0; j < b[i].length; j++) {
	            if(b[i][j] == 0) {
	            	numof0++;
	        }
	    }
	}
    	
        return numof0;
    }
    public int[] randCoord(int[][] b, int offset) {
    	int counter = 0;
		
	    for (int i = 0; i < b.length; i++) {
	        for (int j = 0; j < b[i].length; j++) {
	            if(b[i][j] == 0) {
	        		if(counter == offset) {
	        			return new int[] {i,j};
	        		}
	            counter++;
	        		}
	            }
	        }
        return new int[]{0, 0};
    }
    
    public boolean addNewValue(int[][] b) {
    	
    	int randVal = Rnd2048.randValue();
    	int offset = Rnd2048.randNum(numUnoccupied(b));
    	int[] value = randCoord(b,offset);
    	int x = value[0];
    	int y = value[1];
    	b[x][y]= randVal;
    	
    	
        return true;
    }
    public int[][] combineLeft(int[][] b) {
    	
    	int [][] combineBoard = copyBoard(b);
    	for(int i = 0; i<combineBoard.length; i++) {
    		OneDimensional2048.combineLeft(combineBoard[i]);
    	}
    	
    	
        return combineBoard;
    }
    public int[][] rotateLeft(int[][] b) {
    	
    	int [][] combineBoard = copyBoard(b);		
		    	
		    	int rowLength = combineBoard[0].length;
		    	int x = 0;
		    	int [] values = new int[combineBoard.length * combineBoard[0].length];
		    	
			    for (int i = 0; i < combineBoard.length; i++) {
			        for (int j = 0; j < combineBoard[i].length; j++) {
			        	values[x] = combineBoard[i][j];
			        	x++;
			        }
			    }
			    
			    
			    int[] valSort = new int[values.length];
			    int k = 0;
			    k = rowLength-1;
			    int reg = rowLength-1;
			    
			    for(int i = 0; i<valSort.length; i++) {
			    	
			    	valSort[i] = values[k];
			    	
			    	if(k+rowLength>=values.length) {
			    		reg = reg - 1;
			    		k = reg;
			    	}
			    	else {
			    	k=k+rowLength;
			    	}
			    				
			    }
	
			    int[][] newBoard = new int[combineBoard[0].length][combineBoard.length];
				
			    int y = 0;
			    for (int i = 0; i < newBoard.length; i++) {
			        for (int j = 0; j < newBoard[i].length; j++) {
			        	newBoard[i][j] = valSort[y];
			        	y++;
			        }
			    }
			    
        return newBoard;
    }
    public int[][] left(int[][] b) {
    	int [][] combineBoard = copyBoard(b);
    	
    	combineBoard = combineLeft(combineBoard);
    	
        return combineBoard;
    }
    public int[][] right(int[][] b) {
    	
    	int [][] combineBoard = copyBoard(b);	
    	
    	combineBoard = rotateLeft(combineBoard);
    	combineBoard = rotateLeft(combineBoard);
    	combineBoard = combineLeft(combineBoard);
    	combineBoard = rotateLeft(combineBoard);
    	combineBoard = rotateLeft(combineBoard);
    	
    	
        return combineBoard;
    }
    public int[][] up(int[][] b) {
    	int [][] combineBoard = copyBoard(b);	
    	
    	combineBoard = rotateLeft(combineBoard);
    	combineBoard = combineLeft(combineBoard);
    	combineBoard = rotateLeft(combineBoard);
    	combineBoard = rotateLeft(combineBoard);
    	combineBoard = rotateLeft(combineBoard);
    	
        return combineBoard;
    }
    public int[][] down(int[][] b) {
    	int [][] combineBoard = copyBoard(b);	
    	
    	combineBoard = rotateLeft(combineBoard);
    	combineBoard = rotateLeft(combineBoard);
    	combineBoard = rotateLeft(combineBoard);
    	combineBoard = combineLeft(combineBoard);
    	combineBoard = rotateLeft(combineBoard);
    	
        return combineBoard;
    }

    ////////////////////////optional methods
    public int numMax(int[][] b){
        return 0;
    }
    public int numOccupied(int[][] b){
        return 0;
    }
    public boolean addValue(int[][] b, int x, int y,int val){
        return true;
    }
    public int[][] copyBoard(int[][] b){
    	
    	int[][] newBoard = new int[b.length][b[0].length];
    	
	    for (int i = 0; i < b.length; i++) {
	        for (int j = 0; j < b[i].length; j++) {
	        	newBoard[i][j] = b[i][j];
	        }
	    }
        return newBoard;
    }
    public void printBoard(int[][] b){
		
	    for (int i = 0; i < b.length; i++) {
	        for (int j = 0; j < b[i].length; j++) {
	            System.out.print(b[i][j]+"   ");
	        }
	        System.out.println();
	    }

    }
}