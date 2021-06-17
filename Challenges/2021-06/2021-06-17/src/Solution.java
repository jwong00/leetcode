import java.util.Arrays;

class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        s.numSubarrayBoundedMax(new int[]{1,3,2,5,4,3,9,4,1,3},3,5);
        s.numSubarrayBoundedMax(new int[] {2,1,4,3},2,3);
    }
    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
        int[] colors = new int[nums.length];

        for(int i=0;i<colors.length;i++) {
            if(nums[i]>right) colors[i] = -1; //must not be selected
            else if(nums[i]<left) colors[i] = 0; //need not be selected
            else colors[i] = 1; //absolutely must be selected
        }

        int[] pre = new int[nums.length];
        int[] post = new  int[nums.length];

        int counter = 0;
        for(int i=0;i<pre.length;i++) {
            if(colors[i]==0) {
                pre[i] = ++counter;
            }
            else if(colors[i]==1) {
                pre[i] = ++counter;
                counter=0;
            }
            else {
                counter=0;
                pre[i]=counter;
            }
        }

        counter = 0;
        for(int i=post.length-1;i>=0;i--) {
            if(colors[i] > -1) post[i] = ++counter;
            else counter = 0;
        }

        int r = 0 ;

        for(int i=0;i<nums.length;i++) {
            if(colors[i]==1) {
                r+=pre[i]*post[i];
            }
        }

//        System.out.println(Arrays.toString(nums));
//        System.out.println(Arrays.toString(colors));
//        System.out.println(Arrays.toString(pre));
//        System.out.println(Arrays.toString(post));
//        System.out.println(r);

        return r;

    }
}
