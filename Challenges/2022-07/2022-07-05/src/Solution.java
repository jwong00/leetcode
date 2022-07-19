import java.util.HashMap;

class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.longestConsecutive(new int[]{100,4,200,1,3,2}));
    }

    public int longestConsecutive(int[] nums) {
        for(int n : nums) make_set(n);

        for(int n :nums) {
            if(parent.containsKey(n) && parent.containsKey(n+1)) union(n,n+1);
        }

        return max;
    }

    HashMap<Integer,Integer> parent;
    HashMap<Integer,Integer> rank;
    int max;

    public Solution() {
        parent = new HashMap<>();
        rank = new HashMap<>();
        max = 0;
    }

    public void make_set(int v) {
        parent.putIfAbsent(v,v);
        rank.putIfAbsent(v,0);
    }

    public void union(int a, int b) {
        System.out.println(a+" "+b);
        a = find_set(a);
        b = find_set(b);
        if(a!=b) {
            if(rank.get(a)<rank.get(b)) {
                a = a + b;
                b = a - b;
                a = a - b;
            }
            parent.put(b,a);
            if(rank.get(a).equals(rank.get(b))) {
                rank.put(a,rank.get(a)+1);
                if(rank.get(a)>max) max++;

            }

        }
    }

    public int find_set(int v) {
        if(v==parent.get(v)) return v;
        parent.put(v,find_set(parent.get(v)));
        return find_set(parent.get(v));
    }
}
