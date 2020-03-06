import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.List;

/**
 * Created by Glamdring on 1/28/2017.
 */
public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] j = {1, 2, 3};
        s.subsets(j);

    }

    public List<List<Integer>> subsets(int[] nums) {
        ArrayList<List<Integer>> subsets = new ArrayList<List<Integer>>();
        int n = nums.length;
        for (int i = (int)Math.pow(2, n); i  < (int)Math.pow(2, n +1); ++i) {
            String bm = Integer.toBinaryString(i).substring(1);
            List<Integer> subset = new ArrayList();
            for(int j = 0; j < n; ++j) {
                if(bm.charAt(j)=='1') subset.add(nums[j]);
            }
            subsets.add(subset);
        }

//        for(List s : subsets) System.out.println(Arrays.deepToString(s.toArray()));

        return subsets;
    }

}
