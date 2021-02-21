import java.util.Arrays;

class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] t = {1,2,3,4,5,2,0,10,13,16};
        int[] g = {1,2,3,4,5,6,7,7,7,10,13,16};
        int[] u = {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1};
        s.numberOfArithmeticSlices(t);
        s.numberOfArithmeticSlices(u);
    }
    public int numberOfArithmeticSlices(int[] A) {
        if(A.length==0 || A==null) return 0;
        int[] diff = new int[A.length];

        for(int k=0;k<A.length-1;k++) {
            diff[k] = A[k+1]-A[k];
        }

        int[] runs = new int[A.length];

        for(int i=0,k=0,num=diff[0],count=0;i<diff.length-1;i++) {
            if(diff[i]!=num) {
                k++;
                num=diff[i];

            }
            runs[k]++;
        }

        int slices=0;

        for(int j=0;j<runs.length && runs[j]!=0;j++) {
            slices+=r(runs[j]);
        }
        return slices;
    }

    private int r(int k) {
        int q=0;
        while(k>1) {
            k--;
            q+=k;
        }

        return q;
    }
}
