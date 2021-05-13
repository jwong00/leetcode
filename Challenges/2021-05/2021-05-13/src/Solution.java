import java.util.ArrayList;
import java.util.List;

/*
    No trailing or unnecessary leading zeroes.
    Generate every  combination of proper numbers with . ,
    0 or 1 . for each of the two numbers
            s[0] == '('
    s[s.length-1]== ')'
    shortest string s is 4 char, which  trivially forms only 1 coordinate pair, regardless of 0s
*/

class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        s.ambiguousCoordinates("(00012001)");
    }
    public List<String> ambiguousCoordinates(String s) {
        if(s.length()<4) return new ArrayList<String>();

        List<String> result = new ArrayList<>();
        if(s.length()==4) {
            ; //trivial string
            return result;
        }

        /*
            find all legal comma-positions
                left-most comma must come after precisely one 0 or first non 0
                (0000100402000)
                (0000100402000)
                (00001,00402000)
                (000010040200,0)
                (000010040,2000)
                (00001,00402000)

                even simpler, place comma st that each side contains:
                    precisely one 0
                    at  least non-0

                relationship between trailing and leading zeros
                00100 --> impossible to place
                0100  --> impossible
                01    --> 0.1
                100   --> no other numbers possible
                001   --> 0.01
        */

        StringBuilder sb = new StringBuilder(s.substring(1,s.length()-1));
        int countZeroes = 0;

        ArrayList<String> t = new ArrayList<>();


        String w = sb.toString();
        for(int i=0;i+1<w.length();i++) {
            if(isValid(w.substring(0,i+1)) && isValid(w.substring(i+1))) {
                t.add("("+w.substring(0,i+1)+", "+w.substring(i+1)+")");
            }
            System.out.println("");
        }

//        for(int i=0,cz=0;i+1<s.length()-2;i++) {
//            if(s.substring(1,s.length()-1).charAt(i)=='0') cz++;
//            else cz=0;
//
//            if(cz<=1) {
//                sb.insert(i + 1, ',');
//                t.add(sb.toString());
//                System.out.println(sb.toString());
//                //BOTH HALVES MUST HAVE ONLY TRAILING OR LEADING 0, NOT BOTH
//                sb = new StringBuilder(s.substring(1,s.length()-1));
//            }
////            System.out.println(i+" "+s.substring(1,s.length()-1).charAt(i)+" "+cz);
//        }

        System.out.println(t.toString());

        return result;

    }

    public boolean isValid(String s) {
        System.out.println("Evaluating validity of "+s);
        if(s==null || s.length()==0) return false;
        int lz=0,tz=0;

        for(int i=0;i<s.length();i++) {
            if(s.charAt(i)=='0') lz++;
            else break;
        }

        for(int j=s.length()-1;j>0;j--) {
            if(s.charAt(j)=='0') tz++;
            else break;
        }

        if(lz>0 && tz>0) {
            System.out.println(s+" is not valid!");
            return false;
        }
        System.out.println(s+ " must be valid!");
        return true;
    }
}
