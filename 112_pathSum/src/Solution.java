/**
 * Created by Glamdring on 2/22/2017.
 */
public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        TreeNode r = new TreeNode(3);
        r.left = new TreeNode (1);
        System.out.println(s.hasPathSum(r, 0));
        System.out.println(s.hasPathSum(r, 1));
        System.out.println(s.hasPathSum(r, 2));
        System.out.println(s.hasPathSum(r, 3));
        System.out.println(s.hasPathSum(r, 4));
        System.out.println(s.hasPathSum(r, 5));
    }
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root==null) return false;
        else if(root.left == null && root.right == null) return sum == root.val;
        else return hasPathSum(root.left, sum-root.val) || hasPathSum(root.right, sum-root.val);
    }
}
