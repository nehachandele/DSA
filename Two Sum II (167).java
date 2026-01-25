import java.util.ArrayList;
class Solution {
    
    public int[] twoSum(int[] numbers, int target) {
        int left =0,right=numbers.length-1;
        ArrayList<Integer> arr=new ArrayList<>();
        int res[]=new int[2];
        while(left<right){
            int sum=numbers[left]+numbers[right];
            if(sum==target){
                res[0]=left+1;
                res[1]=right+1;
                return res;
            }else if(sum>target){
                right--;
            }else{
                left++;
            }
        }
        return res;
    }
}