import java.util.ArrayList;
import java.util.List;

/**
 * Created by Glamdring on 1/28/2017.
 */
public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] j = {1,2,3,4,5,6,7,8};
//        s.subsets(j);
        s.nextSet(j,0,1);
    }
    public List<List<Integer>> subsets(int[] nums) {
        ArrayList<ArrayList<Integer>> subsets = new ArrayList<ArrayList<Integer>>();
        for(int size=0; size<nums.length; size++) {
            //generate subsets starting with the one-set, ending with full set
            nextSet(nums, 0, size);
        }
        return null;
    }
    public void nextSet(int[] set, /*List<Integer> subset,*/ int index, int size) {
        if(size>1) {
            for(int i=index; i<set.length-size;i++) {
                nextSet(set, /*new ArrayList<>(subset),*/ index+1, size-1);
            }
        }
        else { // size<=1
            for(int i=index; i<set.length; i++) {
                System.out.println(set[i]);
            }
        }

    }
}
