public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.hammingWeight(0));
        System.out.println(s.hammingWeight(1));
        System.out.println(s.hammingWeight(2));
        System.out.println(s.hammingWeight(3));
        System.out.println(s.hammingWeight(8));
        System.out.println(s.hammingWeight(9));
        System.out.println(s.hammingWeight(16));
        System.out.println(s.hammingWeight(17));
        System.out.println(s.hammingWeight(22));
    }
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {

        int c = 0;

        for(int i=0;i<32;i++) {
           if((n & 1 << i)!=0) c++;
        }
        return c;
    }
}
