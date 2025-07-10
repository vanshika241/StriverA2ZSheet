public class DistinctSubseq {

    public int rec(String s1, String s2, int idx1 , int idx2){
        if (idx2 == 0) {
            return 1;
        }

        if (idx1 == 0 ) {
            return 0;
        }
        if (s1.charAt(idx1-1) == s2.charAt(idx2-1)) {
            return rec(s1, s2, idx1-1, idx2-1) + rec(s1, s2, idx1-1, idx2);
        }
        else{
            return rec(s1, s2, idx1-1, idx2);
        }
    }

    public int memo(String s1, String s2, int idx1 , int idx2, int dp[][]){
                if (idx2 == 0) {
            return 1;
        }

        if (idx1 == 0 ) {
            return 0;
        }
        if (dp[idx1][idx2] != -1) {
            return dp[idx1][idx2] ;
        }
        if (s1.charAt(idx1-1) == s2.charAt(idx2-1)) {
            return dp[idx1][idx2] =  memo(s1, s2, idx1-1, idx2-1,dp) + memo(s1, s2, idx1-1, idx2,dp);
        }
        else{
            return  dp[idx1][idx2]  = memo(s1, s2, idx1-1, idx2,dp);
        }

    }

    public int tabu(String s1, String s2){
        int n = s1.length();
        int m = s2.length();
        int dp[][] = new int[n+1][m+1];
        dp[0][0] = 1;
        for(int j=1;j<m+1;j++){
            dp[0][j] = 1;
        }

        for(int i=1;i<n+1;i++){
            for(int j=1;j<m+1;j++){
                if (s1.charAt(i-1) == s2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
                }
                else{
                     dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][m];
    }
    public int numDistinct(String s1, String s2) {
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
