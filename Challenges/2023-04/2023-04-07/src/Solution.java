/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

import java.sql.Array;
import java.util.*;

class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
    }
    public Node cloneGraph(Node node) {

        //track visited:
        boolean[] visited = new boolean[101];

        //map to store cloned nodes so we can find+connect
        //to rest of graph in constant time:
        HashMap<Integer,Node> nodes = new HashMap<>();

        //iterate breadth-first through the given graph
        //and generate its clone:
        ArrayDeque<Node> queue = new ArrayDeque<>();
        queue.offer(node);

        Node clone = new Node(1,new ArrayList<Node>());
        Node clone_head = clone;
        nodes.put(1,clone);

        while(!queue.isEmpty()) {
            //dequeue node:
            Node original = queue.poll();

            //if already visited, skip
            if(!visited[original.val]) continue;
            else visited[original.val] = true;

            //advance clone:
            clone = nodes.get(original.val);

            //process its neighbors and queue them:
            for(Node neighbor : original.neighbors) {
                if(!nodes.containsKey(neighbor.val)) {
                    //create this node for the first time:
                    nodes.put(neighbor.val,new Node(neighbor.val,new ArrayList<>()));

                }

                //add the node to the neighbors list of cur clone node:
                clone.neighbors.add(new Node(neighbor.val,new ArrayList<>()));

                //enqueue each neighbor for processing:
                queue.offer(neighbor);
            }
        }

        return clone_head;
    }
}
