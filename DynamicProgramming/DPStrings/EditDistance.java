public class EditDistance {

        public int rec(String s1, String s2 , int idx1 , int idx2){
            if (idx1 == 0) {
                return idx2;
            }
            if (idx2 == 0) {
                return idx1;
            }
            if (s1.charAt(idx1-1) == s2.charAt(idx2-1)) {
                return rec(s1, s2, idx1-1, idx2-1);
            }
            else{
                int delete = 1 + rec(s1, s2, idx1-1, idx2);
                int insert = 1+rec(s1, s2, idx1, idx2-1);
                int replace = 1+rec(s1, s2, idx1-1, idx2-1);
                return Math.min(insert, Math.min(replace, delete));
            }
        }

         public int memo(String s1, String s2 , int idx1 , int idx2, int dp[][]){
            if (idx1 == 0) {
                return idx2;
            }
            if (idx2 == 0) {
                return idx1;
            }
            if (dp[idx1][idx2] != -1) {
                return dp[idx1][idx2];
            }
            if (s1.charAt(idx1-1) == s2.charAt(idx2-1)) {
                return dp[idx1][idx2] = rec(s1, s2, idx1-1, idx2-1);
            }

            else{
                int delete = 1 + rec(s1, s2, idx1-1, idx2);
                int insert = 1+rec(s1, s2, idx1, idx2-1);
                int replace = 1+rec(s1, s2, idx1-1, idx2-1);
                return  dp[idx1][idx2] = Math.min(insert, Math.min(replace, delete));
            }
        }

        public int tabu(String s1, String s2){
            int n = s1.length();
            int m = s2.length();
            int dp[][] = new int[n+1][m+1];
            dp[0][0] = 0;
            for(int i=1;i<n+1;i++){
                dp[i][0] = i;
            }

             for(int j=1;j<m+1;j++){
                dp[0][j] = j;
            }

            for(int i=1;i<n+1;i++){
                for(int j=1;j<m+1;j++){
                    if (s1.charAt(i-1) == s2.charAt(j-1)) {
                        dp[i][j] = dp[i-1][j-1];
                    }
                    else{
                int delete = 1 + dp[i-1][j];
                int insert = 1+dp[i][j-1];
                int replace = 1+dp[i-1][j-1];
                  dp[i][j] = Math.min(insert, Math.min(replace, delete));

                    }
                }
            }

            return dp[n][m];

        }



        public int editDistance(String s1, String s2) {
          return tabu(s1, s2);
        }
    public static void main(String[] args) {
        
    }
}
