import com.sun.source.tree.Tree;

import java.util.ArrayDeque;
import java.util.Deque;

class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(9);

        System.out.println(s.toString(root));

        s.invertTree(root);

        System.out.println(s.toString(root));


    }
    public TreeNode invertTree(TreeNode root) {
        if(root==null) return null;

        TreeNode left = root.left, right = root.right;
        root.left = invertTree(right);
        root.right = invertTree(left);

        return root;
    }

    public String toString(TreeNode root) {
        Deque<TreeNode> q = new ArrayDeque<>();
        q.add(root);
        StringBuilder sb = new StringBuilder();

        while(!q.isEmpty()) {
            TreeNode node = q.poll();
            sb.append(node.val);
            if(node.left!=null) q.offer(node.left);
            if(node.right!=null) q.offer(node.right);
            if(!q.isEmpty()) sb.append(", ");
        }

        return sb.toString();

    }
}
