public class lc547 {
    int [][] myM;
    int [] visited;

    public int findCircleNum(int[][] M) {
        visited = new int[M.length];
        myM = M;
        int ans = 0;
        for(int i = 0; i < M.length; i++){
            if(visited[i] == 0){
                ans++;
                dfs(i);
            }
        }
        return ans;
    }

    public void dfs(int row){
        for(int i = 0; i < myM[0].length; i++){
            if(myM[row][i] == 1 && visited[i] == 0){
                visited[i] = 1;
                dfs(i);
            }
        }
    }
}
