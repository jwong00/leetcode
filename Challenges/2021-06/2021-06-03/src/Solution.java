import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.maxArea(5,4, new int[] {1,2,4}, new int[] {1,3}));
        System.out.println(s.maxArea(5,4, new int[] {3,1}, new int[] {1}));
        System.out.println(s.maxArea(5,4, new int[] {3}, new int[] {3}));
        System.out.println(s.maxArea(50,15,new int[] {37,40,41,30,27,10,31},new int[] {2,1,9,5,4,12,6,13,11}));
    }
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);

        int h_max = horizontalCuts[0];
        for(int i=1;i<horizontalCuts.length;i++) {
            h_max = Math.max(h_max,horizontalCuts[i]-horizontalCuts[i-1]);
        }
        h_max = Math.max(h_max,h-horizontalCuts[horizontalCuts.length-1]);

        int v_max = verticalCuts[0];
        for(int j=1;j<verticalCuts.length;j++) {
            v_max = Math.max(v_max,verticalCuts[j]-verticalCuts[j-1]);
        }
        v_max = Math.max(v_max,w-verticalCuts[verticalCuts.length-1]);

        return (int)(1L * v_max * h_max % 1_000_000_007);
    }

}
