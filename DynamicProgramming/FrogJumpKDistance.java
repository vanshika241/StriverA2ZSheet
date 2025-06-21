public class FrogJumpKDist {
    
    public static int frogRec(int arr[], int idx, int k){
        if (idx == 0) {
            return 0;
        }
        int minSteps = Integer.MAX_VALUE;
        for(int j=1;j<=k;j++){
           if (idx-j>=0) {
            int jump = frogRec(arr, idx-j, k)+Math.abs(arr[idx]-arr[idx-j]);
            minSteps = Math.min(minSteps, jump);
           }
         }
         return minSteps;
    }

    public static int frogTabu(int arr[], int k){
        int n = arr.length;
       int dp[] = new int[n];
       dp[0] = 0;
       for(int i=1;i<n;i++){
          int minSteps = Integer.MAX_VALUE;
          for(int j=1;j<=k;j++){
          if (i-j>=0) {
            int jump = dp[i-j]+Math.abs(arr[i]-arr[i-j]);
            minSteps = Math.min(minSteps, jump);
          }
          }
          dp[i]  =minSteps;
       }
       return dp[n-1];

    }
    public static void main(String[] args) {
        int arr[] = {3, 2, 4};
        int k = 4;
        System.out.println("Recursion "+frogRec(arr, arr.length-1, k));
        System.out.println("Tabulation "+frogTabu(arr,k));

    }
}
