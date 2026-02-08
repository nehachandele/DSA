class Solution {
    public int numIslands(char[][] grid) {
        if(grid ==null || grid.length==0){
            return 0;
        }
        int numIslands=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]=='1'){
                    numIslands++;
                    dfs(grid,i,j);
                }
            }
        }
        return numIslands;
    }
    private void dfs(char[][] grid,int i,int j){
        if(i<0 || i>= grid.length || j<0||j>=grid[0].length || grid[i][j]!='1'){
            return;
        }
        grid[i][j]='0';//Mark as Visited
        dfs(grid,i+1,j);//down
        dfs(grid,i-1,j);//up
        dfs(grid,i,j+1);//right
        dfs(grid,i,j-1);//left


    }
}
/* 
class Solution {
    public int numIslands(char[][] grid) {
        int islands = 0;
        int rows = grid.length;
        int cols = grid[0].length;

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == '1') {
                    islands++;
                    bfs(grid, r, c, rows, cols);
                }
            }
        }

        return islands;        
    }

    private void bfs(char[][] grid, int r, int c, int rows, int cols) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{r, c});
        grid[r][c] = '0';

        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        while (!q.isEmpty()) {
            int[] point = q.poll();
            int row = point[0], col = point[1];

            for (int[] direction : directions) {
                int nr = row + direction[0];
                int nc = col + direction[1];
                if (nr >= 0 && nr < rows && nc >= 0 && nc < cols && grid[nr][nc] == '1') {
                    q.add(new int[]{nr, nc});
                    grid[nr][nc] = '0';
                }
            }
        }
    }    
}*/