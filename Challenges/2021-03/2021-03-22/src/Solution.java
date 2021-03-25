import java.util.*;



class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        String[] wl = {"KiTe","kite","yellow","regeneration","catastropHe"};
        String[] q = {"kite","KiTe","yellow","catastrophe"};
        System.out.println(Arrays.toString(s.spellchecker(wl,q)));

        String[] wl2 = {"KiTe","kite","hare","Hare"};
        String[] q2 = {"kite","Kite","KiTe","Hare","HARE","Hear","hear","keti","keet","keto"};
        System.out.println(Arrays.toString(s.spellchecker(wl2,q2)));
    }

    public static boolean isVowel(char c) {
        return "AEIOUaeiou".indexOf(c) != -1;
    }

    public static String maskVowels(String s) {
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<s.length();i++) {
            if(!isVowel(s.charAt(i))) sb.append(s.charAt(i));
            else sb.append('#');
        }
        return sb.toString();
    }

    public String[] spellchecker(String[] wordlist, String[] queries) {

        System.out.println(Arrays.toString(wordlist));
        System.out.println(Arrays.toString(queries));

        //precisely a copy of wordlist
        HashSet<String> words = new HashSet<>();

        //for storing different capitalizations of a word
        HashMap<String,String> capitalizations = new HashMap<String,String>();

        //for misspellings
        HashMap<String,String> consonants = new HashMap<String,String>();

        for(String w : wordlist) {
            words.add(w);
            if(w==null) System.out.println("WARNING NULL");

            //store first diff capitalization
            if(!capitalizations.containsKey(w.toLowerCase()))     capitalizations.put(w.toLowerCase(),w);

            //store mapping vowel-masked string to original
            String vm = maskVowels(w.toLowerCase());
            if(!consonants.containsKey(vm)) consonants.put(vm,w);
        }

        String[] results = new String[queries.length];

        for(int i=0;i<queries.length;i++) {
            if(words.contains(queries[i]))
                results[i]=queries[i];
            else if(capitalizations.containsKey(queries[i].toLowerCase()))
                results[i]=capitalizations.get(queries[i].toLowerCase());
            else if(consonants.containsKey(maskVowels(queries[i].toLowerCase())))
                results[i]=consonants.get(maskVowels(queries[i]));
            else results[i]="";
        }

        return results;
    }
}
