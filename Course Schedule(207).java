import java.util.*;

class Solution {
    
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        // Step 1: Build graph
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0; i < numCourses; i++){
            graph.add(new ArrayList<>());
        }
        
        for(int[] pre : prerequisites){
            graph.get(pre[1]).add(pre[0]);
        }
        
        // 0 = unvisited, 1 = visiting, 2 = visited
        int[] state = new int[numCourses];
        
        // Step 2: Check for cycle in each component
        for(int i = 0; i < numCourses; i++){
            if(state[i] == 0){
                if(hasCycle(graph, state, i)){
                    return false;
                }
            }
        }
        
        return true;
    }
    
    private boolean hasCycle(List<List<Integer>> graph, int[] state, int node){
        
        // If currently visiting → cycle found
        if(state[node] == 1){
            return true;
        }
        
        // If already processed → no cycle from here
        if(state[node] == 2){
            return false;
        }
        
        // Mark as visiting
        state[node] = 1;
        
        for(int neighbor : graph.get(node)){
            if(hasCycle(graph, state, neighbor)){
                return true;
            }
        }
        
        // Mark as fully visited
        state[node] = 2;
        
        return false;
    }
}