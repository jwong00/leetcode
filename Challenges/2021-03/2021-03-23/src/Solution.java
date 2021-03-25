import java.util.Set;
/*
*
    3 <= arr.length <= 3000
    0 <= arr[i] <= 100
    0 <= target <= 300
*
* */
class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] q = {1,1,2,2,3,3,4,4,5,5};

        System.out.println(s.threeSumMulti(q,8));
    }
    public int threeSumMulti(int[] arr, int target) {

        if(arr.length==0) return 0;

        int tuples = 0;
        int mod = 10^9 + 7;

        int[] count = new int[101];
        for(int i : arr) count[i]++;

        /*

        //should be doable with three pointers in nested loops?
        for(int i=0;i<arr.length-2;i++) {
            for(int j=i+1;j<arr.length-1;j++) {
                for(int k=j+1;k<arr.length;k++) {
                    if(arr[i]+arr[j]+arr[k]==target) {
                        count++;
                    }
                }
            }
        }*/
        //guess not, TLE

        /* let's try counting them in a combinatoric way */

        // i<j<k
        for(int i=0;i<=100;i++) {
            for(int j=i+1;j<=100;j++) {
                int k = target - i - j;
                if(j<k && k<=100) {
                    tuples += count[i] * count[j] * count[k];
                    tuples %= mod;
                }
            }
        }

        // i==j < k



        // i < j==k

        // i==j==k
        if(target/3 <= 100 && count[target/3] >= 3) {
            tuples += count[target/3] - 2;
            tuples %= mod;
        }

        return tuples % (10^9 + 7);

    }
}
