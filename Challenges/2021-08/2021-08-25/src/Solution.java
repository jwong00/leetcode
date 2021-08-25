import java.util.LinkedHashMap;
import java.util.LinkedHashSet;

class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.judgeSquareSum(8));
        System.out.println(s.judgeSquareSum(3));
        System.out.println(s.judgeSquareSum(2));
        System.out.println(s.judgeSquareSum(1));
    }
    public boolean judgeSquareSum(int c) {
        LinkedHashMap<Integer,Integer> squares = new LinkedHashMap<>();

        double max = Math.sqrt((double) c);
        for(int i=0;i<=max;i++) {
            int sq = i*i;
            squares.put(sq,i);
            if(squares.containsKey(c-sq)) return true;
        }

        return false;
    }
}
