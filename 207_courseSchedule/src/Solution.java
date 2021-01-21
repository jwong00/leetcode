import java.util.HashSet;

class Solution {
    public static void main(String[] args) {
        int[][] q = {{1,2}};
//        System.out.println(q.length);
//        System.out.println(q[0].length);

        Solution s = new Solution();
        int[][] p = {{0,1},{3,4}};
        System.out.println(s.canFinish(6,p));

        int[][] t = {{0,1},{1,0}};
        System.out.println(s.canFinish(2,t));

    }
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(prerequisites.length==0) return true;

        Boolean[][] adjacency = new Boolean[numCourses][numCourses];

        /*
        * Represents unvisited nodes in the graph. Removal of a node is analogous to
        * visiting that node.
        * */
        HashSet<Integer> visited = new HashSet<>();

        for(int i=0; i<prerequisites.length; i++) {
            adjacency[prerequisites[i][0]][prerequisites[i][1]] = true;
            if(!visited.add(prerequisites[i][1])) return false;
        }
        print(adjacency);
        return true;
    }

    public void print(Boolean[][] array) {
        if(array==null) return;
        for( int i=0; i<array.length; i++ ) {
            for (int j=0; j<array[0].length; j++) {
                System.out.printf("%-5b ",array[i][j]);
            }
            System.out.printf("\n");
        }
    }
}
