public class WildCardMatching {


     public boolean rec(String s1 , String s2, int idx1 , int idx2){
        if (idx1 == 0 && idx2 == 0) {
            return true;
        }
        if (idx2 == 0) {
            if (idx1>0) {
                while (idx1>0) {
                    if (s1.charAt(idx1-1) != '*') {
                        return false;
                    }
                    idx1--;
                }
            }
            return true;
        }

        if ((s1.charAt(idx1-1) == s2.charAt(idx2-1)) || (s1.charAt(idx1-1) == '?')) {
            return rec(s1, s2, idx1-1, idx2-1);
        }
        else{
            if (s1.charAt(idx1-1) == '*') {
                return rec(s1, s2, idx1-1, idx2)|| rec(s1, s2, idx1, idx2-1);
            }
        }
        return false;
     }

     public boolean tabu(String s1 , String s2){
        int n = s1.length();
        int m = s2.length();
        boolean dp[][] = new boolean[n+1][m+1];
        dp[0][0] = true;

        for(int i=1;i<n+1;i++){
            if (s1.charAt(i-1) == '*') {
                dp[i][0] = dp[i-1][0];
            }
            else{
                 dp[i][0] = false;
            }
        }

        for(int i=1;i<n+1;i++){
            for(int j=1;j<m+1;j++){
                if ((s1.charAt(i-1) == s2.charAt(j-1)) || (s1.charAt(i-1) == '?') ) {
                    dp[i][j] = dp[i-1][j-1];
                }
                else{
            if (s1.charAt(i-1) == '*') {
                dp[i][j]  = dp[i-1][j]|| dp[i][j-1];
            }
            else{
                dp[i][j] = false;
            }

                }
            }
        }
        return dp[n][m];

     }

        public boolean wildCard(String txt, String pat) {
       return tabu(txt, pat);
 }

    public static void main(String[] args) {
        
    }
}
