class Solution {
    public static void main(String[] args) {
//        System.out.println((double) 3/2);
        Solution s = new Solution();
        System.out.println(s.brokenCalc(2,3));
        System.out.println(s.brokenCalc(5,8));
        System.out.println(s.brokenCalc(3,10));
    }
    public int brokenCalc(int startValue, int target) {
        int count = 0;

        while(target>startValue) {
            if(target%2==1) target++;
            else target/=2;

//            System.out.println(startValue);

            count++;

        }

        return count + startValue - target;

    }
}
