import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        s.countSubstrings("aaaaa");
    }
    //ds for storing largest known palindromes


    String subject;
//    int[] startToEnd; //stores index of end of palindrome from that char

    Map<Integer, HashSet<Integer>> startToEnd;
    //what if i represent palindromes as (start,end) pairs?

    public int countSubstrings(String s) {
        subject = s;
//        startToEnd = new int[s.length()];


        startToEnd = new HashMap<>();

        /*
        populate initial mappings with start==end
        this makes sense because each one-char string is a palindrome
        */
        for(int i=0;i<s.length();i++) {
            HashSet<Integer> t = new HashSet<>();
            t.add(i);
            startToEnd.put(i,t);
        }

        //start, end
        //if(isPalindromic)==true, store start,end as palindrome
        for(int i=0;i<s.length()-1;i++) {
            for(int j = i + 1; j<s.length();j++) {
                isPalindromic(i,j);
            }
        }

        //count palindromes, iterate over map, and sum the size of each set
        int count = 0;

        for(int i=0;i<startToEnd.size();i++) {
            count += startToEnd.get(i).size();
        }

        System.out.println("Number of palindromic substrings is "+count);

        return count;



    }

    private boolean isPalindromic(int start,int end) {
        if(subject.charAt(start)==subject.charAt(end)) { //might be palindrome? if...
            System.out.println("Testing "+start+" to "+end);

            //it's already hashed
            if(startToEnd.get(start).contains(end)) {
                System.out.println("Already hashed...");
                return true;
            }

            /* not hashed but
             * 0 or 1 char between two identical char is palindrome
             */
            else if(end-start <= 2) {
                System.out.println("Short unhashed palindrome detected from "+start+" to "+end);
                startToEnd.get(start).add(end);
                return true;
            }
            //2 or more, test for sub palindrome
            else if(isPalindromic(start+1,end-1)) {
                startToEnd.get(start).add(end);
                return true;
            }
            else return false;

        }
        else return false;
    }
}
