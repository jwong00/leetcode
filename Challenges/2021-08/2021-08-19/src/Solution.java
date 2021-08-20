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
    public int maxProduct(TreeNode root) {
        List<Integer> subtotal = new ArrayList<>();

        long total = dfs(root,subtotal);
        long max = Integer.MIN_VALUE;

        for(Integer i : subtotal) {
            max = Math.max(max,(total-i)*i);
        }

        return (int) (max % 1_000_000_007);
    }

    public int dfs(TreeNode node,List<Integer> subtotal) {
        if(node==null) return 0;

        int sum = dfs(node.left,subtotal) + dfs(node.right,subtotal) + node.val;
        subtotal.add(sum);

        return sum;
    }
}
