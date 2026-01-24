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