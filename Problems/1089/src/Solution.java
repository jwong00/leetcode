import java.util.Arrays;

class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] t = {1,0,2,3,0,4,5,0};
        s.duplicateZeros(t);
        System.out.println(Arrays.toString(t));
        int[] k = {8,4,5,0,0,0,0,7};
        s.duplicateZeros(k);
        System.out.println(Arrays.toString(k));
    }
    public void duplicateZeros(int[] arr) {
        int l=0,r=arr.length-1;

        //move left towards right, and adjust right when a 0 is encountered on left
        while(l<r) {
            if(arr[l]==0) r--;
            l++;
        }

        int i = arr.length-1;
        while(r>0 && i>0) {
            //arr[r]!=0
            if(arr[r]!=0) arr[i--] = arr[r--];
            //arr[r]==0
            if(arr[r]==0) {
                arr[i--] = arr[r];
                arr[i--] = arr[r--];
            }
        }
    }
}
