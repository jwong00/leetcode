class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.countAndSay(1));
        System.out.println(s.countAndSay(2));
        System.out.println(s.countAndSay(3));
        System.out.println(s.countAndSay(4));
        System.out.println(s.countAndSay(5));
        System.out.println(s.countAndSay(6));
        System.out.println(s.countAndSay(7));
        System.out.println(s.countAndSay(8));
    }
    public String countAndSay(int n) {
        if(n==1) return "1";
        else {
            char[] t = countAndSay(n-1).toCharArray();
            //process t
            char cur = t[0];
            int count = 0;
            StringBuilder sb = new StringBuilder();
            for(int i=0;i<t.length;i++) {
                if(t[i]==cur) count++;
                else {
                    sb.append(count);
                    sb.append(cur);
                    count = 1;
                    cur = t[i];
                }
            }
            sb.append(count);
            sb.append(cur);

            return sb.toString();
        }
    }
}
