public class PartitionSum {
        static boolean tabu(int arr[], int target){
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
        return dp[n-1][target];
    }


        static boolean equalPartition(int arr[]) {
           int tsum = 0;
           for(int num:arr)tsum += num;
           if (tsum %2 != 0) {
            return false;
           }
           int target = tsum/2;
           return tabu(arr, target);
        }
    public static void main(String[] args) {
        
    }
}
