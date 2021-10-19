import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;

class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(Arrays.toString(s.nextGreaterElement(new int[]{4,1,2},new int[]{1,3,4,2})));
        System.out.println(Arrays.toString(s.nextGreaterElement(new int[]{2,4},new int[]{1,2,3,4})));
    }
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        if( nums1==null || nums1.length==0 ||
            nums2==null || nums2.length==0      ) return new int[]{};

        int[] ans = new int[nums1.length];

        Deque<Integer> st = new ArrayDeque<>();
        HashMap<Integer,Integer> nextGreater = new HashMap<>();

        for(int i=0;i<nums2.length;i++) {
            while(!st.isEmpty() && st.peek()<nums2[i]) nextGreater.put(st.pop(),nums2[i]);
            st.push(nums2[i]);
        }

        while(!st.isEmpty()) {
            nextGreater.put(st.pop(),-1);
        }

        for(int i=0;i<ans.length;i++) {
            ans[i] = nextGreater.get(nums1[i]);
        }

        return ans;
    }
}
