class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.slowestKey(new int[]{9,29,49,50},"cbcd"));
        System.out.println(s.slowestKey(new int[]{12,23,36,46,62},"spuda"));
    }
    public char slowestKey(int[] releaseTimes, String keysPressed) {
        for(int i=releaseTimes.length-1;i>0;i--) {
            releaseTimes[i] -= releaseTimes[i-1];
        }

        int releaseTimeMax = releaseTimes[0];
        char slowestKey = keysPressed.charAt(0);
        for(int i=1;i<releaseTimes.length;i++) {
            if(releaseTimes[i] > releaseTimeMax) {
                releaseTimeMax = releaseTimes[i];
                slowestKey = keysPressed.charAt(i);
            }
            else if(releaseTimes[i]==releaseTimeMax) {
                slowestKey = Character.compare(slowestKey,keysPressed.charAt(i)) > 0 ? slowestKey : keysPressed.charAt(i);
            }
        }

        return slowestKey;
    }
}
