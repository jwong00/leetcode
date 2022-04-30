class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.validMountainArray(new int[]{0,2,3,4,5,2,1,0}));
        System.out.println(s.validMountainArray(new int[]{0,2,3,3,5,2,1,0}));
        System.out.println(s.validMountainArray(new int[]{0,1,2,3}));
    }
    public boolean validMountainArray(int[] arr) {

        if(arr.length < 3) return false;

        int i=0;

        while(i+1<arr.length && arr[i] < arr[i+1]) i++;

        if(i==0||i==arr.length-1) return false;

        while(i+1<arr.length && arr[i] > arr[i+1]) i++;

        return i==arr.length-1;

    }
}
