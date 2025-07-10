public class MinSumDifference {
     int  tabu(int arr[], int target){
        int n = arr.length;
        boolean dp[][] = new boolean[n][target+1];
        for(int i=0;i<n;i++){
            dp[i][0] = true;
        }
        if (arr[0]<=target) {
            dp[0][arr[0]] = true;

        }
        for(int i=1;i<n;i++){
            for(int j=1;j<target+1;j++){
                boolean pick = false;
                if (j-arr[i]>=0) {
                    pick = dp[i-1][j-arr[i]];
                }
                boolean notpick = dp[i-1][j];
                dp[i][j] = pick || notpick;
            }
        }
        int min = Integer.MAX_VALUE;
        for(int j=0;j<=target/2;j++){
             if (dp[n-1][j] == true) {
                min = Math.min(Math.abs(target-2*j), min);
             }
        }
        return min;
    }

        public int minDifference(int arr[]) {
          int range = 0;
          for(int num:arr)range += num;
          return tabu(arr, range);
        }
    public static void main(String[] args) {
        
    }
}
