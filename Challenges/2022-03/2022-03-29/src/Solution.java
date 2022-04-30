import java.util.HashSet;

class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.findDuplicate(new int[]{1,3,4,2,2}));
        System.out.println(s.findDuplicate(new int[]{3,1,3,4,2}));
    }
    public int findDuplicate(int[] nums) {

        return findDuplicateHash(nums);
    }

    public int findDuplicateHash(int[] nums) {
        HashSet<Integer> hash = new HashSet<>();
        for(int i=0;i<nums.length;i++) {
            if(hash.contains(nums[i])) return nums[i];
            else hash.add(nums[i]);
        }

        return -1;
    }
}
