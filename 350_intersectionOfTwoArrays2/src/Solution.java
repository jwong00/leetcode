import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(Arrays.toString(s.intersect(new int[]{1,2,2,1},new int[]{2,2})));
        System.out.println(Arrays.toString(s.intersect(new int[]{4,9,5},new int[]{9,4,9,8,4})));
    }
    public int[] intersect(int[] nums1, int[] nums2) {
        int[] counts1 = new int[1001];
        int[] counts2 = new int[1001];

        for(int i=0;i< nums1.length;i++) {
            counts1[nums1[i]]++;
        }

        for(int i=0;i< nums2.length;i++) {
            counts2[nums2[i]]++;
        }

        int intersectSize = 0;

        for(int i=0;i<1001;i++) {
            intersectSize+=Math.min(counts1[i],counts2[i]);
        }

        int[] intersect = new int[intersectSize];
        for(int i=0,j=0;i<1001;i++) {
            for(int k=0;k<Math.min(counts1[i],counts2[i]);k++) intersect[j++] = i;
        }

        return intersect;
    }
}
