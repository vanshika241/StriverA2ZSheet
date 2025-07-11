public class CoinChange2 {
        public int change(int amount, int[] coins) {
            int n = coins.length;
            int dp[][] = new int[n+1][amount+1];
            for(int i=0;i<n+1;i++){
                dp[i][0] = 1;
            }
            for(int i=1;i<n+1;i++){
                for(int j=1;j<amount+1;j++){
                    int pick = 0;
                    if(j-coins[i-1]>=0){
                        pick = dp[i][j-coins[i-1]];
                    }
                    int notpick = dp[i-1][j];
                    dp[i][j] = pick + notpick;
                }
            }
            return dp[n][amount];
        }
}
