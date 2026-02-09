/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<Integer> res;
    public List<Integer> largestValues(TreeNode root) {
      res=new ArrayList<>();
      dfs(root,0);
      return res;
    }
    public void dfs(TreeNode root,int level){
        if(root!=null){
            int val=root.val;
            if(res.size()==level){
                res.add(val);
            }else{
                res.set(level,Math.max(res.get(level),val));
            }
            dfs(root.left,level+1);
            dfs(root.right,level+1);
        }
    }
}

/* 
class Solution {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null)
            return result;

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            int size = q.size();
            int maxVal = Integer.MIN_VALUE;

            for (int i = 0; i < size; i++) {
                TreeNode curr = q.poll();
                maxVal = Math.max(maxVal, curr.val);

                if(curr.left != null) q.add(curr.left);
                if(curr.right != null) q.add(curr.right);
            }
            result.add(maxVal);
        }
        return result;
    }
}*/