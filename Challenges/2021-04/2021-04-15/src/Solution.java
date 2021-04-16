class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.fib(0));
        System.out.println(s.fib(1));
        System.out.println(s.fib(2));
        System.out.println(s.fib(3));
        System.out.println(s.fib(4));
        System.out.println(s.fib(5));
        System.out.println(s.fib(6));
        System.out.println(s.fib(7));
        System.out.println(s.fib(10));
    }
    public int fib(int n) {
        //fib seq
        //   n  0 1 2 3 4 5 6
        // f(n) 0 1 1 2 3 5 8 ...

        if(n<=1) return n;
        if(n<=3) return n-1;

        int i=1;
        int j=2;
        int next=0;

        for(int m=4;m<=n;m++) {
            next = i+j;
            i=j;
            j=next;
        }
        return next;

    }
}
