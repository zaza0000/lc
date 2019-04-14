public class lc289 {
    public void gameOfLife(int[][] board) {
        int r = board.length;
        int c = board[0].length;
        for(int i = 0; i < r; i++){
            for(int j = 0; j < c; j++){
                if(board[i][j] == 0){
                    int lives = getNeighborLives(i, j, board);
                    if(lives == 3)
                        board[i][j] = 2;
                    else
                        board[i][j] = 0;
                }
                else{
                    int lives = getNeighborLives(i, j, board);
                    if(lives == 2 || lives == 3)
                        board[i][j] = 3;
                    else
                        board[i][j] = 1;
                }
            }
        }
        for(int i = 0; i < r; i++){
            for(int j = 0; j < c; j++){
                if(board[i][j] > 1)
                    board[i][j] = 1;
                else
                    board[i][j] = 0;
            }
        }
    }

    public int getNeighborLives(int row, int col, int[][] board){
        int num = -board[row][col];
        int dir[] = {0, 1,-1};
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                int temp_r = row + dir[i];
                int temp_c = col + dir[j];
                if(temp_r >= 0 && temp_c >= 0 && temp_r < board.length && temp_c < board[0].length){
                    if(board[temp_r][temp_c]%2 == 1)
                        num += 1;
                }
            }
        }
        return num;
    }
}
