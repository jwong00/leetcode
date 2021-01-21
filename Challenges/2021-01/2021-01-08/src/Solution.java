import java.util.Arrays;

class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();

        String[] w1 = {"ab","c"};
        String[] w2 = {"a","bc"};

//        System.out.println(s.arrayStringsAreEqual(w1,w2));

        String[] w3 = {"wxgdwznoledlfeoilewsjziotnncyebhwpdnnimcorzovuiig","lycfb"};
        String[] w4 =  {"wxgdwznoledlfeoilewsjzio","tnncyebhwpdnnimcor","iigl","yc","f","b","hnjm"};

        System.out.println(s.arrayStringsAreEqual(w3,w4));
    }



    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {

//        if(word1.length != word2.length) return false;

        System.out.println("String arrays:");
        System.out.println(Arrays.deepToString(word1));
        System.out.println(Arrays.deepToString(word2));

        String word1_concatenated = new String();
        String word2_concatenated = new String();

        for(String s : word1) {
            word1_concatenated = word1_concatenated.concat(s);
        }

        for(String s : word2) {
            word2_concatenated = word2_concatenated.concat(s);
        }

        System.out.println("As actual strings:");
        System.out.println(word1_concatenated);
        System.out.println(word2_concatenated);

        if(word1_concatenated.length()!=word2_concatenated.length()) return false;


        for(int i=0; i < word1_concatenated.length(); i++) {
            if(word1_concatenated.charAt(i) != word2_concatenated.charAt(i)) return false;
        }

        return true;
    }
}

