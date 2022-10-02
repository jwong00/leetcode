import com.sun.source.tree.Tree;

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
        TreeNode t1 = new TreeNode(1);
        t1.left = new TreeNode(2);
        t1.right = new TreeNode(3);
        System.out.println(s.pathSum(t1,5));

        TreeNode t2 = new TreeNode(5);
        t2.left = new TreeNode(4);
        t2.right = new TreeNode(8);
        t2.right.left = new TreeNode(13);
        t2.right.right = new TreeNode(4);
        t2.right.right.left = new TreeNode(5);
        t2.right.right.right = new TreeNode(1);
        t2.left.left = new TreeNode(11);
        t2.left.left.left = new TreeNode(7);
        t2.left.left.right= new TreeNode(2);

        System.out.println(s.pathSum(t2,22));
    }
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
//        List<List<Integer>> ans = new ArrayList<>();
//        List<Integer> cache = new ArrayList<>();
        return dfs(root,targetSum,new ArrayList<>(),new ArrayList<>());

    }

    public List<List<Integer>> dfs(TreeNode node,
                                   int targetSum,
                                   List<List<Integer>> paths,
                                   List<Integer> cache)
    {
        if(node==null) return paths;
        targetSum-=node.val;
        cache.add(node.val);
        if(targetSum==0 && node.left==null && node.right==null) {
            //copy cached path to paths
            paths.add(new ArrayList<>(cache));
        }
        dfs(node.left,targetSum,paths,cache);
        dfs(node.right,targetSum,paths,cache);
        cache.remove(cache.size()-1);

        return paths;
    }
}
