import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
//        return minimumAbsDifferenceCounting(arr);
        return minimumAbsDifferenceOnePass(arr);
    }

    public List<List<Integer>> minimumAbsDifferenceCounting(int[] arr) {

        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;

        for(int i=0;i<arr.length;i++) {
            min = Math.min(min,arr[i]);
            max = Math.max(max,arr[i]);
        }

        int[] line = new int[max-min+1];
        int shift = -1 * min;

        for(int i=0;i<arr.length;i++) {
            line[arr[i]+shift]++;
        }

        return null;
    }

    public List<List<Integer>> minimumAbsDifferenceOnePass(int[] arr) {
        Arrays.sort(arr);

        ArrayList<List<Integer>> ans = new ArrayList();
        int min = arr[arr.length-1] - arr[0];

        for(int i=1;i<arr.length;i++) {
            int cur = arr[i]-arr[i-1];
            if(cur < min) {
                min = cur;
                ans = new ArrayList<>();
            }
            if(cur==min)
                ans.add(Arrays.asList(arr[i-1],arr[i]));
        }

        return ans;
    }
}
