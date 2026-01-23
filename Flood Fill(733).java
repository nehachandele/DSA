import java.util.*;
class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        //Avoid infinite loop if the new and old colors are the same 
        if(image[sr][sc]==color) return image;
        //Run the fill function starting at the position gives..
        fill(image,sr,sc,color,image[sr][sc]);
        return image;
    }
    public void fill(int[][] image,int sr,int sc,int color,int cur){
          // If sr is less than 0 or greater equals to the length of image...
        // Or, If sc is less than 0 or greater equals to the length of image[0]...
        if(sr<0 ||sr>=image.length || sc<0|| sc>=image[0].length) return ;

        //if image[sr][sc] is not equal to prev color
        if(cur!=image[sr][sc])return ;
        //Update the image[sr][sc] as a color
        image[sr][sc]=color;

        //make four recusrive calls to the function with (sr-1,sc).(sr+1,sc),(sr,sc-1),(sr,sc+1)..
        fill(image,sr-1,sc,color,cur);
        fill(image,sr+1,sc,color,cur);
        fill(image,sr,sc-1,color,cur);
        fill(image,sr,sc+1,color,cur);
    }
}

/***
 *Optimized BFS Solution
class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {

        int oldColor = image[sr][sc];
        if (oldColor == color) return image;

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{sr, sc});
        image[sr][sc] = color;

        int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};

        while (!q.isEmpty()) {
            int[] cell = q.poll();

            for (int[] d : dir) {
                int r = cell[0] + d[0];
                int c = cell[1] + d[1];

                if (r >= 0 && c >= 0 &&
                    r < image.length && c < image[0].length &&
                    image[r][c] == oldColor) {

                    image[r][c] = color;
                    q.offer(new int[]{r, c});
                }
            }
        }
        return image;
    }
}

 * 
 */
