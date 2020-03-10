import java.util.ArrayList;
import java.util.List;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public boolean isValidBST(TreeNode root) {
        if(root==null) return true;
        ArrayList<Integer> inOrderList = new ArrayList<>();
        parseNode(root,-1);
        for(int i=1,k=0;i<inOrderList.size();i++,k++) {
//            System.out.println(inOrderList.get(i));
            if(inOrderList.get(i)<inOrderList.get(k)) return false;
        }
        return true;
    }

    public Boolean parseNode(TreeNode node, int lastValue) {
        Boolean result=true;
        if(node.left!=null) result &= parseNode(node.left,node.val);
        if(node.val<= lastValue) result &= false;
        if(node.right!=null) result &= parseNode(node.right,node.val);
        return result;
    }
}
