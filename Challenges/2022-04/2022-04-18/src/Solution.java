import java.util.PriorityQueue;

class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        s.kthSmallest(new TreeNode(),1);
    }
    public int kthSmallest(TreeNode root, int k) {
        PriorityQueue<Integer> q = new PriorityQueue<>((a,b)->b-a);

        helper(root,k,q);

        if(!q.isEmpty()) return q.peek();
        else return -1;
    }

    public void helper(TreeNode node, int k, PriorityQueue<Integer> q) {
        if(node==null) return;
        if(q.size()<k) q.offer(node.val);
        else if(node.val < q.peek()){
            q.poll();
            q.offer(node.val);
        }
        helper(node.left,k,q);
        helper(node.right,k,q);

    }
}
