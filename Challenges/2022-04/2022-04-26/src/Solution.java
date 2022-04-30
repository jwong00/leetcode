import java.util.ArrayList;
import java.util.Collections;

class UnionFind {
    public int[] set;
    public int[] rank;

    public UnionFind(int sz) {
        set = new int[sz];
        rank = new int[sz];

        for(int i=0;i<sz;i++) set[i] = i;

    }

    //returns the integer representation of the set element k belongs to
    //also compresses the path of the kth element to its representative element
    public int find(int k) {
        if(set[k]!=k) set[k] = find(set[k]);
        return set[k];
    }

    //determines what sets element i and j belong to,
    //merges those two sets
    public boolean union(int i, int j) {
        int a = find(i);
        int b = find(j);

        if(a==b) return false;

        //merge the lower ranked element into the set of the higher ranked element
        if      (rank[b] < rank[a]) set[b] = a;
        else if (rank[a] < rank[b]) set[a] = b;
        else {
            set[a] = b;
            rank[b]++;
        }

        return true;
    }
}

class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.dist_manhattan(new int[][]{{2,2},{5,2}},0,1));
        System.out.println(s.dist_manhattan(new int[][]{{2,2},{3,10}},0,1));
        System.out.println(s.dist_manhattan(new int[][]{{2,2},{0,0}},0,1));
    }
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;

        //iterate over all points
        //generate all edges
        //store weights with edge endpoints
        ArrayList<int[]> edges = new ArrayList<>();

        for(int i=0;i<n;i++) {
            for(int j=i+1;j<n;j++) {
                int[] edge = {dist_manhattan(points,i,j),i,j};
                edges.add(edge);
            }
        }

        //sort edges by weight
        Collections.sort(edges, (a,b)->Integer.compare(a[0],b[0]));

        //the real work
        UnionFind uf = new UnionFind(n);
        int cost = 0;
        int edgesUsed = 0;

        for(int i=0;i<edges.size() && edgesUsed<n-1;i++) {
            int w = edges.get(i)[0];
            int a = edges.get(i)[1];
            int b = edges.get(i)[2];

            if(uf.union(a,b)) {
                cost+=w;
                edgesUsed++;
            }
        }

        return cost;


    }



    //computes the manhattan distance for the supplied points
    public int dist_manhattan(int[][] points, int i, int j) {
        return Math.abs(points[i][0]-points[j][0]) + Math.abs(points[i][1]-points[j][1]);
    }
}
