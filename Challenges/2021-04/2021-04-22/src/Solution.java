import java.util.*;

class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        List<List<Integer>> t = new ArrayList<>();

        int[][] w = {{1,2,2,1},{3,1,2},{1,3,2},{2,4},{3,1,2},{1,3,1,1}};

        for(int i=0;i<w.length;i++) {
            t.add(new ArrayList<>());
            for(int j=0;j<w[i].length;j++) {
                t.get(i).add(w[i][j]);
            }
            System.out.println(t.get(i));
        }

        System.out.println(s.leastBricks(t));

    }
    public int leastBricks(List<List<Integer>> wall) {

        int max = Integer.MIN_VALUE;
        System.out.println("START COMPUTING LEAST BRICKS");
        for( List<Integer> row : wall ) {
            int sum = 0;
            for(int i=0;i<row.size();i++) {
                sum+=row.get(i);
                max = Math.max(max,sum);
                row.set(i,sum);
            }
            System.out.println(row);
        }

        System.out.println("Determine majority element");

//        int[] freq = new int[max+1];
        TreeMap<Integer,Integer> freq = new TreeMap<>();

        for( List<Integer> row: wall ) {
            for(int i=0;i<row.size()-1;i++) {
                int t = row.get(i);
                if(freq.containsKey(t)) freq.put(t,freq.get(t)+1);
                else freq.put(t,1);
            }
        }

        max = Integer.MIN_VALUE;

        for(Map.Entry<Integer,Integer> e : freq.entrySet()) {
            Integer v = e.getValue();

            max = Math.max(max,v);
        }

        return wall.size()-max;
    }
}
