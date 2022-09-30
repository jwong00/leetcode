class Solution {
    public String pushDominoes(String dominoes) {
        // L..L->LLLL and R..R-->RRRR
        // R..L->RRLL and R...L->RR.LL
        // L..R->L..R

        //iterate over dominoes
        //store indexes of lo..hi
        char[] dominoes_char = dominoes.toCharArray();

        int lo = -1;
        for(int i=0;i<dominoes.length();i++) {
            if(dominoes_char[i]=='.' && lo==-1) {
                lo = i;
            }

        }

    }
}
