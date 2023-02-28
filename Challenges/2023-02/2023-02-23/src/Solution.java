import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.PriorityQueue;

class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.findMaximizedCapital(2,0,new int[]{1,2,3},new int[]{0,1,1}));
        System.out.println(s.findMaximizedCapital(3,0,new int[]{1,2,3},new int[]{0,1,1}));
        System.out.println(s.findMaximizedCapital(1,0,new int[]{1,2,3},new int[]{1,1,2}));
    }
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {



        //store all projects as a set
        HashSet<int[]> projectSet = new HashSet<>();
        for(int i=0;i<profits.length;i++) {
            projectSet.add(new int[]{profits[i],capital[i]});
        }

        //possible projects sorted by order of profit
        //idea: insert a project iff cost <= w
        PriorityQueue<int[]> projectQueue = new PriorityQueue<>((a,b)->b[0]-a[0]);

        while(k>0) {

            //use set to find projects within cost
            Iterator<int[]> iter = projectSet.iterator();
            while(iter.hasNext()) {
                int[] cache = iter.next();
                if (cache[1] <= w) {
                    projectQueue.offer(cache);
                    iter.remove();
                }
            }

            //take a project of highest profit whose capital[i] falls within w
            //add its profit to w
//            System.out.println(Arrays.toString(projectQueue.peek()));
            if(projectQueue.isEmpty()) break;
            w+=projectQueue.poll()[0];
            k--;
        }

        return w;
    }
}
