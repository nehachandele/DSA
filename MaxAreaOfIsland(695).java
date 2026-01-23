class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int max_area=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1){
                    max_area=Math.max(max_area,AreaOfIsland(grid,i,j));

                }
            }
        }
        return max_area;
    }
    public int AreaOfIsland(int[][] grid,int i,int j){
         if( i >= 0 && i < grid.length && j >= 0 && j < grid[0].length && grid[i][j] == 1){
            grid[i][j]=0;
             return 1 + AreaOfIsland(grid, i+1, j) + AreaOfIsland(grid, i-1, j) + AreaOfIsland(grid, i, j-1) + AreaOfIsland(grid, i, j+1);
         }
         return 0;
    }

}

/**
 *  //BFS Alternative Optimized Solution

class Solution {
    public int maxAreaOfIsland(int[][] grid) {

        int maxArea = 0;
        int rows = grid.length;
        int cols = grid[0].length;

        int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {

                if (grid[i][j] == 1) {
                    maxArea = Math.max(maxArea, bfs(grid, i, j, dir));
                }
            }
        }
        return maxArea;
    }

  
    private int bfs(int[][] grid, int sr, int sc, int[][] dir) {

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{sr, sc});
        grid[sr][sc] = 0;

        int area = 0;

        while (!q.isEmpty()) {
            int[] cell = q.poll();
            area++;

            for (int[] d : dir) {
                int r = cell[0] + d[0];
                int c = cell[1] + d[1];

                if (r >= 0 && c >= 0 &&
                    r < grid.length && c < grid[0].length &&
                    grid[r][c] == 1) {

                    grid[r][c] = 0;
                    q.offer(new int[]{r, c});
                }
            }
        }
        return area;
    }
}

 */

/**
 * //Option 3: Optimized Approach
 *✅ Iterative DFS Code
class Solution {
    public int maxAreaOfIsland(int[][] grid) {

        int maxArea = 0;
        int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {

                if (grid[i][j] == 1) {
                    maxArea = Math.max(maxArea, dfsIterative(grid, i, j, dir));
                }
            }
        }
        return maxArea;
    }

    private int dfsIterative(int[][] grid, int sr, int sc, int[][] dir) {

        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{sr, sc});
        grid[sr][sc] = 0;

        int area = 0;

        while (!stack.isEmpty()) {
            int[] cell = stack.pop();
            area++;

            for (int[] d : dir) {
                int r = cell[0] + d[0];
                int c = cell[1] + d[1];

                if (r >= 0 && c >= 0 &&
                    r < grid.length && c < grid[0].length &&
                    grid[r][c] == 1) {

                    grid[r][c] = 0;
                    stack.push(new int[]{r, c});
                }
            }
        }
        return area;
    }
}

 
 * 
 */

