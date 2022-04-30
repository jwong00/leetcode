import java.util.Arrays;
import java.util.PriorityQueue;

class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
        System.out.println(s.maxArea(new int[]{1,1}));
    }
    public int maxArea(int[] height) {
        if(height==null || height.length==0) return 0;

        int i=0,j=height.length-1, area = 0;

        while(i<j) {
            area = Math.max(area,Math.min(height[i],height[j])*(j-i));
            if(height[i] < height[j]) i++;
            else j--;
        }

        return area;
    }
}
