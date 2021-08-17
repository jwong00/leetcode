/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root==null) return ans;

        Deque<Node> q = new ArrayDeque<>();
        q.add(root);

        Node cur;
        int curLevelSize = 1;
        int nextLevelSize = 0;

        List<Integer> level = new ArrayList<>();

        while(!q.isEmpty()) {
            cur = q.pollFirst();

            curLevelSize--;
            nextLevelSize+=cur.children.size();

            level.add(cur.val);

            for(Node c : cur.children) {
                q.offerLast(c);
            }

            //advanced if none left and level is nonempty
            if(curLevelSize==0 && level.size()>0) {
                ans.add(level);
                level = new ArrayList<>();

                //advance to next level:
                curLevelSize = nextLevelSize;
                nextLevelSize = 0;
            }
            System.out.println(cur.val);
        }
        return ans;

    }
}
