import java.util.ArrayDeque;

class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        TreeNode root = new TreeNode(1);
    }
    public int countNodes(TreeNode root) {
        //count 0-indexed depth
        TreeNode node = root;
        int depth = 0;
        while(node!=null) {
            node=node.left;
            depth++;
        }

        //use st to perform iterative dfs
        //terminate when node at maxDepth is found
        //but count missing nodes
        ArrayDeque<TreeNode> st = new ArrayDeque<>();
        int missing = 0;
        while(!st.isEmpty()) {
            if(st.size()==depth-1) {
                if(st.peek().left!=null && st.peek().right==null) {
                    missing++;
                    break;
                }
                if(st.peek().left==null && st.peek().right==null) missing+=2;
            }

            //wrap in else?
            if(st.peek().right!=null) st.push(st.peek().right);
            if(st.peek().left!=null) st.push(st.peek().left);
            st.pop();
        }

        return missing;

    }
}
