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

    public List<Integer> preorder(Node root) {
        if(root==null) return new ArrayList<>();
        Deque<Node> s = new ArrayDeque<>();
        s.push(root);

        List<Integer> c = new ArrayList<>();

        while(!s.isEmpty()) {
            Node t = s.pop();
            c.add(t.val);
            for(int i=t.children.size()-1;i>=0;i--) {
                s.push(t.children.get(i));
            }
        }

        return c;
    }
}
