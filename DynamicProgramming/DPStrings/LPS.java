public class LPS {

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

        public int longestPalinSubseq(String s) {
            String s1 = s;
         String s2 = new StringBuilder(s).reverse().toString();
         int len = tabu(s1, s2);
         return len;

        
    }

    public static void main(String[] args) {
        
    }
}
