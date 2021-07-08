import java.util.Arrays;

class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        s.kthSmallest(new int[][] {{1,5,9},{10,11,13},{12,13,15}}, 8);
    }
    public int kthSmallest(int[][] matrix, int k) {
        return kthSmallestNaive(matrix, k);
    }

    /*
    * Concatenate each row to 1d matrix, sort, return kth smallest
    * */
    public int kthSmallestNaive(int[][] matrix, int k)  {
        int m=matrix.length, n=matrix[0].length;
        int[] nums = new int[m*n];
        for(int i=0;i<m;i++) {
            for (int j=0;j<n;j++) {
                nums[i*m+j] = matrix[i][j];
            }
        }
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));

        return nums[k-1];
    }

    /*
    * Some kind of quickselect solution, but adapted for 2d matrices
    * */
    public int kthSmallestQuick(int[][] matrix, int k) {

    }
}
