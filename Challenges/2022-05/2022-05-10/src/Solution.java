import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.combinationSum3(3,7));
    }

    protected void backtrack(int k, int r, int num, LinkedList<Integer> selection, List<List<Integer>> result) {
        if(r==0 && selection.size()==k) {
            result.add(new ArrayList<Integer>(selection));
            return;
        }
        else if(r<0 || selection.size()==k)    return;

        for(int i = num; i<=9; i++) {
            selection.add(i);
            this.backtrack(k,r-i,i+1,selection,result);
            selection.removeLast();
        }

    }
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        LinkedList<Integer> selection = new LinkedList<Integer>();
        backtrack(k,n,1,selection,result);
        return result;
    }
}
