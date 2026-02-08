import java.util.*;
class Solution {   
    public int[][] updateMatrix(int[][] mat) {
        int m=mat.length;
        int n=mat[0].length;
        int dir[][]={{-1,0},{0,1},{1,0},{0,-1}};
        int ans[][]= new int[m][n];
        boolean visited[][]= new boolean[m][n];
        Queue<int[]> q= new ArrayDeque<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(mat[i][j]==0){
                    q.add(new int[]{i,j});
                    visited[i][j]=true;
               }
            }
        }

        while(!q.isEmpty()){
            int[] arr=q.remove();
            for(int i=0;i<4;i++){
               int row=arr[0]+dir[i][0];
               int column=arr[1]+dir[i][1];
                if(row>=0 && row<m && column>=0 && column<n && !visited[row][column]){
                    ans[row][column]=ans[arr[0]][arr[1]]+1;
                    q.add(new int[]{row,column});
                    visited[row][column]=true;
                } 
            }
        }
    return ans;
    }
}