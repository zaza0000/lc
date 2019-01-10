class Solution {
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};

    class Position {
        int x;
        int y;
        Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private int bfs(int si, int sj, int[][] grid) {
        int res = 0;
        Queue<Position> queue = new LinkedList<>();
        queue.add(new Position(si, sj));
        grid[si][sj] = 0;
        while(!queue.isEmpty()) {
            int x = queue.peek().x;
            int y = queue.peek().y;
            queue.remove();
            res++;
            for (int i=0; i<4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx < 0 || ny < 0 || nx >= grid.length || ny >= grid[0].length) continue;
                if (grid[nx][ny] == 1) {
                    queue.add(new Position(nx, ny));
                    grid[nx][ny] = 0;
                }
            }
        }
        return res;
    }

    public int maxAreaOfIsland(int[][] grid) {
        int ans = 0;
        for (int i=0; i<grid.length; i++) {
            for (int j=0; j<grid[i].length; j++) {
                if (grid[i][j] == 0) continue;
                ans = Math.max(ans, bfs(i, j, grid));
            }
        }

        return ans;
    }
}