/**
 * Created by Glamdring on 5/10/2017.
 */
public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
//        s.mySqrt(64);
//        s.mySqrt(144);
//        s.mySqrt(24);
//        s.mySqrt(2);
        s.mySqrt(2147395599);
    }
    public int mySqrt(int x) {
        if(x<2) return x;
        long root=x/2;
        while(root*root > (long)x) {
            root/=2;
            System.out.println(root);
        }
        while(root*root < x) {
            root+=1;
        }
        if(root*root > x) root-=1;
        return (int) root;

    }
}
