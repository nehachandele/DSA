import java.util.ArrayList;
import java.util.List;
class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> result=new ArrayList<>();
        int n=nums.length;
        for(int i=0;i<n;i++){
            int num=Math.abs(nums[i]);
            int idx=num-1;
            if(nums[idx]<0){
                result.add(num);
            }
            nums[idx]*=-1;
        }
        return result;
    }
}
//25ms
/*class Solution {
    public List<Integer> findDuplicates(int[] nums) {
    List<Integer> nums1=new ArrayList<>();
    Arrays.sort(nums);
    for(int i=1;i<nums.length;i++){
        if(nums[i]==nums[i-1]){
            nums1.add(nums[i]);
        }
    }
    return nums1;
    }
}*/