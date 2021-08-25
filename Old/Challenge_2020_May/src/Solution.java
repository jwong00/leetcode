class Solution {
    public static void main(String[] args) {

        Solution s = new Solution();
        System.out.println(s.removeKdigits("1432219",3));

        System.out.println(s.removeKdigits("1234567",3));
    }
    public String removeKdigits(String num, int k) {
        System.out.println("Number is: "+num);

        //pad right with a single zero so the rightmost digit of num can compare to it
        num=num+"0";

        System.out.println("Pruning...");
        for(int j=k; j>0; j--) {
            System.out.println(j);
            for(int i=0; i<num.length()-1; i++) {
                if(num.charAt(i) > num.charAt(i+1) ) {
                    System.out.println(num);
                    num = num.replaceFirst(String.valueOf(num.charAt(i)),"");
                    break;
                }
            }
        }



        //prune right-most zero


        return num;
    }
}
