/**
 * LC 0653 :: Two Sum IV - Input is a BST
 */

import java.util.HashSet;

class Solution {
    HashSet<Integer> set;

    public Solution() {
        set = new HashSet<>();
    }
    public boolean findTarget(TreeNode root, int k) {
        if(root==null) return false;
        if(set.contains(k-root.val)) return true;
        set.add(root.val);
        return findTarget(root.left,k) || findTarget(root.right,k);
    }
}
