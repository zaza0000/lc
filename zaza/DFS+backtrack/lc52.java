package DFSandBacktrack;

public class lc52 {
    boolean[] col;
    boolean[] diagonal1;
    boolean[] diagonal2;
    int sum = 0;
    public int totalNQueens(int n) {
        if(n <= 1)
            return n;
        col = new boolean[n];
        diagonal1 = new boolean[n*2-1];
        diagonal2 = new boolean[n*2-1];
        backtrack(0, n);

        return sum;
    }

    private void backtrack(int index, int size) {
        if (index == size)
            sum++;
        for(int c = 0; c < size; c++) {
            if(col[c] != true && diagonal1[index-c+size-1] != true && diagonal2[index+c] != true){
                col[c] = true;
                diagonal1[index-c+size-1] = true;
                diagonal2[index+c] = true;
                backtrack(index+1, size);
                col[c] = false;
                diagonal1[index-c+size-1] = false;
                diagonal2[index+c] = false;
            }
        }
    }
}
