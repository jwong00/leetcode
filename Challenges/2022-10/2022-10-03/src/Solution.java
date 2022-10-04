class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.minCost("abaac",new int[]{1,2,3,4,5}));
        System.out.println(s.minCost("abc",new int[]{1,2,3}));
        System.out.println(s.minCost("aabaa",new int[]{1,2,3,4,1}));
    }
    public int minCost(String colors, int[] neededTime) {
        //iterate over string
        //when duplicates are detected, start summing time for each balloon, and track the minimum
        //when done traversing the duplicates, find the diff of total-min and add that to cost

        char last = colors.charAt(0);
        int max = neededTime[0], sum = max, cost = 0;

        for(int i=1;i<colors.length();i++) {
           if(colors.charAt(i)==last) {
               max = Math.max(max,neededTime[i]);
               sum+=neededTime[i];
           }
           else {
               //add cost of removed
               cost+=(sum-max);
               max = neededTime[i];
               sum = max;
           }

           last = colors.charAt(i);
        }

        cost+=(sum-max);

        return cost;
    }
}
