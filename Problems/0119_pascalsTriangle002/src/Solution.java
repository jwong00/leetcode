import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    List<List<Integer>> pt;

    public Solution() {
        /*
        * due to leetcode problem constraint
        * just populate all possible values
        * and look them up later
        * */
        pt = generate(33);
    }

    public static void main(String args[]) {
        Solution s = new Solution();
        System.out.println(s.getRow(0));
        System.out.println(s.getRow(5));
        System.out.println(s.getRow(2));
    }

    public List<Integer> getRow(int rowIndex) {
//        if (pt == null || pt.size() == 0 || pt.size() < rowIndex) {
//            this.pt = generate(2 * (rowIndex + 1) );
//        }
//        return pt.get(rowIndex);
        return pt.get(rowIndex);
    }

    private List<List<Integer>> generate(int numRows) {
        if(numRows<1) return new ArrayList<>();
        List<List<Integer>> triangle = new ArrayList<>();
        List<Integer> f = new ArrayList<>();
        f.add(1);
        triangle.add( f ) ;

        for(int i=1; i<numRows; i++) {
            List<Integer> row = new ArrayList<>();
            List<Integer> lastRow = triangle.get(i-1);
            for(int column=0; column<i+1; column++) {

                if(column==0 || column==i) row.add(1);
                else {
                    row.add(lastRow.get(column-1)+lastRow.get(column));
                }
            }
            triangle.add(row);
        }
        return triangle;
    }
}

