import com.sun.source.tree.Tree;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        TreeNode k = new TreeNode(1);
        k.left = new TreeNode(2);
        k.right = new TreeNode(3);
        k.left.left= new TreeNode(4);
        k.left.right = new TreeNode(5);

        TreeNode r = new TreeNode(1);
        r.left = new TreeNode(2);


        System.out.println(s.diameterOfBinaryTree(k));
        System.out.println(s.diameterOfBinaryTree(r));
    }
    public int diameterOfBinaryTree(TreeNode root) {
        if(root==null) return 0;
//        if(root.left==null && root.right==null) return 0;

        //longest path passing through root:

        int longestPassingPath = longestPathLength(root.left) + longestPathLength(root.right);

        //longest paths not passing through root:

        int left = diameterOfBinaryTree(root.left);
        int right = diameterOfBinaryTree(root.right);
        int longestNonPassingPath = left > right ? left : right;

//        if(root.left==null || root.right==null) return longestNonPassingPath;
        return longestPassingPath > longestNonPassingPath ? longestPassingPath : longestNonPassingPath;


    }

    public int longestPathLength(TreeNode root) {
        if(root==null) return 0;

        int left = 1 + longestPathLength(root.left);
        int right = 1 + longestPathLength(root.right);

        return left > right ? left : right;
    }
}
