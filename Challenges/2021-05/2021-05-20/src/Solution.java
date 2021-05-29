import java.util.ArrayList;
import java.util.Arrays;
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

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.left.right = new TreeNode(10);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        System.out.println(Arrays.deepToString(s.levelOrder(root).toArray()));
    }
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<TreeNode>> levelOrderTree = new ArrayList<>();

        if(root==null) return new ArrayList<>();

        List<TreeNode> currentLevel = new ArrayList<>();
        List<TreeNode> nextLevel;
        currentLevel.add(root);
        levelOrderTree.add(currentLevel);

        do {
            nextLevel = new ArrayList<>();
            for(TreeNode tn : currentLevel) {
                if(tn.left!=null) nextLevel.add(tn.left);
                if(tn.right!=null) nextLevel.add(tn.right);
            }
            if(!nextLevel.isEmpty()) levelOrderTree.add(nextLevel);
            currentLevel = nextLevel;
        } while(!nextLevel.isEmpty());

        List<List<Integer>> result = new ArrayList<>();
        for(List level : levelOrderTree) {
            List<Integer> t = new ArrayList<>();
            for(Object tn : level) {
                TreeNode k = (TreeNode) tn;
                t.add(k.val);
            }
            result.add(t);
        }

        return result;
    }
}