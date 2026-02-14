import java.util.ArrayList;
import java.util.List;
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> resultList=new ArrayList<>();
        backtrack(resultList,new ArrayList<>(),nums);
        return resultList;
    }

    private void backtrack(List<List<Integer>> resultList,ArrayList<Integer> tempList,int[] nums){
        //If we match the length, it is permutation
        if(tempList.size()==nums.length){
            resultList.add(new ArrayList<>(tempList));
            return;
        }

        for(int num:nums){
            //Skip if w eget same element
            if(tempList.contains(num)){
                continue;
            }

            //add new element
            tempList.add(num);

            //Go back to try other element
            backtrack(resultList,tempList,nums);

            //Remove the element
            tempList.remove(tempList.size()-1);
        }

    }
}

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        backtrack(nums, new ArrayList<>(), used, result);
        return result;
    }

    private void backtrack(int[] nums, List<Integer> temp, boolean[] used, List<List<Integer>> result) {
        if (temp.size() == nums.length) {
            result.add(new ArrayList<>(temp));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) continue;
            used[i] = true;
            temp.add(nums[i]);
            backtrack(nums, temp, used, result);
            temp.remove(temp.size() - 1);
            used[i] = false;
        }
    }
}
