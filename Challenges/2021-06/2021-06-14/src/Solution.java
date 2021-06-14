import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.maximumUnits(new int[][] {{1,3},{2,2},{3,1}},4));
        System.out.println(s.maximumUnits(new int[][] {{5,10},{2,5},{4,7},{3,9}},10));
    }
    public int maximumUnits(int[][] boxTypes, int truckSize) {

        Arrays.sort(boxTypes, new Comparator<int[]>() {
            @Override
            public int compare(int[] e1, int[] e2) {
                int t = e1[1]-e2[1];
                if(t>0) return 1;
                else if(t<0) return -1;
                else return 0;
            }
        });

        int u = 0;
        for(int i=boxTypes.length-1;i>=0 && truckSize>0;i--) {
            u += Math.min(truckSize,boxTypes[i][0]) * boxTypes[i][1];
            truckSize -= boxTypes[i][0];
        }

        return u;

    }
}
