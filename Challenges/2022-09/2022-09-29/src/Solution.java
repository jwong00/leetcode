import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.findClosestElements(new int[]{1,2,3,4,5},4,3));
    }
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(arr.length,(a,b)->Math.abs(a-x)-Math.abs(b-x));

        for(int i=0;i<arr.length;i++) pq.offer(arr[i]);

        List<Integer> ans = new ArrayList<>();

        while(k>0) {
            ans.add(pq.poll());
            k--;
        }

        Collections.sort(ans);

        return ans;
    }
}
