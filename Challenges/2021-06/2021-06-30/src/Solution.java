import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;

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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        HashMap<TreeNode,TreeNode> parents = new HashMap<>();
        Deque<TreeNode> st = new ArrayDeque<>();

        st.push(root);
        parents.put(root,null);
        TreeNode cur;
        while(!st.isEmpty()) {
           cur=st.pop();
           if(cur.left!=null) {
               st.push(cur.left);
               parents.put(cur.left,cur);
           }
           if(cur.right!=null) {
               st.push(cur.right);
               parents.put(cur.right, cur);
           }
        }

        HashSet<TreeNode> ancestors = new HashSet<>();

        while(p!=null) {
            ancestors.add(p);
            p=parents.get(p);
        }

        while(!ancestors.contains(q)) {
            q=parents.get(q);
        }

        return q;

    }

//    public void initializeParentPointers(TreeNode cur, TreeNode pre, HashMap p) {
//
//    }
}
