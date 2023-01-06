import java.util.PriorityQueue;

class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.lastStoneWeight(new int[]{2,7,4,1,8,1}));
        System.out.println(s.lastStoneWeight(new int[]{1}));
    }
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> heap = new PriorityQueue<>((a,b)->b-a);
        for(int i=0;i<stones.length;i++) {
           heap.add(stones[i]);
        }

        while(heap.size()>1) {
            int x = heap.poll();
            int y = heap.poll();

            if(x!=y) {
                heap.add(Math.abs(x-y));
            }
        }

        return heap.isEmpty() ? 0 : heap.poll();

    }
}