public class FrogJump {

    public int rec(int[] height , int idx){
        if (idx == 0) {
            return height[0];
        }
        if (idx == 1) {
            return Math.abs(height[1]-height[0]);
        }
        int oneStep = rec(height, idx-1) + Math.abs(height[idx]-height[idx-1]);
        int twoStep = rec(height, idx-2) + Math.abs(height[idx]-height[idx-2]);
        return Math.min(oneStep, twoStep);
    }

    public int memo(int[] height , int idx , int dp[]){
        if (idx == 0) {
            return 0;
        }
        if (idx == 1) {
            return Math.abs(height[1]-height[0]);
        }
        if (dp[idx] != -1) {
            return dp[idx];
        }
        int oneStep = memo(height, idx-1,dp) + Math.abs(height[idx]-height[idx-1]);
        int twoStep = memo(height, idx-2,dp) + Math.abs(height[idx]-height[idx-2]);
        return dp[idx] = Math.min(oneStep, twoStep);
    }

    public int tabu(int height[]){
        int n = height.length;
        int dp[] = new int[n];
        dp[0] = 0;
        for(int i=1;i<n;i++){
            int oneStep = dp[i-1] + Math.abs(height[i]-height[i-1]);
            int twoStep = Integer.MAX_VALUE;
            if (i-2>=0) {
                twoStep =  dp[i-2] + Math.abs(height[i]-height[i-2]);
            }
           dp[i] = Math.min(oneStep, twoStep);

        }
        return dp[n-1];
    }



    int minCost(int[] height) {
        int n = height.length;
        int dp[] = new int[n];
        return memo(height, n-1, dp);
    }

    public static void main(String[] args) {
        
    }
}
