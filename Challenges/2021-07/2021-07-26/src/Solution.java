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
    public static void main(String[] args) {
        Solution s = new Solution();
        TreeNode r = s.sortedArrayToBST(new int[]{-10,-3,0,5,9});

        s.dfs(r);

    }
    public TreeNode sortedArrayToBST(int[] nums) {
        return makeTree(nums,0,nums.length-1);

    }

    public TreeNode makeTree(int[] nums, int left, int right) {

        //not sure if left>right ever happens
        if(left>right) return null;

        //leaf node
        if(left==right) return new TreeNode(nums[left]);

        //every other node
        int center = left+(right-left)/2;

        TreeNode cur = new TreeNode(nums[center]);
        cur.left = makeTree(nums,left,center-1);
        cur.right = makeTree(nums,center+1,right);

        return cur;
    }

    public void dfs(TreeNode node) {
        if(node==null) return;
        dfs(node.left);
        System.out.println(node.val);
        dfs(node.right);
    }
}
