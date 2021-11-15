class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        TreeNode n = new TreeNode(1);
        n.left = new TreeNode(2);
        n.right = new TreeNode(3);
        System.out.println(s.sumNumbers(n));

    }
    public int sumNumbers(TreeNode root) {
        return dfs(root,0);

    }

    public int dfs(TreeNode node, int sum) {
        if(node==null) return 0;

        sum = 10*sum + node.val;

        if(node.left==null && node.right==null) return sum;

        return dfs(node.left,sum) + dfs(node.right,sum);
    }
}