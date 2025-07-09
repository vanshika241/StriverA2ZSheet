public class ClimbingStairs {
    public int rec(int n){
        if (n<=1) {
            return 1;
        }
        return rec(n-1)+ rec(n-2);
    }

    public int memo(int n , int dp[]){
        if (n<=1) {
            return 1;
        }
        if (dp[n] != -1) {
            return dp[n];
        }
        return dp[n] = memo(n-1,dp)+ memo(n-2,dp);

    }

    public int tabu(int n ){
        if (n<=1) {
            return 1;
        }
         int dp[] = new int[n+1];
         dp[0] = 1;
         dp[1] = 1;
         for(int i=2;i<=n;i++){
            dp[i] = dp[i-1] + dp[i-2];
         }
         return dp[n];
    }



    int countWays(int n) {
        return tabu(n);
    }

}
