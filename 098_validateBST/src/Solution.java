import com.sun.source.tree.Tree;

import javax.xml.transform.SourceLocator;
import java.util.ArrayList;
import java.util.List;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public boolean isValidBST(TreeNode root) {
        if(root==null) return true;
        return parseNode(root,null,null);
    }

    public static void main(String args[]) {
        Solution s = new Solution();
        TreeNode node = new TreeNode(5);
        node.left = new TreeNode(2);
        node.right = new TreeNode(12);
        node.right.left = new TreeNode(7);
        node.right.right = new TreeNode(14);
        node.right.left.left = new TreeNode(6);
        node.right.left.right = new TreeNode(8);
        System.out.println(s.isValidBST(node));
    }

    public Boolean parseNode(TreeNode node, Integer lower, Integer upper) {
        if(lower != null && node.val <= lower ) return false;
        if(upper != null && node.val >= upper ) return false;
        Boolean result = true;
        if(node.right != null) result &= parseNode(node.right,node.val, upper);
        if(node.left != null) result &= parseNode(node.left,lower,node.val);
        return result;
    }
}
