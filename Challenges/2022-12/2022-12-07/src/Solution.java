import java.util.ArrayList;
import java.util.List;

class Solution {

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        if(root1==null && root2==null) return true;

        return getLeafSequence(root1,new ArrayList<>()).equals(getLeafSequence(root2,new ArrayList<>()));

    }

    public List<Integer> getLeafSequence(TreeNode root, ArrayList<Integer> sequence) {
        if(root==null) return sequence;

        if(root.left==null && root.right==null) {
            sequence.add(root.val);
        }

        getLeafSequence(root.left,sequence);
        getLeafSequence(root.right,sequence);

        return sequence;
    }
}
