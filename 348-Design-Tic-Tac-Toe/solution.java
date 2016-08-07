public class TicTacToe {

    /** Initialize your data structure here. */
    int[][] grid;
    public TicTacToe(int n) {
        grid = new int[n][n];
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
        grid[row][col] = player;
        // for(int i = 0; i < 3; i++){
        //     for(int j = 0; j < 3; j++)
        //         System.out.print(grid[i][j] + " ");
        //     System.out.println();
        // }
        if(check(row, col, player))
            return player;
        else
            return 0;
    }
    
    public boolean check(int row, int col, int player){
        boolean win = false;
        int i = 0;
        for(i = 0; i < grid[0].length; i++){
            if(grid[row][i] != player){  
                break;
            }
        }
        win = win || (i == grid.length);
        if(!win){
            for(i = 0; i < grid.length; i++){
                if(grid[i][col] != player){
                    break;
                }
            }
            win = win || (i == grid.length);
        }
        if(!win && row == col){
            for(i = 0; i < grid.length; i++){
                if(grid[i][i] != player){
                    break;
                }
            }
            win = win || (i == grid.length);
        }
        if(!win && row == grid.length-col-1){
            for(i = 0; i < grid.length; i++){
                if(grid[i][grid.length-1-i] != player){
                    break;
                }
            }
            win = win || (i == grid.length);
        }
        return win;
    }
}

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */