import java.util.Arrays;
import java.util.HashSet;

class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] q = {0,1,2,3,4,5};
        int[] r = {3,10};

        System.out.println(Arrays.toString(s.intersection(q,r)));
    }
    public int[] intersection(int[] nums1, int[] nums2) {
        int[] intersect = {};

        if(nums1.length==0 || nums2.length==0) return intersect;

        int len = Math.max(nums1.length,nums2.length);
        HashSet<Integer> test = new HashSet<>();
        intersect = new int[len];

        for(int i=0; i<nums1.length;  i++) {
            test.add(nums1[i]);
        }

        for(int j=0,i=0; j<nums2.length; j++) {
            if(test.contains(nums2[j])) {
                intersect[i++] = nums2[j];
            }
        }

        return intersect;
    }
}
