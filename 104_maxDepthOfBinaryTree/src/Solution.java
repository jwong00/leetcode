/**
 * Created by Glamdring on 2/22/2017.
 */
public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        TreeNode r = new TreeNode(1);
        TreeNode k = new TreeNode(2);
        k.left = new TreeNode(3);
        k.left.right = new TreeNode(4);
        k.right = new TreeNode(4);
        System.out.println(s.maxDepth(k));
    }
    public int maxDepth(TreeNode root) {
        if(root==null) return 0;
        else return 1 + Math.max(maxDepth(root.left),maxDepth(root.right));
    }
}
