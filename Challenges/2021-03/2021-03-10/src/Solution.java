class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.intToRoman(14));
        System.out.println(s.intToRoman(114));
        System.out.println(s.intToRoman(1000));
        System.out.println(s.intToRoman(1900));
        System.out.println(s.intToRoman(1944));
        System.out.println(s.intToRoman(2030));
        System.out.println(s.intToRoman(3999));
    }
    public String intToRoman(int num) {
        if(num==0) return "";
        StringBuilder r = new StringBuilder();
        //1000
        while(num>=1000) {
            num-=1000;
            r.append("M");
        }
        //900?
        if(num>=900) {
            num-=900;
            r.append("CM");
        }
        //500
        while(num>=500) {
            num-=500;
            r.append("D");
        }
        //400?
        if(num>=400) {
            num-=400;
            r.append("CD");
        }
        //100
        while(num>=100) {
            num-=100;
            r.append("C");
        }
        //90?
        if(num>=90) {
            num-=90;
            r.append("XC");
        }
        if(num>=50) {
            num-=50;
            r.append("L");
        }
        //40?
        if(num>=40) {
            num-=40;
            r.append("XL");
        }
        //10
        while(num>=10) {
            num-=10;
            r.append("X");
        }
        //9?
        if(num>=9) {
            num-=9;
            r.append("IX");
        }
        //5
        if(num>=5) {
            num-=5;
            r.append("V");
        }
        //4?
        if(num>=4) {
            num-=4;
            r.append("IV");
        }
        //1
        while(num>=1) {
            num--;
            r.append("I");
        }
        return r.toString();
    }
}
