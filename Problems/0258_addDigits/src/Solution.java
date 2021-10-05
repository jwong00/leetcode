/**
 * Created by Glamdring on 10/26/2016.
 */

public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.addDigits(994));
        System.out.println(s.addDigits(92594));
        System.out.println(s.addDigits(7123));
        System.out.println(s.addDigits(538));
    }
    public int addDigits(int num) {
        int sum = 0;
        while(num>0) {
            sum += num%10;
            num /= 10;
        }
        if(sum>=10) sum=addDigits(sum);
        return sum;
    }
}
