import java.util.ArrayList;
import java.util.List;

class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        s.generateParenthesis(3);
    }
    public List<String> generateParenthesis(int n) {
        ArrayList<String> results = new ArrayList<>();
        this.nextParenthesis(0,0,n,"",results);
        return results;
    }

    public void nextParenthesis(int open, int k,int n, String seq, List<String> p) {
        if(seq.length()==2*n) {
//            System.out.println(seq);
            p.add(seq);
            return;
        }
        //add another open  paren
        if(k<n)nextParenthesis(open+1,k+1,n,seq+"(",p);
        //add a close paren
        if(open>0) nextParenthesis(open-1,k,n,seq+")",p);
    }
}
