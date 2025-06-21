import java.util.Arrays;

public class  MximumSumNonAdjacent{

    public static int sumRec(int arr[], int idx){
        if (idx == 0) {
            return arr[0];
        }
        if (idx<0) {
            return 0;
        }
        int pick = arr[idx]+sumRec(arr, idx-2);
        int nonpick = 0+sumRec(arr, idx-1);
        return Math.max(pick, nonpick);
    }

    public static int sumMemo(int arr[], int idx, int dp[]){
        if (idx == 0) {
            return arr[0];
        }
        if (idx<0) {
            return 0;
        }
        if (dp[idx] != -1) {
            return dp[idx];
        }
        int pick = arr[idx]+sumMemo(arr, idx-2,dp);
        int nonpick = 0+sumMemo(arr, idx-1,dp);
        return  dp[idx] = Math.max(pick, nonpick);
    }

    public static int sumTabu(int arr[]){
        int n = arr.length;
        int dp[] = new int[n];
        dp[0] = arr[0];
        for(int i=1;i<n;i++){
        int pick = arr[i];
         if(i>1){
             pick += dp[i-2];
         }
         int notpick = dp[i-1];
         dp[i] = Math.max(pick, notpick);
        }
        return dp[n-1];
    }
    public static void main(String[] args) {
        int arr[] = {1,2,3,1};
        System.out.println("Recursion "+sumRec(arr, arr.length-1));
        int dp[] = new int[arr.length];
        Arrays.fill(dp, -1);
        System.out.println("Memoization "+sumMemo(arr, arr.length-1,dp));
        System.out.println("Tabulation "+sumTabu(arr));

    }
}
