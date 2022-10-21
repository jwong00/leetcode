import java.util.HashSet;

class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.containsNearbyDuplicate(new int[]{1,2,3,1},3));
        System.out.println(s.containsNearbyDuplicate(new int[]{1,0,1,1},1));
        System.out.println(s.containsNearbyDuplicate(new int[]{1,2,3,1,2,3},2));
    }
    public boolean containsNearbyDuplicate(int[] nums, int k) {

        HashSet<Integer> window = new HashSet<>();

        for(int i=0;i<nums.length;i++) {
            if(window.contains(nums[i])) return true;
            else window.add(nums[i]);

            if(window.size() > k) window.remove(nums[i-k]);
        }

        return false;

    }
}
