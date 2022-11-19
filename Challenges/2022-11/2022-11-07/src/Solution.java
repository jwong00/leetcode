class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.maximum69Number(996));
        System.out.println(s.maximum69Number(9669));
        System.out.println(s.maximum69Number(9996));
        System.out.println(s.maximum69Number(9999));
    }
    public int maximum69Number (int num) {

        char[] num_c = String.valueOf(num).toCharArray();

        for(int i=0;i<num_c.length;i++) {
            if(num_c[i]=='6') {
                num_c[i] = '9';
                break;
            }
        }

        return Integer.parseInt(String.valueOf(num_c));

    }
}
