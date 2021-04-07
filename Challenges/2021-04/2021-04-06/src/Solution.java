import java.util.Arrays;

class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();

        s.minOperations(6);
        s.minOperations(3);
        s.minOperations(5);
        s.minOperations(99);
    }
    public int minOperations(int n) {
        System.out.println("For n="+n);
        int[] arr = new int[n];

        int target = 0;

        for(int i=0;i<n;i++) {
            arr[i] = (2 * i) + 1;
            target += arr[i];
        }
        target /= n;

        System.out.println(Arrays.toString(arr));
        System.out.println("Target: "+target);

        int ops = 0;

        for(int i=0,j=n-1;i<j;i++,j--) {
            while(arr[i]!=arr[j]) {
                arr[i]++;
                arr[j]--;
                ops++;
            }
        }

        System.out.println(Arrays.toString(arr));
        System.out.println("Operations: "+ops);



        return ops;

    }
}
