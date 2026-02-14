import java.util.*;

class Solution {
    
    // Node class to keep track of value, list index, and element index
    static class Node {
        int val;
        int row; // which list
        int col; // index in that list
        Node(int v, int r, int c) {
            val = v;
            row = r;
            col = c;
        }
    }
    
    public int[] smallestRange(List<List<Integer>> nums) {
        // Min-heap based on node values
        PriorityQueue<Node> pq = new PriorityQueue<>((a,b) -> a.val - b.val);
        int maxVal = Integer.MIN_VALUE; // track current max among heap
        int start = 0, end = Integer.MAX_VALUE; // result range
        
        // Step 1: Add first element of each list into heap
        for (int i = 0; i < nums.size(); i++) {
            int val = nums.get(i).get(0);
            pq.offer(new Node(val, i, 0));
            maxVal = Math.max(maxVal, val);
        }
        
        // Step 2: Process heap
        while (true) {
            Node minNode = pq.poll(); // current minimum
            int minVal = minNode.val;
            
            // Update range if smaller
            if (maxVal - minVal < end - start) {
                start = minVal;
                end = maxVal;
            }
            
            // Move to next element in the same list
            if (minNode.col + 1 < nums.get(minNode.row).size()) {
                int nextVal = nums.get(minNode.row).get(minNode.col + 1);
                pq.offer(new Node(nextVal, minNode.row, minNode.col + 1));
                maxVal = Math.max(maxVal, nextVal);
            } else {
                // One list exhausted → cannot cover all lists anymore
                break;
            }
        }
        
        return new int[]{start, end};
    }
    
    public static void main(String[] args) {
        Solution sol = new Solution();
        List<List<Integer>> nums = new ArrayList<>();
        nums.add(Arrays.asList(4,10,15,24,26));
        nums.add(Arrays.asList(0,9,12,20));
        nums.add(Arrays.asList(5,18,22,30));
        
        int[] range = sol.smallestRange(nums);
        System.out.println(Arrays.toString(range)); // Output: [20,24]
    }
}
