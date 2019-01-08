class Solution {
    static int dx[] = {0,-1,1};
    static int dy[] = {-1,1,0};

    private int putValueToBit(int origin, int value, int index) {
        return origin | (value << index);
    }

    private int neighborCount(int[][] board, int x, int y) {
        int res = 0;
        for (int i=0; i<3; i++) {
            for(int j=0; j<3; j++) {
                if (dx[i] == 0 && dy[j] == 0) continue;
                int nx = x + dx[i];
                int ny = y + dy[j];
                if (nx < 0 || ny < 0 || 
                    nx >= board.length || ny >= board[0].length) continue;
                if ((board[nx][ny] & 1) > 0) res++;
            }
        }
        return res;
    }

    public void gameOfLife(int[][] board) {
        for (int i=0; i<board.length; i++) {
            for (int j=0; j<board[i].length; j++) {
                if ((board[i][j] & 1) > 0) {
                    int count = neighborCount(board, i, j);
                    if (count >= 2 && count <= 3) {
                        board[i][j] = putValueToBit(board[i][j], 1, 1);
                    }
                }
                else {
                    int count = neighborCount(board, i, j);
                    if (count == 3) {
                        board[i][j] = putValueToBit(board[i][j], 1, 1);
                    }
                }
            }
        }

        for (int i=0; i<board.length; i++) {
            for (int j=0; j<board[i].length; j++) {
                if ((board[i][j] & 2) > 0)
                    board[i][j] = 1;
                else
                    board[i][j] = 0;
            }
        }
    }
}