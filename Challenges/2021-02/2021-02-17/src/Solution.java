class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] t = {1,0,8,6,2,5,4,8,3,7};
        int[] r = {2,3,10,5,7,8,9};
        int[] q = {10,9,8,7,6,5,4,3,2,1};

        s.maxArea(t);
        s.maxArea(r);
        s.maxArea(q);
    }
    public int maxArea(int[] height) {
        int i=0, j=height.length-1, maxArea=0;

        while(i<j) {
            maxArea = Math.max(maxArea,Math.min(height[i],height[j]) * (j-i));
            if(height[i]<height[j]) i++;
            else j--;
        }

        return maxArea;
    }
}
