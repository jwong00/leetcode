class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.shipWithinDays(new int[]{1,2,3,4,5,6,7,8,9,10},5));
    }
    public int shipWithinDays(int[] weights, int days) {
        int min = 0, max = 0;

        for(int i=0;i<weights.length;i++) {
            min = Math.max(min,weights[i]);
            max+= weights[i];
        }
        //bin search between min and max
        while(min<max) {
            int mid = min + (max-min)/2;
            //simulate shipment with this weight
            if(getDays(weights,mid) > days) min = mid+1;
            else max = mid;

        }

        return min;
    }

    //return number of days to ship with this weight limit
    public int getDays(int[] weights, int weight) {
        int days = 1, weight_cur = 0;
        for(int i=0;i<weights.length;i++) {
            weight_cur+=weights[i];
            if(weight_cur>weight) {
                weight_cur = weights[i];
                days++;
            }
        }
        return days;
    }
}
