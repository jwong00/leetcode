import java.util.LinkedList;

class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.concatenatedBinary(1));
        System.out.println(s.concatenatedBinary(3));
        System.out.println(s.concatenatedBinary(12));
    }
    public int concatenatedBinary(int n) {

        LinkedList<Character> bin_rep = new LinkedList<>();

        for(int i=1;i<=n;i++) {
            LinkedList<Character> bin_rep_cache = new LinkedList<>();
            for(int j=i;j>0;j=j/2) {
                if(j%2==0) bin_rep_cache.addFirst('0');
                else bin_rep_cache.addFirst('1');
            }
            bin_rep.addAll(bin_rep_cache);
        }
        System.out.println(bin_rep.toString());

        int ans = 0;
        for(int i=bin_rep.size()-1,base=1;i>=0;i--,base*=2) {
            if(bin_rep.get(i)=='1') ans+=base;
        }

        return ans % 1_000_000_007;

    }
}
