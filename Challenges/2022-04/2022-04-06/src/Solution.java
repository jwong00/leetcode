import java.util.Arrays;

class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.threeSumMulti(new int[]{1,1,2,2,3,3,4,4,5,5},8));
    }
    public int threeSumMulti(int[] arr, int target) {
        if(arr==null || arr.length==0) return 0;
        Arrays.sort(arr);
        
        int count = 0;
        for(int i=0;i<arr.length;i++) {
            for(int j=i+1;j<arr.length;j++) {
                for(int k=arr.length-1;k>j;k--) {
                    if(arr[i]+arr[j]+arr[k]==target) count++;
                    else if(arr[i]+arr[j]+arr[k]<target) break;
                }
            }
        }

        return count;
    }
}
