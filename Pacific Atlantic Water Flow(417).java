class Solution {
    int[][] directions = {{1,0}, {-1,0}, {0,1}, {0,-1}};
    
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
        
        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];
        
        // DFS from Pacific edges
        for(int i=0;i<m;i++){
            dfs(heights, pacific, i, 0);
            dfs(heights, atlantic, i, n-1);
        }
        for(int j=0;j<n;j++){
            dfs(heights, pacific, 0, j);
            dfs(heights, atlantic, m-1, j);
        }
        
        List<List<Integer>> result = new ArrayList<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(pacific[i][j] && atlantic[i][j]){
                    result.add(Arrays.asList(i,j));
                }
            }
        }
        return result;
    }
    
    private void dfs(int[][] heights, boolean[][] visited, int i, int j){
        if(visited[i][j]) return;
        visited[i][j] = true;
        
        for(int[] dir : directions){
            int ni = i + dir[0];
            int nj = j + dir[1];
            
            if(ni < 0 || nj < 0 || ni >= heights.length || nj >= heights[0].length)
                continue;
            if(heights[ni][nj] < heights[i][j])
                continue;
            
            dfs(heights, visited, ni, nj);
        }
    }
}