import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        s.letterCombinations("");
    }
    public char[][] map = new char[10][];

    public Solution() {
        map[2] = new char[] {'a','b','c'};
        map[3] = new char[] {'d','e','f'};
        map[4] = new char[] {'g','h','i'};
        map[5] = new char[] {'j','k','l'};
        map[6] = new char[] {'m','n','o'};
        map[7] = new char[] {'p','q','r','s'};
        map[8] = new char[] {'t','u','v'};
        map[9] = new char[] {'w','x','y','z'};

//        for(int i=2;i<10;i++) {
//            System.out.println(Arrays.toString(map[i]));
//        }
    }

    public List<String> letterCombinations(String digits) {
        ArrayList<String> memo = new ArrayList<>();
        processNext("",digits,memo);
        System.out.println(memo.size());
        return memo;
    }

    public List<String> processNext(String current, String digitsLeft, ArrayList<String> memo) {

//        System.out.println("Current string: "+current+" Digits left: "+digitsLeft);
        if(current.length()==0 && digitsLeft.length()==0) return memo;
        if(digitsLeft.length()==0) {
            memo.add(current);
            return memo;

        }
        for(char c : map[Character.getNumericValue(digitsLeft.charAt(0))] ) {
            processNext(current+c,digitsLeft.substring(1),memo);
        }

        return memo;
    }
}
