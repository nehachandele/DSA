import java.util.*;

class Solution {
    public int maxOperations(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        int count = 0;

        for (int num : nums) {
            int complement = k - num;
            
            if (freq.getOrDefault(complement, 0) > 0) {
                // Complement exists → form a pair
                count++;
                freq.put(complement, freq.get(complement) - 1);
            } else {
                // Store current number for future pairing
                freq.put(num, freq.getOrDefault(num, 0) + 1);
            }
        }

        return count;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums = {1, 2, 3, 4};
        int k = 5;
        System.out.println(sol.maxOperations(nums, k)); // Output: 2
    }
}
