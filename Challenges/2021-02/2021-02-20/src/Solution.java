class Solution {
    public static void main(String[] args) {
        Solution s= new Solution();
        s.romanToInt("III");
        s.romanToInt("IV");
        s.romanToInt("IX");
    }
    public int romanToInt(String s) {
        if(s==null || s.length()==0) return 0;

        int ara = 0; //store arabic representation of number

        for(int i=0;i<s.length();i++) {
            switch(s.charAt(i)) {
                case 'I':
                    if(i+1<s.length() && s.charAt(i+1)=='V') {
                        ara+=4;
                        i++;
                    }
                    else if(i+1<s.length() && s.charAt(i+1)=='X') {
                        ara+=9;
                        i++;
                    }
                    else ara+=1;
                    break;
                case 'V':
                    ara+=5;
                    break;
                case 'X':
                    if(i+1<s.length() && s.charAt(i+1)=='L') {
                        ara += 40;
                        i++;
                    }
                    else if(i+1<s.length() && s.charAt(i+1)=='C') {
                        ara+=90;
                        i++;
                    }
                    else ara+=10;
                    break;
                case 'L':
                    ara+=50;
                    break;
                case 'C':
                    if(i+1<s.length() && s.charAt(i+1)=='D') {
                        ara+=400;
                        i++;
                    }
                    else if(i+1<s.length() && s.charAt(i+1)=='M') {
                        ara+=900;
                        i++;
                    }
                    else ara+=100;
                    break;
                case 'D':
                    ara+=500;
                    break;
                case 'M':
                    ara+=1000;
                    break;
            }
        }
        System.out.println("ROMAN: "+s+" <> INTEGER: "+ara);
        return ara;

    }
}
