class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
//        System.out.println(s.gcdOfStrings("ABABAB","ABAB"));
//        System.out.println(s.gcdOfStrings("ABCABC","ABC"));
//        System.out.println(s.gcdOfStrings("LEET","CODE"));
        System.out.println(s.gcdOfStrings("ABABCCABAB","ABAB"));
    }
    public String gcdOfStrings(String str1, String str2) {

        int a = str1.length(), b = str2.length();

        int r = a % b;
        while(r!=0) {
            a = b;
            b = r;
            r = a % b;
        }
        r = b;
        a = str1.length();
        b = str2.length();

        System.out.println(r);

        //test for first matching greatest common string
        for(int i=0;i<r;i++) {
            if(str1.charAt(i)!=str2.charAt(i)) return "";
        }

        //must exist, so make sure the rest are there
        for(int i=0;i<a;i++) {
            System.out.println(i+" "+(i%r));
            if(str1.charAt(i)!=str1.charAt(i%r)) return "";
        }
        for(int i=0;i<b;i++) {
            if(str2.charAt(i)!=str2.charAt(i%r)) return "";
        }

        return str1.substring(0,r);

    }
}
