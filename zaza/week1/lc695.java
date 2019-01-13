public class lc695 {
    int [][] visited;
    int [][] myGrid;
    public int maxAreaOfIsland(int[][] grid) {
        myGrid = grid;
        visited = new int[grid.length][grid[0].length];
        int ans = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                ans = Math.max(dfs(i,j), ans);
            }
        }
        return ans;
    }

    public int dfs(int row, int col){
        if(row < 0 || col < 0 || row >= myGrid.length || col >= myGrid[0].length)
            return 0;
        if(visited[row][col] == 1 || myGrid[row][col] == 0)
            return 0;
        visited[row][col] = 1;
        return (1 + dfs(row+1, col) + dfs(row-1, col) + dfs(row, col+1) + dfs(row, col-1));
    }
}
