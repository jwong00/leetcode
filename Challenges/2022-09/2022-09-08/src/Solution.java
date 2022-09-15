import java.util.ArrayList;
import java.util.List;

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
        TreeNode t = new TreeNode(1);

        System.out.println(s.inorderTraversal(t));

        t.right = new TreeNode(2);
        t.right.left = new TreeNode(3);

        System.out.println(s.inorderTraversal(t));

        t = new TreeNode();
        System.out.println(s.inorderTraversal(t));

    }
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> order = new ArrayList<Integer>();
        return helper(root,order);
    }

    public List<Integer> helper(TreeNode node, List<Integer> order) {
        if(node==null) return order;
        helper(node.left,order);
        order.add(node.val);
        helper(node.right,order);
        return order;
    }
}