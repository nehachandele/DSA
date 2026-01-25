class Solution {
    public int removeDuplicates(int[] nums) {
        int n=nums.length;
        int j=1;
        for(int i=1;i<n;i++){
            if(nums[i]!=nums[j-1]){
                nums[j]=nums[i];
                j++;
            }
        }
        return j;
    }
}
/*//0ms
class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums == null) return 0;
        int index = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != nums[index]) {
                index++;
                nums[index] = nums[i];
            }
        }
        return index+1;
    }
}
    */