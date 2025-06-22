class Solution {
     public  int sumCircular(int arr[], int start , int end ){
      int dp[] = new int[end-start+1];
      dp[0] = arr[start];
      
      for(int i=start+1;i<=end;i++){
        int idx = i-start;
        int pick = arr[i];
        if(i-2>=start){
            pick += dp[(i-2)-start];
        }
        int notpick = dp[(i-1)-start];
        dp[idx] = Math.max(pick, notpick);
      }
      return dp[end-start];
   } 
    
    public int rob(int[] arr) {
        int n = arr.length;
        if(n==0 )return 0;
        if(n == 1)return arr[0];
        int ans1 = sumCircular(arr, 0, n-2);
        int ans2 = sumCircular(arr, 1, n-1);
        return Math.max(ans1,ans2);
    }
}
