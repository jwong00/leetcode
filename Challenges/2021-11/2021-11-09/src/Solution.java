import java.util.ArrayList;
import java.util.List;

class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.findNumOfValidWords(   new String[]{"aaaa","asas","able","ability","actt","actor","access"},
                                                    new String[]{"aboveyz","abrodyz","abslute","absoryz","actresz","gaswxyz"}));

    }
    public List<Integer> findNumOfValidWords(String[] words, String[] puzzles) {
        if(words==null || puzzles==null || words.length==0 || puzzles.length==0)
            return null;

        int m = words.length, n = puzzles.length;

        boolean[][] word_hashes = new boolean[m][];
        boolean[][] puzzle_hashes = new boolean[n][];
        char[] first_letter = new char[m];

        //determine which letters are in each puzzle
        //and the first letter of each puzzle
        for(int i=0;i<m;i++) {
            word_hashes[i] = new boolean['z'-'a'+1];
            int length = words[i].length();

            //iterate over word in words
            //terminate early if we encounter all 26 letters
            for(int j=0,c=0;j<length && c < 26;j++) {
                if(!word_hashes[i][words[i].charAt(j)-'a']) {
                    word_hashes[i][words[i].charAt(j)-'a'] = true;
                    c++;
                }
            }

            first_letter[i] = words[i].charAt(0);
        }

        for(int i=0;i<n;i++) {
            puzzle_hashes[i] = new boolean['z'-'a'+1];
            int length = puzzles[i].length();
            for(int j=0;j<length;j++) {
                puzzle_hashes[i][puzzles[i].charAt(j)-'a'] = true;
            }
        }

        //iterate over each puzzle
        ArrayList<Integer> ans = new ArrayList<>();

        for(int i=0;i<n;i++) {

            System.out.println(puzzles[i]);

            int count = 0;
            //iterate over each word
            word:
            for(int j=0;j<m;j++) {
                //check if puzzle's first char is in word
                if(!word_hashes[j][first_letter[i]-'a']) continue; //break

                //if char c is in word
                //check if c also in puzzle
                for(int c=0;c<'z'-'a'+1;c++) {
                    if( !(word_hashes[j][c] && puzzle_hashes[i][c]) ) continue word;
                }

                System.out.println(words[j]);
                count++;


                //if ever false, return early


            }

            ans.add(count);
        }

        return ans;
    }
}
