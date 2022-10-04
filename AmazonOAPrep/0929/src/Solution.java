import java.util.HashSet;

class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.numUniqueEmails(new String[]
                {
                        "test.email+alex@leetcode.com",
                        "test.e.mail+bob.cathy@leetcode.com",
                        "testemail+david@lee.tcode.com"
                }));

        System.out.println(s.numUniqueEmails(new String[]
                {
                        "test.email+alex@leetcode.com",
                        "test.email@leetcode.com"
                }));
        System.out.println(s.numUniqueEmails(new String[]
                {
                        "a@gmail.com",
                        "b@gmail.com",
                        "c@gmail.com"
                }));
    }
    public int numUniqueEmails(String[] emails) {
        HashSet<String> emails_hash = new HashSet<>();

        for(String email : emails) {
            emails_hash.add(filter(email));
        }

        return emails_hash.size();

    }
    public String filter(String email) {
        StringBuilder sb = new StringBuilder();

        int i = 0,n = email.length();

        while(i < n && email.charAt(i)!='@') {
            if(email.charAt(i)=='+') {
                while(i < n && email.charAt(i)!='@') i++;
                break;
            }
            if(email.charAt(i)!='.') sb.append(email.charAt(i));
            i++;
        }

        //copy rest
        while(i < n) {
            sb.append(email.charAt(i));
            i++;
        }

        return sb.toString();
    }
}
