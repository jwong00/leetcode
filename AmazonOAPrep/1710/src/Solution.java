import java.util.Arrays;

/*
* LC 1710 :: Maximum Units on a Truck
* */
class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.maximumUnits(new int[][]{{1,3},{2,2},{3,1}},4));

    }
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (a, b)->b[1]-a[1]);

        int ans = 0;
        for(int i=0;i<boxTypes.length && truckSize > 0;i++) {
            int min = Math.min(truckSize, boxTypes[i][0]);
            ans+= min * boxTypes[i][1];
            truckSize -= min;
        }
        return ans;
    }
}
