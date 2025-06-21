import java.util.Arrays;

public class FrogJump {
    public static int frogRec(int arr[],int idx){
        if (idx == 0) {
            return 0;
        }
        int left = frogRec(arr, idx-1)+Math.abs(arr[idx]-arr[idx-1]);
        int right;
        if (idx>1) {
             right = frogRec(arr, idx-2)+Math.abs(arr[idx]-arr[idx-2]);
        }
        else{
            right = Integer.MAX_VALUE;
        }

        return Math.min(left, right);
    }

    //Memo
    public static int frogMemo(int arr[], int idx, int dp[]){
        if (idx == 0) {
            return 0;
        }
        if (dp[idx] != -1) {
            return dp[idx];
        }
        int left = frogMemo(arr, idx-1,dp)+Math.abs(arr[idx]-arr[idx-1]);
        int right;
        if (idx>1) {
             right = frogMemo(arr, idx-2,dp)+Math.abs(arr[idx]-arr[idx-2]);
        }
        else{
            right = Integer.MAX_VALUE;
        }
        return dp[idx] = Math.min(left, right);
    }

    public static int frogTabu(int arr[]){
        int n = arr.length;
        int dp[] = new int[n];
        dp[0] = 0;
        for(int i=1;i<n;i++){
            int left = dp[i-1] + Math.abs(arr[i]-arr[i-1]);
            int right;
            if (i>1) {
                right = dp[i-2]+Math.abs(arr[i]-arr[i-2]);
            }
            else{
                right = Integer.MAX_VALUE;
            }
            dp[i] = Math.min(left, right);
        }
        return dp[n-1];
    }
    public static void main(String[] args) {
        int arr[] = {30,10,60,10,60,50};
        int n = arr.length;
        System.out.println("Recursion "+frogRec(arr, arr.length-1));
        int dp[] = new int[n+1];
        Arrays.fill(dp, -1);
        System.out.println("Memoization "+frogMemo(arr, n-1, dp));
        System.out.println("Tabulation "+frogTabu(arr));
    }
}
