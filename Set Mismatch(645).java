class Solution {
    public int[] findErrorNums(int[] nums) {
        int duplicate=-1;
        int missing=-1;

        //Pass1:Find the duplicate and marks visisted number
        for(int num:nums){
            int index=Math.abs(num)-1;

            if(nums[index]<0){
                //this index is already marked ,so num is the duplicate
                duplicate =Math.abs(num);
            }else{
                //Mark this index as visited 
                nums[index]=-nums[index];

            }
        }
 // Pass 2: Find the missing number
        // The index that is still positive corresponds to the missing number
        for(int i=0;i<nums.length;i++){
            if(nums[i]>0){
                missing=i+1;
                break;
            }
        }
       return new int[]{duplicate,missing};
    }
}