public class NonAdjacentMaxSum {

    public int rec(int arr[], int idx){
        if (idx == 0) {
            return arr[idx];
        }
        int pick = arr[idx];
        if (idx-2>=0) {
            pick += rec(arr, idx-2);
        }
        int notpick = rec(arr, idx-1);
        return Math.max(pick, notpick);
    }

    public int memo(int arr[], int idx, int dp[]){
        if (idx == 0) {
            return arr[idx];
        }
        if (dp[idx] != -1) {
            return dp[idx];
        }
        int pick = arr[idx];
        if (idx-2>=0) {
            pick += rec(arr, idx-2);
        }
        int notpick = rec(arr, idx-1);
        return dp[idx] = Math.max(pick, notpick);
    }


    public int tabu(int arr[]){
        int n = arr.length;
        int dp[] = new int[n];
        dp[0] = arr[0];
        for(int i=1;i<n;i++){
            int pick = arr[i];
            if (i-2>=0) {
               pick += dp[i-2];
            }
            int nonpick = 0+dp[i-1];
            dp[i] = Math.max(pick, nonpick);
        }
        return dp[n-1];
    }



    int findMaxSum(int arr[]) {
        return rec(arr, arr.length-1);

    }

    public static void main(String[] args) {
        
    }
}
