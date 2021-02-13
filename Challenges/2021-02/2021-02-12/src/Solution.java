class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();

        s.numberOfSteps(9);
    }
    public int numberOfSteps (int num) {
        int steps = 0;
        while(num > 0) {
            if(num % 2 > 0) {
                num--;
            }
            else num/=2;

            steps++;
        }

        System.out.println(steps);

        return steps;
    }
}
