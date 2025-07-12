public class MinCoins {
        public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int dp[][] = new int[n+1][amount+1];
        for(int j=0;j<amount+1;j++){
            dp[0][j] = Integer.MAX_VALUE-1;
        }
        for(int j=1;j<amount+1;j++){
            if (j%coins[0] == 0) {
                dp[1][j] = j/coins[0];
            }
            else{
                dp[1][j] = Integer.MAX_VALUE-1;
            }

        }

        for(int i=2;i<n+1;i++){
            for(int j=1;j<amount+1;j++){
                int pick = 0;
                if (j-coins[i-1] >=0) {
                    pick = 1+dp[i][j-coins[i-1]];
                }
                int notpick = dp[i-1][j];
                dp[i][j] = Math.min(pick, notpick);
            }


        }
        return dp[n][amount];
    }

}
