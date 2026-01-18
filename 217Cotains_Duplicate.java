import java.util.HashMap;
class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashMap<Integer,Integer> seen=new HashMap<>();
        for(int num:nums){
            if(seen.containsKey(num)&& seen.get(num)>=1){
                return true;
            }
            seen.put(num,seen.getOrDefault(num,0)+1);
        }
        return false;
    }
}

/**
Method 2 You really dont need to store count. If key exists, it indicates,
 * element occured twice.
 * 
 * Map<Integer, Boolean> mp = new HashMap<>();
 * for(int i=0; i< nums.length; i++){
 * if(mp.containsKey(nums[i])){
 * return true;
 * }
 * mp.put(nums[i], true);
 * }
 * return false;
 */