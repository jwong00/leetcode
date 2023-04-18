import java.util.HashMap;
import java.util.Map;

class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.zeroFilledSubarray(new int[]{1,3,0,0,2,0,0,4}));
        System.out.println(s.zeroFilledSubarray(new int[]{0,0,0,2,0,0}));
    }
    public long zeroFilledSubarray(int[] nums) {

        //to store region lengths and frequencies of region lengths
        HashMap<Integer,Integer> regions = new HashMap<>();

        int count = 0;
        int total = 0;
        for(int i=0;i<nums.length;i++) {
            //exiting a region of 0
            if(i>0 && nums[i-1]==0 && nums[i]!=0) {
                regions.put(count,regions.getOrDefault(count,0)+1);
//                total++;
                count = 0;
            }
            else if(nums[i]==0) count++;

            //special case: end of array and 0
            //general edge-detection above will not apply
            if(i==nums.length-1 && nums[i]==0) {
                count++;
//                total++;
                regions.put(count,regions.getOrDefault(count,0)+1);
            }
        }

        //compute total number of subarrays:
        for(Map.Entry<Integer,Integer> region : regions.entrySet()) {
            System.out.println(region);
            //region: R< region length,frequency >
            total+=subgroups(region.getKey()) * region.getValue();
        }

        return total;

    }

/*
    return the total number of subarrays
    of a subarray of i 0's (i-length string of zeros)
    e.g. [0,0,0]
        3 of [0]
        2 of [0,0]
        1 of [0,0,0]

    given directly by closed form expression:
*/

    private int subgroups(int i) {
        return (i * ( i + 1) ) / 2;
    }
}
