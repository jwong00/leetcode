import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

class Solution {
    public List<Double> averageOfLevels(TreeNode root) {

        List<Double> averages = new ArrayList<Double>();
        Deque<TreeNode> nodes = new ArrayDeque<TreeNode>();

        nodes.offer(root);
        int countCur = 1;
        int countNext = 0;

        while(nodes.size() > 0) {

            int countCurCopy = countCur;
            double sum = 0;

            while(countCur > 0) {
                TreeNode node = nodes.poll();
                countCur--;

                sum += node.val;

                if(node.left!=null) {
                    nodes.offer(node.left);
                    countNext++;
                }
                if(node.right!=null) {
                    nodes.offer(node.right);
                    countNext++;
                }
            }

            averages.add(sum/countCurCopy);

            countCur = countNext;
            countNext = 0;
        }

        return averages;

    }
}
