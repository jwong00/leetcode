import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;




class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] a = {2,7,11,15};
        int[] b = {1,10,4,11};

        s.advantageCount(a,b);


        int[] c = {12,24,8,32};
        int[] d = {14,25,32,11};

        s.advantageCount(c,d);
    }

    public int[] advantageCount(int[] A, int[] B) {
        Arrays.sort(A);

        PriorityQueue<int[]> q = new PriorityQueue<>((a,b)->b[1]-a[1]);
        for(int i=0;i<B.length;i++)
        {
            q.offer(new int[]{i,B[i]});
        }

        int[] result = new int[A.length];

        int slow=0,fast=A.length-1;

        while(!q.isEmpty()) {
            int[] t = q.poll();
            if(t[1]<A[fast]) result[t[0]]=A[fast--];
            else result[t[0]]=A[slow++];
        }
        System.out.println(Arrays.toString(result));


        return result;
    }
}
