import java.util.ArrayList;
import java.util.List;

class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.compareVersion("1.01","1.001"));
        System.out.println(s.compareVersion("1.0","1.0.0"));
        System.out.println(s.compareVersion("0.1","1.1"));
    }
    public int compareVersion(String version1, String version2) {


        List<List<Integer>> version1_revisions = new ArrayList<>();
        List<List<Integer>> version2_revisions = new ArrayList<>();

        int ptr1 = 0, ptr2 = 0;

        while(ptr1 < version1.length() && ptr2 < version2.length()) {

            //absorb leading zeros
            while(version1.charAt(ptr1)=='0') ptr1++;
            while(version2.charAt(ptr2)=='0') ptr2++;

            //longer revision number implies greater version number
            if(ptr1 < ptr2) return +1;
            if(ptr1 > ptr2) return -1;

            //ptr1==ptr2 --> current revision has same length
            while(version1.charAt(ptr1)!='.' && version2.charAt(ptr2)!='.') {

                if(version1.charAt(ptr1) > version2.charAt(ptr2)) return +1;
                if(version1.charAt(ptr1) < version2.charAt(ptr2)) return -1;

                ptr1++;
                ptr2++;
            }

            //advance past revision separator
            ptr1++;
            ptr2++;
        }

        return 0;
    }
}
