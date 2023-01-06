import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(Arrays.toString(s.createTargetArray(new int[]{0,1,2,3,4},new int[]{0,1,2,2,1})));
    }
    public int[] createTargetArray(int[] nums, int[] index) {
        ArrayList<Integer> target = new ArrayList<>();
        int m = nums.length;
        for(int i=0;i<m;i++) {
            target.add(index[i],nums[i]);
        }

        int[] t = new int[m];

        for(int i=0;i<m;i++) t[i]=target.get(i);

        return t;
    }
}
