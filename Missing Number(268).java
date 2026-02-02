/*class Solution {
    public int missingNumber(int[] nums) {
        Arrays.sort(nums);
        int n=nums.length;
        //case 1
        if(nums[0]!=0) return 0;

        //case 2
        if(nums[n-1]!=n) return n;

        //case 3
        for(int i=1;i<nums.length;i++){
            if(nums[i]!=i) return i;
        }
        return 0;
    }
}*/


import java.util.*;
class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int Tsum = (n * (n + 1)) / 2;
        int actualSum = Arrays.stream(nums).sum();
        return Tsum - actualSum;
    }
}

public class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            ans = ans ^ i;
        }
        for (int i = 0; i < nums.length; i++) {
            ans = ans ^ nums[i];
        }
        return ans;
    }
}
