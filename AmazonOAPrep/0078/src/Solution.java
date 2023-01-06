import java.util.ArrayList;
import java.util.List;

class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.subsets(new int[]{1,2,3}));
    }
    public List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> sets = new ArrayList<>();
        sets.add(new ArrayList<>());
        for(int n : nums) {
            int k = sets.size();
            for(int i=0;i<k;i++) {
                List<Integer> t = new ArrayList<>(sets.get(i));
                t.add(n);
                sets.add(t);
            }
        }

        return sets;
    }
}
