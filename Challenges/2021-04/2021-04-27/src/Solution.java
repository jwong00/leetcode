class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.isPowerOfThree(43));
        System.out.println(s.isPowerOfThree(45));
        System.out.println(s.isPowerOfThree(27));
        System.out.println(s.isPowerOfThree(9));
        System.out.println(s.isPowerOfThree(81));
        System.out.println(s.isPowerOfThree(81*81));
        System.out.println(s.isPowerOfThree(0));
        System.out.println(s.isPowerOfThree(1));
        System.out.println(s.isPowerOfThree(2));
        System.out.println(s.isPowerOfThree(3));
        System.out.println(s.isPowerOfThree(4));
        System.out.println(s.isPowerOfThree(-14));
        System.out.println(s.isPowerOfThree(-555));
        System.out.println(s.isPowerOfThree(-98));
    }
    public boolean isPowerOfThree(int n) {
        System.out.printf("%d ", n);
        if(n==1) return true;
        if(n<1 || n%2==0) return false;
        int k=1;
        while(k<n) {
            k*=3;
        }

        return k==n ? true : false;
    }
}
