/**
 * Created by Glamdring on 11/19/2016.
 */
public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] p1 = {0,0,0,0,2,0,1,0,2,0,4,9,1,1,5,0};
        int[] p2 = {1,0,0,2};
        int[] p3 = {4,6,7,2,8,2,4,4,6,6,3,7,9,1,3,4,5};
        System.out.println(s.trap(p1));
        System.out.println(s.trap(p2));
        System.out.println(s.trap(p3));
    }
    public static final boolean DEBUG = false;
    public int trap(int[] height) {
        int length=height.length;
        int left=0;
        int right=0;
        int sum=0;
        int curHeight=0;
        int gMaxIndex=0;

        while (right<length-1) { //right bounds > left bounds
            if(DEBUG) System.out.println("Left: "+left);
            right=left+1;
            while(height[right]<height[left] && right<length-1) {
                right++;
            }

            if(height[right]<height[left] && right==length-1) {
                if(DEBUG) System.out.println("Global max: "+height[gMaxIndex]+" and length is "+length);
                break;
            }
            curHeight=height[left];
            while(left<right) {
                sum+=curHeight-height[left];
                left++;
            }
            gMaxIndex=right;
        }
        if(gMaxIndex<length) {
            if(DEBUG) System.out.println("Reversing....");
            right=length-1;
            left=right-1;
            if(DEBUG) System.out.println("gMaxIndex: "+gMaxIndex+" left: "+left);
            while (left>gMaxIndex) {
                if(DEBUG) System.out.println("Here1.");
                left=right-1;
                while(height[left]<height[right] && left>gMaxIndex) {
                    left--;
                }
                if(height[left]<height[right] && left==gMaxIndex) {
                   if(DEBUG) System.out.println("breaking");
                    break;
                }
                if(DEBUG) System.out.println("Here.");
                curHeight=height[right];
                while(right>left) {
                    if(DEBUG) System.out.println(" adding from back.");
                    sum+=curHeight-height[right];
                    right--;
                }
            }
        }

        if(DEBUG) System.out.println("Sum: " +sum);
        return sum;
    }
}
