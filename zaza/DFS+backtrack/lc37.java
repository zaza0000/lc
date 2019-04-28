package DFSandBacktrack;

public class lc37 {
    class Solution {
        boolean[][] row;
        boolean[][] col;
        boolean[][] block;
        public void solveSudoku(char[][] board) {
            row = new boolean[9][9];
            col = new boolean[9][9];
            block = new boolean[9][9];
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    char num = board[i][j];
                    if (num != '.') {
                        int numInt = Character.getNumericValue(num);
                        row[i][numInt-1] = true;
                        col[j][numInt-1] = true;
                        block[(i/3)*3+j/3][numInt-1] = true;
                    }
                }
            }
            backtrack(board, 0, 0);
        }

        private boolean backtrack(char[][] board, int r, int c) {
            //System.out.println(r+" "+c);
            if(r == 9)
                return true;
            if (board[r][c] != '.'){
                if(c == 8)
                    return backtrack(board, r+1, 0);
                else
                    return backtrack(board, r, c+1);
            } else {
                for (int index = 0; index < 9; index++) {
                    if(!checkValid(index, r, c))
                        continue;
                    row[r][index] = true;
                    col[c][index] = true;
                    block[(r/3)*3+c/3][index] = true;
                    board[r][c] = (char)(index + '1');
                    boolean flag;
                    if (c == 8)
                        flag = backtrack(board, r+1, 0);
                    else
                        flag = backtrack(board, r, c+1);
                    if(flag == true)
                        return true;
                    row[r][index] = false;
                    col[c][index] = false;
                    block[(r/3)*3+c/3][index] = false;
                    board[r][c] = '.';
                }
            }
            return false;
        }

        private boolean checkValid(int num, int r, int c) {
            if (row[r][num] == false && col[c][num] == false && block[(r/3)*3+c/3][num] == false)
                return true;
            return false;
        }
    }
}
