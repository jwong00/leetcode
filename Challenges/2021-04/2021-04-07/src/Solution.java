class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        s.halvesAreAlike("MerryChristmas");
    }
    public boolean halvesAreAlike(String s) {
        System.out.println("Testing "+s);
        int half = s.length()/2;
        int vowel = 0;
        System.out.println(s.length());
        System.out.println(half);

        for(int i=0; i<s.length();i++) {
            if(isVowel(s.charAt(i))) {
                System.out.println(s.charAt(i));
                if(i<half)      vowel++;
                else vowel--;
            }
        }
        System.out.println("Vowels left "+vowel);

        return vowel == 0;
    }

    private boolean isVowel(char c) {
        return "aeiouAEIOU".indexOf(c) >= 0;
    }
}
