import javax.swing.plaf.SliderUI;

class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        s.isIdealPermutation(new int[] {1,2,0});
    }

    public boolean isIdealPermutation(int[] A) {
        return isIdealPermutationDiff(A);
    }
    public boolean isIdealPermutationMax(int[] A) {

        int max = Integer.MIN_VALUE;

        for(int i=1;i<A.length;i++) {
            if(A[i]<max) return false;
            else max = Math.max(max,A[i-1]);
        }

        return true;


    }

    public boolean isIdealPermutationDiff(int[] A) {
        for (int i = 0; i < A.length; i++) {
            if (Math.abs(A[i] - i) >= 2) return false;
        }
        return true;
    }
}
