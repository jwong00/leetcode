/*
Intuition

Let's determine dp[i], the farthest location we can get to using i refueling stops. This is motivated by the fact that we want the smallest i for which dp[i] >= target.

Algorithm

Let's update dp as we consider each station in order. With no stations, clearly we can get a maximum distance of startFuel with 0 refueling stops.

Now let's look at the update step. When adding a station station[i] = (location, capacity), any time we could reach this station with t refueling stops, we can now reach capacity further with t+1 refueling stops.

For example, if we could reach a distance of 15 with 1 refueling stop, and now we added a station at location 10 with 30 liters of fuel, then we could potentially reach a distance of 45 with 2 refueling stops.
* */

class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.minRefuelStops(1,1,new int[][] {}));
        System.out.println(s.minRefuelStops(100,1,new int[][] {{10,100}}));
        System.out.println(s.minRefuelStops(101,10,new int[][] {{10,100},{10,101}}));
        System.out.println(s.minRefuelStops(100,10,new int[][] {{10,60},{20,30},{30,30},{60,40}}));

    }
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        int[] dp = new int[stations.length+1];
        dp[0] = startFuel;

        for(int i=0;i<stations.length;++i) {
            for(int k=i;k>=0;--k) {
                if(dp[k] >= stations[i][0]) dp[k+1] = Math.max(dp[k+1],dp[k]+stations[i][1]);
            }
        }

        for(int i=0;i<dp.length;i++) {
            if(dp[i] >= target) return i;
        }

        return -1;
    }

    // N A I V E APPROACH //

    /*
    public int minRefuelStops(int target, int startFuel, int[][] stations) {

        if(target<=startFuel) return 0;

        int m=0,n=Integer.MAX_VALUE;
        for(int i=0;i<stations.length;i++) {
            m = travel(0,startFuel,target,i,stations);
            if(m > -1) n = Math.min(n,m);
        }
        return n==Integer.MAX_VALUE ? -1 : n;
    }

    public int travel(int distance, int fuel, int target,int station, int[][] stations) {
        if(fuel<stations[station][0]-distance) return -1;
        fuel = fuel - (stations[station][0]-distance) + stations[station][1];
        distance = stations[station][0];

        int m, n = Integer.MAX_VALUE;
        if(target<=fuel) return 1;
        else {
            for(int i=station+1;i<stations.length;i++) {
                m = travel(distance,fuel,target,i,stations);
                if(m > -1) {
                    n = Math.min(n,m);
                    System.out.println(distance+" "+fuel);
                }
            }
        }

        return n + 1;

    }


     */
}
