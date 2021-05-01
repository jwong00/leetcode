import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        s.powerfulIntegers(2,3,10);
    }
    public List<Integer> powerfulIntegers(int x, int y, int bound) {
        HashSet<Integer> x_powers = new HashSet<>();
        HashSet<Integer> y_powers = new HashSet<>();

        if(x>1) for(int m=1;m<bound;m*=x) {
            x_powers.add(m);
        }
        else x_powers.add(1);

//        System.out.println("Powers of "+x+":");
//        for(Integer m : x_powers) {
//            System.out.println(m);
//        }

        if(y>1) for(int n=1;n<bound;n*=y) {
            y_powers.add(n);
        }
        else y_powers.add(1);

//        System.out.println("Powers of "+y+":");
//        for(Integer n : y_powers) {
//            System.out.println(n);
//        }

        HashSet<Integer> result = new HashSet<Integer>();
        for(Integer m : x_powers) {
            for(Integer n : y_powers) {
                if(m+n<=bound) result.add(m+n);
            }
        }

//        System.out.println("Final answer:");

        ArrayList<Integer> list = new ArrayList<>();
        for(Integer r : result) {
            System.out.println(r);
            list.add(r);
        }

        return list;

    }
}
