
class Solution {
    public int maxDepth(TreeNode root) {
        return dfs(root,0);
    }

    public int dfs(TreeNode node, int level) {
        if(node==null) return level;

        return Math.max(dfs(node.left,level+1),dfs(node.right,level+1));
    }
}
