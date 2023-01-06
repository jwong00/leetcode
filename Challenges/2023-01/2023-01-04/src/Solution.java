import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.minimumRounds(new int[]{2,2,3,3,2,4,4,4,4,4}));
    }

    public int minimumRounds(int[] tasks) {
        int n = tasks.length;

        //count frequencies of each difficulty level
        HashMap<Integer,Integer> freq = new HashMap<>();
        for(int i=0;i<n;i++) {
            freq.put(tasks[i],freq.getOrDefault(tasks[i],0)+1);
        }

        //the frequencies are the number of tasks with that difficulty level
        //compute or return from table the length of shortest sequence of 2's and 3's that sum
        //to that difficulty level
        int ans = 0;
        for(int f : freq.values()) {
            if(f==1) return -1;
            else if(f%3==0) ans+=f/3;
            else ans+=(f/3+1);
        }
        return ans;
    }


}