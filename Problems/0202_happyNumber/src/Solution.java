import java.util.HashSet;

class Solution {
    boolean[] lookup = new boolean[1000];

    public Solution() {
        lookup[1] = false;
        lookup[4] = true;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.isHappy(145));
        System.out.println(s.isHappy(4));
        System.out.println(s.isHappy(1));
        System.out.println(s.isHappy(19));
        System.out.println(s.isHappy(1047));
    }
    public boolean isHappy(int n) {
        if(n==1) return true;
        if(n<1000 && lookup[n]) return false;

        int k=0;
        while(k!=1) {

            k=0;
            while (n > 0) {
                int r=n%10;
                k += r*r;
                n /= 10;
            }

            if(lookup[k]) return false;
            else lookup[k]=true;

            n=k;
        }

        return true;
    }
}
