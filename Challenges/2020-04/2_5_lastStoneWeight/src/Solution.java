import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {
    public static void main(String[] args) {
        int[] k = {2,7,4,1,8,1};
        Solution s = new Solution();
        System.out.println(s.lastStoneWeight(k));
    }
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> stoneHeap = new PriorityQueue<>(
                (o1, o2) -> o2 - o1
        );
        for(int i : stones) {
            stoneHeap.offer(i);
        }
        return smash(stoneHeap);
    }
    public int smash(PriorityQueue<Integer> s) {
        if(s.size()<1) return 0;
        if(s.size()==1) return s.poll();

        s.offer(s.poll()-s.poll());
        return smash(s);
    }
}
