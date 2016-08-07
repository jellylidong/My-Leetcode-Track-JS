public class TicTacToe {

    /** Initialize your data structure here. */
    //when we want to know numbers in a row, col, diagnal or anti_diagnal are the same
    //instead of check numbers one by one
    //we can check their sum
    int[] rowSum;
    int[] colSum;
    int diag, anti_diag;
    int len;
    public TicTacToe(int n) {
        rowSum = new int[n];
        colSum = new int[n];
        diag = 0;
        anti_diag = 0;
        len = n;
    }
    
    /** Player {player} makes a move at ({row}, {col}).
        @param row The row of the board.
        @param col The column of the board.
        @param player The player, can be either 1 or 2.
        @return The current winning condition, can be either:
                0: No one wins.
                1: Player 1 wins.
                2: Player 2 wins. */
    public int move(int row, int col, int player) {
        int toAdd = player == 1? -1:1;
        rowSum[row] += toAdd;
        if(Math.abs(rowSum[row]) == len)    return player;
        
        colSum[col] += toAdd;
        if(Math.abs(colSum[col]) == len)    return player;
        if(row == col){
            diag += toAdd;
            if(Math.abs(diag) == len)   return player;
        }
        if(row == len-1-col){
            anti_diag += toAdd;
            if(Math.abs(anti_diag) == len)  return player;
        }
        
        
        return 0;
    }
}

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */