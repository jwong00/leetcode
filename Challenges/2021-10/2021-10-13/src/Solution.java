import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Deque;

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
        s.preorder(s.bstFromPreorder(new int[]{8,5,1,7,10,12}));
    }

    public void preorder(TreeNode root) {
        if(root==null) return;
        System.out.printf("%d ",root.val);
        preorder(root.left);
        preorder(root.right);
        System.out.println();
    }

    public TreeNode bstFromPreorder(int[] preorder) {
        Deque<Integer> _preorder = new ArrayDeque<>();
//        Collections.addAll(_preorder,preorder);
        for(int i=0;i<preorder.length;i++) {
            _preorder.offer(preorder[i]);
        }

        return helper(_preorder,Integer.MIN_VALUE,Integer.MAX_VALUE);
    }

    public TreeNode helper(Deque<Integer> preorder, int min, int max) {
        if(preorder.isEmpty()) return null;
        int val = preorder.peek();

        //generate the current node
        TreeNode node;
        if(min < val && val < max ) {
            node = new TreeNode(val);
            preorder.poll();
        }
        //or return null so parent can assign null to left/right
        else return null;

        //attempt to generate children notes
        node.left = helper(preorder,min,Math.min(max,node.val));
        node.right = helper(preorder,Math.max(min,node.val),max);

        //returns sub-tree
        return node;
    }
}
