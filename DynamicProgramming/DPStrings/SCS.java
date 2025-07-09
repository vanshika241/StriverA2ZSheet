public class SCS {

    public static int tabuLCS(String s1, String s2){
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

    public static int shortestCommonSupersequence(String s1, String s2) {
    int n = s1.length();
    int m = s2.length();
    int lenLCS = tabuLCS(s1, s2);
    return (n+m)-(lenLCS);
    }


    public static void main(String[] args) {
        
    }
}
