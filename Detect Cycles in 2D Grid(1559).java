class Solution {
    int count=0;
    public boolean dfs(char[][] grid,int i,int j,int[][] visited,int previ,int prevj,char c){
        if(i<0 || j<0 || i>=grid.length || j>=grid[0].length || grid[i][j]!=c)
            return false;
        if(visited[i][j]-visited[previ][prevj]>=3)
            return true;
        if(visited[i][j]!=0)
            return false;
        visited[i][j]=count++;
        return dfs(grid,i+1,j,visited,i,j,c) ||dfs(grid,i-1,j,visited,i,j,c) || dfs(grid,i,j+1,visited,i,j,c) || dfs(grid,i,j-1,visited,i,j,c);
        
    }
 
    public boolean containsCycle(char[][] grid) {
        int n=grid.length,m=grid[0].length;
        int[][] visited=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(visited[i][j]==0 && dfs(grid,i,j,visited,i,j,grid[i][j]))
                    return true;
            }
        }
        return false;
    }
}

/**
 * Optimal Approach- DFS
 * class Solution {
    int n, m;
    boolean[][] visited;
    int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};

    public boolean dfs(char[][] grid, int r, int c, int pr, int pc) {
        visited[r][c] = true;

        for (int[] d : dir) {
            int nr = r + d[0];
            int nc = c + d[1];

            if (nr < 0 || nc < 0 || nr >= n || nc >= m)
                continue;
            if (grid[nr][nc] != grid[r][c])
                continue;

            if (visited[nr][nc]) {
                if (!(nr == pr && nc == pc))
                    return true;
            } else {
                if (dfs(grid, nr, nc, r, c))
                    return true;
            }
        }
        return false;
    }

    public boolean containsCycle(char[][] grid) {
        n = grid.length;
        m = grid[0].length;
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j]) {
                    if (dfs(grid, i, j, -1, -1))
                        return true;
                }
            }
        }
        return false;
    }
}

 * 
 */