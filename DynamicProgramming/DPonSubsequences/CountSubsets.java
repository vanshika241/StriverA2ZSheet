public class CountSubsets {
    int mod = 1_000_000_007;
   public int perfectSum(int[] arr, int target) {
               int n = arr.length;
        int dp[][] = new int[n][target+1];
        for(int i=0;i<n;i++){
            dp[i][0] = 1;
        }
    if (arr[0] == 0) {
        dp[0][0] = 2;  
    } else {
        dp[0][0] = 1;  
        if (arr[0] <= target)
            dp[0][arr[0]] = 1;  
    }

        for(int i=1;i<n;i++){
            for(int j=0;j<target+1;j++){
                int pick = 0;
                if (j-arr[i]>=0) {
                        pick =dp[i-1][j-arr[i]];
                   
                    
                }
                int notpick = dp[i-1][j];
                dp[i][j] = (pick+notpick)%mod;
            }
        }
        return dp[n-1][target];

}
public static void main(String[] args) {
    
}

}
