class UnionFind {
    int[][] set;
    int[] rank;
    boolean[] bipartite;

    public UnionFind(int sz) {

        set = new int[sz][2];
        rank = new int[sz];
        bipartite = new boolean[sz];

        for(int i=0;i<sz;i++) {
            set[i] = new int[]{i,1};
        }

    }

    //find and return the representative element of element v
    public int[] find(int v) {
        if(v!=set[v][0]) {
            int parity = set[v][1];
            set[v] = find(set[v][0]);
            set[v][1] ^= parity;
        }
        return set[v];
    }

    //in this context, used to add an edge
    public void union(int i, int j) {
        int[] pa = find(i);
        int[] pb = find(j);
        int a = pa[0], b = pb[0];
        int x = pa[1], y = pb[1];


        if(a==b && x==y) bipartite[a] = false;
        else {
            if(rank[a] < rank[b]) {
                int t = a;
                a = b;
                b = t;
            }
            set[b][0] = a;
            set[b][1] = x^y^1;
            bipartite[a] &= bipartite[b];
            if(rank[a]==rank[b]) rank[a]++;
        }
    }

    public boolean is_bipartite(int v) {
        return bipartite[find(v)[0]];
    }


}

class Solution {
    public boolean isBipartite(int[][] graph) {

    }
}
