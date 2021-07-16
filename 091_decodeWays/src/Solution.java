import java.util.Arrays;

class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.numDecodings("13252015"));
        System.out.println(s.numDecodings("226"));
    }
    public int numDecodings(String s) {
       int[]  nums = new int[s.length()];
       for(int i=0;i<s.length();i++) {
//           nums[i]=s
       }

        return -1;

//        int[] nums = new int[s.length()];
//        for(int i=0;i<s.length();i++) {
//            nums[i]=Character.getNumericValue(s.charAt(i));
//        }
//
//        int[] select = new int[s.length()-1];
//
//        //assume no leading zeros rn
//        for(int j=0;j<select.length;j++) {
//
//            //ex:
//            // ...04
//            //    ^
//            if (nums[j] == 0 ^ nums[j+1]==0) select[j] = 1;
//
//            //too many zeroes should zero out our selection
//            // 2001 cannot be decoded because 1 has a leading zero
//            else if(nums[j]==0&&nums[j+1]==0) select[j] = 0;
//
//            // <26, can select space two ways:
//            // 2,5==>{"2 5", "25"}
//            else if (10 * nums[j] + nums[j + 1] <= 26) select[j] = 2;
//            else select[j]=1;
//        }
//
//        System.out.println(Arrays.toString(select));
//
//        return 0;

    }
}
