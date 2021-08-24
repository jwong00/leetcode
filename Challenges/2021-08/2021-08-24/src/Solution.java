class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.complexNumberMultiply("1+-1i","1+-1i"));
    }
    public String complexNumberMultiply(String num1, String num2) {
        int a=0;
        while(num1.charAt(a)!='+')  a++;
//        System.out.println("REAL1: "+num1.substring(0,a));
//        System.out.println("IMAG1: "+num1.substring(a+1,num1.length()-1));

        int real_1 = Integer.parseInt(num1.substring(0,a));
        int imag_1 = Integer.parseInt(num1.substring(a+1,num1.length()-1));

        int b=0;
        while(num2.charAt(b)!='+') b++;
//        System.out.println("REAL2: "+num2.substring(0,b));
//        System.out.println("IMAG2: "+num2.substring(b+1,num2.length()-1));

        int real_2 = Integer.parseInt(num2.substring(0,b));
        int imag_2 = Integer.parseInt(num2.substring(b+1,num2.length()-1));

//        System.out.println(real_1);
//        System.out.println(real_2);
//        System.out.println(imag_1);
//        System.out.println(imag_2);
        return (real_1*real_2 + -1*imag_1*imag_2) + "+" + (real_1*imag_2 + real_2*imag_1) + "i";
    }
}