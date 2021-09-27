import java.util.HashSet;

class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.numUniqueEmails(
                new String[]{   "test.email+alex@leetcode.com",
                                "test.e.mail+bob.cathy@leetcode.com",
                                "testemail+david@lee.tcode.com"}));

        System.out.println(s.numUniqueEmails(
                new String[]{ "a@leetcode.com","b@leetcode.com","c@leetcode.com"}));

    }
    public int numUniqueEmails(String[] emails) {
        HashSet<String> emailSet = new HashSet<>();

        for(int i=0;i<emails.length;i++) {
            int plus = Integer.MAX_VALUE;
            int amp = Integer.MAX_VALUE;
            StringBuilder sb = new StringBuilder();

            for(int j=0;j<emails[i].length();j++) {
                if(emails[i].charAt(j)=='+')        plus = j;
                else if(emails[i].charAt(j)=='@')   amp = j;
            }

            int localLength = Math.min(plus,amp);
            for(int k=0;k<localLength;k++) {
                if(Character.isAlphabetic(emails[i].charAt(k))) sb.append(emails[i].charAt(k));
            }

            sb.append(emails[i].substring(amp));
            emailSet.add(sb.toString());
        }

        return emailSet.size();
    }
}
