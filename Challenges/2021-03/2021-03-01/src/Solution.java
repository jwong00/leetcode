import java.util.BitSet;
import java.util.HashSet;

class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] g = {1,1,1,1};

        System.out.println(s.distributeCandies(g));
    }
    public int distributeCandies(int[] candyType) {
        if(candyType==null || candyType.length==0) return 0;

        HashSet<Integer> countOfType = new HashSet<>();

        for(int i=0;i<candyType.length;i++) {
            countOfType.add(candyType[i]);
        }

        return Math.min(candyType.length/2,countOfType.size());
    }
}
