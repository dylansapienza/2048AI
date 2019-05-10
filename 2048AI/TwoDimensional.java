public interface TwoDimensional {
    boolean validateBoard(int[][] b);
    public int[][] blankBoard(int x, int y);
    public boolean identicalBoard(int[][] a, int[][] b);
    public int numUnoccupied(int[][] b);
    public int[] randCoord(int[][] b, int offset);
    public boolean addNewValue(int[][] b);
    public int[][] combineLeft(int[][] b);
    public int[][] rotateLeft(int[][] b);
    public int[][] left(int[][] b);
    public int[][] right(int[][] b);
    public int[][] up(int[][] b);
    public int[][] down(int[][] b);
}
