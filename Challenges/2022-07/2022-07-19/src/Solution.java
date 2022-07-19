import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.generate(5));
    }
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();

        //add the first (0th) row
        if(numRows > 0) ans.add(List.of(1));

        for(int row = 1; row < numRows; row++) {
            //create temp array representing row
            //init first/last to 1
            int[] t = new int[row+1];
            t[0] = 1;
            t[row] = 1;

            //iterate over every element not at the ends
            //set their values
            for(int i = 1; i < row; i++) {
                t[i] = ans.get(row-1).get(i-1) + ans.get(row-1).get(i);
            }

            List<Integer> list_t = new ArrayList<>();
            for(int k : t) {
                list_t.add(k);
            }
            ans.add(list_t);
        }

        return ans;
    }
}
