import java.util.Arrays;
import java.util.PriorityQueue;

class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.lastStoneWeight(new int[]{2,7,4,1,8,1}));
        System.out.println(s.lastStoneWeight(new int[]{7,4,1,8,1}));
        System.out.println(s.lastStoneWeight(new int[]{1}));
    }
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> heap = new PriorityQueue<>((a,b)->b-a);
        for(int i=0;i<stones.length;i++) {
            heap.add(stones[i]);
        }

        System.out.println(Arrays.toString(heap.toArray()));
        while(heap.size()>1) {
            int a = heap.poll();
            int b = heap.poll();

            if(a!=b) heap.add(Math.abs(a-b));
        }

        return heap.isEmpty() ? 0 : heap.peek();
    }
}
