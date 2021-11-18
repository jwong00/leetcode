class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        s.longestDiverseString(1,1,7);
    }
    public String longestDiverseString(int a, int b, int c) {
        int[] freq = {a,b,c};


        int selection = -1;
        //hi
        StringBuilder sb = new StringBuilder();

        int x = 5;
        while(x>0) {


            int value = Integer.MIN_VALUE;
            //choose int with greatest value
            for(int i=0;i<freq.length;i++) {


                //select
                if(selection != i && freq[i]>0 && freq[i]>value) {
                    value = freq[i];
                    selection = i;

                    System.out.println("Selected: "+selection);
                }


            }
            System.out.println("HERE");

            //greedily append selected to string
            for(int count = 2; count>0 && freq[selection]>0;count--){
                sb.append((char)(selection+'a'));
                freq[selection]--;
                System.out.println("CURRENT: "+sb.toString());
            }
            x--;
        }

        return sb.toString();
    }
}
