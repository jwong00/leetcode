import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(Arrays.toString(s.intersection(new int[] {1,2,2,1}, new int[] {2,2})));


    }
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> nums1_hashset = new HashSet<>();
        for(int i=0;i<nums1.length;i++) {
            nums1_hashset.add(nums1[i]);
        }

        HashSet<Integer> nums2_hashset = new HashSet<>();
        for(int i=0;i<nums2.length;i++) {
            nums2_hashset.add(nums2[i]);
        }

        HashSet<Integer> a,b;

        if(nums1_hashset.size()<=nums2_hashset.size()) {
            a = nums1_hashset;
            b = nums2_hashset;
        }
        else {
            a = nums2_hashset;
            b = nums1_hashset;
        }

        ArrayList<Integer> t = new ArrayList();

        for(Integer k : a) {
            if(b.contains(k)) t.add(k);
        }

        int[] result = new int[t.size()];

        for(int i=0;i<result.length;i++) result[i] = t.get(i);

        return result;
    }
}
