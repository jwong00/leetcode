import java.util.ArrayList;
import java.util.List;

class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        s.grayCode(5);
    }
    public List<Integer> grayCode(int n) {
//        double k = Math.pow(2,n);
//        for(int i=0;i<=k;i++) {
//            System.out.println(i+" "+Integer.toBinaryString(i));
//        }
        List<Integer> graycodeSeq = new ArrayList<>();
        if(n==1) {

        }
        int k=1;
        for(int i=0;i<=n;i++) {


            System.out.println("for n="+i);
            for(int j=k/2;j<=k-1;j++) {
                System.out.println(j+" "+Integer.toBinaryString(j));
            }
            k*=2;
        }
        return null;
    }
}
