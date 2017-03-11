import java.net.Inet4Address;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Glamdring on 3/3/2017.
 */
public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] a = {1,2,3,4,5,0,0,0,0,0};
        int[] b = {1,2,3,3,7};
        s.merge(a,5,b,5);
        System.out.println(Arrays.toString(a));

        int[] c = {1,1,1,1,1,0,0,0,0,0};
        int[] d = {1,2,3,3,7};
        s.merge(c,5,d,5);
        System.out.println(Arrays.toString(c));

        int[] e = {1,3,4,5,6,0,0,0,0,0};
        int[] f = {1,1,2,3,3};
        s.merge(e,5,f,5);
        System.out.println(Arrays.toString(e));

    }
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        ArrayList<Integer> z = new ArrayList<>();
        int j=0,k=0;
        while(j < m || k < n) {
            if(j>=m) { //nums1 exhausted
                z.add(nums2[k]);
                k++;
            }
            else if(k>=n) { //nums2 exhausted
                z.add(nums1[j]);
                j++;
            }
            else if(nums1[j] < nums2[k]) { //neither exhausted
                z.add(nums1[j]);
                j++;
            }
            else {
                z.add(nums2[k]);
                k++;
            }
        }
        for(int i=0;i<m+n;i++) {
            nums1[i] = z.get(i);
        }
    }
}
