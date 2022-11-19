import java.util.Arrays;

class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.isUgly(14));
        System.out.println(s.isUgly(6));
        System.out.println(s.isUgly(9));
        System.out.println(s.isUgly(1));
        System.out.println(s.isUgly(-2147483648));


    }
    public boolean isUgly(int n) {
        if(n<=0) return false;

        for(int f : new int[]{2,3,5}) {
            while(n%f==0) n/=f;
        }

        return n==1;
    }
}