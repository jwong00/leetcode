import java.sql.Array;
import java.util.ArrayDeque;
import java.util.ArrayList;

class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        TreeNode r = new TreeNode(1);
        r.left = new TreeNode(2);
        r.right = new TreeNode(2);
        r.left.left = new TreeNode(3);
        r.left.right = new TreeNode(4);
        r.right.left = new TreeNode(4);
        r.right.right = new TreeNode(3);
        System.out.println(s.isSymmetric(r));

    }
    public boolean isSymmetric(TreeNode root) {
        if(root==null) return true;
        //breadth-first traversal
        //perform level by level comparison
        ArrayDeque<TreeNode> queue = new ArrayDeque<>();

        queue.offer(root);
        while(!queue.isEmpty()) {
            int cur_lvl_sz = queue.size();
            if (cur_lvl_sz != 1 && cur_lvl_sz % 2 != 0) return false;
            ArrayList<Integer> t = new ArrayList<>();
            while(cur_lvl_sz>0) {
                TreeNode cur = queue.pollFirst();
                t.add(cur.val);
                if(cur.left!=null) queue.offer(cur.left);
                if(cur.right!=null) queue.offer(cur.right);
                cur_lvl_sz--;
            }
            if(!isLvlSym(t)) return false;
        }

        return true;
    }

    private boolean isLvlSym(ArrayList<Integer> t) {
        System.out.println(t);
        int l = 0, r = t.size()-1;
        while(l<r) {
            if(!t.get(l++).equals(t.get(r--))) return false;
        }
        return true;
    }
}
