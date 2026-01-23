class Solution {
    public void solve(char[][] board) {
        int m=board.length;
        int n=board[0].length;

        //visited matrix to mark all 'O's connected to the boundary
        boolean[][] vis=new boolean[m][n];

        //1.DFS from first/Last columns
        for(int i=0;i<m;i++){
            if(board[i][0]=='O' && vis[i][0]==false){
                dfs(i,0,board,vis);
            }
            if(board[i][n-1]=='O'&& vis[i][n-1]==false){
                dfs(i,n-1,board,vis);
            }
        }

        //2. DFS from first/last rows
        for(int j=0;j<n;j++){
            if(board[0][j]=='O'&& vis[0][j]==false){
                dfs(0,j,board,vis);
            }
             if(board[m-1][j]=='O'&& vis[m-1][j]==false){
                dfs(m-1,j,board,vis);
            }
        }

        //3.Flip Surrounded 'Os'
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                 // Flip 'O' if it's not marked as visited (i.e., not connected to border)
                 if(board[i][j]=='O'&& vis[i][j]==false){
                    board[i][j]='X';
                 }
            }
        }

    }

    public void dfs(int i,int j,char[][] board,boolean[][] vis){
         int m=board.length;
        int n=board[0].length;
        // Base case: out of bounds, already visited, or 'X'
        if(i<0 || j<0 || i>=m || j>=n || vis[i][j] == true || board[i][j] == 'X'){
            return;
        }
        vis[i][j]=true;
          // DFS in all 4 directions
        dfs(i+1,j,board,vis);
        dfs(i,j+1,board,vis);
        dfs(i-1,j,board,vis);
        dfs(i,j-1,board,vis);

    }
}


/**
 * //Optimized Approach without extra space- DFS Inplace

class Solution {
    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;

        // DFS from first & last column
        for(int i = 0; i < m; i++) {
            if(board[i][0] == 'O') dfs(i, 0, board);
            if(board[i][n-1] == 'O') dfs(i, n-1, board);
        }

        // DFS from first & last row
        for(int j = 0; j < n; j++) {
            if(board[0][j] == 'O') dfs(0, j, board);
            if(board[m-1][j] == 'O') dfs(m-1, j, board);
        }

        // Final conversion
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(board[i][j] == 'O') board[i][j] = 'X'; // surrounded
                else if(board[i][j] == '#') board[i][j] = 'O'; // safe
            }
        }
    }

    private void dfs(int i, int j, char[][] board) {
        int m = board.length;
        int n = board[0].length;

        if(i < 0 || j < 0 || i >= m || j >= n || board[i][j] != 'O') {
            return;
        }

        board[i][j] = '#'; // mark as safe

        dfs(i+1, j, board);
        dfs(i-1, j, board);
        dfs(i, j+1, board);
        dfs(i, j-1, board);
    }
}

 * 
 */

//BFs Approach Queue based inplace
/**import java.util.*;

class Solution {
    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;

        Queue<int[]> q = new LinkedList<>();

        // 1️⃣ Push all boundary 'O's into queue
        for (int i = 0; i < m; i++) {
            if (board[i][0] == 'O') {
                q.offer(new int[]{i, 0});
                board[i][0] = '#';
            }
            if (board[i][n - 1] == 'O') {
                q.offer(new int[]{i, n - 1});
                board[i][n - 1] = '#';
            }
        }

        for (int j = 0; j < n; j++) {
            if (board[0][j] == 'O') {
                q.offer(new int[]{0, j});
                board[0][j] = '#';
            }
            if (board[m - 1][j] == 'O') {
                q.offer(new int[]{m - 1, j});
                board[m - 1][j] = '#';
            }
        }

        // 2️⃣ BFS to mark all connected 'O's
        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};

        while (!q.isEmpty()) {
            int[] cell = q.poll();
            int r = cell[0];
            int c = cell[1];

            for (int[] d : dirs) {
                int nr = r + d[0];
                int nc = c + d[1];

                if (nr >= 0 && nc >= 0 && nr < m && nc < n && board[nr][nc] == 'O') {
                    board[nr][nc] = '#';
                    q.offer(new int[]{nr, nc});
                }
            }
        }

        // 3️⃣ Final conversion
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O') board[i][j] = 'X';
                else if (board[i][j] == '#') board[i][j] = 'O';
            }
        }
    }
}
*/
