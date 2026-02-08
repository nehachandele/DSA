import java.util.*;
import java.lang.*;
class Solution {
    public int orangesRotting(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int ans=0;

        boolean[][] visited=new boolean[n][m];
        Queue<int[]> q=new LinkedList<>();

        //we are pushing all sourses in queue 
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==2){
                    q.add(new int[]{i,j,0});
                    visited[i][j]=true; 
                }
               
            }
        }
        //bfs
        while(!q.isEmpty()){
            int [] arr=q.remove();
            int i=arr[0];
            int j=arr[1];
            int time=arr[2];
            ans=Math.max(ans,time);

            //top
            if(i-1>=0&& grid[i-1][j]==1&& !visited[i-1][j]){
                q.add(new int[]{i-1,j,time+1});
                visited[i-1][j]=true;
            }
            //bottom
            if(i+1<n&& grid[i+1][j]==1&& !visited[i+1][j]){
                q.add(new int[]{i+1,j,time+1});
                visited[i+1][j]=true;
            }
            //left
            if(j-1 >= 0 && grid[i][j-1] == 1 && !visited[i][j-1]){
                q.add(new int[]{i, j-1, time+1});
                visited[i][j-1] = true;
            }
             //right
            if(j+1 <m && grid[i][j+1] == 1 && !visited[i][j+1]){
                q.add(new int[]{i, j+1, time+1});
                visited[i][j+1] = true;
            }

        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(!visited[i][j]&& grid[i][j]==1){
                    return -1;
                }
            }
        }
        return ans;
    }
}

/* 
class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        
        // Start DFS from all initially rotten oranges
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    dfs(grid, i, j, m, n, 2);
                }
            }
        }

        int minutes = 2;
        // Find the maximum time and check if any fresh orange remains
        for (int[] row : grid) {
            for (int cell : row) {
                if (cell == 1) return -1; // Fresh orange not reached
                minutes = Math.max(minutes, cell);
            }
        }
        return minutes - 2; // Subtract initial offset
    }

    private void dfs(int[][] grid, int i, int j, int m, int n, int min) {
        // Boundary + stop conditions
        if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] == 0 || (grid[i][j] > 1 && grid[i][j] < min)) 
            return;

        grid[i][j] = min; // Mark current cell with time it rotted

        // Spread rot in all 4 directions
        dfs(grid, i - 1, j, m, n, min + 1);
        dfs(grid, i + 1, j, m, n, min + 1);
        dfs(grid, i, j - 1, m, n, min + 1);
        dfs(grid, i, j + 1, m, n, min + 1);
    }
}*/