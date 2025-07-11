public class KnapSack {

        public static int rec(int idx ,int W, int val[], int wt[] ){
           if (idx == 0 || W == 0) {
               return 0;
           }
           int pick = 0;
           if (W-wt[idx-1]>=0) {
              pick = val[idx-1] + rec(idx-1, W-wt[idx-1], val, wt);
           }
           int notpick = rec(idx-1, W, val, wt);
           return Math.max(pick, notpick);
        }

        public static int memo(int idx ,int W, int val[], int wt[], int dp[][] ){
           if (idx == 0 || W == 0) {
               return 0;
           }
           if (dp[idx][W] != -1) {
            return dp[idx][W];
           }
           int pick = 0;
           if (W-wt[idx-1]>=0) {
              pick = val[idx-1] + memo(idx-1, W-wt[idx-1], val, wt,dp);
           }
           int notpick = memo(idx-1, W, val, wt,dp);
           return dp[idx][W] =  Math.max(pick, notpick);
        }

        static int tabu(int W, int val[], int wt[]) {
           int n = wt.length;
            int dp[][] = new int[n+1][W+1];
            for(int i=1;i<n+1;i++){
                for(int j=1;j<W+1;j++){
                    int pick = 0;
                    if (j-wt[i-1]>=0) {
                        pick = val[i-1] +  dp[i-1][j-wt[i-1]];
                    }
                    int notpick = dp[i-1][j];
                    dp[i][j] = Math.max(pick, notpick);
                }
            }
           return dp[n][W];
        }


        static int knapsack(int W, int val[], int wt[]) {
           int n = wt.length;
           return rec(n, W, val, wt);
        }
    public static void main(String[] args) {
        
    }
}
