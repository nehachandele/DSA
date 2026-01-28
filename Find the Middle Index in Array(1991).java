class Solution {
    public int findMiddleIndex(int[] nums) {
        int tot=0;
        for(int num:nums)
        {
            tot+=num;
        }
        int left=0;
        for(int i=0;i<nums.length;i++)
        {
            if(left==tot-left-nums[i])
            {
                return i;
            }
            left+=nums[i];
        }
        return -1;
    }
}
    