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
        int[] j = {1, 2, 3, 4, 5, 6, 7, 8};
        s.subsets(j);

    }

    public class RecursiveBitSet{
        BitSet bs;
        ArrayList<BitSet> setRepresentations;
        public RecursiveBitSet(int r) {
            bs=new BitSet(r);
            setRepresentations = new ArrayList<BitSet>();
        }
        void fill(int k, int n)
        {
            if (k == n)
            {
//                System.out.println(bs);
                setRepresentations.add((BitSet)bs.clone());
//                setRepresentations.add(bs);
                return;
            }
            bs.set(k, false);
            fill(k+1, n);
            bs.set(k, true);
            fill(k+1, n);
        }
    }
    public List<List<Integer>> subsets(int[] nums) {
        ArrayList<List<Integer>> subsets = new ArrayList<List<Integer>>();
        RecursiveBitSet rbs = new RecursiveBitSet(nums.length);
        rbs.fill(0,nums.length);

        ArrayList<Integer> subset;
        for(BitSet bs : rbs.setRepresentations) {
            subset = new ArrayList<Integer>();
            for(int i=0;i<nums.length;i++) {
                if(bs.get(i)) subset.add(nums[i]);
            }
            subsets.add(subset);
//            System.out.println(bs);
        }

        for(List l : subsets) {
            System.out.println(Arrays.deepToString(l.toArray()));
        }

        return subsets;
    }

}
