import java.util.*;

class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        HashSet<List<Integer>> set = new HashSet<>();
        System.out.println(s.permuteUnique(new int[]{1,1,2}));
        System.out.println(s.permuteUnique(new int[]{1,2,3}));

//        ArrayList<Integer> a = new ArrayList<Integer>(Arrays.asList(1,2,3,4));
//        ArrayList<Integer> b = new ArrayList<Integer>(Arrays.asList(1,2,3,4));
//        System.out.println(set.add(a));
//        System.out.println(set.add(b));
    }
    public List<List<Integer>> permuteUnique(int[] nums) {
//        List<List<Integer>> result = new ArrayList<>();
        HashSet<List<Integer>> result = new HashSet<>();
        Deque<List<Integer>> permutations = new ArrayDeque<>();
        permutations.add(new ArrayList<>());

        for(int num : nums) {
            int n = permutations.size();

            for(int i=0;i<n;i++) {
                List<Integer> p_old = permutations.poll();
                for(int j=0;j<=p_old.size();j++) {
                    List<Integer> p_new = new ArrayList<Integer>(p_old);
                    p_new.add(j,num);
                    if(p_new.size()==nums.length) result.add(p_new);
                    else permutations.add(p_new);
                }
            }
        }

        return new ArrayList<>(result);
    }
}
