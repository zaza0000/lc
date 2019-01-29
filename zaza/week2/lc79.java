public class lc79 {
    public boolean exist(char[][] board, String word) {
        if(word == null || board == null)
            return false;
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(dfs(board, word, 0, i, j) == true)
                    return true;
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, String word, int index, int row, int col){
        if(board[row][col] != word.charAt(index))
            return false;
        if(index == word.length() -1)
            return true;
        char temp = board[row][col];
        board[row][col] = '*';
        int[] dx = {0, 0, -1, 1};
        int[] dy = {1, -1, 0, 0};
        for(int i = 0; i < 4; i++){
            int x = row + dx[i];
            int y = col + dy[i];
            if(x >= 0 && y >= 0 && x < board.length && y < board[0].length)
                if(dfs(board, word, index+1, x, y) == true)
                    return true;
        }
        board[row][col] = temp;
        return false;
    }
}
