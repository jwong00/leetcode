class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.addDigits(38));
        System.out.println(s.addDigits(0));
    }
    public int addDigits(int num) {

        int cache = 0;

        do {
            while(num > 0) {
                cache += num % 10;
                num /= 10;
            }
            num = cache;
            cache = 0;
        } while(num > 9);

        return num;
    }
}
