import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> rightSideView(TreeNode root) {

        if(root==null) return new ArrayList<>();

        ArrayDeque<TreeNode> q = new ArrayDeque<>();

        List<Integer> ans = new ArrayList<>();

        q.offer(root);
        int count_cur = 1, count_next = 0;

        while(!q.isEmpty()) {

            //this inner loop processes a level of the tree
            while(count_cur>0) {
                TreeNode cache = q.poll();
                count_cur--;

                //the last removed element from the queue
                //represents the rightmost element of that level
                if(count_cur==0) ans.add(cache.val);

                //enqueue the left and right subchildren
                if(cache.left!=null) {
                    count_next++;
                    q.offer(cache.left);
                }
                if(cache.right!=null) {
                    count_next++;
                    q.offer(cache.right);
                }
            }

            //go to next level
            count_cur = count_next;
            count_next = 0;
        }

        return ans;
    }
}
