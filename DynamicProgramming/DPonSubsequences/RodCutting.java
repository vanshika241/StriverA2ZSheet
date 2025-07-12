public class RodCutting {
        public int cutRod(int[] price) {
                 int n = price.length;
            int dp[][] = new int[n+1][n+1];
            for(int i=1;i<n+1;i++){
                for(int j=1;j<n+1;j++){
                    int pick = 0;
                    if (j-i>=0) {
                        pick = price[i] +  dp[i][j-i];
                    }
                    int notpick = dp[i-1][j];
                    dp[i][j] = Math.max(pick, notpick);
                }
            }
           return dp[n][n];

    }

}
