/*class Solution {

    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(list, new ArrayList<>(), nums, target, 0);
        return list;
    }

    private void backtrack(List<List<Integer>> list,
                           List<Integer> tempList,
                           int[] nums,
                           int remain,
                           int start) {

        if (remain < 0) return;

        if (remain == 0) {
            list.add(new ArrayList<>(tempList));
            return;
        }

        for (int i = start; i < nums.length; i++) {
            tempList.add(nums[i]);
            backtrack(list, tempList, nums, remain - nums[i], i); // reuse allowed
            tempList.remove(tempList.size() - 1);
        }
    }
}
*/
class Solution {
    List<List<Integer>> res = new ArrayList<>();
    ArrayList<Integer> temp = new ArrayList<>();
    public void rec(int[] arr,int ind,int sum,int tar){
        if(sum==tar){
            res.add(new ArrayList<>(temp));
            return;
        }
        if(ind == arr.length||sum>tar){
            return;
        }
        temp.add(arr[ind]);
        rec(arr,ind,sum+arr[ind],tar);
        temp.remove(temp.size()-1);
        rec(arr,ind+1,sum,tar);
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        rec(candidates,0,0,target);
        return res;
    }
}