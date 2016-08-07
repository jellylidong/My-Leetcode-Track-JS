public class TicTacToe {

    /** Initialize your data structure here. */
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
        rowSum[row] += player == 1? -1:1;
        colSum[col] += player == 1? -1:1;
        if(row == col)
            diag += player == 1? -1:1;
        if(row == len-1-col)
            anti_diag += player == 1? -1:1;
        
        if(player == 1){
            if(rowSum[row] == -len || colSum[col] == -len ||
             (row == col && diag == -len) || (row == len-1-col && anti_diag == -len))
                return player;
        }
        if(player == 2){
            if(rowSum[row] == len || colSum[col] == len ||
             (row == col && diag == len) || (row == len-1-col && anti_diag == len))
                return player;
        }
        return 0;
    }
}

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */