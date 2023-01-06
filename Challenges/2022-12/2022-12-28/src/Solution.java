import java.util.Collections;
import java.util.PriorityQueue;
import java.util.TreeSet;

class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
//        System.out.println(5/2);
        System.out.println(s.minStoneSum(new int[]{5,4,9},2));
        System.out.println(s.minStoneSum(new int[]{4,3,6,7},3));

    }
    public int minStoneSum(int[] piles, int k) {
        PriorityQueue<Integer> sortedPiles = new PriorityQueue<>((a,b)->b-a);
        int total = 0;
        for(int pile : piles) {
            total+=pile;
            sortedPiles.add(pile);
        }
        while(!sortedPiles.isEmpty() && k>0) {
//            sortedPiles.add(sortedPiles.poll()/2);
            int cache = sortedPiles.poll();
            total-=cache/2;
            cache-=cache/2;
            sortedPiles.add(cache);
            k--;
        }
        return total;
    }
}
