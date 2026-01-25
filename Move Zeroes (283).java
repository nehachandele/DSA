/*class Solution {
    public void moveZeroes(int[] nums) {
        int unique=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=0){
                int temp=nums[unique];
                nums[unique]=nums[i];
                nums[i]=temp;
                unique++;
            }
        }
    }
}
*/

//for 2ms 
class Solution {
    public void moveZeroes(int[] nums) {

        int n = nums.length;
        int writeIndex = 0;

        // First pass: move all non-zero elements forward
        for (int i = 0; i < n; i++) {
            if (nums[i] != 0) {
                nums[writeIndex++] = nums[i];
            }
        }

        // Second pass: fill remaining positions with zero
        for (int i = writeIndex; i < n; i++) {
            nums[i] = 0;
        }
    }
}