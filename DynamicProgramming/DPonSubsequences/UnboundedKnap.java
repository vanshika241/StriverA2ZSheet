public class UnboundedKnap {
            static int tabu(int W, int val[], int wt[]) {
           int n = wt.length;
            int dp[][] = new int[n+1][W+1];
            for(int i=1;i<n+1;i++){
                for(int j=1;j<W+1;j++){
                    int pick = 0;
                    if (j-wt[i-1]>=0) {
                        pick = Math.max(val[i-1] +  dp[i][j-wt[i-1]], dp[i-1][j]);
                    }
                    int notpick = dp[i-1][j];
                    dp[i][j] = Math.max(pick, notpick);
                }
            }
           return dp[n][W];
        }

            static int knapSack(int val[], int wt[], int W) {
                 return tabu(W, val, wt);
            }
    public static void main(String[] args) {
        
    }
}
