import java.util.HashSet;

class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.removePalindromeSub("abba"));

    }
    public int removePalindromeSub(String s) {
        if(s==null || s.length()==0) return 0;

        //check if whole str is palindrome

        int start=0;int end= s.length()-1;

        while(start<end && s.charAt(start)==s.charAt(end)) {
            start++;
            end--;
        }
        System.out.println(start + " " + end);
        if(s.charAt(start)==s.charAt(end)) return 1;

        Boolean[] characters = new Boolean[2];

        for(int i=0;i<s.length();i++) {
            if(s.charAt(i)=='a') characters[0]=true;
            if(s.charAt(i)=='b') characters[1]=true;
        }

        return characters[0]&&characters[1] ? 2 : 1;

    }
}
