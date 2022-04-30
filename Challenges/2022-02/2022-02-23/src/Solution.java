import java.util.*;

class Solution {
    public Node cloneGraph(Node node) {

        if(node==null) return null;

        //enqueue first node
        Deque<Node> queue = new ArrayDeque<>();
        queue.offer(node);

        //track visited nodes with a hashmap
        //maps Original-->Copy
        HashMap<Node,Node> map  = new HashMap<>();
        map.put(node, new Node(node.val, new ArrayList<>()));


        //process graph using queue
        while(!queue.isEmpty()) {
            Node a = queue.poll();

            //for each neighbor of Node a...
            for(Node neighbor : a.neighbors) {

                //if not visited, then visit
                if(!map.containsKey(neighbor)) {
                    queue.offer(neighbor);

                    //clone neighbor and map it to its clone
                    map.put(neighbor,new Node(neighbor.val, new ArrayList<>()));
                }

                //point the clone of Node a to its cloned neighbors
                map.get(a).neighbors.add(map.get(neighbor));
            }
        }

        return map.get(node);
    }
}
