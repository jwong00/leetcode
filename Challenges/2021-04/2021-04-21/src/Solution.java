import java.util.*;

class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        List<List<Integer>> t = new ArrayList<>();
        t.add(new ArrayList<>());
        t.add(new ArrayList<>());
        t.add(new ArrayList<>());
        t.add(new ArrayList<>());
        t.get(0).add(2);
        t.get(1).add(3);
        t.get(1).add(4);
        t.get(2).add(6);
        t.get(2).add(5);
        t.get(2).add(7);

        t.get(3).add(4);
        t.get(3).add(1);
        t.get(3).add(8);
        t.get(3).add(3);

        System.out.println("MIN?"+s.minimumTotal(t));
    }


    Map<String,Integer> m;
    List<List<Integer>> t;


    public int minimumTotal(List<List<Integer>> triangle) {
        t = triangle;
        m = new HashMap<>();

        return dfs(0,0);


    }

    public int dfs(int r, int c) {
        String p = r+":"+c;
        if(m.containsKey(p)) {
            return m.get(p);
        }


    }
}
