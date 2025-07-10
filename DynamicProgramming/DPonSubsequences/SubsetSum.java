
public class SubsetSum{

    static Boolean rec(int arr[], int target, int idx){
        if (target == 0) {
            return true;
        }
        if (idx == 0) {
            if (arr[idx] == target) {
                return true;
            }
            return false;
        }

        boolean pick = false;
        if(target>=arr[idx]){
            pick = rec(arr, target-arr[idx], idx-1);
        }
        boolean notpick = rec(arr, target, idx-1);
        return pick || notpick;
    }

        static Boolean memo(int arr[], int target, int idx, Boolean dp[][]){
        if (target == 0) {
            return true;
        }
        if (idx == 0) {
            if (arr[idx] == target) {
                return true;
            }
            return false;
        }
        if (dp[idx][target] != null) {
            return dp[idx][target] ;
        }

        boolean pick = false;
        if(target>=arr[idx]){
            pick = rec(arr, target-arr[idx], idx-1);
        }
        boolean notpick = rec(arr, target, idx-1);
        return dp[idx][target]  = pick || notpick;
    }

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




    static Boolean isSubsetSum(int arr[], int target) {
        int n = arr.length;
      return rec(arr, target, n-1);
        }
    public static void main(String[] args) {
        
    }
}
