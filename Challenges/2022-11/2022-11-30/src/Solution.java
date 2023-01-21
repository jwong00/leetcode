import java.util.HashMap;
import java.util.HashSet;

class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.uniqueOccurrences(new int[]{1,2,2,1,1,3}));
        System.out.println(s.uniqueOccurrences(new int[]{1,2}));
        System.out.println(s.uniqueOccurrences(new int[]{-3,0,1,-3,1,1,1,-3,10,0}));
    }
    public boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer,Integer> freq = new HashMap<>();

        for(int i=0;i<arr.length;i++) {
            freq.put(arr[i],freq.getOrDefault(arr[i],0)+1);
        }

        HashSet<Integer> set = new HashSet<>();

        for(Integer i : freq.values()) {
            if(set.contains(i)) return false;
            else set.add(i);
        }

        return true;
    }
}
