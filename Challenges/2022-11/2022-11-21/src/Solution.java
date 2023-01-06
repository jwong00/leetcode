import java.util.ArrayList;

class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.numSquares(12));
        System.out.println(s.numSquares(0));
        System.out.println(s.numSquares(32));
    }
    public int numSquares(int n) {
        int ans = 0;
        ArrayList<Integer> log = new ArrayList<>();
        Outer: for(int i=(int)Math.sqrt(n);i>0;i--) {
            int sqr=i*i;
            while(n-sqr>=0) {
                log.add(sqr);
                n-=sqr;
                ans++;
                if(n==0) break Outer;
            }
        }

        System.out.println(log);

        return ans;
    }
}
