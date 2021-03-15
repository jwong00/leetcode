import java.util.HashSet;

class Solution {
    public static void main(String[] args) {
        String[] q = {"time","me","bell"};

        Solution s = new Solution();
        s.minimumLengthEncoding(q);
    }

    public int minimumLengthEncoding(String[] words) {
        if(words==null || words.length==0) return 0;

        HashSet<String> dictionary = new HashSet<>();

        for(int i=0;i<words.length;i++) {
            dictionary.add(words[i]);
        }

        for(int i=0;i<words.length;i++) {
            for(int j = 0; j<words.length;j++) {
                if(i!=j && !words[i].equals(words[j]) &&  words[i].endsWith(words[j])) dictionary.remove(words[j]);
            }
        }

        System.out.println(dictionary.toString());

        StringBuilder minimumLengthEncoding = new StringBuilder();

        for(String w : dictionary) {
            minimumLengthEncoding.append(w+"#");
        }
        System.out.println(minimumLengthEncoding);

        return minimumLengthEncoding.length();

    }
}
