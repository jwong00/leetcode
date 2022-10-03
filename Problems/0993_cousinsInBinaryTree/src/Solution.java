import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {
        if(root==null) return false;

        int cur_level = 1;
        int next_level = 0;

        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if(cur_level>0) cur_level--;

            if(node.left!=null) {
                queue.offer(node.left);
                next_level++;
            }
            if(node.right!=null) {
                queue.offer(node.right);
                next_level++;
            }

            if(cur_level==0) {
                cur_level = next_level;
                next_level = 0;


            }

        }
    }
}
