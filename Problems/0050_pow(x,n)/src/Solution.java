/**
 * Created by Glamdring on 11/8/2016.
 */
public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
//        System.out.println(s.myPow(4,2));
//        System.out.println(s.myPow(44,0));
        System.out.println(s.myPow(4.1,-2));
//        System.out.println(s.myPow(10,2));
        System.out.println(s.myPow(2,-2));
//        System.out.println(s.myPow(100,1));
        System.out.println(s.myPow(8.84372,-5));
        System.out.println(s.myPow(8.84372, 5));
        System.out.println(s.myPow(8,5));
        System.out.println(s.myPow(2,0));
        System.out.println(s.myPow(2,1));
        System.out.println(s.myPow(2,2));
        System.out.println(s.myPow(2,3));
        System.out.println(s.myPow(2,4));
//        System.out.println(s.myPow(2,5));
//        System.out.println(s.myPow(2,6));
//        System.out.println(s.myPow(2,7));
//        System.out.println(s.myPow(2,8));
        //System.out.println(s.myPow(5,8));
        //System.out.println(s.myPow(5,7));
        //System.out.println(s.myPow(3.8,-4));
        //System.out.println(s.myPow(4.7,6));
        //System.out.println(s.myPow(4.7,-6));
        //System.out.println(s.myPow(4,19));
        //System.out.println(s.myPow(2,-6));
        //System.out.println(s.myPow(2,-7));
        //System.out.println(s.myPow(2,-9));
//        System.out.println(s.myPow(1.26441,9));
    }
    public static final boolean DEBUG = false;
    public double myPow(double x, int n) {
        if(x==0) return 0;
        if(n==0) return 1;
        else if(n>0) return absPow(x,n);
        else {
            return 1/absPow(x,Math.abs(n));
        }
    }
    public double absPow(double x, int n) {
        if(n==1) return x;
        else if(n > 1 && n%2==0) return absPow(x*x,n/2);
        else return x*absPow(x,n-1);
    }

}
