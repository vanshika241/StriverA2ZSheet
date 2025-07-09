import java.util.Arrays;

public class HouseRobber2 {
    public int memo(int arr[], int start ,  int end , int idx,int dp[]){
        if (idx<start) {
            return 0;
        }
        if (idx == start) {
            return arr[start];
        }
        if (dp[idx] != -1) {
            return dp[idx];
        }
        int pick = arr[idx];
        if (idx-2>=0) {
            pick += memo(arr, start, end, idx-2, dp);
        }
        int nonpick = memo(arr, start, end, idx-1, dp);
        return dp[idx] = Math.max(pick, nonpick);

    }
    int maxValue(int[] arr) {
        int n = arr.length;
        int dp[] = new int[n-1];
        Arrays.fill(dp, -1);
        int max1 = memo(arr, 0, n-2, n-2, dp);
        int max2 = memo(arr, 1, n, n-1, dp);
        return Math.max(max1, max2);
    }

    public static void main(String[] args) {
        
    }
}
