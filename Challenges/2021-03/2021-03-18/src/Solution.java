import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();

        int[] g = {1,7,4,9,2,5};

        s.wiggleMaxLength(g);

        int[] r = {1,17,5,10,13,15,10,5,16,8};
        s.wiggleMaxLength(r);

        int[] a = {1,2,3,4,5,6,7,8,9};
        s.wiggleMaxLength(a);
    }
    public int wiggleMaxLength(int[] nums) {
        if(nums==null) return 0;
        if(nums.length<2) return 1;

        int[] diffArray = new int[nums.length];

        diffArray[0]=0;

        for(int i=1;i<diffArray.length;i++) {
            diffArray[i]=nums[i]-nums[i-1];
        }
        System.out.println(Arrays.toString(diffArray));

        int wml = 1;

        for(int j=1;j<diffArray.length;j++) {
            if(diffArray[j-1]>0) {
                while(j<diffArray.length && diffArray[j]>0) j++;

            }
            else if(diffArray[j-1]<0) {
                while(j<diffArray.length && diffArray[j]<0) j++;
            }
            else while(j<diffArray.length && diffArray[j]==0) j++;

            if(j>=diffArray.length) break;
            wml++;
        }

        System.out.println(wml);

        return wml;
    }
}
