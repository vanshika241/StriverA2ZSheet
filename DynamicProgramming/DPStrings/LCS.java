public class LCS{


    static int rec(String s1,String s2, int idx1 , int idx2){
        if (idx1 == 0 || idx2 == 0) {
            return 0;
        }
        if (s1.charAt(idx1-1) == s2.charAt(idx2-1)) {
            return 1+ rec(s1, s2, idx1-1, idx2-1);
        }
        else{
            int firstString = rec(s1, s2, idx1, idx2-1);
            int secondString = rec(s1, s2, idx1-1, idx2);
            return Math.max(firstString, secondString);
        }
    }

    public int memo(String s1,String s2, int idx1 , int idx2 , int dp[][]){
        if (idx1 == 0 || idx2 == 0) {
            return 0;
        }
        if (dp[idx1][idx2] != -1) {
            return dp[idx1][idx2];
        }
        if (s1.charAt(idx1-1) == s2.charAt(idx2-1)) {
            return dp[idx1][idx2] =  1+ memo(s1, s2, idx1-1, idx2-1,dp);
        }
        else{
            int firstString = memo(s1, s2, idx1, idx2-1,dp);
            int secondString = memo(s1, s2, idx1-1, idx2,dp);
            return  dp[idx1][idx2] =  Math.max(firstString, secondString);
        }

    }

    public int tabu(String s1, String s2){
        int n = s1.length();
        int m = s2.length();
        int dp[][] = new int[n+1][m+1];
        for(int i=1;i<n+1;i++){
            for(int j=1;j<m+1;j++){
                if (s1.charAt(i-1) == s2.charAt(j-1)) {
                    dp[i][j] = 1+dp[i-1][j-1];
                }
                else{
                    dp[i][j] =  Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[n][m];
    }
    static int lcs(String s1, String s2) {
      int n = s1.length();
      int m = s2.length();
      int dp[][] = new int[n+1][m+1];
      for(int i=0;i<n+1;i++){
        for(int j=0;j<m+1;j++){
            dp[i][j] = -1;
        }
      }
      return rec(s1, s2, n, m);

    }
    public static void main(String[] args) {
        
    }
}