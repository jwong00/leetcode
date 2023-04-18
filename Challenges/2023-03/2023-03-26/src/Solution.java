import java.util.HashMap;

class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.longestCycle(new int[]{3,3,4,2,3}));
    }
    public int longestCycle(int[] edges) {
        HashMap<Integer,Integer> visited = new HashMap<>();

        int length = -1;

        for(int i=0;i<edges.length;i++) {

            //skip if already visited
            if(visited.containsKey(i)) continue;

            //start at the ith node
            int node = i;

            //used to track "position" of nodes relative to each other,
            //use for cycling length detection
            int count = 0;

            //traverse the path until end
            while(node!=-1) {
                ++count;

                //only happens once per cycle?
                //so we compute the length and test if its max length
                if(visited.containsKey(node)) {
                    length = Math.max(length,count-visited.get(node));
                    break;
                }

                visited.put(node,count);
                node = edges[i];
            }


        }
        return length;
    }
}
